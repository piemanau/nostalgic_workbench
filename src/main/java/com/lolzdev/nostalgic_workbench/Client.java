package com.lolzdev.nostalgic_workbench;

import com.lolzdev.nostalgic_workbench.gui.LegacyInventoryScreen;
import com.lolzdev.nostalgic_workbench.gui.LegacyInventoryScreenHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {

        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nostalgic_workbench.inventory", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_I, // The keycode of the key
                "category.nostalgic_workbench" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                client.openScreen(new LegacyInventoryScreen(new LegacyInventoryScreenHandler(6, client.player.getInventory()), client.player.getInventory(), new TranslatableText("container.legacy_inventory")));
            }
        });

        ScreenRegistry.register(Core.LEGACY_INVENTORY_SCREEN_HANDLER, LegacyInventoryScreen::new);
    }
}
