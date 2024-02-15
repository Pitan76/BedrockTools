package net.pitan76.bedrocktools.item;

import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.tool.CompatibleHoeItem;
import net.pitan76.mcpitanlib.api.item.tool.CompatibleToolMaterial;

public class BedrockHoeItem extends CompatibleHoeItem implements CreativeShotKillItem {
    public BedrockHoeItem(CompatibleToolMaterial toolMaterial, int attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);

    }
}