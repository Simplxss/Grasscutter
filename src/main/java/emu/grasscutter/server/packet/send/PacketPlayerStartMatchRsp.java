package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

import emu.grasscutter.net.proto.MatchTypeOuterClass.MatchType;
import emu.grasscutter.net.proto.PlayerStartMatchRspOuterClass.PlayerStartMatchRsp;

public class PacketPlayerStartMatchRsp extends BasePacket {

    public PacketPlayerStartMatchRsp(int dungeonId, int matchId, MatchType matchType) {
        super(PacketOpcodes.PlayerStartMatchRsp);
        var proto = PlayerStartMatchRsp.newBuilder()
            .setDungeonId(dungeonId)
            .setMatchId(matchId)
            .setMatchType(matchType)
            .build();

        this.setData(proto);
    }
}
