package net.pitan76.bedrocktools.fabric;

import net.pitan76.bedrocktools.BedrockTools;
import net.fabricmc.api.ModInitializer;

public class BedrockToolsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BedrockTools.init();
    }
}