package me.loving11ish.playerguiadvanced.Listeners;

import me.loving11ish.playerguiadvanced.MenuSystem.Menu;
import me.loving11ish.playerguiadvanced.MenuSystem.Menus.BanManagerMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryHolder;

import static me.loving11ish.playerguiadvanced.MenuSystem.Menus.PlayerListMenu.taskID1;

public class MenuListeners implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event){

        InventoryHolder holder = event.getInventory().getHolder();
        //If the inventoryholder of the inventory clicked on
        // is an instance of Menu, then gg. The reason that
        // an InventoryHolder can be a Menu is because our Menu
        // class implements InventoryHolder!!
        if (holder instanceof Menu) {
            event.setCancelled(true); //prevent them from altering with the inventory
            if (event.getCurrentItem() == null) { //deal with null exceptions
                return;
            }
            //Since we know our inventoryholder is a menu, get the Menu Object representing
            // the menu we clicked on
            Menu menu = (Menu) holder;
            //Call the handleMenu object which takes the event and processes it
            menu.handleMenu(event);
        }
    }
    @EventHandler
    public void onMenuExit(InventoryCloseEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        if (Bukkit.getScheduler().isCurrentlyRunning(taskID1)){
            if (holder instanceof Menu) {
                Bukkit.getScheduler().cancelTask(taskID1);
                BanManagerMenu.onlineplayersmap.clear();
            }
        }
    }
}