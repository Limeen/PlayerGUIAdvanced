package me.loving11ish.playerguiadvanced;

import me.loving11ish.playerguiadvanced.commands.Commands.Actions;
import me.loving11ish.playerguiadvanced.commands.CommandManager;
import me.loving11ish.playerguiadvanced.commands.Commands.Players;
import me.loving11ish.playerguiadvanced.commands.Commands.Punish;
import me.loving11ish.playerguiadvanced.files.ActionsGUIFileManager;
import me.loving11ish.playerguiadvanced.files.BanGUIFileManager;
import me.loving11ish.playerguiadvanced.files.MessagesFileManager;
import me.loving11ish.playerguiadvanced.files.PlayerListGUIFileManager;
import me.loving11ish.playerguiadvanced.listeners.MenuListeners;
import me.loving11ish.playerguiadvanced.listeners.PlayerConnections;
import me.loving11ish.playerguiadvanced.menusystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.updatesystem.JoinEvent;
import me.loving11ish.playerguiadvanced.updatesystem.UpdateChecker;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
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

    public MessagesFileManager messagesFileManager;
    public PlayerListGUIFileManager playersGUIManager;
    public ActionsGUIFileManager actionsGUIManager;
    public BanGUIFileManager banGUIManager;

    @Override
    public void onEnable() {
        //Plugin startup logic
        plugin = this;

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")||
                Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")||
                Bukkit.getServer().getVersion().contains("1.17")||Bukkit.getServer().getVersion().contains("1.18")||
                Bukkit.getServer().getVersion().contains("1.19"))){
            logger.warning(ChatColor.RED + "-------------------------------------------");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - This plugin is only supported on the Minecraft versions listed below:");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.13.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.14.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.15.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.16.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.17.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.18.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - 1.19.x");
            logger.warning(ChatColor.RED + "PlayerGUIAdvanced - Is now disabling!");
            logger.warning(ChatColor.RED + "-------------------------------------------");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }else {
            logger.info(ChatColor.GREEN + "-------------------------------------------");
            logger.info(ChatColor.GREEN + "PlayerGUIAdvanced - A supported Minecraft version has been detected");
            logger.info(ChatColor.GREEN + "PlayerGUIAdvanced - Continuing plugin startup");
            logger.info(ChatColor.GREEN + "-------------------------------------------");
        }

        //Load the config file
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Load messages.yml
        this.messagesFileManager = new MessagesFileManager();
        messagesFileManager.MessagesFileManager(this);

        //Load playersGUI.yml
        this.playersGUIManager = new PlayerListGUIFileManager();
        playersGUIManager.PlayerListGUIFileManager(this);

        //Load actionsGUI.yml
        this.actionsGUIManager = new ActionsGUIFileManager();
        actionsGUIManager.ActionsGUIFileManager(this);

        //Load banGUI.yml
        this.banGUIManager = new BanGUIFileManager();
        banGUIManager.BanGUIFileManager(this);

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

        //Essentials hook check
        if (Bukkit.getPluginManager().isPluginEnabled("Essentials")){
            logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Successfully hooked into Essentials");
            logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Enabling Essentials integration");
        }
        logger.info("-------------------------------------------");

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
        logger.info("-------------------------------------------");
        logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Plugin By Loving11ish");
        logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - has been loaded successfully");
        logger.info(ChatColor.AQUA + "PlayerGUIAdvanced - Plugin Version " + pluginVersion);
        logger.info("-------------------------------------------");

        //Check for available updates
        new UpdateChecker(this, 74596).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("No-update-1")));
                logger.info(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("No-update-2")));
                logger.info(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("No-update-3")));
            }else {
                logger.warning(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("Update-1")));
                logger.warning(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("Update-2")));
                logger.warning(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("Update-3")));
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
