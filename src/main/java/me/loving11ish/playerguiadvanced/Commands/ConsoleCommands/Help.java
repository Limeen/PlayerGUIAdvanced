package me.loving11ish.playerguiadvanced.Commands.ConsoleCommands;

import me.loving11ish.playerguiadvanced.Commands.ConsoleCommand;
import org.bukkit.ChatColor;

public class Help extends ConsoleCommand {

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
        System.out.println(ChatColor.YELLOW + "[---------------- " + ChatColor.AQUA + "[PlayerGUIAdvanced] " + ChatColor.YELLOW + "-----------------]");
        System.out.println(ChatColor.WHITE + "/actions <player>" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command opens up the Actions GUI.");
        System.out.println(ChatColor.WHITE + "/punish <player> " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command opens up the Punish GUI.");
        System.out.println(ChatColor.WHITE + "/players " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command opens up the Player List GUI.");
        System.out.println(ChatColor.WHITE + "/pl reload" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command reloads the plugin config file.");
        System.out.println(ChatColor.WHITE + "/pl vanish" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command sets you into vanish.");
        System.out.println(ChatColor.WHITE + "/pl show" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command sets you out of vanish.");
        System.out.println(ChatColor.WHITE + "/pl help " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command shows this help menu.");
        System.out.println(ChatColor.YELLOW + "[-------------------- " + ChatColor.AQUA + "Permissions " + ChatColor.YELLOW + "---------------------]");
        System.out.println(ChatColor.WHITE + "                     playergui.use");
        System.out.println(ChatColor.WHITE + "                     playergui.mod");
        System.out.println(ChatColor.WHITE + "                     playergui.ban");
        System.out.println(ChatColor.WHITE + "                     playergui.op");
        System.out.println(ChatColor.WHITE + "                     playergui.deop");
        System.out.println(ChatColor.WHITE + "                     playergui.exempt");
        System.out.println(ChatColor.WHITE + "                     playergui.vanish");
        System.out.println(ChatColor.WHITE + "                     playergui.show");
        System.out.println(ChatColor.WHITE + "                     playergui.help");
        System.out.println(ChatColor.WHITE + "                     playergui.reload");
        System.out.println(ChatColor.WHITE + "                     playergui.update");
        System.out.println(ChatColor.YELLOW + "[----------------------------------------------------]");
    }
}
