package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import lombok.Getter;

import java.util.List;
@ResourceType(name = {"ForgeExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGHEST)
@Getter
public class HideAndSeekSkillData extends GameResource {
    @Getter(onMethod = @__(@Override))
    private int id;
    private int skillID;
    private int order;
    private SkillCategory skillCategory;
    private SkillSubCategory skillSubCategory;
    private boolean isDefault;
    private int categoryDescTextMapHash;

    private enum SkillCategory {
        HIDE_AND_SEEK_SKILL_CATEGORY_HUNTER,
        HIDE_AND_SEEK_SKILL_CATEGORY_PREY
    }

    private enum SkillSubCategory {
        HIDE_AND_SEEK_SKILL_SUB_CATEGORY_COMMON,
        HIDE_AND_SEEK_SKILL_SUB_CATEGORY_SKILL1,
        HIDE_AND_SEEK_SKILL_SUB_CATEGORY_SKILL2,

    }
}
