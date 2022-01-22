package grapeapplefruit.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class AutoStop {

    int plrs = Game.players;
    int infp = Game.infectedp;
    int surv = Game.survp;
    boolean on = Game.game;

    public void autoStop(){
        if (on = false){

        } else if (on = true){
            if (plrs == infp){
                on = false;
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Everyone has died to the infected.");
                infp = infp - infp;
                surv = surv - surv;
            }
        }
    }


}
