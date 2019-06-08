package com.massivecraft.factions.zcore.ffly.flyparticledata;

import com.massivecraft.factions.util.Particles.ParticleEffect;
import com.massivecraft.factions.util.Particles.Particles;
import com.massivecraft.factions.zcore.persist.serializable.Item;
import org.bukkit.Location;

public class ColoredHalo extends FlyParticleData {

    private transient ParticleEffect.OrdinaryColor color;

    public ColoredHalo(String name, Item item, Particles particleEffect, ParticleEffect.OrdinaryColor color) {
        super(name, item, particleEffect);
        this.color = color;
    }

    @Override
    public void display(Location origin) {
        drawCircle(origin, 2);
    }

    private void drawCircle(Location center, int radius) {
        int x, y, r2;
        r2 = radius * radius;
        for (x = -radius; x <= radius; x++) {
            y = (int) (Math.sqrt(r2 - x*x) + 0.5);
            Particles.CLOUD.displayAtLocation(center.add(x, 0, y), 1, color);
        }

    }


}
