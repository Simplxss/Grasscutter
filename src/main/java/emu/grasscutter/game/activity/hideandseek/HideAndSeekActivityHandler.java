package emu.grasscutter.game.activity.hideandseek;

import emu.grasscutter.game.activity.ActivityHandler;
import emu.grasscutter.game.activity.GameActivity;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.hideandseek.HideAndSeekPlayerData;
import emu.grasscutter.game.props.ActivityType;

import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass;

import emu.grasscutter.utils.JsonUtils;

import java.util.stream.Collectors;


@GameActivity(ActivityType.NEW_ACTIVITY_HIDE_AND_SEEK)
public class HideAndSeekActivityHandler extends ActivityHandler {

    @Override
    public void onInitPlayerActivityData(PlayerActivityData playerActivityData) {
        var hideAndSeekPlayerData = HideAndSeekPlayerData.create();

        playerActivityData.setDetail(hideAndSeekPlayerData);
    }

    @Override
    public void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfoOuterClass.ActivityInfo.Builder activityInfo) {
        HideAndSeekPlayerData hideAndSeekPlayerData = getHideAndSeekPlayerData(playerActivityData);

        activityInfo.setHideAndSeekInfo(HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.newBuilder()
//            .addAllChosenHiderSkillList(hideAndSeekPlayerData.getChosenHiderSkillList())
//            .addAllChosenHunterSkillList(hideAndSeekPlayerData.getChosenHunterSkillList())
            .addAllOpenMapInfoList(hideAndSeekPlayerData.getUnlockMapList().stream()
                .map(mapId -> HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.newBuilder()
                    .setId(mapId)
                    .build())
                .collect(Collectors.toList()))
//            .addAllChosenMapList(hideAndSeekPlayerData.getChosenMapList())
//            .addAllUnlockMapList(hideAndSeekPlayerData.getUnlockMapList())
            .build());
    }

    public HideAndSeekPlayerData getHideAndSeekPlayerData(PlayerActivityData playerActivityData) {
        if (playerActivityData.getDetail() == null || playerActivityData.getDetail().isBlank()) {
            onInitPlayerActivityData(playerActivityData);
            playerActivityData.save();
        }

        return JsonUtils.decode(playerActivityData.getDetail(), HideAndSeekPlayerData.class);
    }
}
