package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleHoeItem;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleToolMaterial;

public class BedrockHoeItem extends CompatibleHoeItem implements CreativeShotKillItem {
    public BedrockHoeItem(CompatibleToolMaterial toolMaterial, int attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);

    }
}