package net.pitan76.bedrocktools.fabric;

import net.pitan76.bedrocktools.client.BedrockToolsClient;
import net.fabricmc.api.ClientModInitializer;

public class BedrockToolsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BedrockToolsClient.init();
    }
}
