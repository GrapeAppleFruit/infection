package grapeapplefruit.main.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("infhelp")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                player.sendMessage(" ============== ");
                player.sendMessage(" Infection help ");
                player.sendMessage(" ============== ");
                player.sendMessage(" /join - Join the game. ");
                player.sendMessage(" /help - get plugin help. ");
                player.sendMessage(" /status - Get the game's status. ");
                player.sendMessage(" /basic - Get the basic kit. ");
            }
        }
        return false;
    }
}
