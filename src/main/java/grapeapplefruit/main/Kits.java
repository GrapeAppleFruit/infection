package grapeapplefruit.main;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Kits implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            final Inventory inventory = player.getInventory();

            inventory.addItem(new ItemStack(Material.WOODEN_SWORD, 1));
        }
        return false;
    }

    @EventHandler
    public void rightclick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getItemInUse();

        if (item==null)return;
        if(item.getType() == Material.WOODEN_SWORD){
            final Inventory inventory = player.getInventory();
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                inventory.addItem(new ItemStack(Material.STONE_SWORD, 1));
                inventory.removeItem(new ItemStack(Material.WOODEN_SWORD, 1));
            }
        }
    }

}
