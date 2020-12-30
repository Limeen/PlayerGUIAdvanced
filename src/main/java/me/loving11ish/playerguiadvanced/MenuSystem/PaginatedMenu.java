package me.loving11ish.playerguiadvanced.MenuSystem;

import org.bukkit.ChatColor;
import org.bukkit.Material;

//A class extending the functionality of the regular Menu, but making it Paginated

public abstract class PaginatedMenu extends Menu {

    //Keep track of what page the menu is on
    protected int page = 0;
    //28 is max items because with the border set below,
    //28 empty slots are remaining.
    protected int maxItemsPerPage = 45;
    //the index represents the index of the slot
    //that the loop is on
    protected int index = 0;

    public PaginatedMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    //Set the border and menu buttons for the menu
    public void addMenuControls(){
        inventory.setItem(48, makeItem(Material.STONE_BUTTON, ChatColor.GREEN + "Previous Page"));
        inventory.setItem(49, makeItem(Material.BARRIER, ChatColor.DARK_RED + "Close"));
        inventory.setItem(50, makeItem(Material.STONE_BUTTON, ChatColor.GREEN + "Next Page"));
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}

