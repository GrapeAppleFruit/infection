package grapeapplefruit.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game implements CommandExecutor, Listener {

    Set<String> infected = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player randomPlayer = Bukkit.getOnlinePlayers().stream().findAny().get();
            infected.add(randomPlayer.getName());
            randomPlayer.sendMessage(ChatColor.GREEN + "You've been infected!");
            randomPlayer.setPlayerListName(ChatColor.GREEN + randomPlayer.getName());
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Game has started.");
        }
        return false;
    }

    public boolean onCommand1(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            for (Player pls : Bukkit.getOnlinePlayers()) {

                if (infected.contains(pls.getUniqueId())) {

                    infected.remove(pls.getName());
                    pls.setPlayerListName(pls.getName());
                    Bukkit.getServer().broadcastMessage(ChatColor.RED + "Game has been stopped.");

                }
            }
        }
        return false;
    }

        @EventHandler
        public void onHit (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();
            if (infected.contains(whoHit.getUniqueId())) {
                infected.add(whoWasHit.getName());
                whoWasHit.sendMessage(ChatColor.GREEN + "You were infected!");
                whoWasHit.setPlayerListName(ChatColor.GREEN + whoWasHit.getName());
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Player " + whoWasHit + " has been infected.");
            } else {
                whoHit.sendMessage(ChatColor.RED + "You may not damage your team.");
                e.setCancelled(true);
            }
        }

    }

    public void allInfected(){
        for (Player ples : Bukkit.getOnlinePlayers()) {

            if (infected.contains(ples.getUniqueId())) {

                infected.remove(ples.getName());
                ples.setPlayerListName(ples.getName());
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Everyone was infected.");

            }
        }
    }

}