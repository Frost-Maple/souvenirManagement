package com.mixpixel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class smgmtCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("""
                OldCake 插件帮助
                OldCake 插件指令
                """);
            return true;
        }
        else if (args[0].equalsIgnoreCase("getMap")) {
            if (sender instanceof Player player) {
                player.getWorld().dropItemNaturally(player.getLocation(), SouvenirMaking.craft());
            }
        }
        return false;
    }
}
