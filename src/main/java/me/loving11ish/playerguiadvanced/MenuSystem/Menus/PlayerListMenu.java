package me.loving11ish.playerguiadvanced.MenuSystem.Menus;

import de.myzelyam.api.vanish.VanishAPI;
import me.loving11ish.playerguiadvanced.MenuSystem.PaginatedMenu;
import me.loving11ish.playerguiadvanced.MenuSystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class PlayerListMenu extends PaginatedMenu {

    public PlayerListMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Player-list-menu-title"));
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        ArrayList<Player> players = new ArrayList<Player>(getServer().getOnlinePlayers());

        if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {

            PlayerMenuUtility playerMenuUtility = PlayerGUIAdvanced.getPlayerMenuUtility(player);
            playerMenuUtility.setPlayerToMod(Bukkit.getPlayer(UUID.fromString(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(PlayerGUIAdvanced.getPlugin(), "uuid"), PersistentDataType.STRING))));

            new ActionsMenu(playerMenuUtility).open();

        }else if (event.getCurrentItem().getType().equals(Material.BARRIER)) {

            //close inventory
            player.closeInventory();

        }else if(event.getCurrentItem().getType().equals(Material.STONE_BUTTON)){
            if (ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Previous Page")){
                if (page == 0){
                    player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Player-list-menu-first-page")));
                }else{
                    page = page - 1;
                    super.open();
                }
            }else if (ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("Next Page")){
                if (!((index + 1) >= players.size())){
                    page = page + 1;
                    super.open();
                }else{
                    player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Player-list-menu-last-page")));
                }
            }
        }
    }

    @Override
    public void setMenuItems() {

        addMenuControls();

        //The thing you will be looping through to place items
        ArrayList<Player> players = new ArrayList<Player>(getServer().getOnlinePlayers());

        //Pagination loop template
        if(players != null && !players.isEmpty()) {
            for(int i = 0; i < getMaxItemsPerPage(); i++) {
                index = getMaxItemsPerPage() * page + i;
                if(index >= players.size()) break;
                if (players.get(index) != null){

                    //Create an item from our collection and place it into the inventory
                    ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta skull = (SkullMeta) playerHead.getItemMeta();
                    UUID uuid = players.get(i).getUniqueId();
                    skull.setOwningPlayer(getServer().getOfflinePlayer(uuid));
                    playerHead.setItemMeta(skull);
                    ItemMeta meta = playerHead.getItemMeta();
                    meta.setDisplayName(players.get(i).getName());
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.WHITE + "Player Health: " + ChatColor.LIGHT_PURPLE + players.get(i).getHealth());
                    lore.add(ChatColor.WHITE + "Player Food: " + ChatColor.LIGHT_PURPLE + players.get(i).getFoodLevel());
                    lore.add(ChatColor.WHITE + "Player XP: " + ChatColor.LIGHT_PURPLE + players.get(i).getLevel());
                    lore.add(ChatColor.WHITE + "Gamemode: " + ChatColor.LIGHT_PURPLE + players.get(i).getGameMode());
                    if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")){
                        lore.add(ChatColor.WHITE + "Vanished: " + ChatColor.LIGHT_PURPLE + VanishAPI.isInvisible(players.get(i)));
                    }
                    lore.add(ChatColor.WHITE + "Has Fly: " + ChatColor.LIGHT_PURPLE + players.get(i).getAllowFlight());
                    lore.add(ChatColor.WHITE + "World: " + ChatColor.LIGHT_PURPLE + players.get(i).getWorld().getName());
                    lore.add(ChatColor.WHITE + "OP: " + ChatColor.LIGHT_PURPLE + players.get(i).getServer().getOperators().contains(players.get(i).getServer().getPlayerExact(players.get(i).getName())));
                    lore.add(ChatColor.GREEN + "Click to moderate this player");
                    meta.setLore(lore);

                    meta.getPersistentDataContainer().set(new NamespacedKey(PlayerGUIAdvanced.getPlugin(), "uuid"), PersistentDataType.STRING, players.get(index).getUniqueId().toString());
                    playerHead.setItemMeta(meta);

                    inventory.addItem(playerHead);
                }
            }
        }
    }
}