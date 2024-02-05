package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleSwordItem;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleToolMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;

public class BedrockSwordItem extends CompatibleSwordItem implements CreativeShotKillItem {

    public BedrockSwordItem(CompatibleToolMaterial toolMaterial, int attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public float overrideGetMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (overrideIsSuitableFor(state)) return 100F;
        return super.overrideGetMiningSpeedMultiplier(stack, state);
    }
}