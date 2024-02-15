package net.pitan76.bedrocktools.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.bedrocktools.Items;
import net.pitan76.bedrocktools.item.BedrockPickaxeItem;
import net.pitan76.mcpitanlib.api.entity.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "onBreak", at = @At("HEAD"))
    private void inject_onBreak(World world, BlockPos pos, BlockState state, PlayerEntity playerEntity, CallbackInfo ci) {
        Player player = new Player(playerEntity);
        ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);
        if (!(stack.getItem() instanceof BedrockPickaxeItem)) return;
        if (player.isCreative()) return;

        if (state.getBlock() == Blocks.BEDROCK)
            Block.dropStack(world, pos, new ItemStack(Blocks.BEDROCK));
        if (state.getBlock() == Blocks.END_PORTAL_FRAME)
            Block.dropStack(world, pos, new ItemStack(Blocks.END_PORTAL_FRAME));

        if (stack.getItem() == Items.OBSIDIAN_PICKAXE) {
            stack.damage(999, playerEntity, (p) -> p.sendToolBreakStatus(Hand.MAIN_HAND));
        }
    }
}
