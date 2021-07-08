package com.lolzdev.nostalgic_workbench.mixin;

import com.lolzdev.nostalgic_workbench.gui.LegacyCraftingScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(CraftingTableBlock.class)
public class CraftingTableMixin {

    private static final Text TITLE = new TranslatableText("container.crafting");

    /**
     * @author LolzDEV
     */
    @Overwrite
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new LegacyCraftingScreenHandler(syncId, inventory), TITLE);
    }
}
