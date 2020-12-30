package me.loving11ish.playerguiadvanced.Commands.SubCommands;

import de.myzelyam.api.vanish.VanishAPI;
import me.loving11ish.playerguiadvanced.Commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Show extends SubCommand {


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
    public void perform(Player player, String[] args) {
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")){
            if (player.hasPermission("playergui.show")){
                VanishAPI.showPlayer(player);
                player.sendMessage(ChatColor.YELLOW + "You are now visible to other players");
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission " + ChatColor.YELLOW +  "playergui.show "  + ChatColor.DARK_RED + "needed to run that command");
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