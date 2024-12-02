package net.pitan76.bedrocktools.item;

import net.pitan76.bedrocktools.Items;
import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;
import net.pitan76.mcpitanlib.api.util.ItemStackUtil;

import static net.pitan76.bedrocktools.BedrockTools._id;

public class CreativeTabs {
    public static final CreativeTabBuilder BEDROCK_TOOLS_GROUP = CreativeTabBuilder.create(_id("tools")).setIcon(() -> ItemStackUtil.create(Items.BEDROCK_PICKAXE, 1));

}
