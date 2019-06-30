package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdStrikesTake extends FCommand {


    public CmdStrikesTake() {
        super();
        this.aliases.add("take");
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
        target.takeStrike(true);
        fme.msg(TL.COMMAND_STRIKES_CHANGED, target.getTag(), target.getStrikes());
    }


    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_STRIKETAKE_DESCRIPTION;
    }

}
