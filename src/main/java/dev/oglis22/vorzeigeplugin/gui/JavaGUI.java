package dev.oglis22.vorzeigeplugin.gui;

import dev.oglis22.vorzeigeplugin.utils.FileManager;
import dev.oglis22.vorzeigeplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;;

public class JavaGUI {
    public static Inventory inventory = Bukkit.createInventory(null, 9, "§c§lOGLIS-WARPS");;
    public static void createAndOpenGUI(Player player){
        inventory.clear();
        player.openInventory(inventory);
        int i = 1;
            List<Location> warps = new ArrayList<>();
            for (String warpName : FileManager.Warpscfg.getKeys(false)) {
                Location warpLocation = FileManager.Warpscfg.getLocation(warpName);
                if (warpLocation != null) {
                    List<String> list = new ArrayList<>();
                    list.add(" ");
                    list.add("X: " + warpLocation.getX());
                    list.add("Y: " + warpLocation.getY());
                    list.add("z: " + warpLocation.getZ());
                    list.add(" ");
                    inventory.setItem(i, new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname(warpName).setLore(list).build());
                    i++;
                }
            }
    }
}
