package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

import emu.grasscutter.net.proto.MatchReasonOuterClass;
import emu.grasscutter.net.proto.PlayerGCGMatchDismissNotifyOuterClass;

public class PacketPlayerGCGMatchDismissNotify extends BasePacket {
    public PacketPlayerGCGMatchDismissNotify(int matchId, int uid, MatchReasonOuterClass.MatchReason reason) {
        super(PacketOpcodes.PlayerGCGMatchDismissNotify);

        var proto = PlayerGCGMatchDismissNotifyOuterClass.PlayerGCGMatchDismissNotify.newBuilder()
            .setMatchId(matchId)
            .addUidList(uid)
            .setReason(reason)
            .build();
        this.setData(proto);
    }
}

