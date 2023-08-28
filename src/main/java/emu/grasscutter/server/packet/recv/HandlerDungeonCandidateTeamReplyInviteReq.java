package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonCandidateTeamReplyInviteReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketDungeonCandidateTeamReplyInviteRsp;

@Opcodes(PacketOpcodes.DungeonCandidateTeamReplyInviteReq)
public class HandlerDungeonCandidateTeamReplyInviteReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
//        var req = DungeonCandidateTeamReplyInviteReqOuterClass.DungeonCandidateTeamReplyInviteReq.parseFrom(payload);

//        session.send(new PacketDungeonCandidateTeamReplyInviteRsp());
    }
}
