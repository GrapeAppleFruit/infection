package grapeapplefruit.main.kitcommands;

import grapeapplefruit.main.InfectionHashSet;
import grapeapplefruit.main.gamecommands.StartGameCommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class StoneKitCommand implements CommandExecutor {

    Set<String> inf = InfectionHashSet.infection;

    boolean gameStart = StartGameCommand.gameStarted;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("stone")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (gameStart = true){
                    if (inf.contains(player.getName())) {
                        player.sendMessage(ChatColor.RED + "You may not claim a kit while you're infected.");
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "Congrats you claimed your kit.");
                        player.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
                        player.getInventory().addItem(new ItemStack(Material.BOW, 1));
                        player.getInventory().addItem(new ItemStack(Material.ARROW, 12));
                        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 12));
                        player.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
                        player.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
                        player.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS, 1));
                        player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "The game hasn't started yet.");
                }
            }
        }
        return false;
    }
}
