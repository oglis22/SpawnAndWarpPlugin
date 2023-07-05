package dev.oglis22.vorzeigeplugin.commands;

import dev.oglis22.vorzeigeplugin.gui.BedrockGUI;
import dev.oglis22.vorzeigeplugin.gui.JavaGUI;
import dev.oglis22.vorzeigeplugin.utils.Config;
import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WarpCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if(args.length == 0){
            if(player.getName().startsWith(".")){
                //BEDROCK PLAYER
                BedrockGUI.createAndOpenGUI(player);
            }else{
                //JAVA PLAYER
                JavaGUI.createAndOpenGUI(player);
            }
            return true;
        }
        if(args.length != 1){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("WrongSyntaxWarp"));
            return true;
        }
        if(FileManager.getWarp(player.getUniqueId(), args[0], player) == null){
            player.sendMessage(Config.fileConfiguration.getString("Prefix") + Config.fileConfiguration.getString("NoWarpFound"));
            return true;
        }
        player.teleport(FileManager.getWarp(player.getUniqueId(), args[0], player));
        String message = Config.fileConfiguration.getString("WarpTeleportMessage").replaceAll("%Warp%", args[0]);
        player.sendMessage(Config.fileConfiguration.getString("Prefix") + message);
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(args.length == 1){
            return FileManager.getNameofWarps();
        }
        return null;
    }
}
