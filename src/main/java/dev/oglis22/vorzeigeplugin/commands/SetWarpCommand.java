package dev.oglis22.vorzeigeplugin.commands;

import dev.oglis22.vorzeigeplugin.utils.Config;
import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class SetWarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if(!player.hasPermission("oglisspawn.setwarp")){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("noperms"));
            return true;
        }
        if(args.length != 1){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("WrongSyntaxSetWarp"));
            return true;
        }
        if(args[0].length() >= 9){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("MaxLengthWarp"));
            return true;
        }
        try {
            FileManager.setWarp(player.getLocation(), player.getUniqueId(), args[0], player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
