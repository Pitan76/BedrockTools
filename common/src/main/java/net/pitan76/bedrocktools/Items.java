package net.pitan76.bedrocktools;

import net.minecraft.item.Item;
import net.pitan76.bedrocktools.item.*;
import net.pitan76.mcpitanlib.api.item.v2.CompatibleItemSettings;

import static net.pitan76.bedrocktools.BedrockTools._id;

public class Items {
    public static Item OBSIDIAN_SWORD = new BedrockSwordItem(ToolMaterials.OBSIDIAN, 3, -2.4F, CompatibleItemSettings.of(_id("obsidian_sword")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_AXE = new BedrockAxeItem(ToolMaterials.OBSIDIAN, 5.0F, -3.0F, CompatibleItemSettings.of(_id("obsidian_axe")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_PICKAXE = new BedrockPickaxeItem(ToolMaterials.OBSIDIAN, 1, -2.8F, CompatibleItemSettings.of(_id("obsidian_pickaxe")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_SHOVEL = new BedrockShovelItem(ToolMaterials.OBSIDIAN, 1.5F, -3.0F, CompatibleItemSettings.of(_id("obsidian_shovel")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_HOE = new BedrockHoeItem(ToolMaterials.OBSIDIAN, -3, 0F, CompatibleItemSettings.of(_id("obsidian_hoe")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_SWORD = new BedrockSwordItem(ToolMaterials.BEDROCK, 3, -2.4F, CompatibleItemSettings.of(_id("bedrock_sword")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_AXE = new BedrockAxeItem(ToolMaterials.BEDROCK, 5.0F, -3.0F, CompatibleItemSettings.of(_id("bedrock_axe")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_PICKAXE = new BedrockPickaxeItem(ToolMaterials.BEDROCK, 1, -2.8F, CompatibleItemSettings.of(_id("bedrock_pickaxe")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_SHOVEL = new BedrockShovelItem(ToolMaterials.BEDROCK, 1.5F, -3.0F, CompatibleItemSettings.of(_id("bedrock_shovel")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_HOE = new BedrockHoeItem(ToolMaterials.BEDROCK, -3, 0F, CompatibleItemSettings.of(_id("bedrock_hoe")).addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
}
