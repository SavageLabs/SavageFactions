package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdAlts extends FCommand {


    public CmdKickAlt cmdKickAlt = new CmdKickAlt();
    public CmdInviteAlt cmdInviteAlt = new CmdInviteAlt();
    public CmdAltsList cmdAltsList = new CmdAltsList();


    public CmdAlts(){
        super();

        this.aliases.add("alts");
        this.aliases.add("alt");

        this.addSubCommand(this.cmdInviteAlt);
        this.addSubCommand(this.cmdKickAlt);
        this.addSubCommand(this.cmdAltsList);

        this.requirements = new CommandRequirements.Builder(Permission.ALTS)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (!Conf.enableFactionAlts) {
            context.msg(TL.GENERIC_DISABLED);
            return;
        }

        context.commandChain.add(this);
        SavageFactions.plugin.cmdAutoHelp.execute(context);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_ALTS_DESCRIPTION;
    }

}

