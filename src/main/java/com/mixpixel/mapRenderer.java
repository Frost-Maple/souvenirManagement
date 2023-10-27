package com.mixpixel;

import org.bukkit.entity.Player;
import org.bukkit.map.*;
import org.jetbrains.annotations.NotNull;

public class mapRenderer extends MapRenderer {
    @Override
    public void render(@NotNull MapView map, @NotNull MapCanvas canvas, @NotNull Player player) {
        for(int i = 0; i < 128; i++) for(int j = 0; j < 128; j++) canvas.setPixel(i,j, (byte) 0x20);
        canvas.drawText(0,10, new MinecraftFont(), """
                Hello!
                This is MixPixel's Newest
                Lore-Friendly Mapping
                Souvenir System Testing
                to Generate a New Map""");
        canvas.drawText(64,64,new MinecraftFont(), """
                M P - H C 1 1 4 5
                """);
    }
}
