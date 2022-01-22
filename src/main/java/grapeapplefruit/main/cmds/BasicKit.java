package grapeapplefruit.main.cmds;

import com.sun.org.apache.xalan.internal.xsltc.dom.MatchingIterator;
import grapeapplefruit.main.Game;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class BasicKit implements CommandExecutor {

    Set<String> inf = Game.infected;
    int ampl = Game.playerAmount;
    int infam = Game.infAmount;
    boolean gmst = Game.serverStatus;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("basic")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (gmst = false){
                    player.sendMessage(ChatColor.RED + "Sorry the game hasn't started yet.");
                } else if (gmst = true){
                    if (inf.contains(player.getName())){
                        player.sendMessage(ChatColor.RED + "Sorry you can't use this while infected.");
                    } else {
                        player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD, 1));
                        player.getInventory().addItem(new ItemStack(Material.BOW, 1));
                        player.getInventory().addItem(new ItemStack(Material.ARROW, 32));
                        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 32));
                    }
                }

            }
        }
        return false;
    }
}
