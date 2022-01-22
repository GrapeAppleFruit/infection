package grapeapplefruit.main.gameevents;

import grapeapplefruit.main.InfectionHashSet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Set;

public class AllPlayersInf implements Listener {

    Set<String> inf = InfectionHashSet.infection;

    @EventHandler
    public void allBeenInfected(){
        for (Player ples : Bukkit.getOnlinePlayers()) {
            if (inf.contains(ples.getUniqueId())) {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Everyone has died to the infected.");
                inf.remove(ples.getName());
            }
        }
    }
}
