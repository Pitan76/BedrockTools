package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItemProvider;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class BedrockShovelItem extends ShovelItem implements ExtendItemProvider, CreativeShotKillItem {
    public BedrockShovelItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.build());

    }
}