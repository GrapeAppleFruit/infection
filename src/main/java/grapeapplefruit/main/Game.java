package grapeapplefruit.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game implements CommandExecutor, Listener {

    Set<String> infected = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (sender instanceof Player) {
                Player randomPlayer = Bukkit.getOnlinePlayers().stream().findAny().get();
                infected.add(randomPlayer.getName());
                randomPlayer.sendMessage(ChatColor.GREEN + "You've been infected!");
                randomPlayer.setPlayerListName(ChatColor.GREEN + randomPlayer.getName());
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Game has started.");
            }
        }
        return false;
    }

    public boolean onCommand1(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("end")) {
            if (sender instanceof Player) {
                for (Player pls : Bukkit.getOnlinePlayers()) {

                    if (infected.contains(pls.getUniqueId())) {

                        infected.remove(pls.getName());
                        pls.setPlayerListName(pls.getName());
                        Bukkit.getServer().broadcastMessage(ChatColor.RED + "Game has been stopped.");

                    }
                }
            }
        }
        return false;
    }

    public boolean onCommand3(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("basic")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (infected.contains(player.getUniqueId())){
                    player.sendMessage(ChatColor.RED + "You can not claim a kit while infected.");
                } else {
                    final Inventory inventory = player.getInventory();

                    inventory.addItem(new ItemStack(Material.WOODEN_SWORD, 1));
                }
            }
        }
        return false;
    }

    public boolean onCommand2(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("basic")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                    if (infected.contains(player.getUniqueId())) {
                        player.sendMessage("You may not claim a kit while you're infected.");
                    }
            }
        }
        return false;
    }

    @EventHandler
    public void onHit (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();
            if (infected.contains(whoHit.getUniqueId())) {
                infected.add(whoWasHit.getName());
                whoWasHit.sendMessage(ChatColor.GREEN + "You were infected!");
                whoWasHit.setPlayerListName(ChatColor.GREEN + whoWasHit.getName());
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Player " + whoWasHit + " has been infected.");
            } else {
                whoHit.sendMessage(ChatColor.RED + "You may not damage your team.");
                e.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void allInfection(){
        for (Player ples : Bukkit.getOnlinePlayers()) {
            if (infected.contains(ples.getUniqueId())) {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Everyone has died to the infected.");
                infected.remove(ples.getName());
            }
        }
    }

    @EventHandler
    public void infectedChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if (infected.contains(player.getUniqueId())) {
            event.setMessage("infected " + player + event.getMessage());
        } else
            event.setMessage("survivor " + player + event.getMessage());
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