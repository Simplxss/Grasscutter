package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.JoinPlayerSceneRspOuterClass;

public class PacketJoinPlayerSceneRsp extends BasePacket {
    public PacketJoinPlayerSceneRsp(int retcode) {
        super(PacketOpcodes.JoinPlayerSceneRsp);

        this.setData(JoinPlayerSceneRspOuterClass.JoinPlayerSceneRsp.newBuilder()
            .setRetcode(retcode)
            .build()
            .toByteArray());
    }

}
