package com.mixpixel;

import com.mixpixel.configs.ConfigData;
import org.bukkit.entity.Player;
import org.bukkit.map.*;
import org.jetbrains.annotations.NotNull;

public class mapRenderer extends MapRenderer {
    @Override
    public void render(@NotNull MapView map, @NotNull MapCanvas canvas, @NotNull Player player) {
        //for(int i = 0; i < 128; i++) for(int j = 0; j < 128; j++) canvas.setPixel(i,j, (byte) 0x20);
        String s = ConfigData.attached;
        canvas.drawText(64,110,new MinecraftFont(), s);
    }
}
