package com.mixpixel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SouvenirManagement extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Souvenir Management��������");
        Bukkit.getPluginCommand("SouvenirManagement").setExecutor(new smgmtCommand());
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        System.out.println("""
        Souvenir Management������^-1��
        Build 8
        """);
        // Plugin shutdown logic
    }
}
