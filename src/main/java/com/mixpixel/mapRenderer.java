package com.mixpixel;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.map.*;
import org.jetbrains.annotations.NotNull;

public class mapRenderer extends MapRenderer {
    private final FileConfiguration config = SouvenirManagement.getPlugin(SouvenirManagement.class).getConfig();
    @Override
    public void render(@NotNull MapView map, @NotNull MapCanvas canvas, @NotNull Player player) {
        //for(int i = 0; i < 128; i++) for(int j = 0; j < 128; j++) canvas.setPixel(i,j, (byte) 0x20);
        String s = config.getString("");
        canvas.drawText(64,110,new MinecraftFont(), "MP-000008");
    }
}
