package emu.grasscutter.server.packet.recv;

import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.packet.PacketHandler;

import emu.grasscutter.net.proto.PlayerStartMatchReqOuterClass;

import emu.grasscutter.server.packet.send.PacketPlayerStartMatchRsp;

@Opcodes(PacketOpcodes.PlayerStartMatchReq)
public class HandlerPlayerStartMatchReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        var req = PlayerStartMatchReqOuterClass.PlayerStartMatchReq.parseFrom(payload);
        session.getPlayer().getServer().getMatchSystem().startMatch(session, req.getDungeonId(), req.getMatchId(), req.getMatchType());
        session.send(new PacketPlayerStartMatchRsp(req.getDungeonId(), req.getMatchId(), req.getMatchType()));
    }
}
