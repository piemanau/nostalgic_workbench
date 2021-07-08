package com.lolzdev.nostalgic_workbench.util;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public interface IItemRendererDuck {

    void renderSizedGuiItemModel(ItemStack stack, int x, int y, BakedModel model, float width, float height);

    void renderItem(ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model);
}
