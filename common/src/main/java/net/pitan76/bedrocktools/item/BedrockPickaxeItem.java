package net.pitan76.bedrocktools.item;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatiblePickaxeItem;
import ml.pkom.mcpitanlibarch.api.item.tool.CompatibleToolMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;

public class BedrockPickaxeItem extends CompatiblePickaxeItem implements CreativeShotKillItem {
    public BedrockPickaxeItem(CompatibleToolMaterial toolMaterial, int attackDamage, float attackSpeed, CompatibleItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean overrideIsSuitableFor(BlockState state) {
        if (state.isOf(Blocks.BEDROCK)) return true;
        return super.overrideIsSuitableFor(state);
    }

    @Override
    public float overrideGetMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return super.overrideGetMiningSpeedMultiplier(stack, state);
    }
}