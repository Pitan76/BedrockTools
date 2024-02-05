package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleShovelItem;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleToolMaterial;

public class BedrockShovelItem extends CompatibleShovelItem implements CreativeShotKillItem {
    public BedrockShovelItem(CompatibleToolMaterial toolMaterial, float attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);

    }
}