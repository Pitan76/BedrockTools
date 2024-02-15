package net.pitan76.bedrocktools.item;

import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.tool.CompatibleAxeItem;
import net.pitan76.mcpitanlib.api.item.tool.CompatibleToolMaterial;

public class BedrockAxeItem extends CompatibleAxeItem implements CreativeShotKillItem {
    public BedrockAxeItem(CompatibleToolMaterial toolMaterial, float attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}