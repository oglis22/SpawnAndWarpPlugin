package dev.oglis22.vorzeigeplugin.listeners;

import dev.oglis22.vorzeigeplugin.utils.Config;
import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String message = Config.fileConfiguration.getString("JoinMessage").replaceAll("%player%", event.getPlayer().getName());
        event.setJoinMessage(Config.fileConfiguration.getString("Prefix") + message);
        if(FileManager.getSpawn() == null){
            event.getPlayer().sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("NoSpawnSet"));
            return;
        }
        event.getPlayer().teleport(FileManager.getSpawn());
    }
}
