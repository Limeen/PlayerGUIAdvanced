package me.loving11ish.playerguiadvanced.files;

import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActionsGUIFileManager {

    ConsoleCommandSender console = Bukkit.getConsoleSender();

    private PlayerGUIAdvanced plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public void ActionsGUIFileManager(PlayerGUIAdvanced plugin){
        this.plugin = plugin;
        saveDefaultActionsGUIConfig();
    }

    public void reloadActionsGUIConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "actionsGUI.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("actionsGUI.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getActionsGUIConfig(){
        if (this.dataConfig == null){
            this.reloadActionsGUIConfig();
        }
        return this.dataConfig;
    }

    public void saveActionsGUIConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getActionsGUIConfig().save(this.configFile);
        }catch (IOException e){
            console.sendMessage(ColorUtils.translateColorCodes("&bPlayerGUIAdvanced - &4Could not save actionsGUI.yml"));
            console.sendMessage(ColorUtils.translateColorCodes("&bPlayerGUIAdvanced - &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultActionsGUIConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "actionsGUI.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("actionsGUI.yml", false);
        }
    }
}

