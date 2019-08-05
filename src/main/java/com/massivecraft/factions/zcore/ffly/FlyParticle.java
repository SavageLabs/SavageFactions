package com.massivecraft.factions.zcore.ffly;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.zcore.ffly.flyparticledata.FlyParticleData;

public enum FlyParticle {

    WHITE_CLOUD,
    ORANGE_CLOUD,
    GREEN_CLOUD,
    BLUE_CLOUD,
    BLACK_CLOUD,
    YELLOW_CLOUD,
    PURPLE_CLOUD,
    PINK_CLOUD,
    RED_CLOUD;
//    FLAME_RING,
//    ROTATING_SPHERE,
//    PENTAGON_RING,
//    HEXAGON_RING;

    public FlyParticleData getData() {
        return Conf.particleEffectSettings.get(this);
    }
}