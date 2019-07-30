package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;

public class CmdStrikesInfo extends FCommand {

    public CmdStrikesInfo() {
        super();
        this.aliases.add("info");
        this.permission = Permission.STRIKES.node;

        this.optionalArgs.put("target", "faction");

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
        if (target == null) target = myFaction;
        if (target.isSystemFaction()) {
            fme.msg(TL.COMMAND_STRIKES_TARGET_INVALID, argAsString(0));
            return;
        }
        fme.msg(TL.COMMAND_STRIKES_INFO, target.getTag(), target.getStrikes());
    }


    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_STRIKESINFO_DESCRIPTION;
    }


}
