package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerConfirmMatchReqOuterClass.PlayerConfirmMatchReq;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerConfirmMatchRsp;

@Opcodes(PacketOpcodes.PlayerConfirmMatchReq)

public class HandlerPlayerConfirmMatchReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        var req = PlayerConfirmMatchReq.parseFrom(payload);
        session.getServer().getMatchSystem().ConfirmMatch(session, req.getMatchType(), req.getIsAgreed());
    }
}
