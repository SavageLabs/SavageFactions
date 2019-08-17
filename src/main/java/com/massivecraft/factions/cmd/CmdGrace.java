package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdGrace extends FCommand {

    public CmdGrace() {
        super();
        this.aliases.add("grace");

        this.requirements = new CommandRequirements.Builder(Permission.GRACE)
                .playerOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        Conf.graceEnabled = !Conf.graceEnabled;
        context.msg(TL.COMMMAND_GRACE_TOGGLED, Conf.graceEnabled ? TL.GENERIC_ENABLED : TL.GENERIC_DISABLED);
    }


    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_GRACE_DESCRIPTION;
    }

}
