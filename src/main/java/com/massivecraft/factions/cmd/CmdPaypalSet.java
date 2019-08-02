package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdPaypalSet extends FCommand {

    public CmdPaypalSet() {
        this.aliases.add("setpaypal");
        this.requiredArgs.add("email");

        this.requirements = new CommandRequirements.Builder(Permission.PAYPALSET)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (!SavageFactions.plugin.getConfig().getBoolean("fpaypal.Enabled")) {
            context.msg(TL.GENERIC_DISABLED);
            return;
        }

        String paypal = context.argAsString(0);
        if (paypal == null)
            return;
        context.faction.paypalSet(paypal);
        context.msg(TL.COMMAND_PAYPALSET_SUCCESSFUL, paypal);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_PAYPALSET_DESCRIPTION;
    }
}

