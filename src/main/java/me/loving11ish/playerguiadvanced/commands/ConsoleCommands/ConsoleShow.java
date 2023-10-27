package me.loving11ish.playerguiadvanced.commands.ConsoleCommands;

import me.loving11ish.playerguiadvanced.commands.ConsoleCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ConsoleShow extends ConsoleCommand {

    ConsoleCommandSender console = Bukkit.getConsoleSender();

    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return ChatColor.AQUA + "If SuperVanish or PremiumVanish plugins are installed, this will set you out of vanish.";
    }

    @Override
    public String getSyntax() {
        return ChatColor.AQUA + "/pl show";
    }

    @Override
    public void perform(String[] args) {
        console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Player-only-command")));
    }

}
