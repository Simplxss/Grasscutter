package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonCandidateTeamInfoNotifyOuterClass;

public class PacketDungeonCandidateTeamInfoNotify extends BasePacket {
    public PacketDungeonCandidateTeamInfoNotify() {
        super(PacketOpcodes.DungeonCandidateTeamInfoNotify);

        var proto = DungeonCandidateTeamInfoNotifyOuterClass.DungeonCandidateTeamInfoNotify.newBuilder();
        this.setData(proto.build());
    }
}
