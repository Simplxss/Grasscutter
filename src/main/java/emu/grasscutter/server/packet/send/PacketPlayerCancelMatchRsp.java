package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

import emu.grasscutter.net.proto.MatchTypeOuterClass;
import emu.grasscutter.net.proto.PlayerCancelMatchRspOuterClass;

public class PacketPlayerCancelMatchRsp extends BasePacket {
    public PacketPlayerCancelMatchRsp(MatchTypeOuterClass.MatchType matchType) {
        super(PacketOpcodes.PlayerMatchInfoNotify);

        var proto = PlayerCancelMatchRspOuterClass.PlayerCancelMatchRsp.newBuilder()
            .setMatchType(matchType)
            .build();

        this.setData(proto);
    }
}
