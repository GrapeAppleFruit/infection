package grapeapplefruit.main.cmds;

import grapeapplefruit.main.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class JoinCommand implements CommandExecutor {

    Set<String> ingg = Game.ing;
    Set<String> inf = Game.infected;

    boolean on = Game.game;

    int plrs = Game.players;

    int infp = Game.infectedp;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("join")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (on = true){
                    ingg.add(player.getName());
                    inf.add(player.getName());
                    infp = infp + 1;
                    player.sendMessage(ChatColor.YELLOW + "You've joined the game!");
                } else if (on = false){
                    plrs = plrs + 1;
                    player.sendMessage(ChatColor.YELLOW + "You've set yourself in queue, /leave to leave.");
                }

            }
        }
        return false;
    }
}
