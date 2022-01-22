package grapeapplefruit.main.evn;

import grapeapplefruit.main.Game;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Set;

public class JoinEvent implements Listener {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    @EventHandler
    public void JoinEvent(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();
        if (gmst = true){
            ampl = ampl + 1;
            player.sendMessage(ChatColor.YELLOW + "Do /join to join the game.");
        } else if (gmst = false) {
            ampl = ampl + 1;
            if (ampl >= 1){
                player.sendMessage(ChatColor.RED + "1 more player needed to start.");
            }
        }
    }
}
