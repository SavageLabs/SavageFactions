package com.massivecraft.factions.zcore.ffly.flyparticledata;


import com.massivecraft.factions.util.Particles.Particles;
import com.massivecraft.factions.zcore.persist.serializable.ConfigurableItem;
import org.bukkit.Location;


public abstract class FlyParticleData {

    private String name;
    private ConfigurableItem item;
    private transient Particles particleEffect;


    public FlyParticleData(String name, ConfigurableItem item, Particles particleEffect) {
        this.name = name;
        this.item = item;
        this.particleEffect = particleEffect;
    }

    public abstract void display(Location origin);

    public String getName() {
        return name;
    }

    public ConfigurableItem getItem() {
        return item;
    }

    public Particles getParticleEffect() {
        return particleEffect;
    }
}
