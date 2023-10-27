package com.mixpixel;

import com.mixpixel.configs.ConfigData;
import com.mixpixel.configs.Souvenirs;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SouvenirManagement extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Souvenir Management£¬Æô¶¯£¡");
        Bukkit.getPluginCommand("SouvenirManagement").setExecutor(new smgmtCommand());
        // Plugin startup logic
        saveDefaultConfig();
        loadConfigs();
    }

    @Override
    public void onDisable() {
        System.out.println("""
        Souvenir Management£¬Æô¶¯^-1£¡
        Build 13
        """);
        // Plugin shutdown logic
    }
    public void loadConfigs(){
        for(String str : getConfig().getKeys(false)){
            ConfigData.souvenirsList.add(new Souvenirs(str, getConfig().getInt(str+".Id"), getConfig().getString(str+".Header"), getConfig().getInt(str+".Current")));
        }
    }
}
