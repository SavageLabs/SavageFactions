package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.enums.TL;


public class CmdOwnerList extends FCommand {

    public CmdOwnerList() {
        super();
        this.aliases.add("ownerlist");

        //this.requiredArgs.add("");
        //this.optionalArgs.put("", "");

        this.permission = Permission.OWNERLIST.node;
        this.disableOnLock = false;

        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        boolean hasBypass = fme.isAdminBypassing();

        if (!hasBypass && !assertHasFaction()) {
            return;
        }

        if (!Conf.ownedAreasEnabled) {
            fme.msg(TL.CMD_FOWNER_DISABLED);
            return;
        }

        FLocation flocation = new FLocation(fme);

        if (Board.getInstance().getFactionAt(flocation) != myFaction) {
            if (!hasBypass) {
                fme.msg(TL.CMD_FOWNER_WRONG_FACTION);
                return;
            }
            //TODO: This code won't ever be called.
            myFaction = Board.getInstance().getFactionAt(flocation);
            if (!myFaction.isNormal()) {
                fme.msg(TL.CMD_NONE);
                return;
            }
        }

        String owners = myFaction.getOwnerListString(flocation);

        if (owners == null || owners.isEmpty()) {
            fme.msg(TL.CMD_NONE);
            return;
        }

        fme.msg(TL.CMD_OWNERS, owners);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_OWNERLIST_DESCRIPTION;
    }
}