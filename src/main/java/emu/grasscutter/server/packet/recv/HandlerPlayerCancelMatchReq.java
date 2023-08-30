package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;

import emu.grasscutter.net.proto.PlayerCancelMatchReqOuterClass;

import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerCancelMatchRsp;

@Opcodes(PacketOpcodes.PlayerCancelMatchReq)
public class HandlerPlayerCancelMatchReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        var req = PlayerCancelMatchReqOuterClass.PlayerCancelMatchReq.parseFrom(payload);
        session.getPlayer().getServer().getMatchSystem().cancelMatch(session, req.getMatchType());
        session.send(new PacketPlayerCancelMatchRsp(req.getMatchType()));
    }
}
