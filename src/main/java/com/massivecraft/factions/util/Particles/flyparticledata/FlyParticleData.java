package com.massivecraft.factions.util.Particles.flyparticledata;

import com.massivecraft.factions.util.Particles.ParticleEffect;
import com.massivecraft.factions.zcore.persist.serializable.Item;
import org.bukkit.Location;

public abstract class FlyParticleData {

    private String name;
    private Item item;
    private transient ParticleEffect particleEffect;

    public FlyParticleData(String name, Item item, ParticleEffect particleEffect) {
        this.name = name;
        this.item = item;
        this.particleEffect = particleEffect;
    }

    public abstract void display(Location origin);

    public String getName() {
        return name;
    }

    public Item getItem() {
        return item;
    }

    public ParticleEffect getParticleEffect() {
        return particleEffect;
    }
}
