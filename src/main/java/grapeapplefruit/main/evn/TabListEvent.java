package grapeapplefruit.main.evn;

import grapeapplefruit.main.Game;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

public class TabListEvent implements Listener {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    @EventHandler
    public void infectedTab(AsyncPlayerChatEvent event){
        Player player = (Player) event.getPlayer();
        if (inf.contains(player.getName())){
            event.getPlayer().setPlayerListName(ChatColor.GREEN + player.getName());
        }

    }
}
