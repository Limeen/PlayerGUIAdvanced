package me.loving11ish.playerguiadvanced.commands.ConsoleCommands;

import me.loving11ish.playerguiadvanced.commands.ConsoleCommand;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.logging.Logger;

public class ConsoleHelp extends ConsoleCommand {

    Logger logger = PlayerGUIAdvanced.getPlugin().getLogger();
    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return ChatColor.AQUA + "This shows the PlayerGUI full command and permissions lists.";
    }

    @Override
    public String getSyntax() {
        return ChatColor.AQUA + "/pl help";
    }

    @Override
    public void perform(String[] args) {
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-1")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-2")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-3")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-4")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-5")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-6")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-7")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-8")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-9")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-10")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-11")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-12")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-13")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-14")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-15")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-16")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-17")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-18")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-19")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-20")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("Help-21")));
    }
}
