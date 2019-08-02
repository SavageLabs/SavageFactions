package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdPaypalSee extends FCommand {
    public CmdPaypalSee() {
        aliases.add("seepaypal");
        requiredArgs.add("faction");

        this.requirements = new CommandRequirements.Builder(Permission.ADMIN)
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (!SavageFactions.plugin.getConfig().getBoolean("fpaypal.Enabled")) {
            context.msg(TL.GENERIC_DISABLED);
            return;
        }
        Faction faction = context.argAsFaction(0);

        if (faction == null)
            return;

        if (!faction.isWilderness() && !faction.isSafeZone() && !faction.isWarZone()) {
            context.msg(TL.COMMAND_PAYPALSEE_FACTION_NOFACTION.toString(), context.player.getName());
            return;
        }

        if (faction.getPaypal() != null) {
            context.msg(TL.COMMAND_PAYPALSEE_FACTION_PAYPAL.toString(), faction.getTag(), faction.getPaypal());
        } else {
            context.msg(TL.COMMAND_PAYPALSEE_FACTION_NOTSET.toString(), faction.getTag(), faction.getPaypal());
        }
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_PAYPALSEE_DESCRIPTION;
    }
}


