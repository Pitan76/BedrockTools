package net.pitan76.bedrocktools;

import ml.pkom.easyapi.FileControl;
import ml.pkom.easyapi.config.JsonConfig;

import java.io.File;

public class Config {
    public static File configDir;
    public static String fileName = BedrockTools.MOD_ID + ".json";

    public static JsonConfig config = new JsonConfig();

    public static boolean initialized = false;

    public static void init(File configDir) {
        if (initialized) return;
        initialized = true;
        setConfigDir(configDir);

        if (FileControl.fileExists(getConfigFile()))
            config.load(getConfigFile());
        else
            config.save(getConfigFile());

        // 既存の設定以外をデフォルト設定にする (Set to default settings except for existing settings)
        fixConfig();
    }

    public static File getConfigFile() {
        return new File(getConfigDir(), fileName);
    }

    public static void setConfigDir(File configDir) {
        Config.configDir = configDir;
    }

    public static File getConfigDir() {
        return configDir;
    }

    public static boolean reload() {
        if (FileControl.fileExists(getConfigFile())) {
            config.load(getConfigFile());
            return true;
        }
        return false;
    }

    public static void fixConfig() {
        if (!config.has("toolmaterials.obsidian.miningLevel"))
            config.setInt("toolmaterials.obsidian.miningLevel", 2);
        if (!config.has("toolmaterials.obsidian.itemDurability"))
            config.setInt("toolmaterials.obsidian.itemDurability", 3500);
        if (!config.has("toolmaterials.obsidian.miningSpeed"))
            config.setDouble("toolmaterials.obsidian.miningSpeed", 5.0);
        if (!config.has("toolmaterials.obsidian.attackDamage"))
            config.setDouble("toolmaterials.obsidian.attackDamage", 3.0);
        if (!config.has("toolmaterials.obsidian.enchantability"))
            config.setInt("toolmaterials.obsidian.enchantability", 5);

        if (!config.has("toolmaterials.bedrock.miningLevel"))
            config.setInt("toolmaterials.bedrock.miningLevel", 3);
        if (!config.has("toolmaterials.bedrock.itemDurability"))
            config.setInt("toolmaterials.bedrock.itemDurability", 60000);
        if (!config.has("toolmaterials.bedrock.miningSpeed"))
            config.setDouble("toolmaterials.bedrock.miningSpeed", 7.0);
        if (!config.has("toolmaterials.bedrock.attackDamage"))
            config.setDouble("toolmaterials.bedrock.attackDamage", 3.5);
        if (!config.has("toolmaterials.bedrock.enchantability"))
            config.setInt("toolmaterials.bedrock.enchantability", 3);
    }

    public static void save() {
        config.save(getConfigFile());
    }
}
