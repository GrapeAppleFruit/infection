package grapeapplefruit.main.cmds;

import grapeapplefruit.main.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class LeaveCommand implements CommandExecutor {

    Set<String> ingg = Game.ing;
    Set<String> inf = Game.infected;
    Set<String> spec = Game.spect;
    Set<String> surv = Game.survivor;

    boolean on = Game.game;

    int plrs = Game.players;
    int infp = Game.infectedp;
    int survp = Game.survp;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("leave")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (on = false){
                    player.sendMessage(ChatColor.RED + "The game hasn't even started.");
                } else if (on = true){
                    if (inf.contains(player.getName())){
                        infp = infp - 1;
                        plrs = plrs - 1;
                        inf.remove(player.getName());
                        spec.add(player.getName());
                        player.sendMessage("You've left the game.");
                    } else if (surv.contains(player.getName())){
                        surv.remove(player.getName());
                        spec.add(player.getName());
                        plrs = plrs - 1;
                        survp = survp - 1;
                    }
                }

            }
        }
        return false;
    }
}
