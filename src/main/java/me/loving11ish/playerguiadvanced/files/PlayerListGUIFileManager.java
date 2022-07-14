package me.loving11ish.playerguiadvanced.files;

import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class PlayerListGUIFileManager {

    private PlayerGUIAdvanced plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;

    Logger logger = PlayerGUIAdvanced.getPlugin().getLogger();

    public void PlayerListGUIFileManager(PlayerGUIAdvanced plugin){
        this.plugin = plugin;
        saveDefaultPlayersGUIConfig();
    }

    public void reloadPlayersGUIConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "playersGUI.yml");
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource("playersGUI.yml");
        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getPlayersGUIConfig(){
        if (this.dataConfig == null){
            this.reloadPlayersGUIConfig();
        }
        return this.dataConfig;
    }

    public void savePlayersGUIConfig() {
        if (this.dataConfig == null||this.configFile == null){
            return;
        }
        try {
            this.getPlayersGUIConfig().save(this.configFile);
        }catch (IOException e){
            logger.severe(ColorUtils.translateColorCodes("&bPlayerGUIAdvanced - &4Could not save playersGUI.yml"));
            logger.severe(ColorUtils.translateColorCodes("&bPlayerGUIAdvanced - &4Check the below message for the reasons!"));
            e.printStackTrace();
        }
    }

    public void saveDefaultPlayersGUIConfig(){
        if (this.configFile == null){
            this.configFile = new File(plugin.getDataFolder(), "playersGUI.yml");
        }
        if (!this.configFile.exists()){
            this.plugin.saveResource("playersGUI.yml", false);
        }
    }
}
