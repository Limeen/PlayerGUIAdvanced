package me.loving11ish.playerguiadvanced.Commands.Commands;

import me.loving11ish.playerguiadvanced.MenuSystem.Menus.PunishMenu;
import me.loving11ish.playerguiadvanced.MenuSystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Punish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("playergui.ban")){
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-advanced-GUI-features")){
                    if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-manager")){
                        if (args.length == 1){
                            try {
                                UUID uuid = Bukkit.getPlayerExact(args[0]).getUniqueId();
                                Player PlayerToMod = (Player) Bukkit.getOfflinePlayer(uuid);
                                PlayerMenuUtility playerMenuUtility = PlayerGUIAdvanced.getPlayerMenuUtility(player);
                                playerMenuUtility.setPlayerToMod(PlayerToMod);
                                new PunishMenu(PlayerGUIAdvanced.getPlayerMenuUtility(player)).open();
                            }catch (NullPointerException exception){
                                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Punish-command-invalid-player").replace("%target%", args[0])));
                            }
                        }else{
                            player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Punish-command-no-player-provided")));
                        }
                    }else {
                        player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Disabled-GUI-Feature")));
                    }
                }else {
                    player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Simplemode-enabled-message")));
                }
            }else{
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Punish-command-no-permission")));
            }
        }else{
            System.out.println(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Player-only-command")));
        }
        return true;
    }
}