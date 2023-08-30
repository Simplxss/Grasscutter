package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MatchTypeOuterClass;
import emu.grasscutter.net.proto.PlayerMatchAgreedResultNotifyOuterClass;

public class PacketPlayerMatchAgreedResultNotify extends BasePacket {
    public PacketPlayerMatchAgreedResultNotify(int hostUid, MatchTypeOuterClass.MatchType matchType) {
        super(PacketOpcodes.PlayerMatchAgreedResultNotify);

        var proto = PlayerMatchAgreedResultNotifyOuterClass.PlayerMatchAgreedResultNotify.newBuilder()
            .setMatchType(matchType)
            .setTargetUid(hostUid)
            .build();

        this.setData(proto);
    }
}
