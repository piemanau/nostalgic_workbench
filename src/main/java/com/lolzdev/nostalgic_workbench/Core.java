package com.lolzdev.nostalgic_workbench;

import com.lolzdev.nostalgic_workbench.client.OpenScreenPacket;
import com.lolzdev.nostalgic_workbench.gui.LegacyInventoryScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class Core implements ModInitializer {

    public static ScreenHandlerType<LegacyInventoryScreenHandler> LEGACY_INVENTORY_SCREEN_HANDLER;



    @Override
    public void onInitialize() {
        ServerPlayNetworking.registerGlobalReceiver(OpenScreenPacket.ID, OpenScreenPacket::handle);
        LEGACY_INVENTORY_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("nostalgic_workbench", "legacy_inventory"), LegacyInventoryScreenHandler::new);
    }
}
