package grapeapplefruit.main.infgui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitGuiListener implements Listener {
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals("Infection Kits")) {

            e.setCancelled(true);

            switch (e.getSlot()) {

                case 1:
                    player.chat("/basic");

                    player.closeInventory();
                    break;

                case 2:
                    player.chat("/stone");

                    player.closeInventory();
                    break;
            }
        }
    }
}
