package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.fm.enums.TL;

public class CmdAutoClaim extends FCommand {

    public CmdAutoClaim() {
        super();
        this.aliases.add("autoclaim");

        //this.requiredArgs.add("");
        this.optionalArgs.put("faction", "your");

        this.permission = Permission.AUTOCLAIM.node;
        this.disableOnLock = true;

        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        Faction forFaction = this.argAsFaction(0, myFaction);
        if (forFaction == null || forFaction == fme.getAutoClaimFor()) {
            fme.setAutoClaimFor(null);
            msg(TL.AUTOCLAIM_DISABLED);
            return;
        }

        if (!fme.canClaimForFaction(forFaction)) {
            if (myFaction == forFaction) {
                msg(TL.AUTOCLAIM_REQUIRED_RANK, Role.MODERATOR.getTranslation());
            } else {
                msg(TL.AUTOCLAIM_DENY_OTHER_FACTION, forFaction.describeTo(fme));
            }

            return;
        }

        fme.setAutoClaimFor(forFaction);

        msg(TL.AUTOCLAIM_ENABLE, forFaction.describeTo(fme));
        fme.attemptClaim(forFaction, me.getLocation(), true);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.CMD_ADMIN_DESCRIPTION;
    }
}