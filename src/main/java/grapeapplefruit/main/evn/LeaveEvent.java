package grapeapplefruit.main.evn;

import grapeapplefruit.main.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Set;

public class LeaveEvent implements Listener {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    public void playerLeave(PlayerQuitEvent event){
        Player player = (Player) event.getPlayer();
        ampl = ampl - 1;
        if (inf.contains(player.getName())){
            inf.remove(player.getName());
            infam = infam - 1;
        }
    }

}
