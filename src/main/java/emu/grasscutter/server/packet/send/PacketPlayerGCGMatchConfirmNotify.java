package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerGCGMatchConfirmNotifyOuterClass;

public class PacketPlayerGCGMatchConfirmNotify extends BasePacket {
    public PacketPlayerGCGMatchConfirmNotify(int matchId, int uid, boolean isAgree) {
        super(PacketOpcodes.PlayerGCGMatchConfirmNotify);

        var proto = PlayerGCGMatchConfirmNotifyOuterClass.PlayerGCGMatchConfirmNotify.newBuilder()
            .setMatchId(matchId)
            .setUid(uid)
            .setIsAgree(isAgree)
            .build();
        this.setData(proto);
    }
}
