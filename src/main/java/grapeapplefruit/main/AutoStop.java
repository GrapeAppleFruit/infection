package grapeapplefruit.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Set;

public class AutoStop {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    public void autoStop(){
        if (infam == ampl){
            infam = infam - infam;
            inf.clear();
            gmst = false;
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Everyone has been infected.");
        }
        if (infam == 0){
            infam = infam - infam;
            inf.clear();
            gmst = false;
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "The infected has left.");
        }


    }

}
