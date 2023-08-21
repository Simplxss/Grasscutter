package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import lombok.Getter;

@ResourceType(name = "HideAndSeekAvatarSDExcelConfigData.json")
@Getter
public class HideAndSeekAvatarSDData extends GameResource {
    private int avatarId;
    private int descTextMapHash;

    @Override
    public int getId() {
        return this.avatarId;
    }

}
