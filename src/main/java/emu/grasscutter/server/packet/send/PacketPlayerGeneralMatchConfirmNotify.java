package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerGeneralMatchConfirmNotifyOuterClass;

public class PacketPlayerGeneralMatchConfirmNotify extends BasePacket {
    public PacketPlayerGeneralMatchConfirmNotify(int matchId, int uid, boolean isAgree) {
        super(PacketOpcodes.PlayerGeneralMatchConfirmNotify);

        var proto = PlayerGeneralMatchConfirmNotifyOuterClass.PlayerGeneralMatchConfirmNotify.newBuilder()
            .setMatchId(matchId)
            .setUid(uid)
            .setIsAgree(isAgree)
            .build();
        this.setData(proto);
    }
}
