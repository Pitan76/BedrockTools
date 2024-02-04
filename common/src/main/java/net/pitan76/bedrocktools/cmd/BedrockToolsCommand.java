package net.pitan76.bedrocktools.cmd;

import ml.pkom.mcpitanlibarch.api.command.CommandSettings;
import ml.pkom.mcpitanlibarch.api.command.LiteralCommand;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.pitan76.bedrocktools.Config;

import java.util.Optional;

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

        addArgumentCommand("config", new ConfigCommand());

        addArgumentCommand("version", new LiteralCommand() {
            @Override
            public void execute(ServerCommandEvent event) {
                Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("bedrocktools76");
                if (!modContainer.isPresent()) {
                    event.sendFailure(TextUtil.literal("[BedrockTools] Failed to get version!"));
                    return;
                }
                event.sendSuccess(TextUtil.literal("[BedrockTools] v" + modContainer.get().getMetadata().getVersion()), false);
            }
        });
    }

    @Override
    public void execute(ServerCommandEvent event) {
        event.sendSuccess(TextUtil.literal("[BedrockTools] Command List:"
                + "\n- /bedrocktools76 version...Show version"
                + "\n- /bedrocktools76 reload...Reload config"
                + "\n- /bedrocktools76 config set [Key] [Value]...Set config"
                + "\n- /bedrocktools76 config get [Key]...Get config"
                + "\n- /bedrocktools76 config list...List config"
                + "\n- /bedrocktools76 config reset...Reset config"
        ), false);
    }
}
