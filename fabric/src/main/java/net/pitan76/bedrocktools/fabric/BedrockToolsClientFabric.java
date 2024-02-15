package net.pitan76.bedrocktools.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.pitan76.bedrocktools.client.BedrockToolsClient;

public class BedrockToolsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BedrockToolsClient.init();
    }
}
