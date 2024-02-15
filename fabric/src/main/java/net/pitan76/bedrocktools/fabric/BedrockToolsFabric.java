package net.pitan76.bedrocktools.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.pitan76.bedrocktools.BedrockTools;
import net.pitan76.bedrocktools.Config;

public class BedrockToolsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Config.init(FabricLoader.getInstance().getConfigDir().toFile());
        BedrockTools.init();
    }
}