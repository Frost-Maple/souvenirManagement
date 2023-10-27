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
                S. Mgmt �������
                S. Mgmt ���ָ��
                """);
            return true;
        }
        else if (args[0].equalsIgnoreCase("check")) {
            if (sender instanceof Player player) {
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                if (check(itemStack)== -1){
                    player.sendMessage("������Ʒ��Ч��");
                    return false;
                }
                else if (check(itemStack)==-2){
                    player.sendMessage("���ֵ�ͼ����δ֪����");
                }
                sender.sendMessage("��ǰ��ͼIdΪ��"+ check(itemStack));
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
        try{
            MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();
            if (!mapMeta.hasMapId())return -2;
            return mapMeta.getMapId();
        }
        catch (Exception e){
            return -1;
        }
    }
}
