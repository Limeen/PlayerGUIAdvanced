package me.loving11ish.playerguiadvanced.commands.SubCommands;

import me.loving11ish.playerguiadvanced.commands.SubCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class Help extends SubCommand {

    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return ChatColor.AQUA + "This shows the PlayerGUI full command and permissions lists.";
    }

    @Override
    public String getSyntax() {
        return ChatColor.AQUA + "/pl help";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (player.hasPermission("playergui.help")) {
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-1")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-2")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-3")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-4")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-5")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-6")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-7")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-8")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-9")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-10")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-11")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-12")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-13")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-14")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-15")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-16")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-17")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-18")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-19")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-20")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-21")));
        } else {
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-command-no-permission")));
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}
