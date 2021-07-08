package com.lolzdev.nostalgic_workbench.gui;

import com.lolzdev.nostalgic_workbench.util.IItemRendererDuck;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class LegacyCraftingScreen extends HandledScreen<LegacyCraftingScreenHandler> {

    private float mouseX;
    private float mouseY;
    private static final Identifier TEXTURE = new Identifier("nostalgic_workbench", "textures/gui/legacy_crafting.png");

    public LegacyCraftingScreen(LegacyCraftingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.passEvents = true;
        this.titleX = 97;
        this.backgroundWidth = 256;
        this.backgroundHeight = 192;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        this.drawTexture(matrices, x, y, 0, 27, 256, 192);
        ((IItemRendererDuck)MinecraftClient.getInstance().getItemRenderer()).renderSizedGuiItemModel(new ItemStack(Items.APPLE), x+136, y+115, MinecraftClient.getInstance().getItemRenderer().getHeldItemModel(new ItemStack(Items.APPLE), (World)null, (LivingEntity)null, 0), 11.5f, 11.5f);

        this.textRenderer.draw(matrices, new TranslatableText("Inventory"), x+167, y+106, 4210752);
        this.textRenderer.draw(matrices, new TranslatableText("Crafting"), x+50, y+106, 4210752);
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {

    }
}
