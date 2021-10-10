package me.loving11ish.playerguiadvanced.MenuSystem.Menus;

import me.loving11ish.playerguiadvanced.MenuSystem.Menu;
import me.loving11ish.playerguiadvanced.MenuSystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class PunishMenu extends Menu {

    public PunishMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Punish-menu-title").replace("%target%", playerMenuUtility.getPlayerToMod().getName()));
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        String target = event.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
        ArrayList<Player> onlinePlayersList = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());
        for (int i = 0; i < onlinePlayersList.size(); i++){
            String playersname = onlinePlayersList.get(i).getPlayer().getName();
            if (!(BanManagerMenu.onlineplayersmap.containsKey(onlinePlayersList.get(i).getPlayer()))){
                BanManagerMenu.onlineplayersmap.put(onlinePlayersList.get(i).getPlayer(), playersname);
            }
        }
        if (!(BanManagerMenu.onlineplayersmap.containsKey(playerMenuUtility.getPlayerToMod().getPlayer()))){
            player.closeInventory();
            player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Punish-command-invalid-player").replace("%target%", target)));
            return;
        }
        UUID uuid = playerMenuUtility.getPlayerToMod().getUniqueId();
        Player targetToBan = (Player) Bukkit.getOfflinePlayer(uuid);
        if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {
            player.closeInventory();
        }else if (event.getCurrentItem().getType().equals(Material.BARRIER))  {
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
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
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-10-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-10-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-11-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-11-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-12-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-12-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-13-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-13-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-14-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-14-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-15-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-15-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-16-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-16-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-17-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-17-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-18-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))) {
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-18-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")) {
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                } else {
                    player.closeInventory();
                }
            } else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-19-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-19-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-20-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-20-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-21-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-21-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-22-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-22-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-23-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-23-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-24-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-24-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-25-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-25-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-26-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-26-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-27-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-27-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-28-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-28-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-29-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-29-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-30-material")))){
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-30-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-31-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-31-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-32-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-32-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-33-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-33-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-34-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-34-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-35-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))){
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-35-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")){
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                }else {
                    player.closeInventory();
                }
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }else if (event.getCurrentItem().getType().equals(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-36-material")))) {
            if (!(targetToBan.hasPermission("playergui.exempt"))) {
                player.performCommand(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-36-command").replace("%target%", target));
                if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-banned-player-message")) {
                    targetToBan.chat(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Banned-player-message")));
                    player.closeInventory();
                } else {
                    player.closeInventory();
                }
            } else {
                player.sendMessage(ColorUtils.translateColorCodes(PlayerGUIAdvanced.getPlugin().getConfig().getString("Target-ban-exempt")));
                player.closeInventory();
            }
        }
    }

    @Override
    public void setMenuItems() {

        String targetToBan = playerMenuUtility.getPlayerToMod().getName();
        UUID uuid = playerMenuUtility.getPlayerToMod().getUniqueId();

        //Player To Ban ------------------------------------------------------------------------------------------------
        ItemStack PlayerName = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skull = (SkullMeta) PlayerName.getItemMeta();
        skull.setOwningPlayer(getServer().getOfflinePlayer(uuid));
        PlayerName.setItemMeta(skull);
        ItemMeta Pmeta = PlayerName.getItemMeta();
        Pmeta.setDisplayName(targetToBan);
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

        //Item 10 -------------------------------------------------------------------------------------------------------
        ItemStack Ten = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-10-material")), 1);
        ItemMeta TenMeta = Ten.getItemMeta();
        TenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-10-name")));
        ArrayList<String> Tenlore = new ArrayList<>();
        Tenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-10-lore-1")));
        Tenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-10-lore-2")));
        Tenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-10-lore-3")));
        TenMeta.setLore(Tenlore);
        Ten.setItemMeta(TenMeta);

        //Item 11 -------------------------------------------------------------------------------------------------------
        ItemStack Eleven = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-11-material")), 1);
        ItemMeta ElevenMeta = Eleven.getItemMeta();
        ElevenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-11-name")));
        ArrayList<String> Elevenlore = new ArrayList<>();
        Elevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-11-lore-1")));
        Elevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-11-lore-2")));
        Elevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-11-lore-3")));
        ElevenMeta.setLore(Elevenlore);
        Eleven.setItemMeta(ElevenMeta);

        //Item 12 -------------------------------------------------------------------------------------------------------
        ItemStack Twelve = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-12-material")), 1);
        ItemMeta TwelveMeta = Twelve.getItemMeta();
        TwelveMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-12-name")));
        ArrayList<String> Twelvelore = new ArrayList<>();
        Twelvelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-12-lore-1")));
        Twelvelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-12-lore-2")));
        Twelvelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-12-lore-3")));
        TwelveMeta.setLore(Twelvelore);
        Twelve.setItemMeta(TwelveMeta);

        //Item 13 -------------------------------------------------------------------------------------------------------
        ItemStack Thirteen = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-13-material")), 1);
        ItemMeta ThirteenMeta = Thirteen.getItemMeta();
        ThirteenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-13-name")));
        ArrayList<String> Thirteenlore = new ArrayList<>();
        Thirteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-13-lore-1")));
        Thirteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-13-lore-2")));
        Thirteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-13-lore-3")));
        ThirteenMeta.setLore(Thirteenlore);
        Thirteen.setItemMeta(ThirteenMeta);

        //Item 14 -------------------------------------------------------------------------------------------------------
        ItemStack Forteen = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-14-material")), 1);
        ItemMeta ForteenMeta = Forteen.getItemMeta();
        ForteenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-14-name")));
        ArrayList<String> Forteenlore = new ArrayList<>();
        Forteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-14-lore-1")));
        Forteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-14-lore-2")));
        Forteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-14-lore-3")));
        ForteenMeta.setLore(Forteenlore);
        Forteen.setItemMeta(ForteenMeta);

        //Item 15 -------------------------------------------------------------------------------------------------------
        ItemStack Fifteen = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-15-material")), 1);
        ItemMeta FifteenMeta = Fifteen.getItemMeta();
        FifteenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-15-name")));
        ArrayList<String> Fifteenlore = new ArrayList<>();
        Fifteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-15-lore-1")));
        Fifteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-15-lore-2")));
        Fifteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-15-lore-3")));
        FifteenMeta.setLore(Fifteenlore);
        Fifteen.setItemMeta(FifteenMeta);

        //Item 16 -------------------------------------------------------------------------------------------------------
        ItemStack Sixteen = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-16-material")), 1);
        ItemMeta SixteenMeta = Sixteen.getItemMeta();
        SixteenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-16-name")));
        ArrayList<String> Sixteenlore = new ArrayList<>();
        Sixteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-16-lore-1")));
        Sixteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-16-lore-2")));
        Sixteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-16-lore-3")));
        SixteenMeta.setLore(Sixteenlore);
        Sixteen.setItemMeta(SixteenMeta);

        //Item 17 -------------------------------------------------------------------------------------------------------
        ItemStack Seventeen = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-17-material")), 1);
        ItemMeta SeventeenMeta = Seventeen.getItemMeta();
        SeventeenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-17-name")));
        ArrayList<String> Seventeenlore = new ArrayList<>();
        Seventeenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-17-lore-1")));
        Seventeenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-17-lore-2")));
        Seventeenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-17-lore-3")));
        SeventeenMeta.setLore(Seventeenlore);
        Seventeen.setItemMeta(SeventeenMeta);

        //Item 18 -------------------------------------------------------------------------------------------------------
        ItemStack Eighteen = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-18-material")), 1);
        ItemMeta EighteenMeta = Eighteen.getItemMeta();
        EighteenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-18-name")));
        ArrayList<String> Eighteenlore = new ArrayList<>();
        Eighteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-18-lore-1")));
        Eighteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-18-lore-2")));
        Eighteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-18-lore-3")));
        EighteenMeta.setLore(Eighteenlore);
        Eighteen.setItemMeta(EighteenMeta);

        //Item 19 -------------------------------------------------------------------------------------------------------
        ItemStack Nineteen = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-19-material")), 1);
        ItemMeta NineteenMeta = Nineteen.getItemMeta();
        NineteenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-19-name")));
        ArrayList<String> Nineteenlore = new ArrayList<>();
        Nineteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-19-lore-1")));
        Nineteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-19-lore-2")));
        Nineteenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-19-lore-3")));
        NineteenMeta.setLore(Nineteenlore);
        Nineteen.setItemMeta(NineteenMeta);

        //Item 20 -------------------------------------------------------------------------------------------------------
        ItemStack Twenty = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-20-material")), 1);
        ItemMeta TwentyMeta = Twenty.getItemMeta();
        TwentyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-20-name")));
        ArrayList<String> Twentylore = new ArrayList<>();
        Twentylore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-20-lore-1")));
        Twentylore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-20-lore-2")));
        Twentylore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-20-lore-3")));
        TwentyMeta.setLore(Twentylore);
        Twenty.setItemMeta(TwentyMeta);

        //Item 21 -------------------------------------------------------------------------------------------------------
        ItemStack Twentyone = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-21-material")), 1);
        ItemMeta TwentyoneMeta = Twentyone.getItemMeta();
        TwentyoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-21-name")));
        ArrayList<String> Twentyonelore = new ArrayList<>();
        Twentyonelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-21-lore-1")));
        Twentyonelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-21-lore-2")));
        Twentyonelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-21-lore-3")));
        TwentyoneMeta.setLore(Twentyonelore);
        Twentyone.setItemMeta(TwentyoneMeta);

        //Item 22 -------------------------------------------------------------------------------------------------------
        ItemStack Twentytwo = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-22-material")), 1);
        ItemMeta TwentytwoMeta = Twentytwo.getItemMeta();
        TwentytwoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-22-name")));
        ArrayList<String> Twentytwolore = new ArrayList<>();
        Twentytwolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-22-lore-1")));
        Twentytwolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-22-lore-2")));
        Twentytwolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-22-lore-3")));
        TwentytwoMeta.setLore(Twentytwolore);
        Twentytwo.setItemMeta(TwentytwoMeta);

        //Item 23 -------------------------------------------------------------------------------------------------------
        ItemStack Twentythree = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-23-material")), 1);
        ItemMeta TwentythreeMeta = Twentythree.getItemMeta();
        TwentythreeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-23-name")));
        ArrayList<String> Twentythreelore = new ArrayList<>();
        Twentythreelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-23-lore-1")));
        Twentythreelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-23-lore-2")));
        Twentythreelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-23-lore-3")));
        TwentythreeMeta.setLore(Twentythreelore);
        Twentythree.setItemMeta(TwentythreeMeta);

        //Item 24 -------------------------------------------------------------------------------------------------------
        ItemStack Twentyfour = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-24-material")), 1);
        ItemMeta TwentyfourMeta = Twentyfour.getItemMeta();
        TwentyfourMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-24-name")));
        ArrayList<String> Twentyfourlore = new ArrayList<>();
        Twentyfourlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-24-lore-1")));
        Twentyfourlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-24-lore-2")));
        Twentyfourlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-24-lore-3")));
        TwentyfourMeta.setLore(Twentyfourlore);
        Twentyfour.setItemMeta(TwentyfourMeta);

        //Item 25 -------------------------------------------------------------------------------------------------------
        ItemStack Twentyfive = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-25-material")), 1);
        ItemMeta TwentyfiveMeta = Twentyfive.getItemMeta();
        TwentyfiveMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-25-name")));
        ArrayList<String> Twentyfivelore = new ArrayList<>();
        Twentyfivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-25-lore-1")));
        Twentyfivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-25-lore-2")));
        Twentyfivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-25-lore-3")));
        TwentyfiveMeta.setLore(Twentyfivelore);
        Twentyfive.setItemMeta(TwentyfiveMeta);

        //Item 26 -------------------------------------------------------------------------------------------------------
        ItemStack Twentysix = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-26-material")), 1);
        ItemMeta TwentysixMeta = Twentysix.getItemMeta();
        TwentysixMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-26-name")));
        ArrayList<String> Twentysixlore = new ArrayList<>();
        Twentysixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-26-lore-1")));
        Twentysixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-26-lore-2")));
        Twentysixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-26-lore-3")));
        TwentysixMeta.setLore(Twentysixlore);
        Twentysix.setItemMeta(TwentysixMeta);

        //Item 27 -------------------------------------------------------------------------------------------------------
        ItemStack Twentyseven = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-27-material")), 1);
        ItemMeta TwentysevenMeta = Twentyseven.getItemMeta();
        TwentysevenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-27-name")));
        ArrayList<String> Twentysevenlore = new ArrayList<>();
        Twentysevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-27-lore-1")));
        Twentysevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-27-lore-2")));
        Twentysevenlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-27-lore-3")));
        TwentysevenMeta.setLore(Twentysevenlore);
        Twentyseven.setItemMeta(TwentysevenMeta);

        //Item 28 -------------------------------------------------------------------------------------------------------
        ItemStack Twentyeight = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-28-material")), 1);
        ItemMeta TwentyeightMeta = Twentyeight.getItemMeta();
        TwentyeightMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-28-name")));
        ArrayList<String> Twentyeightlore = new ArrayList<>();
        Twentyeightlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-28-lore-1")));
        Twentyeightlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-28-lore-2")));
        Twentyeightlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-28-lore-3")));
        TwentyeightMeta.setLore(Twentyeightlore);
        Twentyeight.setItemMeta(TwentyeightMeta);

        //Item 29 -------------------------------------------------------------------------------------------------------
        ItemStack Twentynine = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-29-material")), 1);
        ItemMeta TwentynineMeta = Twentynine.getItemMeta();
        TwentynineMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-29-name")));
        ArrayList<String> Twentyninelore = new ArrayList<>();
        Twentyninelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-29-lore-1")));
        Twentyninelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-29-lore-2")));
        Twentyninelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-29-lore-3")));
        TwentynineMeta.setLore(Twentyninelore);
        Twentynine.setItemMeta(TwentynineMeta);

        //Item 30 -------------------------------------------------------------------------------------------------------
        ItemStack Thirty = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-30-material")), 1);
        ItemMeta ThirtyMeta = Thirty.getItemMeta();
        ThirtyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-30-name")));
        ArrayList<String> Thirtylore = new ArrayList<>();
        Thirtylore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-30-lore-1")));
        Thirtylore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-30-lore-2")));
        Thirtylore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-30-lore-3")));
        ThirtyMeta.setLore(Thirtylore);
        Thirty.setItemMeta(ThirtyMeta);

        //Item 31 -------------------------------------------------------------------------------------------------------
        ItemStack Thirtyone = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-31-material")), 1);
        ItemMeta ThirtyoneMeta = Thirtyone.getItemMeta();
        ThirtyoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-31-name")));
        ArrayList<String> Thirtyonelore = new ArrayList<>();
        Thirtyonelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-31-lore-1")));
        Thirtyonelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-31-lore-2")));
        Thirtyonelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-31-lore-3")));
        ThirtyoneMeta.setLore(Thirtyonelore);
        Thirtyone.setItemMeta(ThirtyoneMeta);

        //Item 32 -------------------------------------------------------------------------------------------------------
        ItemStack Thirytwo = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-32-material")), 1);
        ItemMeta ThirytwoMeta = Thirytwo.getItemMeta();
        ThirytwoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-32-name")));
        ArrayList<String> Thirytwolore = new ArrayList<>();
        Thirytwolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-32-lore-1")));
        Thirytwolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-32-lore-2")));
        Thirytwolore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-32-lore-3")));
        ThirytwoMeta.setLore(Thirytwolore);
        Thirytwo.setItemMeta(ThirytwoMeta);

        //Item 33 -------------------------------------------------------------------------------------------------------
        ItemStack Thirtythree = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-33-material")), 1);
        ItemMeta ThirtythreeMeta = Thirtythree.getItemMeta();
        ThirtythreeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-33-name")));
        ArrayList<String> Thirtythreelore = new ArrayList<>();
        Thirtythreelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-33-lore-1")));
        Thirtythreelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-33-lore-2")));
        Thirtythreelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-33-lore-3")));
        ThirtythreeMeta.setLore(Thirtythreelore);
        Thirtythree.setItemMeta(ThirtythreeMeta);

        //Item 34 -------------------------------------------------------------------------------------------------------
        ItemStack Thirtyfour = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-34-material")), 1);
        ItemMeta ThirtyfourMeta = Thirtyfour.getItemMeta();
        ThirtyfourMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-34-name")));
        ArrayList<String> Thirtyfourlore = new ArrayList<>();
        Thirtyfourlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-34-lore-1")));
        Thirtyfourlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-34-lore-2")));
        Thirtyfourlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-34-lore-3")));
        ThirtyfourMeta.setLore(Thirtyfourlore);
        Thirtyfour.setItemMeta(ThirtyfourMeta);

        //Item 35 -------------------------------------------------------------------------------------------------------
        ItemStack Thirtyfive = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-35-material")), 1);
        ItemMeta ThirtyfiveMeta = Thirtyfive.getItemMeta();
        ThirtyfiveMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-35-name")));
        ArrayList<String> Thirtyfivelore = new ArrayList<>();
        Thirtyfivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-35-lore-1")));
        Thirtyfivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-35-lore-2")));
        Thirtyfivelore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-35-lore-3")));
        ThirtyfiveMeta.setLore(Thirtyfivelore);
        Thirtyfive.setItemMeta(ThirtyfiveMeta);

        //Item 36 -------------------------------------------------------------------------------------------------------
        ItemStack Thirtysix = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-36-material")), 1);
        ItemMeta ThirtysixMeta = Thirtysix.getItemMeta();
        ThirtysixMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-36-name")));
        ArrayList<String> Thirtysixlore = new ArrayList<>();
        Thirtysixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-36-lore-1")));
        Thirtysixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-36-lore-2")));
        Thirtysixlore.add(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Ban-length-36-lore-3")));
        ThirtysixMeta.setLore(Thirtysixlore);
        Thirtysix.setItemMeta(ThirtysixMeta);

        //Close menu -------------------------------------------------------------------------------------------------------
        ItemStack Close = new ItemStack(Material.BARRIER, 1);
        ItemMeta CloseMeta = Close.getItemMeta();
        CloseMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cClick to close"));
        Close.setItemMeta(CloseMeta);

        //Filler item -------------------------------------------------------------------------------------------------------
        ItemStack Filler = new ItemStack(Material.getMaterial(PlayerGUIAdvanced.getPlugin().getConfig().getString("Filler-material")), 1);
        ItemMeta FillerMeta = Filler.getItemMeta();
        FillerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', PlayerGUIAdvanced.getPlugin().getConfig().getString("Filler-name")));
        Filler.setItemMeta(FillerMeta);

        inventory.setItem(0, Filler);
        inventory.setItem(1, Filler);
        inventory.setItem(2, Filler);
        inventory.setItem(3, Filler);
        inventory.setItem(4, PlayerName);
        inventory.setItem(5, Filler);
        inventory.setItem(6, Filler);
        inventory.setItem(7, Filler);
        inventory.setItem(8, Filler);
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-1")){
            inventory.setItem(9, One);
        }else {
            inventory.setItem(9, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-2")){
            inventory.setItem(10, Two);
        }else {
            inventory.setItem(10, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-3")){
            inventory.setItem(11, Three);
        }else {
            inventory.setItem(11, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-4")){
            inventory.setItem(12, Four);
        }else {
            inventory.setItem(12, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-5")){
            inventory.setItem(13, Five);
        }else {
            inventory.setItem(13, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-6")){
            inventory.setItem(14, Six);
        }else {
            inventory.setItem(14, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-7")){
            inventory.setItem(15, Seven);
        }else {
            inventory.setItem(15, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-8")){
            inventory.setItem(16, Eight);
        }else {
            inventory.setItem(16, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-9")){
            inventory.setItem(17, Nine);
        }else {
            inventory.setItem(17, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-10")){
            inventory.setItem(18, Ten);
        }else {
            inventory.setItem(18, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-11")){
            inventory.setItem(19, Eleven);
        }else {
            inventory.setItem(19, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-12")){
            inventory.setItem(20, Twelve);
        }else {
            inventory.setItem(20, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-13")){
            inventory.setItem(21, Thirteen);
        }else {
            inventory.setItem(21, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-14")){
            inventory.setItem(22, Forteen);
        }else {
            inventory.setItem(22, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-15")){
            inventory.setItem(23, Fifteen);
        }else {
            inventory.setItem(23, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-16")){
            inventory.setItem(24, Sixteen);
        }else {
            inventory.setItem(24, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-17")){
            inventory.setItem(25, Seventeen);
        }else {
            inventory.setItem(25, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-18")){
            inventory.setItem(26, Eighteen);
        }else {
            inventory.setItem(26, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-19")){
            inventory.setItem(27, Nineteen);
        }else {
            inventory.setItem(27, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-20")){
            inventory.setItem(28, Twenty);
        }else {
            inventory.setItem(28, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-21")){
            inventory.setItem(29, Twentyone);
        }else {
            inventory.setItem(29, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-22")){
            inventory.setItem(30, Twentytwo);
        }else {
            inventory.setItem(30, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-23")){
            inventory.setItem(31, Twentythree);
        }else {
            inventory.setItem(31, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-24")){
            inventory.setItem(32, Twentyfour);
        }else {
            inventory.setItem(32, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-25")){
            inventory.setItem(33, Twentyfive);
        }else {
            inventory.setItem(33, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-26")){
            inventory.setItem(34, Twentysix);
        }else {
            inventory.setItem(34, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-27")){
            inventory.setItem(35, Twentyseven);
        }else {
            inventory.setItem(35, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-28")){
            inventory.setItem(36, Twentyeight);
        }else {
            inventory.setItem(36, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-29")){
            inventory.setItem(37, Twentynine);
        }else {
            inventory.setItem(37, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-30")){
            inventory.setItem(38, Thirty);
        }else {
            inventory.setItem(38, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-31")){
            inventory.setItem(39, Thirtyone);
        }else {
            inventory.setItem(39, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-32")){
            inventory.setItem(40, Thirytwo);
        }else {
            inventory.setItem(40, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-33")){
            inventory.setItem(41, Thirtythree);
        }else {
            inventory.setItem(41, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-34")){
            inventory.setItem(42, Thirtyfour);
        }else {
            inventory.setItem(42, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-35")){
            inventory.setItem(43, Thirtyfive);
        }else {
            inventory.setItem(43, Filler);
        }
        if (PlayerGUIAdvanced.getPlugin().getConfig().getBoolean("Enable-ban-36")){
            inventory.setItem(44, Thirtysix);
        }else {
            inventory.setItem(44, Filler);
        }
        inventory.setItem(45, Filler);
        inventory.setItem(46, Filler);
        inventory.setItem(47, Filler);
        inventory.setItem(48, Filler);
        inventory.setItem(49, Close);
        inventory.setItem(50, Filler);
        inventory.setItem(51, Filler);
        inventory.setItem(52, Filler);
        inventory.setItem(53, Filler);
    }
}
