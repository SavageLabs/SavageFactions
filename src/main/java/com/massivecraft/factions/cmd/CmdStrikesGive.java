package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.enums.TL;

public class CmdStrikesGive extends FCommand {


    public CmdStrikesGive() {
        super();
        this.aliases.add("give");
        this.permission = Permission.STRIKES.node;

        this.requiredArgs.add(0, "faction");

        this.disableOnLock = true;

        this.senderMustBePlayer = true;
        this.senderMustBeMember = false;
        this.senderMustBeModerator = false;
        this.senderMustBeColeader = false;
        this.senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        Faction target = argAsFaction(0);
        if (target == null || target.isSystemFaction()) {
            fme.msg(TL.COMMAND_STRIKES_TARGET_INVALID, argAsString(0));
            return;
        }
        target.giveStrike(true);
        fme.msg(TL.COMMAND_STRIKES_CHANGED, target.getTag(), target.getStrikes());
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_STRIKESGIVE_DESCRIPTION;
    }
}