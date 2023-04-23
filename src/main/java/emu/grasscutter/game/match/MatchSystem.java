package emu.grasscutter.game.match;


import emu.grasscutter.data.GameData;
import emu.grasscutter.game.activity.hideandseek.HideAndSeekActivityHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.game.GameSession;

import emu.grasscutter.net.proto.MatchTypeOuterClass;
import emu.grasscutter.net.proto.MatchPlayerInfoOuterClass;
import emu.grasscutter.net.proto.MatchReasonOuterClass;

import emu.grasscutter.server.packet.send.*;

import emu.grasscutter.utils.Utils;

import java.util.*;

public class MatchSystem extends BaseGameSystem {
    Map<Integer, List<Room>> multiplayerGeneralListMap;
    Map<Integer, List<Room>> singlePlayerGeneralListMap;

    Map<Integer, List<Room>> multiplayerDungeonListMap;
    Map<Integer, List<Room>> singlePlayerDungeonListMap;

    Map<Integer, List<Room>> multiplayerGCGListMap;
    Map<Integer, List<Room>> singlePlayerGCGListMap;

    Map<Integer, Room> WaitingForConfirmMap;

    public MatchSystem(GameServer server) {
        super(server);

        multiplayerGeneralListMap = new HashMap<>();
        singlePlayerGeneralListMap = new HashMap<>();
        multiplayerDungeonListMap = new HashMap<>();
        singlePlayerDungeonListMap = new HashMap<>();
        multiplayerGCGListMap = new HashMap<>();
        singlePlayerGCGListMap = new HashMap<>();

        WaitingForConfirmMap = new HashMap<>();
    }

    public synchronized void startMatch(GameSession session, int dungeonId, int matchId, MatchTypeOuterClass.MatchType matchType) {
        session.send(new PacketPlayerStartMatchRsp(dungeonId, matchId, matchType));

        // TODO: estimate the match time
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> {
                if (session.getPlayer().isInMultiplayer())
                    singlePlayerDungeonListMap.computeIfAbsent(dungeonId, roomList -> new ArrayList<>()).add(new Room(session, dungeonId, matchType));
                else
                    multiplayerDungeonListMap.computeIfAbsent(dungeonId, roomList -> new ArrayList<>()).add(
                        new Room(session, dungeonId, matchType,
                            session.getPlayer().getWorld().getPlayers().toArray(new emu.grasscutter.game.player.Player[0])));
                session.send(new PacketPlayerMatchInfoNotify(session.getPlayer().getUid(), dungeonId, 1000, matchType));
            }
            case MATCH_TYPE_GENERAL -> {
                List<Integer> matchParam;
                switch (GameData.getMatchDataMap().get(matchId).getMatchSubType()) {
                    case MATCH_SUB_TYPE_HIDE -> {
                        var playerData = session.getPlayer().getActivityManager().getPlayerActivityDataByActivityType(ActivityType.NEW_ACTIVITY_HIDE_AND_SEEK);
                        if (playerData.isEmpty())
                            return;
                        matchParam = ((HideAndSeekActivityHandler) playerData.get().getActivityHandler())
                            .getHideAndSeekPlayerData(playerData.get()).getChosenMapList();
                    }
                    // TODO: add other match type
                    default -> matchParam = new ArrayList<>();
                }
                if (session.getPlayer().isInMultiplayer())
                    singlePlayerGeneralListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).
                        add(new Room(session, matchId, matchType, new HashSet<>(matchParam)));
                else
                    multiplayerGeneralListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).
                        add(new Room(session, matchId, matchType, new HashSet<>(matchParam),
                            session.getPlayer().getWorld().getPlayers().toArray(new emu.grasscutter.game.player.Player[0])));
                session.send(new PacketPlayerMatchInfoNotify(session.getPlayer().getUid(), matchId, matchParam, 1000, matchType));
            }
            case MATCH_TYPE_GCG -> {
                if (session.getPlayer().isInMultiplayer())
                    singlePlayerGCGListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).add(new Room(session, matchId, matchType));
                else
                    multiplayerGCGListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).add(
                        new Room(session, matchId, matchType,
                            session.getPlayer().getWorld().getPlayers().toArray(new emu.grasscutter.game.player.Player[0])));
                session.send(new PacketPlayerMatchInfoNotify(session.getPlayer().getUid(), matchId, 1000, matchType));
            }
        }
    }

    public void ConfirmMatch(GameSession session, MatchTypeOuterClass.MatchType matchType, boolean isAgree) {
        var uid = session.getPlayer().getUid();
        if (!WaitingForConfirmMap.containsKey(uid))
            return;
        var room = WaitingForConfirmMap.get(uid);
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> session.send(new PacketPlayerConfirmMatchRsp(isAgree));
            case MATCH_TYPE_GENERAL, MATCH_TYPE_GCG ->
                session.send(new PacketPlayerConfirmMatchRsp(matchType, room.id, isAgree));
        }
        room.playersConfirmedMap.put(session.getPlayer(), isAgree);

        for (var confirmed : room.playersConfirmedMap.values())
            if (!confirmed) return;
        SendMatchStopMessage(room, isAgree ? MatchReasonOuterClass.MatchReason.MATCH_REASON_PLAYER_CONFIRM : MatchReasonOuterClass.MatchReason.MATCH_REASON_PLAYER_CANCEL);
        room.playersConfirmedMap.forEach((player, confirmed) -> WaitingForConfirmMap.remove(player.getUid()));
    }

    public synchronized void cancelMatch(GameSession session, MatchTypeOuterClass.MatchType matchType) {
        session.send(new PacketPlayerCancelMatchRsp(matchType));
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> singlePlayerDungeonListMap.forEach((k, v) -> {
                var itr = v.iterator();
                while (itr.hasNext()) {
                    var room = itr.next();
                    if (room.hostPlayer.getPlayer().getUid() == session.getPlayer().getUid()) {
                        itr.remove();
                        break;
                    }
                }
            });
            case MATCH_TYPE_GENERAL -> singlePlayerGeneralListMap.forEach((k, v) -> {
                var itr = v.iterator();
                while (itr.hasNext()) {
                    var room = itr.next();
                    if (room.hostPlayer.getPlayer().getUid() == session.getPlayer().getUid()) {
                        itr.remove();
                        break;
                    }
                }
            });
            case MATCH_TYPE_GCG -> singlePlayerGCGListMap.forEach((k, v) -> {
                var itr = v.iterator();
                while (itr.hasNext()) {
                    var room = itr.next();
                    if (room.hostPlayer.getPlayer().getUid() == session.getPlayer().getUid()) {
                        itr.remove();
                        break;
                    }
                }
            });
        }
    }

    public synchronized void SendMatchSuccessMessage(Room room) {
        var playerList = new ArrayList<MatchPlayerInfoOuterClass.MatchPlayerInfo>();
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            WaitingForConfirmMap.put(room.hostPlayer.getPlayer().getUid(), room);
            playerList.add(MatchPlayerInfoOuterClass.MatchPlayerInfo.newBuilder()
                .setPlayerInfo(player.getSession().getPlayer().getOnlinePlayerInfo())
                .build());
        });
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            switch (room.matchType) {
                case MATCH_TYPE_DUNGEON ->
                    player.getSession().send(new PacketPlayerMatchSuccNotify(room.id, room.hostPlayer.getPlayer().getUid(), Utils.getCurrentSeconds() + 30));
                case MATCH_TYPE_GENERAL -> {
                    var matchData = GameData.getMatchDataMap().get(room.id);
                    player.getSession().send(new PacketPlayerMatchSuccNotify(room.id, room.randomMatchParam, playerList, room.hostPlayer.getPlayer().getUid(), Utils.getCurrentSeconds() + matchData.getConfirmTime(), room.matchType));
                }
                case MATCH_TYPE_GCG ->
                    player.getSession().send(new PacketPlayerMatchSuccNotify(playerList, room.hostPlayer.getPlayer().getUid(), Utils.getCurrentSeconds() + 20));
            }
        });
    }

    private void SendMatchConfirmMessage(Room room, int uid, boolean isAgree) {
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            switch (room.matchType) {
                case MATCH_TYPE_GENERAL -> {
                    player.getSession().send(new PacketPlayerGeneralMatchConfirmNotify(room.id, uid, isAgree));
                    if (isAgree)
                        player.getSession().send(new PacketPlayerGeneralMatchDismiss(room.id, uid, MatchReasonOuterClass.MatchReason.MATCH_REASON_PLAYER_CANCEL));
                }
                case MATCH_TYPE_GCG -> {
                    player.getSession().send(new PacketPlayerGCGMatchConfirmNotify(room.id, uid, isAgree));
                    if (!isAgree)
                        player.getSession().send(new PacketPlayerGCGMatchDismissNotify(room.id, uid, MatchReasonOuterClass.MatchReason.MATCH_REASON_PLAYER_CANCEL));
                }
            }
        });
    }

    private void SendMatchStopMessage(Room room, MatchReasonOuterClass.MatchReason reason) {
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            player.getSession().send(new PacketPlayerMatchStopNotify(player.getUid(), reason));
        });
    }

    private void matchGeneralMatches(int id, List<Room> multiplayerRoomList, List<Room> singlePlayerRoomList, int maxPlayerNum, int minPlayerNum) {
        switch (GameData.getMatchDataMap().get(id).getMatchSubType()) {
            // need to be improved
            case MATCH_SUB_TYPE_HIDE -> {
                multiplayerRoomList.removeIf(room -> {
                    var minLeftCount = minPlayerNum - room.playersConfirmedMap.size();
                    if (room.matchParam == null) return false;
                    var maxLeftCount = maxPlayerNum - room.playersConfirmedMap.size();
                    for (var i = 0; i < singlePlayerRoomList.size() - minLeftCount; i++) {
                        Set<Integer> matchParam = new HashSet<>(room.matchParam);
                        List<Room> newPlayers = new ArrayList<>();
                        for (var j = i; j < singlePlayerRoomList.size(); j++) {
                            var singlePlayerRoom = singlePlayerRoomList.get(j);
                            matchParam.retainAll(singlePlayerRoom.matchParam);
                            if (matchParam.size() == 0) break;
                            newPlayers.add(singlePlayerRoom);
                            if (newPlayers.size() == maxLeftCount) break;
                        }
                        if (newPlayers.size() >= minLeftCount) {
                            newPlayers.forEach(singlePlayerRoom -> {
                                room.playersConfirmedMap.put(singlePlayerRoom.hostPlayer.getPlayer(), false);

                                int randomIndex = new Random().nextInt(matchParam.size());
                                room.randomMatchParam = (Integer) matchParam.toArray()[randomIndex];
                                singlePlayerRoomList.remove(singlePlayerRoom);
                            });
                            // waiting for confirm
                            SendMatchSuccessMessage(room);
                            return true;
                        }
                    }
                    return false;
                });

                for (var i = 0; i < singlePlayerRoomList.size() - minPlayerNum; i++) {
                    var room = singlePlayerRoomList.get(0);
                    Set<Integer> matchParam = new HashSet<>(room.matchParam);
                    List<Room> newPlayers = new ArrayList<>();
                    for (var j = i; j < singlePlayerRoomList.size(); j++) {
                        var singlePlayerRoom = singlePlayerRoomList.get(j);
                        matchParam.retainAll(singlePlayerRoom.matchParam);
                        if (matchParam.size() == 0) break;
                        newPlayers.add(singlePlayerRoom);
                        if (newPlayers.size() == maxPlayerNum) break;
                    }
                    if (newPlayers.size() >= minPlayerNum) {
                        newPlayers.forEach(singlePlayerRoom -> {
                            room.playersConfirmedMap = new HashMap<>();
                            room.playersConfirmedMap.put(singlePlayerRoom.hostPlayer.getPlayer(), false);

                            int randomIndex = new Random().nextInt(matchParam.size());
                            room.randomMatchParam = (Integer) matchParam.toArray()[randomIndex];
                            singlePlayerRoomList.remove(singlePlayerRoom);
                        });
                        // waiting for confirm
                        SendMatchSuccessMessage(room);
                    }
                }
            }
            case MATCH_SUB_TYPE_BRICK_BREAKER ->
                matchMatches(multiplayerRoomList, singlePlayerRoomList, maxPlayerNum, minPlayerNum);
        }
    }

    private synchronized void matchMatches(List<Room> multiplayerRoomList, List<Room> singlePlayerRoomList, int maxPlayerNum, int minPlayerNum) {
        // first meet the multiplayer match
        multiplayerRoomList.removeIf(room -> {
            if (singlePlayerRoomList.size() < minPlayerNum - room.playersConfirmedMap.size()) return false;
            while (singlePlayerRoomList.size() > 0 && room.playersConfirmedMap.size() < maxPlayerNum) {
                room.playersConfirmedMap.put(singlePlayerRoomList.get(0).hostPlayer.getPlayer(), false);
                singlePlayerRoomList.remove(0);
            }
            // waiting for confirm
            SendMatchSuccessMessage(room);
            return true;
        });

        // then meet the singlePlayer match
        while (singlePlayerRoomList.size() > minPlayerNum) {
            var room = singlePlayerRoomList.get(0);
            room.playersConfirmedMap = new HashMap<>();
            while (singlePlayerRoomList.size() > 0 && room.playersConfirmedMap.size() < maxPlayerNum) {
                room.playersConfirmedMap = new HashMap<>();
                room.playersConfirmedMap.put(singlePlayerRoomList.get(0).hostPlayer.getPlayer(), false);
                singlePlayerRoomList.remove(0);
            }
            // waiting for confirm
            SendMatchSuccessMessage(room);
        }
    }

    public synchronized void runTasks() {
        multiplayerGeneralListMap.forEach((id, multiplayerRoomList) -> {
            var matchData = GameData.getMatchDataMap().get(id.intValue());

            List<Room> singlePlayerRoomList;
            if (singlePlayerGeneralListMap.containsKey(id))
                singlePlayerRoomList = singlePlayerGeneralListMap.get(id);
            else return;

            matchGeneralMatches(id, multiplayerRoomList, singlePlayerRoomList, matchData.getMaxPlayerNum(), matchData.getMinPlayerNum());
        });

        multiplayerDungeonListMap.forEach((id, multiplayerRoomList) -> {
            List<Room> singlePlayerRoomList;
            if (singlePlayerDungeonListMap.containsKey(id))
                singlePlayerRoomList = singlePlayerDungeonListMap.get(id);
            else return;

            matchMatches(multiplayerRoomList, singlePlayerRoomList, 4, 4);
        });

        multiplayerGCGListMap.forEach((id, multiplayerRoomList) -> {
            List<Room> singlePlayerRoomList;
            if (singlePlayerGCGListMap.containsKey(id))
                singlePlayerRoomList = singlePlayerGCGListMap.get(id);
            else return;

            matchMatches(multiplayerRoomList, singlePlayerRoomList, 2, 2);
        });

        // check the waiting for confirm list
        WaitingForConfirmMap.forEach((k, v) -> {
            if (v.confirmEndTime < System.currentTimeMillis()) {
                WaitingForConfirmMap.remove(k);
                SendMatchStopMessage(v, MatchReasonOuterClass.MatchReason.MATCH_REASON_CONFIRM_TIMEOUT);
            }
        });
    }

    private static class Room {
        public int id;
        public MatchTypeOuterClass.MatchType matchType;
        public GameSession hostPlayer;
        public Set<Integer> matchParam;
        public int randomMatchParam;
        public Map<Player, Boolean> playersConfirmedMap;
        public int confirmEndTime;

        public Room(GameSession hostPlayer, int id, MatchTypeOuterClass.MatchType matchType) {
            this.id = id;
            this.matchType = matchType;
            this.hostPlayer = hostPlayer;
        }

        public Room(GameSession hostPlayer, int id, MatchTypeOuterClass.MatchType matchType, Set<Integer> matchParam) {
            this.id = id;
            this.matchType = matchType;
            this.hostPlayer = hostPlayer;
            this.matchParam = matchParam;
        }

        public Room(GameSession hostPlayer, int id, MatchTypeOuterClass.MatchType matchType, Player[] players) {
            this.id = id;
            this.matchType = matchType;
            this.hostPlayer = hostPlayer;

            this.playersConfirmedMap = new HashMap<>();
            for (var player : players)
                this.playersConfirmedMap.put(player, false);
        }

        public Room(GameSession hostPlayer, int id, MatchTypeOuterClass.MatchType matchType, Set<Integer> matchParam, Player[] players) {
            this.id = id;
            this.matchType = matchType;
            this.hostPlayer = hostPlayer;
            this.matchParam = matchParam;

            this.playersConfirmedMap = new HashMap<>();
            for (var player : players)
                this.playersConfirmedMap.put(player, false);
        }
    }
}
