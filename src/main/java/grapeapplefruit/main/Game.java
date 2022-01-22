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

public class Game implements Listener {

    Set<String> inf = InfectionHashSet.infection;

    @EventHandler
    public void onHit (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();
            if (inf.contains(whoHit.getName())) {
                inf.add(whoWasHit.getName());
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
    public void allBeenInfected(){
        for (Player ples : Bukkit.getOnlinePlayers()) {
            if (inf.contains(ples.getUniqueId())) {
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Everyone has died to the infected.");
                inf.remove(ples.getName());
            }
        }
    }


}