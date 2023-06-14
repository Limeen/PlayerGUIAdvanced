package me.loving11ish.playerguiadvanced.commands.ConsoleCommands;

import com.tcoded.folialib.FoliaLib;
import me.loving11ish.playerguiadvanced.commands.ConsoleCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ConsoleReload extends ConsoleCommand {

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
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Plugin-reload-begin")));
        FoliaLib foliaLib = PlayerGUIAdvanced.getFoliaLib();
        PlayerGUIAdvanced.getPlugin().onDisable();
        foliaLib.getImpl().runLater(new Runnable() {
            @Override
            public void run() {
                Bukkit.getPluginManager().getPlugin("PlayerGUIAdvanced").onEnable();
            }
        }, 5L, TimeUnit.SECONDS);
        foliaLib.getImpl().runLater(new Runnable() {
            @Override
            public void run() {
                PlayerGUIAdvanced.getPlugin().reloadConfig();
                PlayerGUIAdvanced.getPlugin().messagesFileManager.reloadMessagesConfig();
                PlayerGUIAdvanced.getPlugin().playersGUIManager.reloadPlayersGUIConfig();
                PlayerGUIAdvanced.getPlugin().actionsGUIManager.reloadActionsGUIConfig();
                PlayerGUIAdvanced.getPlugin().banGUIManager.reloadBanGUIConfig();
                logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Plugin-reload-successful")));
            }
        }, 5L, TimeUnit.SECONDS);
    }
}
