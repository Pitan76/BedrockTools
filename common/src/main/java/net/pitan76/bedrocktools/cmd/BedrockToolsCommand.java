package net.pitan76.bedrocktools.cmd;

import net.pitan76.bedrocktools.Config;
import net.pitan76.mcpitanlib.api.command.CommandSettings;
import net.pitan76.mcpitanlib.api.command.ConfigCommand;
import net.pitan76.mcpitanlib.api.command.LiteralCommand;
import net.pitan76.mcpitanlib.api.event.ServerCommandEvent;
import net.pitan76.mcpitanlib.api.util.TextUtil;

public class BedrockToolsCommand extends LiteralCommand {
    @Override
    public void init(CommandSettings settings) {

        addArgumentCommand("reload", new LiteralCommand() {
            @Override
            public void init(CommandSettings settings) {
                settings.permissionLevel(2);
            }

            @Override
            public void execute(ServerCommandEvent event) {
                event.sendSuccess(TextUtil.literal("[BedrockTools] Reloading..."), false);
                if (Config.reload()) {
                    event.sendSuccess(TextUtil.literal("[BedrockTools] Reloaded!"), false);
                } else {
                    event.sendFailure(TextUtil.literal("[BedrockTools] Failed to reload!"));
                }
            }
        });

        addArgumentCommand("config", new ConfigCommand(Config.config, Config.getConfigFile(), "[BedrockTools]", Config::fixConfig));
    }

    @Override
    public void execute(ServerCommandEvent event) {
        event.sendSuccess(TextUtil.literal("[BedrockTools] Command List:"
                + "\n- /bedrocktools76 reload...Reload config"
                + "\n- /bedrocktools76 config set [Key] [Value]...Set config"
                + "\n- /bedrocktools76 config get [Key]...Get config"
                + "\n- /bedrocktools76 config list...List config"
                + "\n- /bedrocktools76 config reset...Reset config"
        ), false);
    }
}
