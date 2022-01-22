package grapeapplefruit.main.evnts;

import grapeapplefruit.main.Game;
import jdk.javadoc.internal.doclets.toolkit.taglets.SeeTaglet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Set;

public class JoinEvent implements Listener {

    Set<String> inf = Game.infected;

    boolean on = Game.game;
    int infp = Game.infectedp;
    int plrs = Game.players;

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();
        if (on = false){
            player.sendMessage(ChatColor.YELLOW + "Do /join to join the waiting.");
            plrs = plrs + 1;
        } else if (on = true){
            inf.add(player.getName());
            infp = infp + 1;
        }
    }
}
