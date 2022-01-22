package grapeapplefruit.main.gamecommands;

import grapeapplefruit.main.InfectionHashSet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class StartGameCommand implements CommandExecutor {

    Set<String> inf = InfectionHashSet.infection;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (sender instanceof Player) {
                Player randomPlayer = Bukkit.getOnlinePlayers().stream().findAny().get();
                inf.add(randomPlayer.getName());
                randomPlayer.sendMessage(ChatColor.GREEN + "You've been infected!");
                randomPlayer.setPlayerListName(ChatColor.GREEN + randomPlayer.getName());
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Game has started.");
            }
        }
        return false;
    }
}
