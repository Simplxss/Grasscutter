package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MatchReasonOuterClass.MatchReason;
import emu.grasscutter.net.proto.PlayerMatchStopNotifyOuterClass;

public class PacketPlayerMatchStopNotify extends BasePacket {
    public PacketPlayerMatchStopNotify(int hostUid, MatchReason reason) {
        super(PacketOpcodes.PlayerMatchStopNotify);
        var proto = PlayerMatchStopNotifyOuterClass.PlayerMatchStopNotify.newBuilder()
            .setHostUid(hostUid)
            .setReason(reason)
            .build();
        this.setData(proto);
    }
}
