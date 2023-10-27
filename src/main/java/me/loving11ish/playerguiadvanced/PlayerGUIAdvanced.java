package me.loving11ish.playerguiadvanced;

import com.rylinaux.plugman.api.PlugManAPI;
import com.tcoded.folialib.FoliaLib;
import io.papermc.lib.PaperLib;
import me.loving11ish.playerguiadvanced.commands.Commands.Actions;
import me.loving11ish.playerguiadvanced.commands.CommandManager;
import me.loving11ish.playerguiadvanced.commands.Commands.Players;
import me.loving11ish.playerguiadvanced.commands.Commands.Punish;
import me.loving11ish.playerguiadvanced.externalhooks.PlugManXAPI;
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
import me.loving11ish.playerguiadvanced.utils.VersionCheckerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class PlayerGUIAdvanced extends JavaPlugin {

    ConsoleCommandSender console = Bukkit.getConsoleSender();

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();

    private static PlayerGUIAdvanced plugin;
    private static FoliaLib foliaLib;
    private static VersionCheckerUtils versionCheckerUtils;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    public MessagesFileManager messagesFileManager;
    public PlayerListGUIFileManager playersGUIManager;
    public ActionsGUIFileManager actionsGUIManager;
    public BanGUIFileManager banGUIManager;

    @Override
    public void onEnable() {
        //Plugin startup logic
        plugin = this;
        foliaLib = new FoliaLib(plugin);
        versionCheckerUtils = new VersionCheckerUtils();
        versionCheckerUtils.setVersion();

        //Server version compatibility check
        if (versionCheckerUtils.getVersion() < 13||versionCheckerUtils.getVersion() > 20){
            console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Your server version is: &d" + Bukkit.getServer().getVersion()));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4This plugin is only supported on the Minecraft versions listed below:"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.13.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.14.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.15.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.16.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.17.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.18.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.19.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &41.20.x"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Is now disabling!"));
            console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }else {
            console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aA supported Minecraft version has been detected"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aYour server version is: &d" + Bukkit.getServer().getVersion()));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aContinuing plugin startup"));
            console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
        }

        //Suggest PaperMC if not using
        if (foliaLib.isUnsupported()||foliaLib.isSpigot()){
            PaperLib.suggestPaper(this);
        }

        //Check if PlugManX is enabled
        if (Bukkit.getServer().getPluginManager().isPluginEnabled("PlugManX")||PlugManXAPI.isPlugManXEnabled()){
            if (!PlugManAPI.iDoNotWantToBeUnOrReloaded("PlayerGUIAdvanced")){
                console.sendMessage(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                console.sendMessage(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                console.sendMessage(ColorUtils.translateColorCodes("&4WARNING WARNING WARNING WARNING!"));
                console.sendMessage(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4You appear to be using an unsupported version of &d&lPlugManX"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Please &4&lDO NOT USE PLUGMANX TO LOAD/UNLOAD/RELOAD THIS PLUGIN!"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Please &4&lFULLY RESTART YOUR SERVER!"));
                console.sendMessage(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4This plugin &4&lHAS NOT &4been validated to use this version of PlugManX!"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4&lNo official support will be given to you if you use this!"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4&lUnless Loving11ish has explicitly agreed to help!"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &4Please add PlayerGUIAdvanced to the ignored-plugins list in PlugManX's config.yml"));
                console.sendMessage(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &6Continuing plugin startup"));
                console.sendMessage(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                console.sendMessage(ColorUtils.translateColorCodes("&c-------------------------------------------"));
            }else {
                console.sendMessage(ColorUtils.translateColorCodes("&a-------------------------------------------"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aSuccessfully hooked into PlugManX"));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aSuccessfully added PlayerGUIAdvanced to ignored-Plugins list."));
                console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &6Continuing plugin startup"));
                console.sendMessage(ColorUtils.translateColorCodes("&a-------------------------------------------"));
            }
        }else {
            console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &cPlugManX not found!"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &cDisabling PlugManX hook loader"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &6Continuing plugin startup"));
            console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
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
        console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
        if (Bukkit.getPluginManager().isPluginEnabled("SuperVanish")){
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Successfully hooked into SuperVanish"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Enabling VanishAPI features"));
        }
        if (Bukkit.getPluginManager().isPluginEnabled("PremiumVanish")){
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Successfully hooked into PremiumVanish"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Enabling VanishAPI features"));
        }

        //Essentials hook check
        if (Bukkit.getPluginManager().isPluginEnabled("Essentials")){
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Successfully hooked into Essentials"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Enabling Essentials integration"));
        }
        console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));

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
        console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
        console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin By &b&lLoving11ish"));
        console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3has been loaded successfully"));
        console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin Version &d&l" + pluginVersion));
        console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));

        //Check for available updates
        new UpdateChecker(74596).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                console.sendMessage(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("No-update-1")));
                console.sendMessage(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("No-update-2")));
                console.sendMessage(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("No-update-3")));
            }else {
                console.sendMessage(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("Update-1")));
                console.sendMessage(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("Update-2")));
                console.sendMessage(ColorUtils.translateColorCodes(messagesFileManager.getMessagesConfig().getString("Update-3")));
            }
        });
    }

    @Override
    public void onDisable() {
        //Plugin shutdown logic

        //Unregister plugin listeners
        HandlerList.unregisterAll(this);

        //Safely stop the background tasks if running
        console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));
        console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin by: &b&lLoving11ish"));
        try {
            if (!PlayerListMenu.GUIUpdateTask.isCancelled()){
                PlayerListMenu.GUIUpdateTask.cancel();
            }
            if (foliaLib.isUnsupported()){
                Bukkit.getScheduler().cancelTasks(this);
            }
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Background tasks have disabled successfully!"));
        }catch (Exception e){
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Background tasks have disabled successfully!"));
        }

        //Final plugin shutdown message
        console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Plugin Version: &d&l" + pluginVersion));
        console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Has been shutdown successfully"));
        console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &3Goodbye!"));
        console.sendMessage(ColorUtils.translateColorCodes("-------------------------------------------"));

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

    public static PlayerGUIAdvanced getPlugin() {
        return plugin;
    }

    public static FoliaLib getFoliaLib() {
        return foliaLib;
    }

    public static VersionCheckerUtils getVersionCheckerUtils() {
        return versionCheckerUtils;
    }
}
