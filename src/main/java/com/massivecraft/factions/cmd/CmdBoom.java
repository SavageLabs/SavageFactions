package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.enums.TL;

public class CmdBoom extends FCommand {

    public CmdBoom() {
        super();
        this.aliases.add("noboom");
        this.aliases.add("explosions");
        this.aliases.add("toggleexplosions");

        //this.requiredArgs.add("");
        this.optionalArgs.put("on/off", "flip");

        this.permission = Permission.NO_BOOM.node;
        this.disableOnLock = true;

        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = true;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        if (!myFaction.isPeaceful()) {
            fme.msg(TL.CMD_PEACEFUL_ONLY.toString());
            return;
        }

        // if economy is enabled, they're not on the bypass list, and this command has a cost set, make 'em pay
        if (!payForCommand(Conf.econCostNoBoom, TL.COMMAND_BOOM_TOTOGGLE, TL.COMMAND_BOOM_FORTOGGLE)) {
            return;
        }

        myFaction.setPeacefulExplosionsEnabled(this.argAsBool(0, !myFaction.getPeacefulExplosionsEnabled()));

        String enabled = myFaction.noExplosionsInTerritory() ? TL.GENERIC_DISABLED.toString() : TL.GENERIC_ENABLED.toString();

        // Inform
        myFaction.msg(TL.CMD_BOOM_ENABLED.toString(), fme.describeTo(myFaction), enabled);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_BOOM_DESCRIPTION;
    }
}
