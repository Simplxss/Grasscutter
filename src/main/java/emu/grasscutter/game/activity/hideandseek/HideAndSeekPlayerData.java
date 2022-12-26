package emu.grasscutter.game.activity.hideandseek;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(builderMethodName = "of")
public class HideAndSeekPlayerData {

    List<Integer> chosenHunterSkillList;
    List<Integer> chosenHiderSkillList;
    List<Integer> chosenMapList;
    List<Integer> unlockMapList;

    public static HideAndSeekPlayerData create() {
        return HideAndSeekPlayerData.of()
            .build();
    }
}
