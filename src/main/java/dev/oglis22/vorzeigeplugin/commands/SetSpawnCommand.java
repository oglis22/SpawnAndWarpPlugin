package dev.oglis22.vorzeigeplugin.commands;

import dev.oglis22.vorzeigeplugin.utils.Config;
import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if(!player.hasPermission("oglisspawn.setspawn")){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("noperms"));
            return true;
        }
        if(args.length != 0){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("WrongSyntaxSetSpawn"));
            return true;
        }
        FileManager.setSpawn(player.getLocation());
        player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("SetSpawnMessage"));

        return false;
    }
}
