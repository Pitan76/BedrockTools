package net.pitan76.bedrocktools.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.pitan76.bedrocktools.Items;
import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;

import static net.pitan76.bedrocktools.BedrockTools.id;

public class CreativeTabs {
    public static final ItemGroup BEDROCK_TOOLS_GROUP = CreativeTabBuilder.create(id("tools")).setIcon(() -> new ItemStack(Items.BEDROCK_PICKAXE, 1)).build();

}
