package me.loving11ish.playerguiadvanced.updatesystem;

import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    PlayerGUIAdvanced plugin;

    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    public JoinEvent(PlayerGUIAdvanced plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("playergui.update")) {
            new UpdateChecker(74596).getVersion(version -> {
                try {
                    if (!(plugin.getDescription().getVersion().equalsIgnoreCase(version))) {
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Update-1")));
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Update-2")));
                        player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Update-3")));
                    }
                }catch (NullPointerException e){
                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Update-check-failure")));
                }
            });
        }
    }
}