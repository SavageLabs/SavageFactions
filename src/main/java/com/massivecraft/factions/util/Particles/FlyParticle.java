package com.massivecraft.factions.util.Particles;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.util.Particles.flyparticledata.FlyParticleData;

public enum FlyParticle {

    /*
     * All clouds are free.
     * Maybe write a backend & minishop, to let people get purchase some particle effects or something ( Optifine Cape like concept )
     */

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
