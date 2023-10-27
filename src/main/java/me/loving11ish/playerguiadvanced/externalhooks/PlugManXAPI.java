package me.loving11ish.playerguiadvanced.externalhooks;

import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class PlugManXAPI {

    static ConsoleCommandSender console = Bukkit.getConsoleSender();

    public static boolean isPlugManXEnabled() {
        try {
            Class.forName("com.rylinaux.plugman.PlugMan");
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aFound PlugManX main class at:"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &dcom.rylinaux.plugman.PlugMan"));
            return true;
        }catch (ClassNotFoundException e){
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &aCould not find PlugManX main class at:"));
            console.sendMessage(ColorUtils.translateColorCodes("&6PlayerGUIAdvanced: &dcom.rylinaux.plugman.PlugMan"));
            return false;
        }
    }
}
