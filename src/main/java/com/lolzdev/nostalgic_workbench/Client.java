package com.lolzdev.nostalgic_workbench;

import com.lolzdev.nostalgic_workbench.client.OpenScreenPacket;
import com.lolzdev.nostalgic_workbench.gui.LegacyCraftingScreen;
import com.lolzdev.nostalgic_workbench.gui.LegacyInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {

        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nostalgic_workbench.inventory",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                "category.nostalgic_workbench"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (keyBinding.wasPressed()) {
                OpenScreenPacket.send();
            }
        });

        ScreenRegistry.register(Core.LEGACY_INVENTORY_SCREEN_HANDLER, LegacyInventoryScreen::new);
        ScreenRegistry.register(Core.LEGACY_CRAFTING_SCREEN_HANDLER, LegacyCraftingScreen::new);
    }
}
