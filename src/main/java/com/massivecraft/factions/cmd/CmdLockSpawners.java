package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdLockSpawners extends FCommand {

    public CmdLockSpawners() {
        super();

        this.aliases.add("lockspawners");
        this.aliases.add("spawnerlock");

        this.requirements = new CommandRequirements.Builder(Permission.LOCKSPAWNERS)
                .playerOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        SavageFactions.plugin.spawnersPlacing = !SavageFactions.plugin.spawnersPlacing;
        context.msg(TL.COMMAND_SPAWNERTOGGLE_TOGGLE, SavageFactions.plugin.spawnersPlacing ? SavageFactions.plugin.color("&aEnabled") : SavageFactions.plugin.color("&4Disabled"));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_SPAWNERTOGGLE_DESCRIPTION;
    }

}
