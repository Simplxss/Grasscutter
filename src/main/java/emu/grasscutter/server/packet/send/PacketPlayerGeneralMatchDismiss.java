package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MatchReasonOuterClass;
import emu.grasscutter.net.proto.PlayerGeneralMatchDismissNotifyOuterClass;

public class PacketPlayerGeneralMatchDismiss extends BasePacket {
    public PacketPlayerGeneralMatchDismiss(int matchId, int uid, MatchReasonOuterClass.MatchReason reason) {
        super(PacketOpcodes.PlayerGeneralMatchDismissNotify);

        var proto = PlayerGeneralMatchDismissNotifyOuterClass.PlayerGeneralMatchDismissNotify.newBuilder()
            .setMatchId(matchId)
            .addUidList(uid)
            .setReason(reason)
            .build();
        this.setData(proto);
    }
}
