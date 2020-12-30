package me.loving11ish.playerguiadvanced.Commands.Commands;

import me.loving11ish.playerguiadvanced.MenuSystem.Menus.PlayerListMenu;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Players implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("playergui.use")){
                new PlayerListMenu(PlayerGUIAdvanced.getPlayerMenuUtility(player)).open();
            }else{
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission " + ChatColor.YELLOW +  "playergui.use "  + ChatColor.DARK_RED + "needed to run that command");
            }
        }else{
            System.out.println(ChatColor.DARK_RED + "That command can only be executed by a player.");
        }
        return true;
    }
}