package me.loving11ish.playerguiadvanced.commands.SubCommands;

import de.myzelyam.api.vanish.VanishAPI;
import me.loving11ish.playerguiadvanced.commands.SubCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class Vanish extends SubCommand {

    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

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
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Vanish-command-player-invisible")));
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Vanish-command-no-permission")));
            }
        }else {
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Vanish-1")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Vanish-2")));
            player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Vanish-3")));
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}