package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.fperms.Permissable;
import com.massivecraft.factions.zcore.util.TL;

public class CmdPointsTake extends FCommand {

    public CmdPointsTake() {
        super();


        this.aliases.add("take");

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

        int amount = context.argAsInt(1,1 );

        targetFaction.takePoints(amount);
        context.msg(TL.COMMAND_POINTS_TOOK, amount, targetFaction.getTag());


    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_POINTS_TAKE;
    }
}
