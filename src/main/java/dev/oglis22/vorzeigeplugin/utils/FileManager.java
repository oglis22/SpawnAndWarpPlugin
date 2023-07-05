package dev.oglis22.vorzeigeplugin.utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileManager {

    public static File Spawn = new File("plugins/VorzeigePlugin/data/spawn.yml");
    public static FileConfiguration Spawncfg = YamlConfiguration.loadConfiguration(Spawn);

    public static File Warps = new File("plugins/VorzeigePlugin/data/" + "warps.yml");
    public static FileConfiguration Warpscfg = YamlConfiguration.loadConfiguration(Warps);

    public static void setSpawn(Location location){
        Spawncfg.set("loc", location);
        try{
            Spawncfg.save(Spawn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Location getSpawn(){
        if(Spawncfg.get("loc") == null){
            return null;
        }
        return Spawncfg.getLocation("loc");
    }

    public static void setWarp(Location location, UUID uuid, String name, Player player) throws IOException {

        if(FileManager.getCountOfWarps() >= 8){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("MaxWarp"));
            return;
        }

        Warpscfg.set(name, location);
        Warpscfg.save(Warps);
        String message = Config.fileConfiguration.getString("SetWarp").replaceAll("%Warp%", name);
        player.sendMessage(Config.fileConfiguration.getString("Prefix") + message);

    }
    public static Location getWarp(UUID uuid, String name, Player player){
        if(Warpscfg.get(name) == null){
            return null; // SICHER IST SICHER
        }
        return Warpscfg.getLocation(name);
    }

    public static void removeWarp(UUID uuid, String name, Player player) throws IOException {
        if(Warpscfg.get(name) == null){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("NoWarpFound"));
            return;
        }
        Warpscfg.set(name, null);
        Warpscfg.save(Warps);
        String message = Config.fileConfiguration.getString("DeleteWarp").replaceAll("%Warp%", name);
        player.sendMessage(Config.fileConfiguration.getString("Prefix") + message);

    }

    public static List<Location> getAllWarps() {
        List<Location> warps = new ArrayList<>();
        for (String warpName : Warpscfg.getKeys(false)) {
            Location warpLocation = Warpscfg.getLocation(warpName);
            if (Warpscfg.get(warpName) != null) {
                warps.add(warpLocation);
            }
        }
        return warps;
    }

    public static List<String> getNameofWarps() {
        List<String> warps = new ArrayList<>();
        for (String warpName : Warpscfg.getKeys(false)) {
            if (Warpscfg.get(warpName) != null) {
                warps.add(warpName);
            }
        }
        return warps;
    }

    public static Integer getCountOfWarps(){
        int count = 1;
        for(String warpname : Warpscfg.getKeys(false)){
            Location warpLocation = Warpscfg.getLocation(warpname);
            if(Warpscfg.get(warpname) != null){
                count++;
            }
        }
        return count;
    }
}
