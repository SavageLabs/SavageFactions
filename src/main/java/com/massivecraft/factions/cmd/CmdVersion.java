package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdVersion extends FCommand {

    public CmdVersion() {
        this.aliases.add("version");
        this.aliases.add("ver");

        this.requirements = new CommandRequirements.Builder(Permission.VERSION)
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        context.msg(TL.COMMAND_VERSION_NAME); // Did this so people can differentiate between SavageFactions and FactionsUUID (( Requested Feature ))
        context.msg(TL.COMMAND_VERSION_VERSION, SavageFactions.plugin.getDescription().getFullName());
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_VERSION_DESCRIPTION;
    }
}
