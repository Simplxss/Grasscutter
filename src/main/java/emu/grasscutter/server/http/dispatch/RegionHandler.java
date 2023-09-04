package emu.grasscutter.server.http.dispatch;

import static emu.grasscutter.config.Configuration.*;

import com.google.gson.*;
import com.google.protobuf.ByteString;
import emu.grasscutter.*;
import emu.grasscutter.Grasscutter.ServerRunMode;
import emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp;
import emu.grasscutter.net.proto.QueryRegionListHttpRspOuterClass.QueryRegionListHttpRsp;
import emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfo;
import emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfig;
import emu.grasscutter.net.proto.RegionInfoOuterClass.RegionInfo;
import emu.grasscutter.net.proto.RetcodeOuterClass.Retcode;
import emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfo;
import emu.grasscutter.server.event.dispatch.*;
import emu.grasscutter.server.http.Router;
import emu.grasscutter.server.http.objects.QueryCurRegionRspJson;
import emu.grasscutter.utils.*;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import lombok.Getter;
import org.slf4j.Logger;

/**
 * Handles requests related to region queries.
 */
public final class RegionHandler implements Router {
    // region -> version -> data
    private static final Map<String, Map<String, RegionData>> regions = new ConcurrentHashMap<>();
    private static final Map<String, String> regionLists = new ConcurrentHashMap<>();

    public RegionHandler() {
        try { // Read and initialize region data.
            this.initialize();
        } catch (Exception exception) {
            Grasscutter.getLogger().error("Failed to initialize region data.", exception);
        }
    }

    /**
     * Configures region data according to configuration.
     */
    private void initialize() {
        var dispatchDomain =
            "http"
                + (HTTP_ENCRYPTION.useInRouting ? "s" : "")
                + "://"
                + lr(HTTP_INFO.accessAddress, HTTP_INFO.bindAddress)
                + ":"
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
            if (configuredRegions.isEmpty()) {
                Grasscutter.getLogger().error("[Dispatch] There are no game servers available. Exiting due to unplayable state.");
                System.exit(1);
            }
        } else {
            configuredRegions = List.of(new Region(
                lr(GAME_INFO.accessAddress, GAME_INFO.bindAddress),
                lr(GAME_INFO.accessPort, GAME_INFO.bindPort),
                !resourceList.isEmpty()));
        }

        usedNames.clear();
        Map<String, List<Region>> versionRegionMap = new HashMap<>(); // version -> region
        for (var region : configuredRegions) {
            if (usedNames.contains(region.name)) {
                Grasscutter.getLogger().error("Region name already in use.");
                return;
            }
            usedNames.add(region.name);

            for (var version : region.versions) {
                versionRegionMap.computeIfAbsent(version, k -> new ArrayList<>()).add(region);

                // Create a region info object.
                var regionInfo = RegionInfo.newBuilder()
                    .setGateserverIp(region.ip)
                    .setGateserverPort(region.port);

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
                var updatedQuery =
                    QueryCurrRegionHttpRsp.newBuilder()
                        .setRegionInfo(regionInfo.build())
                        .setClientSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED))
                        .build();

                regions.computeIfAbsent(region.name, k -> new ConcurrentHashMap<>())
                    .put(version, new RegionData(updatedQuery));

            }
        }

        versionRegionMap.forEach((version, regionList) ->
        {
            // Create regions.
            List<RegionSimpleInfo> servers = new ArrayList<>();

            regionList.forEach(region -> servers.add(RegionSimpleInfo.newBuilder()
                .setName(region.name).setTitle(region.title).setType("DEV_PUBLIC")
                .setDispatchUrl(dispatchDomain + "/query_cur_region/" + region.name)
                .build()));

            // Determine config settings.
            var hiddenIcons = new JsonArray();
            hiddenIcons.add(40);
            var codeSwitch = new JsonArray();
            codeSwitch.add(3628);

            // Create a config object.
            var customConfig = new JsonObject();
            if (version.startsWith("OS"))
                customConfig.addProperty("sdkenv", "2");
            else if (version.startsWith("CN"))
                customConfig.addProperty("sdkenv", "0");

            customConfig.addProperty("checkdevice", "false");
            customConfig.addProperty("loadPatch", "false");
            customConfig.addProperty("showexception", String.valueOf(GameConstants.DEBUG));
            customConfig.addProperty("regionConfig", "pm|fk|add");
            customConfig.addProperty("downloadMode", "0");
            customConfig.add("codeSwitch", codeSwitch);
            customConfig.add("coverSwitch", hiddenIcons);

            // XOR the config with the key.
            var encodedConfig = JsonUtils.encode(customConfig).getBytes();
            Crypto.xor(encodedConfig, Crypto.DISPATCH_KEY);

            // Create an updated region list.
            var updatedRegionList = QueryRegionListHttpRsp.newBuilder()
                .addAllRegionList(servers)
                .setClientSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED))
                .setClientCustomConfigEncrypted(ByteString.copyFrom(encodedConfig))
                .setEnableLoginPc(true)
                .build();

            // Set the region list response.
            regionLists.put(version, Utils.base64Encode(updatedRegionList.toByteString().toByteArray()));
        });
    }

    @Override
    public void applyRoutes(Javalin javalin) {
        javalin.get("/query_region_list", RegionHandler::queryRegionList);
        javalin.get("/query_cur_region/{region}", RegionHandler::queryCurrentRegion);
    }

    /**
     * Handle query region list request.
     *
     * @param ctx The context object for handling the request.
     * @route /query_region_list
     */
    private static void queryRegionList(Context ctx) {
        // Get logger and query parameters.
        Logger logger = Grasscutter.getLogger();
        String versionName = ctx.queryParam("version");

        if (versionName == null || versionName.isEmpty()) {
            // no version info
            String regionListResponse = "CP///////////wE=";
            QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionListResponse);
            event.call();

            // Respond with the event result.
            ctx.result(event.getRegionList());
            logger.info(String.format("[Dispatch] Client %s with no version request: query_region_list", ctx.ip()));
        }

        if (regionLists.containsKey(versionName)) {
            // Invoke event.
            QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionLists.get(versionName));
            event.call();
            // Respond with event result.
            ctx.result(event.getRegionList());

            // Log to console.
            logger.info(String.format("[Dispatch] Client %s version %s request: query_region_list", ctx.ip(), versionName));
        } else if (regionLists.containsKey("*")) {
            // Invoke event.
            QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionLists.get("*"));
            event.call();
            // Respond with event result.
            ctx.result(event.getRegionList());

            // Log to console.
            logger.info(String.format("[Dispatch] Client %s version %s match * request: query_region_list", ctx.ip(), versionName));
        } else {
            // no version info
            String regionListResponse = "CP///////////wE=";
            QueryAllRegionsEvent event = new QueryAllRegionsEvent(regionListResponse);
            event.call();

            // Respond with the event result.
            ctx.result(event.getRegionList());
            logger.info(String.format("[Dispatch] Client %s version %s matches none request: query_region_list", ctx.ip(), versionName));
        }
    }

    /**
     * @route /query_cur_region/{region}
     */
    private static void queryCurrentRegion(Context ctx) {
        // Get region to query.
        String regionName = ctx.pathParam("region");
        String versionName = ctx.queryParam("version");
        String key_id = ctx.queryParam("key_id");

        if (versionName == null || versionName.isEmpty()) {
            ctx.status(400);
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s with no version request: query_cur_region/%s", ctx.ip(), regionName));
            return;
        }

        if (key_id == null || key_id.isEmpty()) {
            ctx.status(400);
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s with no key_id request: query_cur_region/%s", ctx.ip(), regionName));
            return;
        }

        // Get region data.
        String regionData = null;
        if (regions.containsKey(regionName)) {
            if (regions.get(regionName).containsKey(versionName)) {
                regionData = regions.get(regionName).get(versionName).getBase64();
            } else if (regions.get(regionName).containsKey("*")) {
                regionData = regions.get(regionName).get("*").getBase64();
            } else
                Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s matches none request: query_cur_region/%s", ctx.ip(), versionName, regionName));
        } else
            Grasscutter.getLogger().info(String.format("[Dispatch] Client %s version %s matches none request: query_cur_region/%s", ctx.ip(), versionName, regionName));


        var clientVersion = versionName.replaceAll(Pattern.compile("[a-zA-Z]").pattern(), "");
        var versionCode = clientVersion.split("\\.");
        var versionMajor = Integer.parseInt(versionCode[0]);
        var versionMinor = Integer.parseInt(versionCode[1]);
        var versionFix = Integer.parseInt(versionCode[2]);

        if (versionMajor >= 3
            || (versionMajor == 2 && versionMinor == 7 && versionFix >= 50)
            || (versionMajor == 2 && versionMinor == 8)) {
            try {
                QueryCurrentRegionEvent event = new QueryCurrentRegionEvent(regionData);
                event.call();

                if (regionData == null) { // Reject clients when there is a version mismatch

                    boolean updateClient = GameConstants.VERSION.compareTo(clientVersion) > 0;

                    QueryCurrRegionHttpRsp rsp =
                        QueryCurrRegionHttpRsp.newBuilder()
                            .setRetcode(Retcode.RET_STOP_SERVER_VALUE)
                            .setMsg("Connection Failed!")
                            .setRegionInfo(RegionInfo.newBuilder())
                            .setStopServer(
                                StopServerInfo.newBuilder()
                                    .setUrl("https://discord.gg/T5vZU6UyeG")
                                    .setStopBeginTime((int) Instant.now().getEpochSecond())
                                    .setStopEndTime((int) Instant.now().getEpochSecond() + 1)
                                    .setContentMsg("No match found for your client version.")
                                    .build())
                            .buildPartial();

                    Grasscutter.getLogger()
                        .debug(
                            String.format(
                                "Connection denied for %s due to %s.",
                                Utils.address(ctx), updateClient ? "outdated client!" : "outdated server!"));

                    ctx.json(Crypto.encryptAndSignRegionData(rsp.toByteArray(), key_id));
                    return;
                }

                if (ctx.queryParam("dispatchSeed") == null) {
                    // More love for UA Patch players
                    var rsp = new QueryCurRegionRspJson();

                    rsp.content = event.getRegionInfo();
                    rsp.sign = "TW9yZSBsb3ZlIGZvciBVQSBQYXRjaCBwbGF5ZXJz";

                    ctx.json(rsp);
                    return;
                }

                var regionInfo = Utils.base64Decode(event.getRegionInfo());

                ctx.json(Crypto.encryptAndSignRegionData(regionInfo, key_id));
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
    @Getter
    public static class RegionData {
        private final QueryCurrRegionHttpRsp regionQuery;
        private final String base64;

        public RegionData(QueryCurrRegionHttpRsp prq) {
            this.regionQuery = prq;
            this.base64 = Utils.base64Encode(prq.toByteString().toByteArray());
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
                if (regions.get("os_usa").containsKey(gameVersion)) {
                    yield regions.get("os_usa").get(gameVersion).getRegionQuery();
                } else if (regions.get("os_usa").containsKey("*")) {
                    yield regions.get("os_usa").get("*").getRegionQuery();
                } else {
                    // shouldn't occur, but in case...
                    RegionInfo serverRegion = RegionInfo.newBuilder()
                        .setGateserverIp(lr(GAME_INFO.accessAddress, GAME_INFO.bindAddress))
                        .setGateserverPort(lr(GAME_INFO.accessPort, GAME_INFO.bindPort))
                        .setSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED))
                        .build();

                    Grasscutter.getLogger().info("[Dispatch] getCurrentRegion matches ???");
                    yield QueryCurrRegionHttpRsp.newBuilder().setRegionInfo(serverRegion).build();
                }
            }
            case DISPATCH_ONLY ->
                throw new UnsupportedOperationException("Dispatch-only mode does not support this operation.");
        };
    }
}
