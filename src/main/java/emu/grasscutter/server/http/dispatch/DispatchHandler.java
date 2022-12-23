package emu.grasscutter.server.http.dispatch;

import com.google.protobuf.ByteString;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.Grasscutter.ServerRunMode;
import emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp;
import emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp;
import emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfo;
import emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfig;
import emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfo;
import emu.grasscutter.server.event.dispatch.QueryAllRegionsEvent;
import emu.grasscutter.server.event.dispatch.QueryCurrentRegionEvent;
import emu.grasscutter.server.http.Router;
import emu.grasscutter.server.http.objects.QueryCurRegionRspJson;
import emu.grasscutter.utils.Crypto;
import emu.grasscutter.utils.JsonUtils;
import emu.grasscutter.utils.Utils;
import io.javalin.Javalin;
import io.javalin.http.Context;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.security.Signature;
import java.util.regex.Pattern;

import static emu.grasscutter.config.Configuration.*;

/**
 * Handles requests related to region queries.
 */
public final class DispatchHandler implements Router {
    // region -> version -> data
    private static final Map<String, Map<String, RegionData>> regions = new ConcurrentHashMap<>();
    private static final Map<String, String> regionLists = new ConcurrentHashMap<>();

    public DispatchHandler() {
        try { // Read & initialize region data.
            this.initialize();
        } catch (Exception exception) {
            Grasscutter.getLogger().error("Failed to initialize region data.", exception);
        }
    }

    /**
     * Configures region data according to configuration.
     */
    private void initialize() {
        String dispatchDomain = "http" + (HTTP_ENCRYPTION.useInRouting ? "s" : "") + "://"
            + lr(HTTP_INFO.accessAddress, HTTP_INFO.bindAddress) + ":"
            + lr(HTTP_INFO.accessPort, HTTP_INFO.bindPort);


        Map<String, Resource> resourceList = new ConcurrentHashMap<>();
        List<String> usedNames = new ArrayList<>(); // List to check for potential naming conflicts.
        for (String version : DISPATCH_INFO.resources.keySet()) {
            if (usedNames.contains(version)) {
                Grasscutter.getLogger().error("version name already in use.");
                continue;
            }
            usedNames.add(version);

            resourceList.put(version, JsonUtils.decode(DISPATCH_INFO.resources.get(version), Resource.class));
        }

        List<Region> configuredRegions;
        if (SERVER.runMode == ServerRunMode.DISPATCH_ONLY) {
            configuredRegions = List.of(DISPATCH_INFO.regions);
            if (configuredRegions.size() == 0) {
                Grasscutter.getLogger().error("[Dispatch] There are no game servers available. Exiting due to unplayable state.");
                System.exit(1);
            }
        } else {
            configuredRegions = List.of(new Region(
                lr(GAME_INFO.accessAddress, GAME_INFO.bindAddress),
                lr(GAME_INFO.accessPort, GAME_INFO.bindPort),
                true,
                resourceList.size() > 0 ? resourceList.keySet().toArray(new String[0]) : new String[]{"*"}));
        }


        usedNames.clear();
        Map<String, List<Region>> Versions = new HashMap<>();
        for (var region : configuredRegions) {
            if (usedNames.contains(region.name)) {
                Grasscutter.getLogger().error("Region name already in use.");
                continue;
            }
            usedNames.add(region.name);

            for (var version : region.versions) {
                Versions.computeIfAbsent(version, k -> new ArrayList<>()).add(region);

                // Create a region info object.
                var regionInfo = RegionInfo.newBuilder()
                    .setGateserverIp(region.ip).setGateserverPort(region.port)
                    .setSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED));

                // Add resource download info if exist
                if (resourceList.containsKey(version) && region.isEnableDownloadResource) {
                    var resource = resourceList.get(version);
                    regionInfo.setResourceUrl(resource.resourceUrl)
                        .setDataUrl(resource.dataUrl)
                        .setResourceUrlBak(resource.resourceUrlBak)
                        .setClientDataVersion(resource.clientDataVersion)
                        .setClientSilenceDataVersion(resource.clientSilenceDataVersion)
                        .setClientDataMd5(resource.clientDataMd5)
                        .setClientSilenceDataMd5(resource.clientSilenceDataMd5)
                        .setResVersionConfig(ResVersionConfig.newBuilder()
                            .setVersion(resource.resVersionConfig.version)
                            .setMd5(resource.resVersionConfig.md5)
                            .setReleaseTotalSize(resource.resVersionConfig.releaseTotalSize)
                            .setVersionSuffix(resource.resVersionConfig.versionSuffix)
                            .setBranch(resource.resVersionConfig.branch)
                            .build())
                        .setClientVersionSuffix(resource.clientVersionSuffix)
                        .setClientSilenceVersionSuffix(resource.clientSilenceVersionSuffix)
                        .setNextResourceUrl(resource.nextResourceUrl)
                        .setNextResVersionConfig(ResVersionConfig.newBuilder()
                            .setVersion(resource.nextResVersionConfig.version)
                            .setMd5(resource.nextResVersionConfig.md5)
                            .setReleaseTotalSize(resource.nextResVersionConfig.releaseTotalSize)
                            .setVersionSuffix(resource.nextResVersionConfig.versionSuffix)
                            .setBranch(resource.nextResVersionConfig.branch)
                            .build());

                }

                // Create an updated region query.
                regions.computeIfAbsent(region.name, k -> new ConcurrentHashMap<>())
                    .put(version, new RegionData(QueryCurrRegionHttpRsp.newBuilder().setRegionInfo(regionInfo).build()));
            }

        }

        Versions.forEach((version, regionList) ->
        {
            // Create regions.
            List<RegionSimpleInfo> servers = new ArrayList<>();
            regionList.forEach(region -> {
                servers.add(RegionSimpleInfo.newBuilder()
                    .setName(region.name).setTitle(region.title).setType("DEV_PUBLIC")
                    .setDispatchUrl(dispatchDomain + "/query_cur_region/" + region.name)
                    .build());
            });

            // Create a config object.
            byte[] customConfig = "{\"sdkenv\":\"2\",\"checkdevice\":\"false\",\"loadPatch\":\"false\",\"showexception\":\"false\",\"regionConfig\":\"pm|fk|add\",\"downloadMode\":\"0\"}".getBytes();
            Crypto.xor(customConfig, Crypto.DISPATCH_KEY); // XOR the config with the key.

            // Create an updated region list.
            QueryRegionListHttpRsp updatedRegionList = QueryRegionListHttpRsp.newBuilder()
                .addAllRegionList(servers)
                .setClientSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED))
                .setClientCustomConfigEncrypted(ByteString.copyFrom(customConfig))
                .setEnableLoginPc(true).build();

            // Set the region list response.
            regionLists.put(version, Utils.base64Encode(updatedRegionList.toByteString().toByteArray()));
        });
    }

    @Override
    public void applyRoutes(Javalin javalin) {
        javalin.get("/query_region_list", DispatchHandler::queryRegionList);
        javalin.get("/query_cur_region/{region}", DispatchHandler::queryCurrentRegion);
    }

    /**
     * @route /query_region_list
     */
    private static void queryRegionList(Context ctx) {
        String versionName = ctx.queryParam("version");

        if (versionName == null || versionName.isEmpty()) {
            ctx.status(400);
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s with no version request: query_region_list", ctx.ip()));
            return;
        }

        if (regionLists.containsKey(versionName)) {
            // Invoke event.
            QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionLists.get(versionName));
            event.call();
            // Respond with event result.
            ctx.result(event.getRegionList());

            // Log to console.
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s request: query_region_list", ctx.ip(), versionName));
        } else if (regionLists.containsKey("*")) {
            // Invoke event.
            QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionLists.get("*"));
            event.call();
            // Respond with event result.
            ctx.result(event.getRegionList());

            // Log to console.
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s match * request: query_region_list", ctx.ip(), versionName));
        } else {
            ctx.status(400);
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s request: query_region_list, but no match", ctx.ip(), versionName));
        }
    }

    /**
     * @route /query_cur_region/{region}
     */
    private static void queryCurrentRegion(Context ctx) {
        // Get region to query.
        String regionName = ctx.pathParam("region");
        String versionName = ctx.queryParam("version");

        String regionData;
        if (regions.containsKey(regionName)) {
            if (versionName != null && !versionName.isEmpty()) {
                if (regions.get(regionName).containsKey(versionName)) {
                    regionData = regions.get(regionName).get(versionName).getBase64();
                } else if (regions.get(regionName).containsKey("*")) {
                    regionData = regions.get(regionName).get("*").getBase64();
                } else {
                    ctx.status(400);
                    Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s request: query_cur_region/%s, but no version match", ctx.ip(), versionName, regionName));
                    return;
                }
            } else {
                ctx.status(400);
                Grasscutter.getLogger().info(String.format("[Dispatch] Client %s with no version request: query_cur_region/%s", ctx.ip(), regionName));
                return;
            }
        } else {
            ctx.status(400);
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s request: query_cur_region/%s, but no region match", ctx.ip(), versionName, regionName));
            return;
        }


        String[] versionCode = versionName.replaceAll(Pattern.compile("[a-zA-Z]").pattern(), "").split("\\.");
        int versionMajor = Integer.parseInt(versionCode[0]);
        int versionMinor = Integer.parseInt(versionCode[1]);
        int versionFix = Integer.parseInt(versionCode[2]);

        if (versionMajor >= 3 || (versionMajor == 2 && versionMinor == 7 && versionFix >= 50) || (versionMajor == 2 && versionMinor == 8)) {
            try {
                QueryCurrentRegionEvent event = new QueryCurrentRegionEvent(regionData);
                event.call();

                String key_id = ctx.queryParam("key_id");

                if (key_id == null)
                    throw new Exception("Key ID was not set");

                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.ENCRYPT_MODE, Crypto.EncryptionKeys.get(Integer.valueOf(key_id)));
                var regionInfo = Utils.base64Decode(event.getRegionInfo());

                //Encrypt regionInfo in chunks
                ByteArrayOutputStream encryptedRegionInfoStream = new ByteArrayOutputStream();

                //Thank you so much GH Copilot
                int chunkSize = 256 - 11;
                int regionInfoLength = regionInfo.length;
                int numChunks = (int) Math.ceil(regionInfoLength / (double) chunkSize);

                for (int i = 0; i < numChunks; i++) {
                    byte[] chunk = Arrays.copyOfRange(regionInfo, i * chunkSize, Math.min((i + 1) * chunkSize, regionInfoLength));
                    byte[] encryptedChunk = cipher.doFinal(chunk);
                    encryptedRegionInfoStream.write(encryptedChunk);
                }

                Signature privateSignature = Signature.getInstance("SHA256withRSA");
                privateSignature.initSign(Crypto.CUR_SIGNING_KEY);
                privateSignature.update(regionInfo);

                var rsp = new QueryCurRegionRspJson();

                rsp.content = Utils.base64Encode(encryptedRegionInfoStream.toByteArray());
                rsp.sign = Utils.base64Encode(privateSignature.sign());

                ctx.json(rsp);
            } catch (Exception e) {
                Grasscutter.getLogger().error("An error occurred while handling query_cur_region.", e);
            }
        } else {
            // Invoke event.
            QueryCurrentRegionEvent event = new QueryCurrentRegionEvent(regionData);
            event.call();
            // Respond with event result.
            ctx.result(event.getRegionInfo());
        }
        // Log to console.
        Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s request: query_cur_region/%s", ctx.ip(), versionName, regionName));
    }

    /**
     * Region data container.
     */
    public static class RegionData {
        private final QueryCurrRegionHttpRsp regionQuery;
        private final String base64;

        public RegionData(QueryCurrRegionHttpRsp prq) {
            this.regionQuery = prq;
            this.base64 = Utils.base64Encode(prq.toByteString().toByteArray());
        }

        public QueryCurrRegionHttpRsp getRegionQuery() {
            return this.regionQuery;
        }

        public String getBase64() {
            return this.base64;
        }

    }

    /**
     * Gets the current region query.
     *
     * @return A {@link QueryCurrRegionHttpRsp} object.
     */
    public static QueryCurrRegionHttpRsp getCurrentRegion(String gameVersion) {
        return switch (SERVER.runMode) {
            case HYBRID, GAME_ONLY -> {
                var versionMap = regions.get("os_usa");
                if (versionMap.containsKey(gameVersion)) {
                    yield versionMap.get(gameVersion).getRegionQuery();
                } else if (versionMap.containsKey("*")) {
                    yield versionMap.get("*").getRegionQuery();
                } else {
                    RegionInfo serverRegion = RegionInfo.newBuilder()
                        .setGateserverIp(lr(GAME_INFO.accessAddress, GAME_INFO.bindAddress))
                        .setGateserverPort(lr(GAME_INFO.accessPort, GAME_INFO.bindPort))
                        .setSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED))
                        .build();

                    yield QueryCurrRegionHttpRsp.newBuilder().setRegionInfo(serverRegion).build();
                }
            }
            case DISPATCH_ONLY ->
                throw new UnsupportedOperationException("Dispatch-only mode does not support this operation.");
        };
    }
}
