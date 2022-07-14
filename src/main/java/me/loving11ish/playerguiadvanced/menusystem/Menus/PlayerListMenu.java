package me.loving11ish.playerguiadvanced.menusystem.Menus;

import de.myzelyam.api.vanish.VanishAPI;
import me.loving11ish.playerguiadvanced.menusystem.PaginatedMenu;
import me.loving11ish.playerguiadvanced.menusystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

import static org.bukkit.Bukkit.getServer;

public class PlayerListMenu extends PaginatedMenu {

    public static Integer taskID1;

    FileConfiguration playersGUIConfig = PlayerGUIAdvanced.getPlugin().playersGUIManager.getPlayersGUIConfig();
    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    public PlayerListMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ColorUtils.translateColorCodes(playersGUIConfig.getString("Player-list-menu-title"));
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        List<String> commandList = PlayerGUIAdvanced.getPlugin().getConfig().getStringList("Simplemode-click-commands");
        Player player = (Player) event.getWhoClicked();
        ArrayList<Player> players = new ArrayList<Player>(getServer().getOnlinePlayers());
        if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
            PlayerMenuUtility playerMenuUtility = PlayerGUIAdvanced.getPlayerMenuUtility(player);
            playerMenuUtility.setPlayerToMod(Bukkit.getOfflinePlayer(UUID.fromString(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(PlayerGUIAdvanced.getPlugin(), "uuid"), PersistentDataType.STRING))));
            String playerToMod = playerMenuUtility.getPlayerToMod().getName();
            if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-advanced-GUI-features")){
                if (player.hasPermission("playergui.mod") || player.hasPermission("playergui.*") || player.isOp()){
                    new ActionsMenu(playerMenuUtility).open();
                    Bukkit.getScheduler().cancelTask(taskID1);
                }else {
                    player.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Actions-command-no-permission")));
                    player.closeInventory();
                    Bukkit.getScheduler().cancelTask(taskID1);
                }
            }else if (!(PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-advanced-GUI-features"))){
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-simplemode-command")){
                    if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Simplemode-console-sender")){
                        for (String string : commandList){
                            getServer().dispatchCommand(Bukkit.getConsoleSender(), string.replace("%target%", playerToMod));
                        }
                        player.closeInventory();
                        Bukkit.getScheduler().cancelTask(taskID1);
                    }else if (!(PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Simplemode-console-sender"))){
                        for (String string : commandList){
                            player.performCommand(string.replace("%target%", playerToMod));
                        }
                        player.closeInventory();
                        Bukkit.getScheduler().cancelTask(taskID1);
                    }
                }
            }
        }else if (event.getCurrentItem().getType().equals(Material.BARRIER)) {
            //close inventory
            player.closeInventory();
            Bukkit.getScheduler().cancelTask(taskID1);
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
        taskID1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(PlayerGUIAdvanced.getPlugin(PlayerGUIAdvanced.class), new Runnable() {
            @Override
            public void run() {
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
                            UUID uuid = players.get(index).getUniqueId();
                            skull.setOwningPlayer(getServer().getOfflinePlayer(uuid));
                            playerHead.setItemMeta(skull);
                            ItemMeta meta = playerHead.getItemMeta();
                            meta.setDisplayName(players.get(index).getName());
                            ArrayList<String> lore = new ArrayList<>();
                            lore.add(ChatColor.WHITE + "Player Health: " + ChatColor.LIGHT_PURPLE + players.get(index).getHealth());
                            lore.add(ChatColor.WHITE + "Player Food: " + ChatColor.LIGHT_PURPLE + players.get(index).getFoodLevel());
                            lore.add(ChatColor.WHITE + "Player XP: " + ChatColor.LIGHT_PURPLE + players.get(index).getLevel());
                            lore.add(ChatColor.WHITE + "Gamemode: " + ChatColor.LIGHT_PURPLE + players.get(index).getGameMode());
                            if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish") || Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")){
                                lore.add(ChatColor.WHITE + "Vanished: " + ChatColor.LIGHT_PURPLE + VanishAPI.isInvisible(players.get(index)));
                            }
                            lore.add(ChatColor.WHITE + "Has Fly: " + ChatColor.LIGHT_PURPLE + players.get(index).getAllowFlight());
                            lore.add(ChatColor.WHITE + "World: " + ChatColor.LIGHT_PURPLE + players.get(index).getWorld().getName());
                            lore.add(ChatColor.WHITE + "Is OP: " + ChatColor.LIGHT_PURPLE + players.get(index).getServer().getOperators().contains(players.get(index).getServer().getPlayerExact(players.get(index).getName())));
                            lore.add(ChatColor.GRAY + "==============================");
                            lore.add(ChatColor.WHITE + "UUID: " + ChatColor.BLUE + "" + ChatColor.ITALIC + players.get(index).getPlayer().getUniqueId());
                            lore.add(ChatColor.GRAY + "==============================");
                            if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-advanced-GUI-features")){
                                lore.add(ChatColor.GREEN + "Click to moderate this player");
                            }else {
                                lore.add(ChatColor.GREEN + "Click Me");
                            }
                            meta.setLore(lore);

                            meta.getPersistentDataContainer().set(new NamespacedKey(PlayerGUIAdvanced.getPlugin(), "uuid"), PersistentDataType.STRING, players.get(index).getUniqueId().toString());
                            playerHead.setItemMeta(meta);

                            inventory.setItem(index, playerHead);
                        }
                    }
                }
            }
        }, 0, 40);
    }
}