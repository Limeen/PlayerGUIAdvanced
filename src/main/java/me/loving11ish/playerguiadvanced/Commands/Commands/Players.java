package me.loving11ish.playerguiadvanced.Commands.Commands;

import me.loving11ish.playerguiadvanced.MenuSystem.Menus.PlayerListMenu;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class Players implements CommandExecutor {

    Logger logger = PlayerGUIAdvanced.getPlugin().getLogger();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("playergui.use")){
                new PlayerListMenu(PlayerGUIAdvanced.getPlayerMenuUtility(player)).open();
            }else{
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Player-list-command-no-permission")));
            }
        }else{
            logger.info(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Player-only-command")));
        }
        return true;
    }
}