package me.loving11ish.playerguiadvanced.commands;

import me.loving11ish.playerguiadvanced.commands.ConsoleCommands.ConsoleHelp;
import me.loving11ish.playerguiadvanced.commands.ConsoleCommands.ConsoleReload;
import me.loving11ish.playerguiadvanced.commands.ConsoleCommands.ConsoleShow;
import me.loving11ish.playerguiadvanced.commands.ConsoleCommands.ConsoleVanish;
import me.loving11ish.playerguiadvanced.commands.SubCommands.Help;
import me.loving11ish.playerguiadvanced.commands.SubCommands.Reload;
import me.loving11ish.playerguiadvanced.commands.SubCommands.Show;
import me.loving11ish.playerguiadvanced.commands.SubCommands.Vanish;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements TabExecutor {

    ConsoleCommandSender console = Bukkit.getConsoleSender();
    
    private ArrayList<SubCommand> subCommands = new ArrayList<>();
    private ArrayList<ConsoleCommand> consoleCommands = new ArrayList<>();

    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    public CommandManager() {
        //Get the subcommands so we can access them in the command manager class(here)
        consoleCommands.add(new ConsoleReload());
        consoleCommands.add(new ConsoleHelp());
        consoleCommands.add(new ConsoleVanish());
        consoleCommands.add(new ConsoleShow());
        subCommands.add(new Reload());
        subCommands.add(new Help());
        subCommands.add(new Vanish());
        subCommands.add(new Show());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                        getSubCommands().get(i).perform(player, args);
                    }
                }
            }
        } else if (sender instanceof ConsoleCommandSender) {
            if (args.length > 0) {
                for (int i = 0; i < getConsoleCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getConsoleCommands().get(i).getName())) {
                        getConsoleCommands().get(i).perform(args);
                    }
                }
            } else {
                console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Syntax-error-1")));
                console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Syntax-error-2")));
                console.sendMessage(ColorUtils.translateColorCodes(messagesConfig.getString("Syntax-error-3")));
            }
        }
        return true;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return subCommands;
    }

    public ArrayList<ConsoleCommand> getConsoleCommands() {
        return consoleCommands;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) { //pl <subcommand> <args>
            ArrayList<String> subcommandsArguments = new ArrayList<>();
            for (int i = 0; i < getSubCommands().size(); i++) {
                subcommandsArguments.add(getSubCommands().get(i).getName());
            }
            return subcommandsArguments;
        } else if (args.length >= 2) {
            for (int i = 0; i < getSubCommands().size(); i++) {
                if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                    return getSubCommands().get(i).getSubcommandArguments((Player) sender, args);
                }
            }
        }
        return null;
    }
}