package me.loving11ish.playerguiadvanced.Commands;

import me.loving11ish.playerguiadvanced.Commands.SubCommands.Help;
import me.loving11ish.playerguiadvanced.Commands.SubCommands.Reload;
import me.loving11ish.playerguiadvanced.Commands.SubCommands.Show;
import me.loving11ish.playerguiadvanced.Commands.SubCommands.Vanish;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class CommandManager implements TabExecutor {

    private ArrayList<SubCommand> subcommands = new ArrayList<>();
    private ArrayList<ConsoleCommand> consolecommands = new ArrayList<>();

    public CommandManager(){
        //Get the subcommands so we can access them in the command manager class(here)
        consolecommands.add(new me.loving11ish.playerguiadvanced.Commands.ConsoleCommands.Reload());
        consolecommands.add(new me.loving11ish.playerguiadvanced.Commands.ConsoleCommands.Help());
        consolecommands.add(new me.loving11ish.playerguiadvanced.Commands.ConsoleCommands.Vanish());
        consolecommands.add(new me.loving11ish.playerguiadvanced.Commands.ConsoleCommands.Show());
        subcommands.add(new Reload());
        subcommands.add(new Help());
        subcommands.add(new Vanish());
        subcommands.add(new Show());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length > 0){
                for (int i = 0; i < getSubCommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                        getSubCommands().get(i).perform(player, args);
                    }
                }
            }
        }else if (!(sender instanceof Player)) {
            if (args.length > 0){
                for (int i = 0; i < getConsoleCommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getConsoleCommands().get(i).getName())){
                        getConsoleCommands().get(i).perform(args);
                    }
                }
            }else {
                System.out.println(ChatColor.DARK_RED + "Please provide an argument!");
                System.out.println(ChatColor.DARK_RED + "pl reload");
                System.out.println(ChatColor.DARK_RED + "pl help");
            }
        }
        return true;
    }

    public ArrayList<SubCommand> getSubCommands(){
        return subcommands;
    }
    public ArrayList<ConsoleCommand> getConsoleCommands(){
        return consolecommands;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){ //pl <subcommand> <args>
            ArrayList<String> subcommandsArguments = new ArrayList<>();
            for (int i = 0; i < getSubCommands().size(); i++){
                subcommandsArguments.add(getSubCommands().get(i).getName());
            }
            return subcommandsArguments;
        }else if(args.length >= 2){
            for (int i = 0; i < getSubCommands().size(); i++){
                if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                    return getSubCommands().get(i).getSubcommandArguments((Player) sender, args);
                }
            }
        }
        return null;
    }
}