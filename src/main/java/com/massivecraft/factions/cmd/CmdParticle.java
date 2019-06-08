package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.ffly.ParticleGUI;
import com.massivecraft.factions.zcore.util.TL;

public class CmdParticle extends FCommand {


   public CmdParticle() {
      super();
      this.aliases.add("particle");

      //this.requiredArgs.add("");
      //this.optionalArgs.put("", "");

      this.permission = Permission.PARTICLE.node;
      this.disableOnLock = false;


      senderMustBePlayer = true;
      senderMustBeMember = false;
      senderMustBeModerator = false;
      senderMustBeColeader = false;
      senderMustBeAdmin = false;
   }


   @Override
   public TL getUsageTranslation() {
      return TL.COMMAND_PARTICLE_NO_SELECTED_PARTICLE;
   }

   @Override
   public void perform() {
       new ParticleGUI(SavageFactions.plugin, "&cChoose a Particle! &o(Patreon)", 5).buildGUI(fme);
   }
}
