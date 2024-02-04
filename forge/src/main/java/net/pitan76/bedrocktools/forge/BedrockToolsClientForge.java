package net.pitan76.bedrocktools.forge;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.pitan76.bedrocktools.client.BedrockToolsClient;

public class BedrockToolsClientForge {
    public static void clientInit(FMLClientSetupEvent event) {
        BedrockToolsClient.init();
    }
}
