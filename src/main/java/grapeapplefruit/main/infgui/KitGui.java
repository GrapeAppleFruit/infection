package grapeapplefruit.main.infgui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KitGui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("kitgui")) {

                Inventory gui = Bukkit.getServer().createInventory(p, 9, "Infection Kits");

                ItemStack ref1 = new ItemStack(Material.WOODEN_SWORD);
                ItemStack ref2 = new ItemStack(Material.STONE_SWORD);

                ItemMeta metaref2 = ref2.getItemMeta();
                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore2 = new ArrayList<>();
                ArrayList<String> lore = new ArrayList<String>();


                metaref1.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                metaref2.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);


                ref1.setItemMeta(metaref1);
                ref2.setItemMeta(metaref2);


                lore.add("Basic");
                lore.add("");
                lore2.add("Stone");
                lore2.add("");


                metaref1.setLore(lore);
                metaref1.setDisplayName("Get the basic kit.");
                metaref2.setLore(lore2);
                metaref2.setDisplayName("Get the stone kit..");


                ref1.setItemMeta(metaref1);
                ref2.setItemMeta(metaref2);
                gui.setItem(1, ref1);
                gui.setItem(2, ref2);


                p.openInventory(gui);


            }
        }
        return false;
    }
}
