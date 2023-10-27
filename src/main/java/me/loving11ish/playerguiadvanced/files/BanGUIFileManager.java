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

public class BanGUIFileManager {

    ConsoleCommandSender console = Bukkit.getConsoleSender();

    private PlayerGUIAdvanced plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    public void BanGUIFileManager(PlayerGUIAdvanced plugin){
        this.plugin = plugin;
        saveDefaultBanGUIConfig();
    }

    public void reloadBanGUIConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "banGUI.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("banGUI.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getBanGUIConfig(){
        if (this.dataConfig == null){
            this.reloadBanGUIConfig();
        }
        return this.dataConfig;
    }

    public void saveBanGUIConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getBanGUIConfig().save(this.configFile);
        }catch (IOException e){
            console.sendMessage(ColorUtils.translateColorCodes("&bPlayerGUIAdvanced - &4Could not save banGUI.yml"));
            console.sendMessage(ColorUtils.translateColorCodes("&bPlayerGUIAdvanced - &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultBanGUIConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "banGUI.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("banGUI.yml", false);
        }
    }
}


