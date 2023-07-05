package dev.oglis22.vorzeigeplugin.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static File file = new File("plugins/VorzeigePlugin/config.yml");
    public static FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);

    public static void createDefaultConfig(){
        if(file.exists()){
            return;
        }
        fileConfiguration.set("Prefix", "§aOglisSpawn §7• §c");
        fileConfiguration.set("JoinMessage", "§aWhooah ein wildes %player% is auf den Server gekommen!");
        fileConfiguration.set("SpawnMessage", "Du wurdest zum Spawn teleportiert!");
        fileConfiguration.set("SetSpawnMessage", "Der Spawn wurde gesetzt!");
        fileConfiguration.set("WarpTeleportMessage", "Du wurdest zum Warp %Warp% teleportiert");
        fileConfiguration.set("ToMuchWarps", "Du hast leider schon die maximal Anzahl an Warps verbraucht.");
        fileConfiguration.set("WrongSyntaxWarp", "Bitte Benutzte /warp");
        fileConfiguration.set("WrongSyntaxSetWarp", "Bitte Benutzte /setwarp");
        fileConfiguration.set("WrongSyntaxSpawn", "Bitte benutzte /spawn");
        fileConfiguration.set("WrongSyntaxSetSpawn", "Bitte benutzte /setspawn");
        fileConfiguration.set("NoSpawnSet", "Es wurde noch kein Spawn gesetzt!");
        fileConfiguration.set("MaxWarp", "Maximale Anzahl an Warps wurden erreicht!");
        fileConfiguration.set("NoExistingWarp", "Dein Warp wurde nicht gefunden");
        fileConfiguration.set("MaxLengthWarp", "Dein Warp Name darf Maximal 8 Zeichen lang sein!");
        fileConfiguration.set("NoWarpFound", "Es wurde kein Warp gefunden!");
        fileConfiguration.set("SetWarp", "Der Warp %Warp% wurde gesetzt!");
        fileConfiguration.set("DeleteWarp", "Der Warp %Warp% wurde erfolgreich gelöscht!");
        fileConfiguration.set("noperms", "Keine Rechte!");

        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
