package net.pitan76.bedrocktools.item;

import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.pitan76.bedrocktools.BedrockTools;
import net.pitan76.bedrocktools.Config;
import net.pitan76.mcpitanlib.api.item.v3.CompatToolMaterial;
import net.pitan76.mcpitanlib.api.tag.item.RepairIngredientTag;

public enum ToolMaterials implements CompatToolMaterial {

    OBSIDIAN(Ingredient.ofItems(Items.OBSIDIAN)),
    BEDROCK(Ingredient.ofItems(Items.BEDROCK)),
    ;

    private final String configPath = "toolmaterials." + this.name().toLowerCase();
    private final Ingredient repairIngredient;

    ToolMaterials(Ingredient repairIngredient) {
        this.repairIngredient = repairIngredient;
    }

    public int getCompatDurability() {
        return Config.config.getInt(configPath + ".itemDurability");
    }

    public float getCompatMiningSpeedMultiplier() {
        return (float) Config.config.getDouble(configPath + ".miningSpeed");
    }

    public float getCompatAttackDamage() {
        return (float) Config.config.getDouble(configPath + ".attackDamage");
    }

    public int getCompatMiningLevel() {
        return Config.config.getInt(configPath + ".miningLevel");
    }

    public int getCompatEnchantability() {
        return Config.config.getInt(configPath + ".enchantability");
    }

    public Ingredient getCompatRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    public RepairIngredientTag getRepairIngredientTag() {
        return new RepairIngredientTag(BedrockTools._id(this.name().toLowerCase() + "_tool_materials"));
    }
}