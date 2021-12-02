package me.loving11ish.playerguiadvanced;

import me.loving11ish.playerguiadvanced.Commands.Commands.Actions;
import me.loving11ish.playerguiadvanced.Commands.CommandManager;
import me.loving11ish.playerguiadvanced.Commands.Commands.Players;
import me.loving11ish.playerguiadvanced.Commands.Commands.Punish;
import me.loving11ish.playerguiadvanced.Listeners.MenuListeners;
import me.loving11ish.playerguiadvanced.Listeners.PlayerConnections;
import me.loving11ish.playerguiadvanced.MenuSystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.UpdateSystem.JoinEvent;
import me.loving11ish.playerguiadvanced.UpdateSystem.UpdateChecker;
import me.loving11ish.playerguiadvanced.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public final class PlayerGUIAdvanced extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();
    private static PlayerGUIAdvanced plugin;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    Logger logger = this.getLogger();

    @Override
    public void onEnable() {

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")||
                Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")||
                Bukkit.getServer().getVersion().contains("1.17")||Bukkit.getServer().getVersion().contains("1.18"))){
            logger.warning(ChatColor.RED + "-------------------------------------------");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - This plugin is only supported on the Minecraft versions listed below:");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.13.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.14.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.15.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.16.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.17.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.18.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - Is now disabling!");
            logger.warning(ChatColor.RED + "-------------------------------------------");
            Bukkit.getPluginManager().disablePlugin(plugin);
        }else {
            logger.info(ChatColor.GREEN + "-------------------------------------------");
            logger.info(ChatColor.GREEN + "PlayerGUIAdvanced - A supported Minecraft version has been detected");
            logger.info(ChatColor.GREEN + "PlayerGUIAdvanced - Continuing plugin startup");
            logger.info(ChatColor.GREEN + "-------------------------------------------");
        }

        //Load the config file
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //VanishAPI hook check
        logger.info("-------------------------------------------");
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish")){
            logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Successfully hooked into SuperVanish");
            logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Enabling VanishAPI features");
        }
        if (Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")){
            logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Successfully hooked into PremiumVanish");
            logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Enabling VanishAPI features");
        }

        //Register commands here
        getCommand("players").setExecutor(new Players());
        getCommand("actions").setExecutor(new Actions());
        getCommand("punish").setExecutor(new Punish());
        getCommand("pl").setExecutor(new CommandManager());

        //Register events here
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new MenuListeners(),this);
        getServer().getPluginManager().registerEvents(new PlayerConnections(), this);

        //Plugin startup message
        logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Plugin By Loving11ish");
        logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - has been loaded successfully");
        logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Plugin Version " + pluginVersion);
        logger.info("-------------------------------------------");

        //Check for available updates
        new UpdateChecker(this, 74596).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ColorUtils.translateColorCodes(getConfig().getString("No-update-1")));
                logger.info(ColorUtils.translateColorCodes(getConfig().getString("No-update-2")));
                logger.info(ColorUtils.translateColorCodes(getConfig().getString("No-update-3")));
            }else {
                logger.warning(ColorUtils.translateColorCodes(getConfig().getString("Update-1")));
                logger.warning(ColorUtils.translateColorCodes(getConfig().getString("Update-2")));
                logger.warning(ColorUtils.translateColorCodes(getConfig().getString("Update-3")));
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    //Provide a player and return a menu system for that player
    //create one if they don't already have one
    public static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(player))) {
            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuUtilityMap.put(player, playerMenuUtility);
            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(player);
        }
    }

    public static PlayerGUIAdvanced getPlugin() {
        return plugin;
    }
}
