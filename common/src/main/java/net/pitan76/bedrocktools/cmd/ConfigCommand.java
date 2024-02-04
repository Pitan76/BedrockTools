package net.pitan76.bedrocktools.cmd;

import com.mojang.brigadier.arguments.StringArgumentType;
import ml.pkom.mcpitanlibarch.api.command.CommandSettings;
import ml.pkom.mcpitanlibarch.api.command.LiteralCommand;
import ml.pkom.mcpitanlibarch.api.command.argument.StringCommand;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.StringCommandEvent;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.pitan76.bedrocktools.Config;

public class ConfigCommand extends LiteralCommand {

    @Override
    public void init(CommandSettings settings) {
        settings.permissionLevel(3);

        addArgumentCommand("set", new StringCommand() {
            @Override
            public String getArgumentName() {
                return "key";
            }

            @Override
            public void init(CommandSettings settings) {

                addArgumentCommand("value", new StringCommand() {
                    @Override
                    public String getArgumentName() {
                        return "value";
                    }

                    @Override
                    public void execute(StringCommandEvent event) {
                        String key = StringArgumentType.getString(event.context, "key");
                        String value = StringArgumentType.getString(event.context, "value");
                        if (Config.config.get(key) == null) {
                            event.sendFailure(TextUtil.literal("[BedrockTools] Key not found."));
                            return;
                        }
                        if (Config.config.get(key).getClass() == String.class) {
                            Config.config.setString(key, value);
                            event.sendSuccess(TextUtil.literal("[BedrockTools] Set " + key + " to " + value), false);

                        } else if (Config.config.get(key).getClass() == Integer.class) {
                            Config.config.setInt(key, Integer.parseInt(value));
                            event.sendSuccess(TextUtil.literal("[BedrockTools] Set " + key + " to " + value), false);

                        } else if (Config.config.get(key).getClass() == Double.class) {
                            Config.config.setDouble(key, Double.parseDouble(value));
                            event.sendSuccess(TextUtil.literal("[BedrockTools] Set " + key + " to " + value), false);

                        } else if (Config.config.get(key).getClass() == Boolean.class) {
                            Config.config.setBoolean(key, Boolean.parseBoolean(value));
                            event.sendSuccess(TextUtil.literal("[BedrockTools] Set " + key + " to " + value), false);

                        } else {
                            event.sendFailure(TextUtil.literal("[BedrockTools] Not supported type."));
                        }
                        Config.save();
                    }
                });
            }

            @Override
            public void execute(StringCommandEvent event) {
            }
        });

        addArgumentCommand("get", new StringCommand() {
            @Override
            public String getArgumentName() {
                return "key";
            }

            @Override
            public void execute(StringCommandEvent event) {
                String key = StringArgumentType.getString(event.context, "key");
                if (Config.config.get(key) == null) {
                    event.sendFailure(TextUtil.literal("[BedrockTools] Key not found."));
                    return;
                }
                event.sendSuccess(TextUtil.literal("[BedrockTools] " + key + ": " + Config.config.get(key).toString()), false);
            }
        });

        addArgumentCommand("list", new LiteralCommand() {
            @Override
            public void execute(ServerCommandEvent event) {
                event.sendSuccess(TextUtil.literal("[BedrockTools] Config List"), false);
                for (String key : Config.config.configMap.keySet()) {
                    event.sendSuccess(TextUtil.literal(" - " + key + ": " + Config.config.get(key).toString()), false);
                }
            }
        });

        addArgumentCommand("reset", new LiteralCommand() {
            @Override
            public void execute(ServerCommandEvent event) {
                Config.config.configMap.clear();
                Config.fixConfig();
                Config.save();
                event.sendSuccess(TextUtil.literal("[BedrockTools] Reset config."), false);
            }
        });
    }

    @Override
    public void execute(ServerCommandEvent event) {
    }
}
