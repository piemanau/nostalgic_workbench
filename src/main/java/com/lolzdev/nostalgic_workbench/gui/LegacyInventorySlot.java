package com.lolzdev.nostalgic_workbench.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class LegacyInventorySlot extends Slot {
    public LegacyInventorySlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return true;
    }
}
