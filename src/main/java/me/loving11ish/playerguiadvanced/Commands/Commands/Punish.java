package me.loving11ish.playerguiadvanced.Commands.Commands;

import me.loving11ish.playerguiadvanced.MenuSystem.Menus.PunishMenu;
import me.loving11ish.playerguiadvanced.MenuSystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Punish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("playergui.mod")){
                if (args.length == 1){
                    Player PlayerToMod = Bukkit.getPlayerExact(args[0]);
                    if (Bukkit.getServer().getOnlinePlayers().contains(PlayerToMod)) {
                        PlayerMenuUtility playerMenuUtility = PlayerGUIAdvanced.getPlayerMenuUtility(player);
                        playerMenuUtility.setPlayerToMod(Bukkit.getPlayer(args[0]));
                        new PunishMenu(PlayerGUIAdvanced.getPlayerMenuUtility(player)).open();
                    }else {
                        player.sendMessage(ChatColor.RED + "The player " + ChatColor.YELLOW + args[0] + ChatColor.RED + " could not be found!");
                    }
                }else{
                    player.sendMessage(ChatColor.RED + "Please provide a player to moderate. /actions <player>");
                }
            }else{
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission " + ChatColor.YELLOW +  "playergui.mod "  + ChatColor.DARK_RED + "needed to run that command");
            }
        }else{
            System.out.println(ChatColor.DARK_RED + "That command can only be executed by a player.");
        }
        return true;
    }
}