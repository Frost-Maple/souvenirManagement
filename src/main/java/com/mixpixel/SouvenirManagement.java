package com.mixpixel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SouvenirManagement extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Souvenir Management£¬Æô¶¯£¡");
        Bukkit.getPluginCommand("SouvenirManagement").setExecutor(new smgmtCommand());
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        System.out.println("""
        Souvenir Management£¬Æô¶¯^-1£¡
        Build 7
        """);
        // Plugin shutdown logic
    }
}
