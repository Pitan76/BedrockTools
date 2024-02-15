package net.pitan76.bedrocktools.item;

import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.tool.CompatibleShovelItem;
import net.pitan76.mcpitanlib.api.item.tool.CompatibleToolMaterial;

public class BedrockShovelItem extends CompatibleShovelItem implements CreativeShotKillItem {
    public BedrockShovelItem(CompatibleToolMaterial toolMaterial, float attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);

    }
}