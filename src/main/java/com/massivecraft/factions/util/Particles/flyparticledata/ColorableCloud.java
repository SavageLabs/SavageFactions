package com.massivecraft.factions.util.Particles.flyparticledata;

import com.massivecraft.factions.util.Particles.ParticleEffect;
import com.massivecraft.factions.zcore.persist.serializable.Item;
import org.bukkit.Location;

public class ColorableCloud extends FlyParticleData {

    private transient ParticleEffect.OrdinaryColor color;

    public ColorableCloud(String name, Item item, ParticleEffect particleEffect, ParticleEffect.OrdinaryColor color) {
        super(name, item, particleEffect);
        this.color = color;
    }

    @Override
    public void display(Location origin) {
        // TODO: Make it display lol.
    }
}
