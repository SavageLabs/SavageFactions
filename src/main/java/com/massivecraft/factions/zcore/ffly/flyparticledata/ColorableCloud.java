package com.massivecraft.factions.zcore.ffly.flyparticledata;


import com.massivecraft.factions.util.Particles.ParticleEffect;
import com.massivecraft.factions.util.Particles.Particles;
import com.massivecraft.factions.zcore.persist.serializable.Item;
import org.bukkit.Location;

public class ColorableCloud extends FlyParticleData {

    private transient ParticleEffect.OrdinaryColor color;

    public ColorableCloud(String name, Item item, Particles particleEffect, ParticleEffect.OrdinaryColor color) {
        super(name, item, particleEffect);
        this.color = color;
    }

    @Override
    public void display(Location origin) {
        // Kinda sucky way to do it, but the ParticleEffect API just wont let me do offsets WITH colors :/.
        getParticleEffect().displayAtLocation(origin.add(0.1, 0, 0), 1, color);
        getParticleEffect().displayAtLocation(origin.add(0, 0, 0.1), 1, color);
        getParticleEffect().displayAtLocation(origin, 1, color);
        getParticleEffect().displayAtLocation(origin.add(0.1, 0, 0.1), 1, color);
        getParticleEffect().displayAtLocation(origin.add(-0.1, 0, -0.1), 1, color);
    }
}
