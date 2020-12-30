package me.loving11ish.playerguiadvanced.UpdateSystem;

import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    PlayerGUIAdvanced plugin;

    public JoinEvent(PlayerGUIAdvanced plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("playergui.update")) {
            new UpdateChecker(plugin, 74596).getVersion(version -> {
                if (!(plugin.getDescription().getVersion().equalsIgnoreCase(version))) {
                    player.sendMessage(ChatColor.DARK_RED + "*-------------------------------------------*");
                    player.sendMessage(ChatColor.AQUA + "       [PlayerGUIAdvanced] " + ChatColor.RED + "- A new version is available!");
                    player.sendMessage(ChatColor.DARK_RED + "*-------------------------------------------*");
                }
            });
        }
    }
}
