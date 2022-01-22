package grapeapplefruit.main.infgui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Gui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("infgui")) {

                Inventory gui = Bukkit.getServer().createInventory(p, 9, "Infection");

                ItemStack ref1 = new ItemStack(Material.BOOK);
                ItemStack ref2 = new ItemStack(Material.GREEN_WOOL);
                ItemStack ref3 = new ItemStack(Material.RED_WOOL);

                ItemMeta metaref2 = ref2.getItemMeta();
                ItemMeta metaref1 = ref1.getItemMeta();
                ItemMeta metaref3 = ref3.getItemMeta();
                ArrayList<String> lore2 = new ArrayList<>();
                ArrayList<String> lore3 = new ArrayList<>();
                ArrayList<String> lore = new ArrayList<String>();


                metaref1.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                metaref2.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);


                ref1.setItemMeta(metaref1);
                ref2.setItemMeta(metaref2);
                ref3.setItemMeta(metaref3);


                lore.add("Help");
                lore.add("");
                lore2.add("Start");
                lore2.add("");
                lore3.add("End");
                lore3.add("");


                metaref1.setLore(lore);
                metaref1.setDisplayName("Get help here!");
                metaref2.setLore(lore2);
                metaref2.setDisplayName("Start the game.");
                metaref3.setLore(lore3);
                metaref3.setDisplayName("End the game.");


                ref1.setItemMeta(metaref1);
                ref2.setItemMeta(metaref2);
                ref3.setItemMeta(metaref3);
                gui.setItem(2, ref1);
                gui.setItem(5, ref2);
                gui.setItem(8, ref3);


                p.openInventory(gui);


            }
        }
        return false;
    }
}

