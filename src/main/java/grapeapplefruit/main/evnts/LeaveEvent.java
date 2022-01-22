package grapeapplefruit.main.evnts;

import grapeapplefruit.main.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Set;

public class LeaveEvent implements Listener {

    Set<String> inf = Game.infected;
    Set<String> surv = Game.survivor;

    boolean on = Game.game;
    int infp = Game.infectedp;
    int survp = Game.survp;
    int plrs = Game.players;

    @EventHandler
    public void playerLeave(PlayerQuitEvent event){
        Player player = (Player) event.getPlayer();
        if (on = false){
            plrs = plrs - 1;
        }
        if (on = true){
            if (inf.contains(player.getName())){
                plrs = plrs - 1;
                infp = infp - 1;
                inf.remove(player.getName());
            }
            if (surv.contains(player.getName())){
                plrs = plrs - 1;
                survp = survp - 1;
                surv.remove(player.getName());
            }
        }

    }
}
