package net.pitan76.bedrocktools.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.tool.CompatiblePickaxeItem;
import net.pitan76.mcpitanlib.api.item.tool.CompatibleToolMaterial;

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