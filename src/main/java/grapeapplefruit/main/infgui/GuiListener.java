package grapeapplefruit.main.infgui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiListener implements Listener {
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals("Infection")) {

            e.setCancelled(true);

            switch (e.getSlot()) {

                case 8:
                    player.chat("/end");

                    player.closeInventory();
                    break;

                case 4:
                    player.chat("/start");

                    player.closeInventory();
                    break;

                case 2:

                    player.chat("/help");

                    player.closeInventory();
                    break;
            }
        }
    }
}
