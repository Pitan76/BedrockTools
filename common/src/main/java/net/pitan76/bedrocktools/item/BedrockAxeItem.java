package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleAxeItem;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleToolMaterial;

public class BedrockAxeItem extends CompatibleAxeItem implements CreativeShotKillItem {
    public BedrockAxeItem(CompatibleToolMaterial toolMaterial, float attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}