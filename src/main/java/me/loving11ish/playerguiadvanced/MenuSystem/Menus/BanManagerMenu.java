package me.loving11ish.playerguiadvanced.MenuSystem.Menus;

import me.loving11ish.playerguiadvanced.MenuSystem.Menu;
import me.loving11ish.playerguiadvanced.MenuSystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class BanManagerMenu extends Menu {

    public BanManagerMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ChatColor.AQUA + "Ban: " + playerMenuUtility.getPlayerToMod().getName();
    }

    @Override
    public int getSlots() {
        return 18;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        String target = event.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
        Player targetToBan = Bukkit.getPlayerExact(event.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
        if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)){
            player.closeInventory();
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-1-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-1-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-2-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-2-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-3-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-3-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-4-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-4-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-5-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-5-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-6-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-6-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-7-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-7-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-8-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-8-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-9-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-9-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ChatColor.RED + "That player is exempt from bans!");
                player.closeInventory();
            }
        }
    }

    @Override
    public void setMenuItems() {

        Player targetToBan = playerMenuUtility.getPlayerToMod();

        //Player To Ban ------------------------------------------------------------------------------------------------
        ItemStack PlayerName = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skull = (SkullMeta) PlayerName.getItemMeta();
        UUID uuid = targetToBan.getUniqueId();
        skull.setOwningPlayer(getServer().getOfflinePlayer(uuid));
        PlayerName.setItemMeta(skull);
        ItemMeta Pmeta = PlayerName.getItemMeta();
        Pmeta.setDisplayName(targetToBan.getName());
        ArrayList<String> Plore = new ArrayList<>();
        Plore.add(ChatColor.RED + "Player To Ban");
        Plore.add(ChatColor.LIGHT_PURPLE + "Click to close");
        Pmeta.setLore(Plore);
        PlayerName.setItemMeta(Pmeta);

        //Item 1 -------------------------------------------------------------------------------------------------------
        ItemStack One = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-1-material")), 1);
        ItemMeta OneMeta = One.getItemMeta();
        OneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-1-name")));
        ArrayList<String> Onelore = new ArrayList<>();
        Onelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-1-lore-1")));
        Onelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-1-lore-2")));
        Onelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-1-lore-3")));
        OneMeta.setLore(Onelore);
        One.setItemMeta(OneMeta);

        //Item 2 -------------------------------------------------------------------------------------------------------
        ItemStack Two = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-2-material")), 1);
        ItemMeta TwoMeta = Two.getItemMeta();
        TwoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-2-name")));
        ArrayList<String> Twolore = new ArrayList<>();
        Twolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-2-lore-1")));
        Twolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-2-lore-2")));
        Twolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-2-lore-3")));
        TwoMeta.setLore(Twolore);
        Two.setItemMeta(TwoMeta);

        //Item 3 -------------------------------------------------------------------------------------------------------
        ItemStack Three = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-3-material")), 1);
        ItemMeta ThreeMeta = Three.getItemMeta();
        ThreeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-3-name")));
        ArrayList<String> Threelore = new ArrayList<>();
        Threelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-3-lore-1")));
        Threelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-3-lore-2")));
        Threelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-3-lore-3")));
        ThreeMeta.setLore(Threelore);
        Three.setItemMeta(ThreeMeta);

        //Item 4 -------------------------------------------------------------------------------------------------------
        ItemStack Four = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-4-material")), 1);
        ItemMeta FourMeta = Four.getItemMeta();
        FourMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-4-name")));
        ArrayList<String> Forelore = new ArrayList<>();
        Forelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-4-lore-1")));
        Forelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-4-lore-2")));
        Forelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-4-lore-3")));
        FourMeta.setLore(Forelore);
        Four.setItemMeta(FourMeta);

        //Item 5 -------------------------------------------------------------------------------------------------------
        ItemStack Five = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-5-material")), 1);
        ItemMeta FiveMeta = Five.getItemMeta();
        FiveMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-5-name")));
        ArrayList<String> Fivelore = new ArrayList<>();
        Fivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-5-lore-1")));
        Fivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-5-lore-2")));
        Fivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-5-lore-3")));
        FiveMeta.setLore(Fivelore);
        Five.setItemMeta(FiveMeta);

        //Item 6 -------------------------------------------------------------------------------------------------------
        ItemStack Six = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-6-material")), 1);
        ItemMeta SixMeta = Six.getItemMeta();
        SixMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-6-name")));
        ArrayList<String> Sixlore = new ArrayList<>();
        Sixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-6-lore-1")));
        Sixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-6-lore-2")));
        Sixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-6-lore-3")));
        SixMeta.setLore(Sixlore);
        Six.setItemMeta(SixMeta);

        //Item 7 -------------------------------------------------------------------------------------------------------
        ItemStack Seven = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-7-material")), 1);
        ItemMeta SevenMeta = Seven.getItemMeta();
        SevenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-7-name")));
        ArrayList<String> Sevenlore = new ArrayList<>();
        Sevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-7-lore-1")));
        Sevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-7-lore-2")));
        Sevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-7-lore-3")));
        SevenMeta.setLore(Sevenlore);
        Seven.setItemMeta(SevenMeta);

        //Item 8 -------------------------------------------------------------------------------------------------------
        ItemStack Eight = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-8-material")), 1);
        ItemMeta EightMeta = Eight.getItemMeta();
        EightMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-8-name")));
        ArrayList<String> Eightlore = new ArrayList<>();
        Eightlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-8-lore-1")));
        Eightlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-8-lore-2")));
        Eightlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-8-lore-3")));
        EightMeta.setLore(Eightlore);
        Eight.setItemMeta(EightMeta);

        //Item 9 -------------------------------------------------------------------------------------------------------
        ItemStack Nine = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-9-material")), 1);
        ItemMeta NineMeta = Nine.getItemMeta();
        NineMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-9-name")));
        ArrayList<String> Ninelore = new ArrayList<>();
        Ninelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-9-lore-1")));
        Ninelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-9-lore-2")));
        Ninelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-9-lore-3")));
        NineMeta.setLore(Ninelore);
        Nine.setItemMeta(NineMeta);

        inventory.setItem(4, PlayerName);
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-1")){
            inventory.setItem(9, One);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-2")){
            inventory.setItem(10, Two);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-3")){
            inventory.setItem(11, Three);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-4")){
            inventory.setItem(12, Four);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-5")){
            inventory.setItem(13, Five);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-6")){
            inventory.setItem(14, Six);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-7")){
            inventory.setItem(15, Seven);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-8")){
            inventory.setItem(16, Eight);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-9")){
            inventory.setItem(17, Nine);
        }
    }
}