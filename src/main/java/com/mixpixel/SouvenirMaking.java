package com.mixpixel;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.logging.Logger;

public class SouvenirMaking {
    public static ItemStack craft(){
        ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
        ItemMeta itemMeta = itemStack.getItemMeta();
        MapMeta mapMeta = (MapMeta) itemMeta;
        MapView mapView0 = Bukkit.getMap(1052); // ��������Souvenirʱ��Ӧ���ĳɴ�Config�л�ȡ��
        if (mapView0 == null) {
            throw new RuntimeException("ָ���ĵ�ͼ�����ڡ�");
        }
        MapView mapView = Bukkit.createMap(Bukkit.getWorld("World"));
        for (MapRenderer mapRenderer: mapView0.getRenderers()) mapView.addRenderer(mapRenderer);
        mapView.addRenderer(new mapRenderer());
        mapView.setLocked(true);
        mapMeta.setMapView(mapView);
        itemStack.setItemMeta(mapMeta);
        return itemStack;
    }
}
