package grapeapplefruit.main.gamecommands;

import grapeapplefruit.main.InfectionHashSet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class EndGameCommand implements CommandExecutor {

    Set<String> inf = InfectionHashSet.infection;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("end")) {
            if (sender instanceof Player) {
                for (Player pls : Bukkit.getOnlinePlayers()) {

                    if (inf.contains(pls.getName())) {

                        inf.remove(pls.getName());
                        pls.setPlayerListName(pls.getName());
                        Bukkit.getServer().broadcastMessage(ChatColor.RED + "Game has been stopped.");

                    }
                }
            }
        }
        return false;
    }
}
