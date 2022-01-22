package grapeapplefruit.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Set;

public class AutoStart {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    public void autostart(){
        Player player = Bukkit.getOnlinePlayers().stream().skip((int) (Bukkit.getOnlinePlayers().size() * Math.random())).findFirst().orElse(null);
        if (ampl <= 2){
            gmst = true;
            infam = infam + 1;
            inf.add(player.getName());
            Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Infected, don't get killed.");
            Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Survivors, don't get hit.");
            player.setPlayerListName(ChatColor.GREEN + player.getName());
        }

        if (ampl == 1){
            Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "We need one more player to start the game.");
        }


    }

}
