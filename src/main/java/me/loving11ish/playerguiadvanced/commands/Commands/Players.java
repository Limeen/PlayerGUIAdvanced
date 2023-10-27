package me.loving11ish.playerguiadvanced.commands.Commands;

import me.loving11ish.playerguiadvanced.menusystem.Menus.PlayerListMenu;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Players implements CommandExecutor {

    ConsoleCommandSender console = Bukkit.getConsoleSender();

    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("playergui.use")){
                new PlayerListMenu(PlayerGUIAdvanced.getPlayerMenuUtility(player)).open();
            }else{
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Player-list-command-no-permission")));
            }
        }else{
            console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Player-only-command")));
        }
        return true;
    }
}