package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.systems.MultiplayerSystem;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.JoinPlayerSceneReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketJoinPlayerSceneRsp;

@Opcodes(PacketOpcodes.JoinPlayerSceneReq)
public class HandlerJoinPlayerSceneReq extends PacketHandler {
    @Override
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        var req = JoinPlayerSceneReqOuterClass.JoinPlayerSceneReq.parseFrom(payload);

        // TODO: Verify that request is valid
        session.getServer().getMultiplayerSystem().joinPlayer(session.getPlayer(), session.getServer().getPlayerByUid(req.getTargetUid()));

        session.send(
            new PacketJoinPlayerSceneRsp(509)); // idk
    }
}
