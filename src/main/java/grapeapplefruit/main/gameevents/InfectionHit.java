package grapeapplefruit.main.gameevents;

import grapeapplefruit.main.InfectionHashSet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Set;

public class InfectionHit implements Listener {

    Set<String> inf = InfectionHashSet.infection;

    @EventHandler
    public void onHit (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();
            if (inf.contains(whoHit.getName())) {
                inf.add(whoWasHit.getName());
                whoHit.setExp(whoHit.getExp() + 20);
                whoWasHit.sendMessage(ChatColor.GREEN + "You were infected!");
                whoWasHit.setPlayerListName(ChatColor.GREEN + whoWasHit.getName());
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Player " + whoWasHit + " has been infected.");
            } else {
                whoHit.sendMessage(ChatColor.RED + "You may not damage your team.");
                e.setCancelled(true);
            }
        }

    }
}
