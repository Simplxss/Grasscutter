package emu.grasscutter.game.match;


import emu.grasscutter.data.GameData;
import emu.grasscutter.net.proto.MatchPlayerInfoOuterClass;
import emu.grasscutter.net.proto.MatchReasonOuterClass;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;

import emu.grasscutter.net.proto.MatchTypeOuterClass.MatchType;

import emu.grasscutter.server.game.GameSession;

import emu.grasscutter.server.packet.send.*;

import emu.grasscutter.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class MatchSystem extends BaseGameSystem {
    Map<Integer, List<room>> MuiltiplayerGeneralListMap;
    Map<Integer, List<room>> SinglePlayerGeneralListMap;

    Map<Integer, List<room>> MuiltiplayerDungeonListMap;
    Map<Integer, List<room>> SinglePlayerDungeonListMap;
    Map<Integer, List<room>> MuiltiplayerGCGListMap;
    Map<Integer, List<room>> SinglePlayerGCGListMap;

    Map<Integer, room> WaitingForConfirmMap;

    public MatchSystem(GameServer server) {
        super(server);

        MuiltiplayerGeneralListMap = new HashMap<>();
        SinglePlayerGeneralListMap = new HashMap<>();
        MuiltiplayerDungeonListMap = new HashMap<>();
        SinglePlayerDungeonListMap = new HashMap<>();
        MuiltiplayerGCGListMap = new HashMap<>();
        SinglePlayerGCGListMap = new HashMap<>();

        WaitingForConfirmMap = new HashMap<>();
    }

    private synchronized void matchMatchs(Map<Integer, List<room>> MuiltiplayerRoomListMap, Map<Integer, List<room>> SinglePlayerRoomListMap) {
        // first meet the muitiplayer match
        MuiltiplayerRoomListMap.forEach((k, v) -> {
            List<room> singlePlayerMatchList;
            if (SinglePlayerRoomListMap.containsKey(k))
                singlePlayerMatchList = SinglePlayerRoomListMap.get(k);
            else return;

            var itr = v.iterator();
            while (itr.hasNext()) {
                var room = itr.next();
                var leftCount = room.minPlayerNum - room.playersConfirmedMap.size();
                if (singlePlayerMatchList.size() > leftCount) {
                    for (int i = 0; i < leftCount; i++) {
                        room.playersConfirmedMap.put(singlePlayerMatchList.get(0).hostPlayer, false);
                        singlePlayerMatchList.remove(0);
                    }
                    // waiting for confirm
                    SendMatchSuccessMessage(room);

                    // remove from the list
                    itr.remove();
                }
            }
        });

        // then meet the singleplayer match
        SinglePlayerRoomListMap.forEach((k, v) -> {
            if (v.size() >= v.get(0).minPlayerNum) {
                var room = v.get(0);
                room.playersConfirmedMap.put(room.hostPlayer, false);
                for (int i = 0; i < room.minPlayerNum; i++) {
                    room.playersConfirmedMap.put(v.get(0).hostPlayer, false);
                    v.remove(0);
                }
                // waiting for confirm
                WaitingForConfirmMap.put(room.hostPlayer.getPlayer().getUid(), room);
                SendMatchSuccessMessage(room);
            }
        });
    }

    public synchronized void SendMatchSuccessMessage(room room) {
        var playerList = new ArrayList<MatchPlayerInfoOuterClass.MatchPlayerInfo>();
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            WaitingForConfirmMap.put(room.hostPlayer.getPlayer().getUid(), room);
            playerList.add(MatchPlayerInfoOuterClass.MatchPlayerInfo.newBuilder()
                .setPlayerInfo(player.getPlayer().getOnlinePlayerInfo())
                .build());
        });
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            switch (room.matchType) {
                case MATCH_TYPE_DUNGEON ->
                    player.send(new PacketPlayerMatchSuccNotify(room.id, room.hostPlayer.getPlayer().getUid(), Utils.getCurrentSeconds() + 30));
                case MATCH_TYPE_GENERAL ->
                    player.send(new PacketPlayerMatchSuccNotify(room.id, room.randomMatchParam, playerList, room.hostPlayer.getPlayer().getUid(), Utils.getCurrentSeconds() + 10, room.matchType));
                case MATCH_TYPE_GCG ->
                    player.send(new PacketPlayerMatchSuccNotify(playerList, room.hostPlayer.getPlayer().getUid(), Utils.getCurrentSeconds() + 20));
            }
        });
    }

    public void SendStopMessage(room room, MatchReasonOuterClass.MatchReason reason) {
        room.playersConfirmedMap.forEach((player, confirmed) -> {
            player.send(new PacketPlayerMatchStopNotify(player.getPlayer().getUid(), reason));
        });
    }

    public synchronized void startMatch(GameSession session, int dungeonId, int matchId, MatchType matchType) {
        session.send(new PacketPlayerStartMatchRsp(dungeonId, matchId, matchType));

        // TODO: estimate the match time
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> {
                SinglePlayerDungeonListMap.computeIfAbsent(dungeonId, roomList -> new ArrayList<>()).add(new room(session, dungeonId, 4, 4, matchType));
                session.send(new PacketPlayerMatchInfoNotify(session.getPlayer().getUid(), dungeonId, 1000, matchType));
            }
            case MATCH_TYPE_GENERAL -> {
                var matchData = GameData.getMatchDataMap().get(matchId);
                List<Integer> matchParam;
                switch (matchData.getMatchSubType()) {
                    case MATCH_SUB_TYPE_HIDE -> matchParam=session.getPlayer().getActivityManager().getPlayerActivityDataByActivityType(ActivityType.ACTIVITY_TYPE_HIDE).getMatchParam();
                }
                SinglePlayerGeneralListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).add(new room(session, matchId, matchData.getMinPlayerNum(), matchData.getMaxPlayerNum(), matchType));
                session.send(new PacketPlayerMatchInfoNotify(session.getPlayer().getUid(), matchId, matchParam, 1000, matchType));
            }
            case MATCH_TYPE_GCG -> {
                SinglePlayerGCGListMap.computeIfAbsent(matchId, roomList -> new ArrayList<>()).add(new room(session, matchId, 2, 2, matchType));
                session.send(new PacketPlayerMatchInfoNotify(session.getPlayer().getUid(), matchId, 1000, matchType));
            }
        }
    }

    public synchronized void cancelMatch(GameSession session, MatchType matchType) {
        session.send(new PacketPlayerCancelMatchRsp(matchType));
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> SinglePlayerDungeonListMap.forEach((k, v) -> {
                var itr = v.iterator();
                while (itr.hasNext()) {
                    var room = itr.next();
                    if (room.hostPlayer.getPlayer().getUid() == session.getPlayer().getUid()) {
                        itr.remove();
                        break;
                    }
                }
            });
            case MATCH_TYPE_GENERAL -> SinglePlayerGeneralListMap.forEach((k, v) -> {
                var itr = v.iterator();
                while (itr.hasNext()) {
                    var room = itr.next();
                    if (room.hostPlayer.getPlayer().getUid() == session.getPlayer().getUid()) {
                        itr.remove();
                        break;
                    }
                }
            });
            case MATCH_TYPE_GCG -> SinglePlayerGCGListMap.forEach((k, v) -> {
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

    public void ConfirmMatch(GameSession session, MatchType matchType, boolean isAgree) {
        if (!WaitingForConfirmMap.containsKey(session.getPlayer().getUid()))
            return;
        var room = WaitingForConfirmMap.get(session.getPlayer().getUid());
        switch (matchType) {
            case MATCH_TYPE_DUNGEON -> session.send(new PacketPlayerConfirmMatchRsp(isAgree));
            case MATCH_TYPE_GENERAL -> {
                session.send(new PacketPlayerConfirmMatchRsp(matchType, room.id, isAgree));
                room.playersConfirmedMap.forEach((player, confirmed) -> player.send(new PacketPlayerGeneralMatchConfirmNotify(room.id, session.getPlayer().getUid(), isAgree)));
            }
        }
        room.playersConfirmedMap.put(session, isAgree);
        for (var confirmed : room.playersConfirmedMap.values())
            if (!confirmed) return;

        SendStopMessage(room, isAgree ? MatchReasonOuterClass.MatchReason.MATCH_REASON_PLAYER_CONFIRM : MatchReasonOuterClass.MatchReason.MATCH_REASON_PLAYER_CANCEL);
        room.playersConfirmedMap.forEach((player, confirmed) -> WaitingForConfirmMap.remove(player.getPlayer().getUid()));

    }

    public synchronized void runTasks() {
        matchMatchs(MuiltiplayerGeneralListMap, SinglePlayerGeneralListMap);
        matchMatchs(MuiltiplayerDungeonListMap, SinglePlayerDungeonListMap);
        matchMatchs(MuiltiplayerGCGListMap, SinglePlayerGCGListMap);

        // check the waiting for confirm list
        WaitingForConfirmMap.forEach((k, v) -> {
            if (v.confirmEndTime < System.currentTimeMillis()) {
                WaitingForConfirmMap.remove(k);
                SendStopMessage(v, MatchReasonOuterClass.MatchReason.MATCH_REASON_CONFIRM_TIMEOUT);
            }
        });
    }

    private static class room {
        public int id;
        public MatchType matchType;
        public int minPlayerNum;
        public int maxPlayerNum;
        public GameSession hostPlayer;
        public Map<GameSession, Boolean> playersConfirmedMap;
        public int[] matchParam;
        public int randomMatchParam;
        public int confirmEndTime;

        public room(GameSession hostPlayer, int id, int minPlayerNum, int maxPlayerNum, MatchType matchType) {
            this.id = id;
            this.matchType = matchType;
            this.minPlayerNum = minPlayerNum;
            this.maxPlayerNum = maxPlayerNum;
            this.hostPlayer = hostPlayer;
        }

        public room(GameSession hostPlayer, int id, int minPlayerNum, int maxPlayerNum, MatchType matchType, int[] matchParam) {
            this.id = id;
            this.matchType = matchType;
            this.minPlayerNum = minPlayerNum;
            this.maxPlayerNum = maxPlayerNum;
            this.hostPlayer = hostPlayer;
            this.matchParam = matchParam;
        }

        public room(GameSession hostPlayer, int id, int minPlayerNum, int maxPlayerNum, MatchType matchType, GameSession[] players) {
            this.id = id;
            this.matchType = matchType;
            this.minPlayerNum = minPlayerNum;
            this.maxPlayerNum = maxPlayerNum;
            this.hostPlayer = hostPlayer;

            this.playersConfirmedMap = new HashMap<>();
            for (var player : players)
                this.playersConfirmedMap.put(player, false);
        }

        public room(GameSession hostPlayer, int id, int minPlayerNum, int maxPlayerNum, MatchType matchType, GameSession[] players, int[] matchParam) {
            this.id = id;
            this.matchType = matchType;
            this.minPlayerNum = minPlayerNum;
            this.maxPlayerNum = maxPlayerNum;
            this.hostPlayer = hostPlayer;
            this.matchParam = matchParam;

            this.playersConfirmedMap = new HashMap<>();
            for (var player : players)
                this.playersConfirmedMap.put(player, false);
        }
    }
}
