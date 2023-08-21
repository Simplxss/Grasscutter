package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import lombok.Getter;

import java.util.List;

@ResourceType(name = "HideAndSeekMatchExcelConfigData.json")
@Getter
public class HideAndSeekMatchData extends GameResource {
    @Getter(onMethod = @__(@Override))
    private int id;
    private int titleTextMapHash;
    private int unlockTipsTextMapHash;
    private long FMHPOADCFBG;
    private long AALKCLMKLJG;
    private int dscTextMapHash;
    private int mapIconPathHashSuffix;
    private int mapSmallIconPathHashPre;
    private long mapIconPathHashPre;
    private int mapSmallIconPathHashSuffix;
    private int sceneId;
    private int groupId;
    private int[] transportPointList;
    private int[] durationList;
    private int galleryID;
    private List<Cond> cond;

    private static class Cond {
        private int type;
        private int value;
    }
}
