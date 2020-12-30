package me.loving11ish.playerguiadvanced.Commands.ConsoleCommands;

import me.loving11ish.playerguiadvanced.Commands.ConsoleCommand;
import org.bukkit.ChatColor;

public class Vanish extends ConsoleCommand {

    @Override
    public String getName() {
        return "vanish";
    }

    @Override
    public String getDescription() {
        return ChatColor.AQUA + "If SuperVanish or PremiumVanish plugins are installed, this will set you into vanish.";
    }

    @Override
    public String getSyntax() {
        return ChatColor.AQUA + "/pl vanish";
    }

    @Override
    public void perform(String[] args) {
        System.out.println(ChatColor.DARK_RED + "That command can only be executed by a player!");
    }

}
