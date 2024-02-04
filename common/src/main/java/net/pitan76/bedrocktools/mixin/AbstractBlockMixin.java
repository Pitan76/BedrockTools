package net.pitan76.bedrocktools.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.pitan76.bedrocktools.item.BedrockPickaxeItem;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {
    @Inject(method = "calcBlockBreakingDelta", at = @At(value = "JUMP", opcode = Opcodes.IFNE, shift = At.Shift.AFTER), cancellable = true, locals = LocalCapture.CAPTURE_FAILSOFT)
    public void inject_calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos, CallbackInfoReturnable<Float> cir, float hardness) {
        ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);
        if (hardness == -1.0F && stack.getItem() instanceof BedrockPickaxeItem) {
            int effective = player.canHarvest(state) ? 30 : 100;
            if (state.getBlock() == Blocks.BEDROCK) {
                cir.setReturnValue(player.getBlockBreakingSpeed(state) / 20F / effective);
                return;
            }
            if (state.getBlock() == Blocks.END_PORTAL_FRAME) {
                cir.setReturnValue(player.getBlockBreakingSpeed(state) / 5F / effective);
                return;
            }

            cir.setReturnValue(player.getBlockBreakingSpeed(state) / 10F / effective);
        }
    }
}
