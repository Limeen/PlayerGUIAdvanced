package me.loving11ish.playerguiadvanced.Listeners;

import me.loving11ish.playerguiadvanced.MenuSystem.Menus.BanManagerMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnections implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if (BanManagerMenu.onlineplayersmap.containsKey(player)){
            BanManagerMenu.onlineplayersmap.remove(player);
        }
    }
}
