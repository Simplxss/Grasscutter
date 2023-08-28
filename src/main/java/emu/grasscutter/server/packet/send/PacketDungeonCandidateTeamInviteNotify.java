package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonCandidateTeamInviteNotifyOuterClass;

public class PacketDungeonCandidateTeamInviteNotify extends BasePacket {
    public PacketDungeonCandidateTeamInviteNotify(int dungeonId, int playerUid, int vaildDeadlineTimeSec) {
        super(PacketOpcodes.DungeonCandidateTeamInviteNotify);

        var proto = DungeonCandidateTeamInviteNotifyOuterClass.DungeonCandidateTeamInviteNotify.newBuilder()
            .setDungeonId(dungeonId)
            .setPlayerUid(playerUid)
            .setVaildDeadlineTimeSec(vaildDeadlineTimeSec);
        this.setData(proto.build());
    }
}
