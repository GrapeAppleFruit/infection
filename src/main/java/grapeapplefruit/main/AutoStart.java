package grapeapplefruit.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Set;

public class AutoStart implements Listener {

    int plrs = Game.players;
    Set<String> inf = Game.infected;
    Set<String> survp = Game.survivor;
    int surv = Game.survp;
    int pc = Main.pc;

    public void autoStart(){
        if (plrs == 2){
            Player player = Bukkit.getOnlinePlayers().stream().skip((int) (Bukkit.getOnlinePlayers().size() * Math.random())).findFirst().orElse(null);
            inf.add(player.getName());
            player.setPlayerListName(ChatColor.GREEN + player.getName());
            if (inf.contains(player.getName())){
                surv = surv - 1;
                surv = surv + pc;
            }
        }
    }

}
