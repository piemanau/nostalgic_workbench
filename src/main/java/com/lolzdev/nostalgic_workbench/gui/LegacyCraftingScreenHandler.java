package com.lolzdev.nostalgic_workbench.gui;

import com.lolzdev.nostalgic_workbench.Core;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;

public class LegacyCraftingScreenHandler extends ScreenHandler {

    public LegacyCraftingScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(Core.LEGACY_CRAFTING_SCREEN_HANDLER, syncId);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
