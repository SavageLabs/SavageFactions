package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.ffly.ParticleGUI;
import com.massivecraft.factions.zcore.util.TL;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdParticle extends FCommand {


    public CmdParticle() {
        super();
        this.aliases.add("particle");

        this.requirements = new CommandRequirements.Builder(Permission.PARTICLE)
                .playerOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        new ParticleGUI(SavageFactions.plugin, Conf.particleGUITitle, 5).buildGUI(context.fPlayer);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_PARTICLE_NO_SELECTED_PARTICLE;
    }
}
