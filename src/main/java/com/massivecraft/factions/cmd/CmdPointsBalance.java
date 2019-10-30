package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdPointsBalance extends FCommand {

    public CmdPointsBalance() {
        super();


        this.aliases.add("balance");

        this.requiredArgs.add("target");


        this.requirements = new CommandRequirements.Builder(Permission.POINTS).build();
    }



    @Override
    public void perform(CommandContext context) {
        Faction targetFaction = context.argAsFaction(0);
        // Warns on its own when getting as faction.
        if (targetFaction == null) {
            return;
        }

        context.msg(TL.COMMAND_POINTS_FACTIONBALANCE, targetFaction.getTag(), targetFaction.getPoints());

    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_POINTS_BALANCE;
    }
}
