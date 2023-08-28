package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonCandidateTeamCreateReqOuterClass;
import emu.grasscutter.server.packet.send.PacketDungeonCandidateTeamCreateRsp;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.DungeonCandidateTeamCreateReq)
public class HandlerDungeonCandidateTeamCreateReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
//        var req = DungeonCandidateTeamCreateReqOuterClass.DungeonCandidateTeamCreateReq.parseFrom(payload);

        session.send(new PacketDungeonCandidateTeamCreateRsp());
    }
}
