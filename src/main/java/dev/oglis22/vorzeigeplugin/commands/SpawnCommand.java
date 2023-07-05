package dev.oglis22.vorzeigeplugin.commands;

import dev.oglis22.vorzeigeplugin.utils.Config;
import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if(args.length != 0){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("WrongSyntaxSpawn"));
            return true;
        }
        if(FileManager.getSpawn() == null){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("NoSpawnSet"));
            return true;
        }
        player.teleport(FileManager.getSpawn());
        player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("SpawnMessage"));
        return false;
    }
}
