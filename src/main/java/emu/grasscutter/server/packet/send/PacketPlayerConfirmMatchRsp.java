package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MatchTypeOuterClass.MatchType;
import emu.grasscutter.net.proto.PlayerConfirmMatchRspOuterClass.PlayerConfirmMatchRsp;

public class PacketPlayerConfirmMatchRsp extends BasePacket {
    public PacketPlayerConfirmMatchRsp(boolean isAgreed) {
        super(PacketOpcodes.PlayerConfirmMatchRsp);

        var proto = PlayerConfirmMatchRsp.newBuilder()
            .setMatchType(MatchType.MATCH_TYPE_DUNGEON)
            .setIsAgreed(isAgreed)
            .build();

        this.setData(proto);
    }

    public PacketPlayerConfirmMatchRsp(MatchType matchType, int matchId, boolean isAgreed) {
        super(PacketOpcodes.PlayerConfirmMatchRsp);

        var proto = PlayerConfirmMatchRsp.newBuilder()
            .setMatchType(matchType)
            .setMatchId(matchId)
            .setIsAgreed(isAgreed)
            .build();

        this.setData(proto);
    }
}
