package com.mixpixel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.jetbrains.annotations.NotNull;

public class smgmtCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("""
                S. Mgmt 插件帮助
                S. Mgmt 插件指令
                """);
            return true;
        }
        else if (args[0].equalsIgnoreCase("check")) {
            if (sender instanceof Player player) {
                ItemStack itemStack = player.getItemOnCursor();
                if (check(itemStack)== -1){
                    return false;
                }
                sender.sendMessage("当前地图Id为："+Integer.toString(check(itemStack)));
            }
        }
        else if (args[0].equalsIgnoreCase("getMap")) {
            if (sender instanceof Player player) {
                player.getWorld().dropItemNaturally(player.getLocation(), SouvenirMaking.craft());
            }
        }
        return false;
    }
    private int check(ItemStack itemStack){
        if (itemStack == null) return -1;
        MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();
        if (!mapMeta.hasMapId())return -2;
        return mapMeta.getMapId();
    }
}
