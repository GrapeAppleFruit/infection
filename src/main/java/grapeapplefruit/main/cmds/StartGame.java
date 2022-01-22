package grapeapplefruit.main.cmds;

import grapeapplefruit.main.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartGame implements CommandExecutor {

    boolean on = Game.game;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("forcestart")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (on = true){
                    player.sendMessage(ChatColor.RED + "The game already started.");
                } else if (on = false){

                }
            }
        }
        return false;
    }
}
