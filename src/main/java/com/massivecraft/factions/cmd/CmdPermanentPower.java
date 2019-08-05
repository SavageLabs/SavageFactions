package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.enums.TL;

public class CmdPermanentPower extends FCommand {
    public CmdPermanentPower() {
        super();
        this.aliases.add("permanentpower");

        this.requiredArgs.add("faction");
        this.requiredArgs.add("power");

        this.permission = Permission.SET_PERMANENTPOWER.node;
        this.disableOnLock = true;

        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        Faction targetFaction = this.argAsFaction(0);
        if (targetFaction == null) {
            return;
        }

        Integer targetPower = this.argAsInt(1);

        targetFaction.setPermanentPower(targetPower);

        String change = TL.CMD_FPERMN_REVOKE.toString();
        if (targetFaction.hasPermanentPower()) {
            change = TL.CMD_FPERMN_GRANT.toString();
        }

        // Inform sender
        msg(TL.CMD_FPERMN_YOURS, change, targetFaction.describeTo(fme));

        // Inform all other players
        for (FPlayer fplayer : targetFaction.getFPlayersWhereOnline(true)) {
            if (fplayer == fme) {
                continue;
            }
            String blame = (fme == null ? TL.GENERIC_SERVER_ADMIN.toString() : fme.describeTo(fplayer, true));
            fplayer.msg(TL.CMD_FPERMN_OTHER, blame, change);
        }
    }

    @Override
    public TL getUsageTranslation() {
        return TL.CMD_FPERMN_DESCRIPTION;
    }
}