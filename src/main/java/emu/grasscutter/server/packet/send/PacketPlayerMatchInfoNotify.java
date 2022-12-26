package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

import emu.grasscutter.net.proto.MatchTypeOuterClass;
import emu.grasscutter.net.proto.PlayerMatchInfoNotifyOuterClass;

import emu.grasscutter.utils.Utils;

import java.util.List;

public class PacketPlayerMatchInfoNotify extends BasePacket {
    public PacketPlayerMatchInfoNotify(int hostUid, int dungeonId, int estimateMatchCostTime, MatchTypeOuterClass.MatchType matchType) {
        super(PacketOpcodes.PlayerMatchInfoNotify);

        var proto = PlayerMatchInfoNotifyOuterClass.PlayerMatchInfoNotify.newBuilder()
            .setDungeonId(dungeonId)
            .setMatchBeginTime(Utils.getCurrentSeconds())
            .setEstimateMatchCostTime(estimateMatchCostTime)
            .setHostUid(hostUid)
            .setMatchType(matchType)
            .build();

        this.setData(proto);
    }

    public PacketPlayerMatchInfoNotify(int hostUid, int matchId, List<Integer> matchParam, int estimateMatchCostTime, MatchTypeOuterClass.MatchType matchType) {
        super(PacketOpcodes.PlayerMatchInfoNotify);

        var proto = PlayerMatchInfoNotifyOuterClass.PlayerMatchInfoNotify.newBuilder()
            .setMatchId(matchId)
            .addAllMatchParamList(matchParam)
            .setMatchBeginTime(Utils.getCurrentSeconds())
            .setEstimateMatchCostTime(estimateMatchCostTime)
            .setHostUid(hostUid)
            .setMatchType(matchType)
            .build();

        this.setData(proto);
    }
}
