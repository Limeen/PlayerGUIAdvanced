package me.loving11ish.playerguiadvanced.commands.ConsoleCommands;

import me.loving11ish.playerguiadvanced.commands.ConsoleCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.logging.Logger;

public class Reload extends ConsoleCommand {

    Logger logger = PlayerGUIAdvanced.getPlugin().getLogger();
    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return ChatColor.AQUA + "This reloads the plugin config file.";
    }

    @Override
    public String getSyntax() {
        return ChatColor.AQUA + "/pl reload";
    }

    @Override
    public void perform(String[] args) {
        PlayerGUIAdvanced.getPlugin().reloadConfig();
        PlayerGUIAdvanced.getPlugin().messagesFileManager.reloadMessagesConfig();
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Plugin-reload-successful")));
    }
}
