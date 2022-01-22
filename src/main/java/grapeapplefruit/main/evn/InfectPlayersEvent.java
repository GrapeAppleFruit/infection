package grapeapplefruit.main.evn;

import grapeapplefruit.main.Game;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Set;

public class InfectPlayersEvent implements Listener {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player whoWasHit = (Player) event.getEntity();
            Player whoHit = (Player) event.getDamager();
            if (inf.contains(whoHit.getName())){
                inf.add(whoWasHit.getName());
                infam = infam + 1;
                whoWasHit.sendMessage(ChatColor.GREEN + "You were infected.");
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + " " + whoWasHit + " Has been infected.");
            } else {
                whoHit.sendMessage(ChatColor.RED + "Do not damage your teammates.");
                event.setCancelled(true);
            }
        }
    }

}
