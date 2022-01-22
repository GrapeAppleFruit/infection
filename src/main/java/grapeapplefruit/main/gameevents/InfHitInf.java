package grapeapplefruit.main.gameevents;

import grapeapplefruit.main.InfectionHashSet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Set;

public class InfHitInf implements Listener {

    Set<String> inf = InfectionHashSet.infection;

    @EventHandler
    public void onHit (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();
            if (inf.contains(whoHit.getName())){
                if (inf.contains(whoWasHit.getName())) {
                    whoHit.sendMessage(ChatColor.RED + "Do not hit your team.");
                    e.setCancelled(true);
                }
            }
        }

    }

}
