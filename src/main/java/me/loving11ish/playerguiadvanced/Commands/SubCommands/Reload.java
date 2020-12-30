package me.loving11ish.playerguiadvanced.Commands.SubCommands;

import me.loving11ish.playerguiadvanced.Commands.SubCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Reload extends SubCommand {


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
            player.sendMessage(ChatColor.GREEN + "The config file has been reloaded!");
        }else {
            player.sendMessage(ChatColor.DARK_RED + "You do not have the permission " + ChatColor.YELLOW +  "playergui.reload "  + ChatColor.DARK_RED + "needed to run that command");
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}