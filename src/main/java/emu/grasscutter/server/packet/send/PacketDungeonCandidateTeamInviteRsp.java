package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonCandidateTeamInviteRspOuterClass;

public class PacketDungeonCandidateTeamInviteRsp extends BasePacket {
    public PacketDungeonCandidateTeamInviteRsp() {
        super(PacketOpcodes.DungeonCandidateTeamInviteRsp);

        var proto = DungeonCandidateTeamInviteRspOuterClass.DungeonCandidateTeamInviteRsp.newBuilder()
            .setRetcode(0);
        this.setData(proto.build());
    }
}
