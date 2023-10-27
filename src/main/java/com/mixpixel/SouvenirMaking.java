package com.mixpixel;

import com.mixpixel.configs.ConfigData;
import com.mixpixel.configs.Souvenirs;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

public class SouvenirMaking {
    public static ItemStack craft(String name){
        Optional <Souvenirs> souvenir = ConfigData.souvenirsList.stream().filter(souvenirs -> souvenirs.name().equals(name)).findFirst();
        if (souvenir.isEmpty())throw new RuntimeException("指定了config中未指明的地图Id！");

        Souvenirs souvenirs = souvenir.get();
        int Id = souvenirs.id();
        ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
        ItemMeta itemMeta = itemStack.getItemMeta();
        MapMeta mapMeta = (MapMeta) itemMeta;
        MapView mapView0 = Bukkit.getMap(Id);

        ConfigData.attached = souvenirs.header()+souvenirs.current();


        if (mapView0 == null) {
            throw new RuntimeException("指定的地图不存在。");
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
