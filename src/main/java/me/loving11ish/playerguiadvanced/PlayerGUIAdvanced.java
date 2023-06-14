package me.loving11ish.playerguiadvanced;

import com.rylinaux.plugman.api.PlugManAPI;
import com.tcoded.folialib.FoliaLib;
import io.papermc.lib.PaperLib;
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
import me.loving11ish.playerguiadvanced.menusystem.Menus.PlayerListMenu;
import me.loving11ish.playerguiadvanced.menusystem.PlayerMenuUtility;
import me.loving11ish.playerguiadvanced.updatesystem.JoinEvent;
import me.loving11ish.playerguiadvanced.updatesystem.UpdateChecker;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public final class PlayerGUIAdvanced extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();

    private static PlayerGUIAdvanced plugin;
    private static FoliaLib foliaLib;

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
        foliaLib = new FoliaLib(plugin);

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")||
                Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")||
                Bukkit.getServer().getVersion().contains("1.17")||Bukkit.getServer().getVersion().contains("1.18")||
                Bukkit.getServer().getVersion().contains("1.19")||Bukkit.getServer().getVersion().contains("1.20"))){
            logger.warning(ColorUtils.translateColorCodes("-------------------------------------------"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Your server version is: " + Bukkit.getServer().getVersion()));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4This plugin is only supported on the Minecraft versions listed below:"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.13.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.14.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.15.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.16.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.17.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.18.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.19.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.20.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Is now disabling!"));
            logger.warning(ColorUtils.translateColorCodes("-------------------------------------------"));
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }else {
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aA supported Minecraft version has been detected"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Your server version is: " + Bukkit.getServer().getVersion()));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aContinuing plugin startup"));
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        }

        //Suggest PaperMC if not using
        if (foliaLib.isUnsupported()||foliaLib.isSpigot()){
            PaperLib.suggestPaper(this);
        }

        //Check if PlugManX is enabled
        if (isPlugManXEnabled()){
            if (!PlugManAPI.iDoNotWantToBeUnOrReloaded("PlayerGUIAdvanced")){
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&4WARNING WARNING WARNING WARNING!"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4You appear to be using an unsupported version of &d&lPlugManX"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Please &4&lDO NOT USE PLUGMANX TO LOAD/UNLOAD/RELOAD THIS PLUGIN!"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Please &4&lFULLY RESTART YOUR SERVER!"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4This plugin &4&lHAS NOT &4been validated to use this version of PlugManX!"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4&lNo official support will be given to you if you use this!"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4&lUnless Loving11ish has explicitly agreed to help!"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Please add PlayerGUIAdvanced to the ignored-plugins list in PlugManX's config.yml"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &6Continuing plugin startup"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
            }else {
                logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
                logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aSuccessfully hooked into PlugManX"));
                logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aSuccessfully added PlayerGUIAdvanced to ignored-Plugins list."));
                logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &6Continuing plugin startup"));
                logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
            }
        }else {
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &cPlugManX not found!"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &cDisabling PlugManX hook loader"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &6Continuing plugin startup"));
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
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
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish")){
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Successfully hooked into SuperVanish"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Enabling VanishAPI features"));
        }
        if (Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")){
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Successfully hooked into PremiumVanish"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Enabling VanishAPI features"));
        }

        //Essentials hook check
        if (Bukkit.getPluginManager().isPluginEnabled("Essentials")){
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Successfully hooked into Essentials"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Enabling Essentials integration"));
        }
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));

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
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin By &b&lLoving11ish"));
        logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3has been loaded successfully"));
        logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin Version &d&l" + pluginVersion));
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));

        //Check for available updates
        new UpdateChecker(74596).getVersion(version -> {
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
        //Plugin shutdown logic

        //Unregister plugin listeners
        HandlerList.unregisterAll(this);

        //Safely stop the background tasks if running
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin by: &b&lLoving11ish"));
        try {
            if (!PlayerListMenu.wrappedTaskOne.isCancelled()){
                PlayerListMenu.wrappedTaskOne.cancel();
            }
            if (foliaLib.isUnsupported()){
                Bukkit.getScheduler().cancelTasks(this);
            }
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Background tasks have disabled successfully!"));
        }catch (Exception e){
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Background tasks have disabled successfully!"));
        }

        //Final plugin shutdown message
        logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin Version: &d&l" + pluginVersion));
        logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Has been shutdown successfully"));
        logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Goodbye!"));
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));

        //Clean up any plugin remains
        playersGUIManager = null;
        actionsGUIManager = null;
        banGUIManager = null;
        messagesFileManager = null;
        foliaLib = null;
        plugin = null;
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

    public boolean isPlugManXEnabled() {
        try {
            Class.forName("com.rylinaux.plugman.PlugMan");
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aFound PlugManX main class at:"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &dcom.rylinaux.plugman.PlugMan"));
            return true;
        }catch (ClassNotFoundException e){
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aCould not find PlugManX main class at:"));
            logger.info(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &dcom.rylinaux.plugman.PlugMan"));
            return false;
        }
    }

    public static PlayerGUIAdvanced getPlugin() {
        return plugin;
    }

    public static FoliaLib getFoliaLib() {
        return foliaLib;
    }
}
