package dev.oglis22.vorzeigeplugin.commands;

import dev.oglis22.vorzeigeplugin.utils.Config;
import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class RemoveWarpCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if(!player.hasPermission("oglisspawn.removewarp")){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("noperms"));
            return true;
        }
        if(args.length != 1){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("NoWarpFound"));
            return true;
        }
        try {
            FileManager.removeWarp(player.getUniqueId(), args[0], player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(args.length == 1){
            return FileManager.getNameofWarps();
        }
        return null;
    }
}
