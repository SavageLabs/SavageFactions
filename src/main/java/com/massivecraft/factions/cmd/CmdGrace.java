package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdGrace extends FCommand {

    public CmdGrace() {
        super();

        this.aliases.add("grace");

        this.permission = Permission.GRACE.node;


        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        Conf.graceEnabled = !Conf.graceEnabled;
        fme.msg(TL.COMMMAND_GRACE_TOGGLED, Conf.graceEnabled ? "Enabled" : "Disabled");
    }


    @Override
    public TL getUsageTranslation() {
        return TL.COMMANd_GRACE_DESCRIPTION;
    }

}
