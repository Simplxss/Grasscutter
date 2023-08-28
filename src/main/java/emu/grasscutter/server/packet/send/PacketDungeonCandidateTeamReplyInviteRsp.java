package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonCandidateTeamReplyInviteRspOuterClass;

public class PacketDungeonCandidateTeamReplyInviteRsp extends BasePacket {
    public PacketDungeonCandidateTeamReplyInviteRsp(int dungeonId) {
        super(PacketOpcodes.DungeonCandidateTeamReplyInviteRsp);

        var proto = DungeonCandidateTeamReplyInviteRspOuterClass.DungeonCandidateTeamReplyInviteRsp.newBuilder()
            .setDungeonId(dungeonId);
        this.setData(proto.build());
    }
}
