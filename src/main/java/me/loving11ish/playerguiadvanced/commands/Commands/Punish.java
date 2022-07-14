package me.loving11ish.playerguiadvanced.commands.Commands;

import me.loving11ish.playerguiadvanced.menusystem.Menus.BanManagerMenu;
import me.loving11ish.playerguiadvanced.menusystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.logging.Logger;

public class Punish implements CommandExecutor {

    Logger logger = PlayerGUIAdvanced.getPlugin().getLogger();
    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();
    FileConfiguration banGUIConfig = PlayerGUIAdvanced.getPlugin().banGUIManager.getBanGUIConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("playergui.ban")){
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-advanced-GUI-features")){
                    if (banGUIConfig.getBoolean("Enable-ban-manager")){
                        if (args.length == 1){
                            try {
                                UUID uuid = Bukkit.getPlayerExact(args[0]).getUniqueId();
                                Player PlayerToMod = (Player) Bukkit.getOfflinePlayer(uuid);
                                PlayerMenuUtility playerMenuUtility = PlayerGUIAdvanced.getPlayerMenuUtility(player);
                                playerMenuUtility.setPlayerToMod(PlayerToMod);
                                new BanManagerMenu(PlayerGUIAdvanced.getPlayerMenuUtility(player)).open();
                            }catch (NullPointerException exception){
                                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Punish-command-invalid-player").replace("%target%", args[0])));
                            }
                        }else{
                            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Punish-command-no-player-provided")));
                        }
                    }else {
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Disabled-GUI-Feature")));
                    }
                }else {
                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Simplemode-enabled-message")));
                }
            }else{
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Punish-command-no-permission")));
            }
        }else{
            logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Player-only-command")));
        }
        return true;
    }
}