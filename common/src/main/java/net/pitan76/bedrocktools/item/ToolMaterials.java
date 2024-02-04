package net.pitan76.bedrocktools.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.pitan76.bedrocktools.Config;

public enum ToolMaterials implements ToolMaterial {

    OBSIDIAN(Ingredient.ofItems(Items.OBSIDIAN)),
    BEDROCK(Ingredient.ofItems(Items.BEDROCK)),
    ;

    private final String configPath = "toolmaterials." + this.name().toLowerCase();
    private final Ingredient repairIngredient;

    ToolMaterials(Ingredient repairIngredient) {
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return Config.config.getInt(configPath + ".itemDurability");
    }

    public float getMiningSpeedMultiplier() {
        return (float) Config.config.getDouble(configPath + ".miningSpeed");
    }

    public float getAttackDamage() {
        return (float) Config.config.getDouble(configPath + ".attackDamage");
    }

    public int getMiningLevel() {
        return Config.config.getInt(configPath + ".miningLevel");
    }

    public int getEnchantability() {
        return Config.config.getInt(configPath + ".enchantability");
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}