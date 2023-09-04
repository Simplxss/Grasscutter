package emu.grasscutter.game.match;


import emu.grasscutter.data.GameData;
//import emu.grasscutter.game.activity.hideandseek.HideAndSeekActivityHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.game.GameSession;

import emu.grasscutter.net.proto.MatchTypeOuterClass;
import emu.grasscutter.net.proto.MatchPlayerInfoOuterClass;
import emu.grasscutter.net.proto.MatchReasonOuterClass;

import emu.grasscutter.server.packet.send.*;

import emu.grasscutter.utils.Utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MatchSystem extends BaseGameSystem {
    Map<Integer, List<Room>> DungeonListMap;
    Map<Integer, List<Room>> GeneralListMap;
    Map<Integer, List<Room>> GCGListMap;

    Map<Player, Room> DungeonWaitingForConfirmMap;
    Map<Player, Room> GeneralAndGCGWaitingForConfirmMap;

    public MatchSystem(GameServer server) {
        super(server);

        DungeonListMap = new HashMap<>();
        GeneralListMap = new HashMap<>();
        GCGListMap = new HashMap<>();

        DungeonWaitingForConfirmMap = new HashMap<>();
        GeneralAndGCGWaitingForConfirmMap = new HashMap<>();
    }

    public synchronized void clearMatchOnLogout(Player player) {
        Function<Map<Integer, List<Room>>, Boolean> delete = (listMap) -> {
            for (var rooms : listMap.values())
                for (var itr = rooms.iterator(); itr.hasNext(); ) {
                    var room = itr.next();
                    if (room.hostPlayer == player) {
                        itr.remove();
                        return true;
                    }
                    if (room.hostIsMP)
                        if (room.playersConfirmedMap.containsKey(player)) {
                            room.playersConfirmedMap.remove(player);
                            return true;
                        }
                }
            return false;
        };

        boolean ret = delete.apply(DungeonListMap);
        if (DungeonWaitingForConfirmMap.containsKey(player)) {
            var room = DungeonWaitingForConfirmMap.get(player);
            room.playersConfirmedMap.remove(player);

            // re-add the room to the match list if the original room is full
            if (room.playersConfirmedMap.size() == 4 - 1)
                DungeonListMap.computeIfAbsent(room.id, roomList -> new ArrayList<>()).add(room);
            ret = true;
        }
        if (ret) return;

        if (delete.apply(GeneralListMap)) return;
        if (delete.apply(GCGListMap)) return;

        if (GeneralAndGCGWaitingForConfirmMap.containsKey(player)) {
            var room = GeneralAndGCGWaitingForConfirmMap.get(player);
            SendMatchStopMessage(room, MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CANCEL);

            for (var entry : room.playersConfirmedMap.entrySet())
                if (entry.getValue() != 0) // not confirmed
                    GeneralAndGCGWaitingForConfirmMap.remove(entry.getKey());
        }

    }

    public synchronized void startMatch(GameSession session, int dungeonId, int matchId, MatchTypeOuterClass.MatchType matchType) {
        // TODO: estimate the match time
        var player = session.getPlayer();
        Room room;
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> {
                if (player.isInMultiplayer())
                    room = new Room(player, dungeonId, matchType, player.getWorld().getPlayers());
                else
                    room = new Room(player, dungeonId, matchType);
                DungeonListMap.computeIfAbsent(dungeonId, roomList -> new ArrayList<>()).add(room);
            }
            case MATCH_TYPE_GENERAL -> {
                List<Integer> matchParam;
                switch (GameData.getMatchDataMap().get(matchId).getMatchSubType()) {
//                    case MATCH_SUB_TYPE_HIDE -> {
//                        var playerData = player.getActivityManager().getPlayerActivityDataByActivityType(ActivityType.NEW_ACTIVITY_HIDE_AND_SEEK);
//                        if (playerData.isEmpty())
//                            return;
//                        matchParam = ((HideAndSeekActivityHandler) playerData.get().getActivityHandler())
//                            .getHideAndSeekPlayerData(playerData.get()).getChosenMapList();
//                    }
                    default -> matchParam = new ArrayList<>();
                }
                if (player.isInMultiplayer())
                    return;
                room = new Room(player, matchId, matchType, new HashSet<>(matchParam));
                GeneralListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).add(room);
                sendMatchInfoMessage(session, room);
            }
            case MATCH_TYPE_GCG -> {
                if (player.isInMultiplayer())
                    return;
                room = new Room(player, matchId, matchType);
                GCGListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).add(room);
                sendMatchInfoMessage(session, room);
            }
            default -> room = new Room(player);
        }
        sendMatchInfoMessage(session, room);
    }

    public void ConfirmMatch(GameSession session, MatchTypeOuterClass.MatchType matchType, boolean isAgree) {
        var player = session.getPlayer();
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> {
                if (DungeonWaitingForConfirmMap.containsKey(player)) {
                    var room = DungeonWaitingForConfirmMap.get(player);
                    DungeonWaitingForConfirmMap.remove(player);
                    session.send(new PacketPlayerConfirmMatchRsp(matchType, room.id, isAgree));

                    SendMatchConfirmMessage(room, player.getUid(), isAgree);
                    if (isAgree) {
                        room.playersConfirmedMap.put(player, 0);
                        session.send(new PacketPlayerMatchStopNotify(player.getUid(), MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CONFIRM));

                        // room is full
                        if (room.playersConfirmedMap.size() == 4) {
                            for (var confirmed : room.playersConfirmedMap.values())
                                if (confirmed != 0) return;
                            // all confirmed
                            SendMatchStopMessage(room, MatchReasonOuterClass.MatchReason.MATCH_FINISH);
                        }
                    } else {
                        room.playersConfirmedMap.remove(player);

                        // add the room to the match list
                        if (room.playersConfirmedMap.size() == 4 - 1)
                            DungeonListMap.computeIfAbsent(room.id, roomList -> new ArrayList<>()).add(room);
                    }
                }
            }
            case MATCH_TYPE_GENERAL, MATCH_TYPE_GCG -> {
                if (GeneralAndGCGWaitingForConfirmMap.containsKey(player)) {
                    var room = GeneralAndGCGWaitingForConfirmMap.get(player);
                    GeneralAndGCGWaitingForConfirmMap.remove(player);

                    session.send(new PacketPlayerConfirmMatchRsp(matchType, room.id, isAgree));

                    SendMatchConfirmMessage(room, player.getUid(), isAgree);
                    if (isAgree) {
                        room.playersConfirmedMap.put(player, 0);

                        for (var confirmed : room.playersConfirmedMap.values())
                            if (confirmed != 0) return;
                        SendMatchStopMessage(room, MatchReasonOuterClass.MatchReason.MATCH_FINISH);
                    } else
                        SendMatchStopMessage(room, MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CANCEL);
                }
            }
            default -> throw new IllegalStateException("Not Supported Type: " + matchType);
        }
    }

    public synchronized void cancelMatch(GameSession session, MatchTypeOuterClass.MatchType matchType) {
        var player = session.getPlayer();
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> {
                for (var rooms : DungeonListMap.values())
                    for (var itr = rooms.iterator(); itr.hasNext(); ) {
                        var room = itr.next();
                        if (room.hostPlayer == player) {
                            SendMatchStopMessage(room, MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CANCEL);
                            itr.remove();
                            return;
                        }
                    }
            }
            case MATCH_TYPE_GENERAL -> {
                for (var rooms : GeneralListMap.values())
                    for (var itr = rooms.iterator(); itr.hasNext(); ) {
                        var room = itr.next();
                        if (room.hostPlayer == player) {
                            SendMatchStopMessage(room, MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CANCEL);
                            itr.remove();
                            return;
                        }
                    }
            }
            case MATCH_TYPE_GCG -> {
                for (var rooms : GeneralListMap.values())
                    for (var itr = rooms.iterator(); itr.hasNext(); ) {
                        var room = itr.next();
                        if (room.hostPlayer == player) {
                            SendMatchStopMessage(room, MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CANCEL);
                            itr.remove();
                            break;
                        }
                    }
            }
        }
    }

    public synchronized void sendMatchInfoMessage(Player host, Player target) {
        Function<Map<Integer, List<Room>>, Boolean> send = (listMap) -> {
            for (var rooms : listMap.values())
                for (var room : rooms)
                    if (room.hostPlayer == host) {
                        sendMatchInfoMessage(host.getSession(), target, room);
                        return true;
                    }
            return false;
        };

        if (send.apply(DungeonListMap)) return;
        if (send.apply(GeneralListMap)) return;
        if (send.apply(GCGListMap)) return;

        // if not found, send the default message
        sendMatchInfoMessage(host.getSession(), target, new Room(host));
    }

    private synchronized void sendMatchInfoMessage(GameSession session, Room room) {
        sendMatchInfoMessage(session, null, room);
    }

    private synchronized void sendMatchInfoMessage(GameSession session, Player target, Room room) {
        var hostUid = room.hostPlayer.getUid();
        switch (room.matchType) {
            case MATCH_TYPE_NONE -> {
                if (target == null)
                    session.getPlayer().broadcastPacketToWorld(new PacketPlayerMatchInfoNotify(hostUid));
                else
                    target.sendPacket(new PacketPlayerMatchInfoNotify(hostUid));
            }
            case MATCH_TYPE_DUNGEON, MATCH_TYPE_GCG -> {
                if (target == null)
                    session.getPlayer().broadcastPacketToWorld(new PacketPlayerMatchInfoNotify(hostUid, room.id, 1, room.matchType));
                else
                    target.sendPacket(new PacketPlayerMatchInfoNotify(hostUid, room.id, 1, room.matchType));
            }
            case MATCH_TYPE_GENERAL -> {
                if (target == null)
                    session.getPlayer().broadcastPacketToWorld(new PacketPlayerMatchInfoNotify(hostUid, room.id, room.matchParam.stream().toList(), 1, room.matchType));
                else
                    target.sendPacket(new PacketPlayerMatchInfoNotify(hostUid, room.id, room.matchParam.stream().toList(), 1, room.matchType));
            }
        }
    }


    private void SendMatchSuccessMessage(Room room) {
        if (room.matchType == MatchTypeOuterClass.MatchType.MATCH_TYPE_DUNGEON) {
            int confirmEndTime = Utils.getCurrentSeconds() + 30;
            for (var player : room.playersConfirmedMap.keySet())
                if (player != room.hostPlayer)
                    player.sendPacket(new PacketPlayerMatchSuccNotify(room.id, room.hostPlayer.getUid(), confirmEndTime));
                else room.playersConfirmedMap.put(player, 0);
        } else {
            // generate the player info
            var playerList = new ArrayList<MatchPlayerInfoOuterClass.MatchPlayerInfo>();
            for (var player : room.playersConfirmedMap.keySet())
                playerList.add(MatchPlayerInfoOuterClass.MatchPlayerInfo.newBuilder()
                    .setPlayerInfo(player.getSession().getPlayer().getOnlinePlayerInfo())
                    .build());

            if (room.matchType == MatchTypeOuterClass.MatchType.MATCH_TYPE_GENERAL) {
                var matchData = GameData.getMatchDataMap().get(room.id);
                for (var player : room.playersConfirmedMap.keySet())
                    player.sendPacket(new PacketPlayerMatchSuccNotify(room.id, room.randomMatchParam, playerList, room.hostPlayer.getUid(), Utils.getCurrentSeconds() + matchData.getConfirmTime(), room.matchType));
            } else if (room.matchType == MatchTypeOuterClass.MatchType.MATCH_TYPE_GCG) {
                for (var player : room.playersConfirmedMap.keySet())
                    player.sendPacket(new PacketPlayerMatchSuccNotify(playerList, room.hostPlayer.getUid(), Utils.getCurrentSeconds() + 20));
            }
        }
    }

    private void SendMatchConfirmMessage(Room room, int uid, boolean isAgree) {
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            switch (room.matchType) {
                case MATCH_TYPE_DUNGEON -> {
                    if (isAgree)
                        player.sendPacket(new PacketPlayerMatchAgreedResultNotify(room.hostPlayer.getUid(), room.matchType));
                }
                case MATCH_TYPE_GENERAL -> {
                    player.sendPacket(new PacketPlayerGeneralMatchConfirmNotify(room.id, uid, isAgree));
                    if (isAgree)
                        player.sendPacket(new PacketPlayerGeneralMatchDismiss(room.id, uid, MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CANCEL));
                }
                case MATCH_TYPE_GCG -> {
                    player.sendPacket(new PacketPlayerGCGMatchConfirmNotify(room.id, uid, isAgree));
                    if (!isAgree)
                        player.sendPacket(new PacketPlayerGCGMatchDismissNotify(room.id, uid, MatchReasonOuterClass.MatchReason.MATCH_PLAYER_CANCEL));
                }
            }
        });
    }

    private void SendMatchStopMessage(Room room, MatchReasonOuterClass.MatchReason reason) {
        room.playersConfirmedMap.forEach((player, confirmed) ->
            player.sendPacket(new PacketPlayerMatchStopNotify(player.getUid(), reason))
        );
    }

    private synchronized List<Room> matchDungeonMatches(List<Room> roomList) {
        var multiPlayerRoomStream = roomList.stream().filter(room -> room.hostIsMP);
        var singlePlayerRoomStream = roomList.stream().filter(room -> !room.hostIsMP);

        // first meet the multiplayer match
        var itr = singlePlayerRoomStream.iterator();
        if (!itr.hasNext()) return multiPlayerRoomStream.collect(Collectors.toList());
        List<Room> newRoomList = multiPlayerRoomStream.filter(room -> {
            while (room.playersConfirmedMap.size() < 4) {
                if (!itr.hasNext()) return true;
                var tmpRoom = itr.next();
                if (room.hostPlayer.getWorldLevel() < tmpRoom.hostPlayer.getWorldLevel()) continue;
                int confirmEndTime = Utils.getCurrentSeconds() + 30;
                room.playersConfirmedMap.put(tmpRoom.hostPlayer, confirmEndTime);

                // add to the waiting for confirm list
                room.addRoomToConfirmingMap(DungeonWaitingForConfirmMap);

                // send the confirmation to the player
                tmpRoom.hostPlayer.sendPacket(new PacketPlayerMatchSuccNotify(room.id, room.hostPlayer.getUid(), confirmEndTime));
            }
            return false;
        }).collect(Collectors.toList());

        // then meet the singlePlayer match
        // enough for 4 players
        int i = 0;
        Room[] players = new Room[4];
        loop:
        while (true) {
            for (; i < 4; i++)
                if (itr.hasNext())
                    players[i] = itr.next();
                else break loop;

            Room room = Room.MIN(Room.MIN(players[0], players[1]), Room.MIN(players[2], players[3]));
            room.hostIsMP = true;
            room.playersConfirmedMap = new HashMap<>();
            room.playersConfirmedMap.put(players[0].hostPlayer, 1);
            room.playersConfirmedMap.put(players[1].hostPlayer, 1);
            room.playersConfirmedMap.put(players[2].hostPlayer, 1);
            room.playersConfirmedMap.put(players[3].hostPlayer, 1);

            room.playersConfirmedMap.put(room.hostPlayer, 0); // the host is auto confirmed

            room.addRoomToConfirmingMap(DungeonWaitingForConfirmMap);
            SendMatchSuccessMessage(room);
        }
        // if there is no singlePlayer match, return
        if (i == 0) return newRoomList;

        // not enough for 4 players
        Room room = players[0];
        for (int j = 1; j < i; j++)
            room = Room.MIN(room, players[j]);

        room.hostIsMP = true;
        room.playersConfirmedMap = new HashMap<>();
        for (int j = 0; j < i; j++)
            room.playersConfirmedMap.put(players[j].hostPlayer, 1);
        room.playersConfirmedMap.put(room.hostPlayer, 0); // the host is auto confirmed

        newRoomList.add(room);
        room.addRoomToConfirmingMap(DungeonWaitingForConfirmMap);
        SendMatchSuccessMessage(room);
        return newRoomList;
    }

    private List<Room> matchGeneralMatches(int id, List<Room> roomList, int maxPlayerNum, int minPlayerNum) {
        switch (GameData.getMatchDataMap().get(id).getMatchSubType()) {
            // need to be improved
            case MATCH_SUB_TYPE_HIDE -> {
                // index -> room
                for (int i = 0; i < roomList.size() - minPlayerNum; ) {
                    Room room = roomList.get(i);
                    var matchParam = new HashSet<>(room.matchParam);
                    var players = new HashMap<Integer, Room>();
                    players.put(i, room);
                    for (int j = i + 1; (j < roomList.size() + players.size() - minPlayerNum) && (players.size() < maxPlayerNum); j++) {
                        var tmpRoom = roomList.get(j);
                        var tmpMatchParam = new HashSet<>(matchParam);
                        tmpMatchParam.retainAll(tmpRoom.matchParam);
                        // if the matchParam is empty, the two rooms can't match
                        if (!tmpMatchParam.isEmpty()) {
                            players.put(j, tmpRoom);
                            matchParam = tmpMatchParam;
                            room = Room.MIN(room, tmpRoom);
                        }
                    }

                    if (players.size() >= minPlayerNum) {
                        // if the number of players is enough
                        room.hostIsMP = true;
                        room.matchParam = matchParam;
                        room.playersConfirmedMap = new HashMap<>();
                        for (var player : players.values())
                            room.playersConfirmedMap.put(player.hostPlayer, 1);
                        for (int j : players.keySet())
                            roomList.remove(j);

                        room.addRoomToConfirmingMap(GeneralAndGCGWaitingForConfirmMap);
                        SendMatchSuccessMessage(room);

                        // keep i unchanged because the room[i] has been removed
                        // the next room is the new room[i]
                    } else i++; // if not, move the host to next room
                }
            }
            case MATCH_SUB_TYPE_BRICK_BREAKER -> {
                for (int i = 0; i < roomList.size() / 2; i++) {
                    var player1 = roomList.get(2 * i);
                    var player2 = roomList.get(2 * i + 1);

                    var room = Room.MIN(player1, player2);
                    room.hostIsMP = true;
                    room.playersConfirmedMap = new HashMap<>();
                    room.playersConfirmedMap.put(player1.hostPlayer, 1);
                    room.playersConfirmedMap.put(player2.hostPlayer, 1);

                    room.addRoomToConfirmingMap(GeneralAndGCGWaitingForConfirmMap);
                    SendMatchSuccessMessage(room);
                }
                // if one player left, return it
                return roomList.size() % 2 == 1 ? List.of(roomList.get(roomList.size() - 1)) : List.of();
            }
            default ->
                throw new IllegalStateException("Not Supported Type: " + GameData.getMatchDataMap().get(id).getMatchSubType());
        }
        return roomList;
    }

    private synchronized List<Room> matchGCGMatches(List<Room> roomList) {
        for (int i = 0; i < roomList.size() / 2; i++) {
            var player1 = roomList.get(2 * i);
            var player2 = roomList.get(2 * i + 1);

            var room = Room.MIN(player1, player2);
            room.hostIsMP = true;
            room.playersConfirmedMap = new HashMap<>();
            room.playersConfirmedMap.put(player1.hostPlayer, 1);
            room.playersConfirmedMap.put(player2.hostPlayer, 1);

            room.addRoomToConfirmingMap(GeneralAndGCGWaitingForConfirmMap);
            SendMatchSuccessMessage(room);
        }
        // if one player left, return it
        return roomList.size() % 2 == 1 ? List.of(roomList.get(roomList.size() - 1)) : List.of();
    }

    public synchronized void onTick() {
        for (var entry : DungeonListMap.entrySet())
            entry.setValue(matchDungeonMatches(entry.getValue()));

        for (var entry : GeneralListMap.entrySet()) {
            var matchData = GameData.getMatchDataMap().get(entry.getKey().intValue());
            entry.setValue(matchGeneralMatches(entry.getKey(), entry.getValue(), matchData.getMaxPlayerNum(), matchData.getMinPlayerNum()));
        }

        for (var entry : GCGListMap.entrySet())
            entry.setValue(matchGCGMatches(entry.getValue()));


        // check the waiting for confirm list
        long time = System.currentTimeMillis();
        for (var room : DungeonWaitingForConfirmMap.values())
            for (var it = room.playersConfirmedMap.entrySet().iterator(); it.hasNext(); ) {
                var player = it.next();
                // if the player is not confirmed and the confirmation time is out
                if (player.getValue() != 0 && player.getValue() < time) {
                    it.remove();

                    // re-add the player to the match list
                    DungeonListMap.computeIfAbsent(room.id, roomList -> new ArrayList<>()).add(new Room(player.getKey(), room.id, room.matchType));
                }
            }

        for (var itr = GeneralAndGCGWaitingForConfirmMap.entrySet().iterator(); itr.hasNext(); ) {
            var entry = itr.next();
            if (entry.getValue().confirmEndTime < time) {
                itr.remove();
                SendMatchStopMessage(entry.getValue(), MatchReasonOuterClass.MatchReason.MATCH_CONFIRM_TIMEOUT);
            }
        }
    }

    private static class Room {
        public int id;
        public MatchTypeOuterClass.MatchType matchType;
        public Player hostPlayer;
        public boolean hostIsMP;
        public Set<Integer> matchParam;
        public int randomMatchParam;
        // 0 for confirmed, 1 for not confirmed(General and GCG), others for confirm time(Dungeon)
        public Map<Player, Integer> playersConfirmedMap;
        // used for General and GCG
        public int confirmEndTime;

        public Room(Player hostPlayer) {
            this.matchType = MatchTypeOuterClass.MatchType.MATCH_TYPE_NONE;
            this.hostPlayer = hostPlayer;
        }

        public Room(Player hostPlayer, int id, MatchTypeOuterClass.MatchType matchType) {
            this.id = id;
            this.matchType = matchType;
            this.hostPlayer = hostPlayer;
        }

        public Room(Player hostPlayer, int id, MatchTypeOuterClass.MatchType matchType, Set<Integer> matchParam) {
            this.id = id;
            this.matchType = matchType;
            this.hostPlayer = hostPlayer;
            this.matchParam = matchParam;
        }

        // for multiplayer dungeon, notice that players are all default confirmed
        public Room(Player hostPlayer, int id, MatchTypeOuterClass.MatchType matchType, List<Player> players) {
            this.id = id;
            this.matchType = matchType;
            this.hostPlayer = hostPlayer;
            this.hostIsMP = true;

            this.playersConfirmedMap = new HashMap<>();
            for (var player : players)
                this.playersConfirmedMap.put(player, 0);
        }

        // return the room with the lower world level
        public static Room MIN(Room A, Room B) {
            return A.hostPlayer.getWorldLevel() < B.hostPlayer.getWorldLevel() ? A : B;
        }

        public void addRoomToConfirmingMap(Map<Player, Room> waitingForConfirmMap) {
            for (var entry : playersConfirmedMap.entrySet())
                if (entry.getValue() != 0)
                    waitingForConfirmMap.put(entry.getKey(), this);
        }
    }
}
