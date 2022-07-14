package me.loving11ish.playerguiadvanced.commands.SubCommands;

import me.loving11ish.playerguiadvanced.commands.SubCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class Reload extends SubCommand {

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
    public void perform(Player player, String[] args) {
        if (player.hasPermission("playergui.reload")){
            PlayerGUIAdvanced.getPlugin().reloadConfig();
            PlayerGUIAdvanced.getPlugin().messagesFileManager.reloadMessagesConfig();
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Plugin-reload-successful")));
        }else {
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Reload-command-no-permission")));
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}