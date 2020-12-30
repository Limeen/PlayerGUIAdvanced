package me.loving11ish.playerguiadvanced.Commands.SubCommands;

import me.loving11ish.playerguiadvanced.Commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Help extends SubCommand {


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
    public void perform(Player player, String[] args) {
        if (player.hasPermission("playergui.help")) {
            player.sendMessage(ChatColor.YELLOW + "[---------------- " + ChatColor.AQUA + "[PlayerGUIAdvanced] " + ChatColor.YELLOW + "-----------------]");
            player.sendMessage(ChatColor.WHITE + "/actions <player>" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command opens up the Actions GUI.");
            player.sendMessage(ChatColor.WHITE + "/punish <player> " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command opens up the Punish GUI.");
            player.sendMessage(ChatColor.WHITE + "/players " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command opens up the Player List GUI.");
            player.sendMessage(ChatColor.WHITE + "/pl reload" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command reloads the plugin config file.");
            player.sendMessage(ChatColor.WHITE + "/pl vanish" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command sets you into vanish.");
            player.sendMessage(ChatColor.WHITE + "/pl show" + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command sets you out of vanish.");
            player.sendMessage(ChatColor.WHITE + "/pl help " + ChatColor.GRAY + "- " + ChatColor.LIGHT_PURPLE + "This command shows this help menu.");
            player.sendMessage(ChatColor.YELLOW + "[-------------------- " + ChatColor.AQUA + "Permissions " + ChatColor.YELLOW + "---------------------]");
            player.sendMessage(ChatColor.WHITE + "                               playergui.use");
            player.sendMessage(ChatColor.WHITE + "                               playergui.mod");
            player.sendMessage(ChatColor.WHITE + "                               playergui.ban");
            player.sendMessage(ChatColor.WHITE + "                               playergui.op");
            player.sendMessage(ChatColor.WHITE + "                               playergui.deop");
            player.sendMessage(ChatColor.WHITE + "                               playergui.exempt");
            player.sendMessage(ChatColor.WHITE + "                               playergui.vanish");
            player.sendMessage(ChatColor.WHITE + "                               playergui.show");
            player.sendMessage(ChatColor.WHITE + "                               playergui.help");
            player.sendMessage(ChatColor.WHITE + "                               playergui.reload");
            player.sendMessage(ChatColor.WHITE + "                               playergui.update");
            player.sendMessage(ChatColor.YELLOW + "[----------------------------------------------------]");
        } else {
            player.sendMessage(ChatColor.DARK_RED + "You do not have the permission " + ChatColor.YELLOW + "playergui.help " + ChatColor.DARK_RED + "required to execute that command!");
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}
