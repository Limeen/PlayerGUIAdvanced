package me.loving11ish.playerguiadvanced.Commands.ConsoleCommands;

import me.loving11ish.playerguiadvanced.Commands.ConsoleCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.Utils.ColorUtils;
import org.bukkit.ChatColor;

public class Reload extends ConsoleCommand {

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
        System.out.println(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Plugin-reload-successful")));
    }
}
