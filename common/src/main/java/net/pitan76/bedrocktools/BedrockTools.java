package net.pitan76.bedrocktools;

import dev.architectury.event.EventResult;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.bedrocktools.cmd.BedrockToolsCommand;
import net.pitan76.bedrocktools.item.BedrockPickaxeItem;
import net.pitan76.bedrocktools.item.CreativeShotKillItem;
import net.pitan76.bedrocktools.item.CreativeTabs;
import net.pitan76.mcpitanlib.api.command.CommandRegistry;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.event.block.result.BlockBreakResult;
import net.pitan76.mcpitanlib.api.event.v0.AttackEntityEventRegistry;
import net.pitan76.mcpitanlib.api.event.v2.BlockEventRegistry;
import net.pitan76.mcpitanlib.api.registry.v2.CompatRegistryV2;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.mcpitanlib.api.util.EntityUtil;
import net.pitan76.mcpitanlib.api.util.ItemStackUtil;

public class BedrockTools {
    public static final String MOD_ID = "bedrocktools76";

    public static final CompatRegistryV2 registry = CompatRegistryV2.create(MOD_ID);

    public static void init() {
        registry.registerItemGroup(_id("tools"), CreativeTabs.BEDROCK_TOOLS_GROUP);

        registry.registerItem(_id("obsidian_sword"), () -> Items.OBSIDIAN_SWORD);
        registry.registerItem(_id("obsidian_axe"), () -> Items.OBSIDIAN_AXE);
        registry.registerItem(_id("obsidian_pickaxe"), () -> Items.OBSIDIAN_PICKAXE);
        registry.registerItem(_id("obsidian_shovel"), () -> Items.OBSIDIAN_SHOVEL);
        registry.registerItem(_id("obsidian_hoe"), () -> Items.OBSIDIAN_HOE);
        registry.registerItem(_id("bedrock_sword"), () -> Items.BEDROCK_SWORD);
        registry.registerItem(_id("bedrock_axe"), () -> Items.BEDROCK_AXE);
        registry.registerItem(_id("bedrock_pickaxe"), () -> Items.BEDROCK_PICKAXE);
        registry.registerItem(_id("bedrock_shovel"), () -> Items.BEDROCK_SHOVEL);
        registry.registerItem(_id("bedrock_hoe"), () -> Items.BEDROCK_HOE);

        CommandRegistry.register("bedrocktools76", new BedrockToolsCommand());

        registry.allRegister();

        AttackEntityEventRegistry.register(
                (player, world, entity, hand, result) -> {
                    if (!player.isCreative()) return EventResult.pass();
                    if (!(player.getStackInHand(hand).getItem() instanceof CreativeShotKillItem)) return EventResult.pass();
                    EntityUtil.kill(entity);
                    return EventResult.interruptTrue();
                }
        );

        BlockEventRegistry.ON_BREAK.register(e -> {
            Player player = e.player;
            ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);
            if (!(stack.getItem() instanceof BedrockPickaxeItem) || player.isCreative()) return new BlockBreakResult(e.state);
            BlockState state = e.state;
            World world = e.world;
            BlockPos pos = e.pos;

            if (state.getBlock() == Blocks.BEDROCK)
                Block.dropStack(world, pos, ItemStackUtil.create(Blocks.BEDROCK));
            if (state.getBlock() == Blocks.END_PORTAL_FRAME)
                Block.dropStack(world, pos, ItemStackUtil.create(Blocks.END_PORTAL_FRAME));

            if (stack.getItem() == Items.OBSIDIAN_PICKAXE && !player.isClient())
                ItemStackUtil.damage(stack, 999, (ServerPlayerEntity) player.getPlayerEntity());

            return new BlockBreakResult(e.state);
        });
    }

    public static CompatIdentifier _id(String name) {
        return CompatIdentifier.of(MOD_ID, name);
    }
}