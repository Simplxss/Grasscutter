package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonCandidateTeamCreateRspOuterClass;

public class PacketDungeonCandidateTeamCreateRsp extends BasePacket {
    public PacketDungeonCandidateTeamCreateRsp() {
        super(PacketOpcodes.DungeonCandidateTeamCreateRsp);

        var proto = DungeonCandidateTeamCreateRspOuterClass.DungeonCandidateTeamCreateRsp.newBuilder()
            .setRetcode(0);
        this.setData(proto.build());
    }
}
