package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItemProvider;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class BedrockAxeItem extends AxeItem implements ExtendItemProvider, CreativeShotKillItem {
    public BedrockAxeItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.build());
    }
}