package net.pitan76.bedrocktools.forge;

import dev.architectury.platform.forge.EventBuses;
import ml.pkom.mcpitanlibarch.api.util.PlatformUtil;
import net.pitan76.bedrocktools.BedrockTools;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BedrockTools.MOD_ID)
public class BedrockToolsForge {
    public BedrockToolsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(BedrockTools.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        BedrockTools.init();

        if (PlatformUtil.isClient()) {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(BedrockToolsClientForge::clientInit);
        }
    }
}