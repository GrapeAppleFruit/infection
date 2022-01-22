package grapeapplefruit.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreditsCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("credits")){
            if (sender instanceof Player){
                Player player = (Player) sender;

                player.sendMessage(ChatColor.GOLD + "Developed by GrapeAppleFruit!");
            }
        }
        return false;
    }
}
