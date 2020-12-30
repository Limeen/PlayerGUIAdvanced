package me.loving11ish.playerguiadvanced.Commands.SubCommands;

import de.myzelyam.api.vanish.VanishAPI;
import me.loving11ish.playerguiadvanced.Commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Vanish extends SubCommand {


    @Override
    public String getName() {
        return "vanish";
    }

    @Override
    public String getDescription() {
        return ChatColor.AQUA + "If SuperVanish or PremiumVanish plugins are installed, this will set you into vanish.";
    }

    @Override
    public String getSyntax() {
        return ChatColor.AQUA + "/pl vanish";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")){
            if (player.hasPermission("playergui.vanish")){
                VanishAPI.hidePlayer(player);
                player.sendMessage(ChatColor.YELLOW + "You are now invisible to other players");
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission " + ChatColor.YELLOW +  "playergui.vanish "  + ChatColor.DARK_RED + "needed to run that command");
            }
        }else {
            player.sendMessage(ChatColor.DARK_RED + "This command is only active if either SuperVanish or PremiumVanish are installed!");
            player.sendMessage(ChatColor.DARK_RED + "SuperVanish: " + ChatColor.LIGHT_PURPLE + "https://www.spigotmc.org/resources/supervanish-be-invisible.1331/");
            player.sendMessage(ChatColor.DARK_RED + "PremiumVanish: " + ChatColor.LIGHT_PURPLE + "https://www.spigotmc.org/resources/premiumvanish-stay-hidden-bungee-support.14404/");
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}
