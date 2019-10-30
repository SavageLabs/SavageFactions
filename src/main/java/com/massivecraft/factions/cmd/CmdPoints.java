package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdPoints extends FCommand{

    public CmdPoints() {
        super();

        this.aliases.add("points");

        this.addSubCommand(new CmdPointsGive());
        this.addSubCommand(new CmdPointsTake());
        this.addSubCommand(new CmdPointsBalance());

        this.requirements = new CommandRequirements.Builder(Permission.POINTS).build();

    }

    @Override
    public void perform(CommandContext context) {
        context.commandChain.add(this);
        SavageFactions.plugin.cmdAutoHelp.execute(context);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_POINTS_DESCRIPTION;
    }


}
