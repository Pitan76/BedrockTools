package net.pitan76.bedrocktools;

import net.minecraft.item.Item;
import net.pitan76.bedrocktools.item.*;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;

public class Items {
    public static Item OBSIDIAN_SWORD = new BedrockSwordItem(ToolMaterials.OBSIDIAN, 3, -2.4F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_AXE = new BedrockAxeItem(ToolMaterials.OBSIDIAN, 5.0F, -3.0F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_PICKAXE = new BedrockPickaxeItem(ToolMaterials.OBSIDIAN, 1, -2.8F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_SHOVEL = new BedrockShovelItem(ToolMaterials.OBSIDIAN, 1.5F, -3.0F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item OBSIDIAN_HOE = new BedrockHoeItem(ToolMaterials.OBSIDIAN, -3, 0F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_SWORD = new BedrockSwordItem(ToolMaterials.BEDROCK, 3, -2.4F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_AXE = new BedrockAxeItem(ToolMaterials.BEDROCK, 5.0F, -3.0F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_PICKAXE = new BedrockPickaxeItem(ToolMaterials.BEDROCK, 1, -2.8F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_SHOVEL = new BedrockShovelItem(ToolMaterials.BEDROCK, 1.5F, -3.0F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
    public static Item BEDROCK_HOE = new BedrockHoeItem(ToolMaterials.BEDROCK, -3, 0F, CompatibleItemSettings.of().addGroup(CreativeTabs.BEDROCK_TOOLS_GROUP));
}
