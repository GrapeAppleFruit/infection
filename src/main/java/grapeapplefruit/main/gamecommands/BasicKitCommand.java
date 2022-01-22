package grapeapplefruit.main.gamecommands;

import grapeapplefruit.main.InfectionHashSet;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class BasicKitCommand implements CommandExecutor {

    Set<String> inf = InfectionHashSet.infection;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("basic")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (inf.contains(player.getName())) {
                    player.sendMessage("You may not claim a kit while you're infected.");
                } else {
                    player.sendMessage("Congrats you claimed your kit.");
                }
            }
        }
        return false;
    }
}
