package grapeapplefruit.main.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("plhelp")){
            if (sender instanceof Player){
                Player player = (Player) sender;

                player.sendMessage(" ================ ");
                player.sendMessage("  Infection Help ");
                player.sendMessage(" ================ ");
                player.sendMessage(" /forcestart - Force to start. ");
                player.sendMessage(" /join - Join the game, or waiting. ");
                player.sendMessage(" /leave - Leave the game. ");
                player.sendMessage(" ================ ");

            }
        }
        return false;
    }
}
