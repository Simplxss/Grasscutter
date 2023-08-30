package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.match.MatchSubType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@ResourceType(name = "MatchExcelConfigData.json", loadPriority = ResourceType.LoadPriority.LOW)
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchData extends GameResource {
    @Getter(onMethod_ = @Override)
    int id;
    MatchSubType matchSubType;
    int minPlayerNum;
    int maxPlayerNum;
    int confirmTime;
}
