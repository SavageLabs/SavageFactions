package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdPointsGive extends FCommand {

    public CmdPointsGive() {
        super();

        this.aliases.add("give");
        this.requiredArgs.add("recipient");
        this.requiredArgs.add("amount");

        this.requirements = new CommandRequirements.Builder(Permission.POINTS).build();
    }



    @Override
    public void perform(CommandContext context) {
        Faction targetFaction = context.argAsFaction(0);
        // Warns on its own when getting as faction.
        if (targetFaction == null) {
            return;
        }

        // Defaults to 1.
        int amount = context.argAsInt(1, 1);
        targetFaction.givePoints(amount);
        context.msg(TL.COMMAND_POINTS_GIVEN, amount, targetFaction.getTag());

    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_POINTS_GIVE;
    }
}
