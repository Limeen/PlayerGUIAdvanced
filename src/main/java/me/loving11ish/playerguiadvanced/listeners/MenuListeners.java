package me.loving11ish.playerguiadvanced.listeners;

import com.tcoded.folialib.wrapper.WrappedTask;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.menusystem.Menu;
import me.loving11ish.playerguiadvanced.menusystem.Menus.PlayerListMenu;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListeners implements Listener {

    FileConfiguration playersGUIConfig = PlayerGUIAdvanced.getPlugin().playersGUIManager.getPlayersGUIConfig();

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
    public void onMenuClose(InventoryCloseEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Menu){
            if (((Menu) holder).getMenuName().equalsIgnoreCase(ColorUtils.translateColorCodes(playersGUIConfig.getString("Player-list-menu-title")))){
                WrappedTask wrappedTask = PlayerListMenu.wrappedTaskOne;
                if (!wrappedTask.isCancelled()){
                    wrappedTask.cancel();
                }
            }
        }
    }
}