package grapeapplefruit.main.cmds;

import grapeapplefruit.main.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class ServerStatus implements CommandExecutor {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("status")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (gmst = false){
                    player.sendMessage(ChatColor.YELLOW + "The game is currently off.");
                } else if(gmst = true){
                    player.sendMessage(ChatColor.YELLOW + "The game is currently on.");
                }
            }
        }
        return false;
    }
}
