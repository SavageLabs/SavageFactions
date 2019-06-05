package com.massivecraft.factions.zcore.ffly;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.zcore.ffly.flyparticledata.FlyParticleData;

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
    RED_CLOUD,
    WHITE_HALO,
    ORANGE_HALO,
    GREEN_HALO,
    BLUE_HALO,
    BLACK_HALO,
    YELLOW_HALO,
    PURPLE_HALO,
    PINK_HALO,
    RED_HALO;

//    FLAME_RING,
//    ROTATING_SPHERE,
//    PENTAGON_RING,
//    HEXAGON_RING;

    public FlyParticleData getData() {
        return Conf.particleEffectSettings.get(this);
    }

}
