package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdStrikesSet extends FCommand {

    public CmdStrikesSet() {
        super();
        this.aliases.add("set");

        this.requiredArgs.add(0, "faction");
        this.requiredArgs.add(1, "amount");
        this.permission = Permission.STRIKES.node;
        this.disableOnLock = false;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        Faction target = argAsFaction(0);
        if (target == null || target.isSystemFaction()) {
            fme.msg(TL.COMMAND_STRIKES_TARGET_INVALID, argAsString(0));
            return;
        }
        target.setStrikes(argAsInt(1), true);
        fme.msg(TL.COMMAND_STRIKES_CHANGED, target.getTag(), target.getStrikes());
    }


    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_STRIKESET_DESCRIPTION;
    }

}
