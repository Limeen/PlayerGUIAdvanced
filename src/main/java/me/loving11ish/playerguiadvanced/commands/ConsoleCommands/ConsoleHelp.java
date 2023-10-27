package me.loving11ish.playerguiadvanced.commands.ConsoleCommands;

import me.loving11ish.playerguiadvanced.commands.ConsoleCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ConsoleHelp extends ConsoleCommand {

    ConsoleCommandSender console = Bukkit.getConsoleSender();
    
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
    public void perform(String[] args) {
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-1")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-2")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-3")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-4")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-5")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-6")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-7")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-8")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-9")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-10")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-11")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-12")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-13")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-14")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-15")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-16")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-17")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-18")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-19")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-20")));
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Help-21")));
    }
}
