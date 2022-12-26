package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

import emu.grasscutter.net.proto.PlayerMatchSuccNotifyOuterClass;
import emu.grasscutter.net.proto.GeneralMatchInfoOuterClass;
import emu.grasscutter.net.proto.MatchPlayerInfoOuterClass;
import emu.grasscutter.net.proto.MatchTypeOuterClass;
import emu.grasscutter.net.proto.GCGMatchInfoOuterClass;


import java.util.List;

public class PacketPlayerMatchSuccNotify extends BasePacket {

    public PacketPlayerMatchSuccNotify(int dungeonId, int hostUid, int confirmEndTime) {
        super(PacketOpcodes.PlayerMatchSuccNotify);
        var proto = PlayerMatchSuccNotifyOuterClass.PlayerMatchSuccNotify.newBuilder()
            .setDungeonId(dungeonId)
            .setHostUid(hostUid)
            .setConfirmEndTime(confirmEndTime)
            .setMatchType(MatchTypeOuterClass.MatchType.MATCH_TYPE_DUNGEON)
            .build();
        this.setData(proto);
    }

    public PacketPlayerMatchSuccNotify(int matchId, int matchParam, List<MatchPlayerInfoOuterClass.MatchPlayerInfo> playerList, int hostUid, int confirmEndTime, MatchTypeOuterClass.MatchType matchType) {
        super(PacketOpcodes.PlayerMatchSuccNotify);
        var proto = PlayerMatchSuccNotifyOuterClass.PlayerMatchSuccNotify.newBuilder()
            .setGeneralMatchInfo(GeneralMatchInfoOuterClass.GeneralMatchInfo.newBuilder()
                .setMatchParam(matchParam)
                .setMatchId(matchId)
                .addAllPlayerList(playerList)
                .build())
            .setHostUid(hostUid)
            .setConfirmEndTime(confirmEndTime)
            .setMatchType(matchType)
            .build();
        this.setData(proto);
    }

    public PacketPlayerMatchSuccNotify(List<MatchPlayerInfoOuterClass.MatchPlayerInfo> playerList, int hostUid, int confirmEndTime) {
        super(PacketOpcodes.PlayerMatchSuccNotify);
        var proto = PlayerMatchSuccNotifyOuterClass.PlayerMatchSuccNotify.newBuilder()
            .setGcgMatchInfo(GCGMatchInfoOuterClass.GCGMatchInfo.newBuilder()
                .addAllPlayerList(playerList)
                .build())
            .setHostUid(hostUid)
            .setConfirmEndTime(confirmEndTime)
            .setMatchType(MatchTypeOuterClass.MatchType.MATCH_TYPE_GCG)
            .build();
        this.setData(proto);
    }
}
