package dev.oglis22.vorzeigeplugin.listeners;

import dev.oglis22.vorzeigeplugin.gui.JavaGUI;
import dev.oglis22.vorzeigeplugin.utils.Config;
import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {

    @EventHandler
    public void onInvInteract(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        if(event.getCurrentItem() == null) return;
        if(event.getInventory().equals(JavaGUI.inventory)){
            Player player = (Player) event.getWhoClicked();
            String warpname = event.getCurrentItem().getItemMeta().getDisplayName();
            player.teleport(FileManager.getWarp(player.getUniqueId(), warpname ,player));
            String message = Config.fileConfiguration.getString("WarpTeleportMessage").replaceAll("%Warp%", warpname);
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + message);
            event.setCancelled(true);
        }
    }
}
