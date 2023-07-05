package dev.oglis22.vorzeigeplugin;

import dev.oglis22.vorzeigeplugin.commands.*;
import dev.oglis22.vorzeigeplugin.listeners.ClickEvent;
import dev.oglis22.vorzeigeplugin.listeners.PlayerHandler;
import dev.oglis22.vorzeigeplugin.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class VorzeigePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Config.createDefaultConfig();
        register();
    }

    public void register(){

        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setwarp").setExecutor(new SetWarpCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("removewarp").setExecutor(new RemoveWarpCommand());

        getCommand("warp").setTabCompleter(new WarpCommand());

        Bukkit.getPluginManager().registerEvents(new PlayerHandler(), this);
        Bukkit.getPluginManager().registerEvents(new ClickEvent(), this);

    }

    @Override
    public void onDisable() {

    }
}
