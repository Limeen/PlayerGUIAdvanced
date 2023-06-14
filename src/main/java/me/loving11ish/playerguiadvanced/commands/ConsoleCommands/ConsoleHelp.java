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
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-1")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-2")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-3")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-4")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-5")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-6")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-7")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-8")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-9")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-10")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-11")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-12")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-13")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-14")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-15")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-16")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-17")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-18")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-19")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-20")));
        logger.info(ColorUtils.translateColorCodes(messagesConfig.getString("ConsoleHelp-21")));
    }
}
