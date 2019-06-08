package com.massivecraft.factions.zcore.ffly.flyparticledata;


import com.massivecraft.factions.util.Particles.Particles;
import com.massivecraft.factions.zcore.persist.serializable.Item;
import org.bukkit.Location;


public abstract class FlyParticleData {

    private String name;
    private Item item;
    private transient Particles particleEffect;


    public FlyParticleData(String name, Item item, Particles particleEffect) {
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

    public Particles getParticleEffect() {
        return particleEffect;
    }
}
