package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItemProvider;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class BedrockHoeItem extends HoeItem implements ExtendItemProvider, CreativeShotKillItem {
    public BedrockHoeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.build());

    }
}