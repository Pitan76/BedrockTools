package net.pitan76.bedrocktools;

import dev.architectury.event.EventResult;
import ml.pkom.mcpitanlibarch.api.event.v0.AttackEntityEventRegistry;
import ml.pkom.mcpitanlibarch.api.item.CreativeTabBuilder;
import ml.pkom.mcpitanlibarch.api.registry.ArchRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.pitan76.bedrocktools.item.CreativeShotKillItem;

public class BedrockTools {
    public static final String MOD_ID = "bedrocktools76";

    public static final ArchRegistry registry = ArchRegistry.createRegistry(MOD_ID);

    public static final ItemGroup BEDROCK_TOOLS_GROUP = CreativeTabBuilder.create(id("tools")).setIcon(() -> new ItemStack(Items.BEDROCK_PICKAXE, 1)).build();

    public static void init() {
        Config.init(FabricLoader.getInstance().getConfigDir().toFile());

        registry.registerItemGroup(id("tools"), () -> BEDROCK_TOOLS_GROUP);

        registry.registerItem(id("obsidian_sword"), () -> Items.OBSIDIAN_SWORD);
        registry.registerItem(id("obsidian_axe"), () -> Items.OBSIDIAN_AXE);
        registry.registerItem(id("obsidian_pickaxe"), () -> Items.OBSIDIAN_PICKAXE);
        registry.registerItem(id("obsidian_shovel"), () -> Items.OBSIDIAN_SHOVEL);
        registry.registerItem(id("obsidian_hoe"), () -> Items.OBSIDIAN_HOE);
        registry.registerItem(id("bedrock_sword"), () -> Items.BEDROCK_SWORD);
        registry.registerItem(id("bedrock_axe"), () -> Items.BEDROCK_AXE);
        registry.registerItem(id("bedrock_pickaxe"), () -> Items.BEDROCK_PICKAXE);
        registry.registerItem(id("bedrock_shovel"), () -> Items.BEDROCK_SHOVEL);
        registry.registerItem(id("bedrock_hoe"), () -> Items.BEDROCK_HOE);

        registry.allRegister();

        AttackEntityEventRegistry.register(
                (player, world, entity, hand, result) -> {
                    if (!player.isCreative()) return EventResult.pass();
                    if (!(player.getStackInHand(hand).getItem() instanceof CreativeShotKillItem)) return EventResult.pass();
                    entity.kill();
                    return EventResult.interruptTrue();
                }
        );
    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }
}