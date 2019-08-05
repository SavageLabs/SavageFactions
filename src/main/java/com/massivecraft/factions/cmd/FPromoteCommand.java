package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.fm.enums.TL;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;

public class FPromoteCommand extends FCommand {

    public int relative = 0;

    public FPromoteCommand() {
        super();

        this.requiredArgs.add("player");

        this.permission = Permission.PROMOTE.node;
        this.disableOnLock = true;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FPlayer target = this.argAsBestFPlayerMatch(0);
        if (target == null) {
            msg(TL.GENERIC_NO_PLAYER_FOUND, this.argAsString(0));
            return;
        }

        if (!target.getFaction().equals(myFaction)) {
            msg(TL.CMD_WRONG_FACTION, target.getName());
            return;
        }

        Role current = target.getRole();
        Role promotion = Role.getRelative(current, +relative);

        // Now it ain't that messy
        if (!fme.isAdminBypassing()) {
            Access access = myFaction.getAccess(fme, PermissableAction.PROMOTE);
            if (access != Access.ALLOW && fme.getRole() != Role.LEADER) {
                fme.msg(TL.GENERIC_NO_CMD_PERMS.toString(), "manage ranks");
                return;
            }
            if (target == fme) {
                fme.msg(TL.CMD_TARGET_IS_SELF.toString());
                return;
            }
            // Don't allow people to manage role of their same rank
            if (fme.getRole() == current) {
                fme.msg(TL.CMD_NOT_ALLOWED.toString());
                return;
            }
            // Don't allow people to promote people to their same or higher rank.
            if (fme.getRole().value <= promotion.value) {
                fme.msg(TL.CMD_NOT_ALLOWED.toString());
                return;
            }
        }

        if (promotion == null) {
            fme.msg(TL.CMD_NOT_THAT_PLAYER.toString());
            return;
        }

        // Don't allow people to promote people to their same or higher rnak.
        if (fme.getRole().value <= promotion.value) {
            fme.msg(TL.CMD_NOT_ALLOWED.toString());
            return;
        }

        String action = relative > 0 ? TL.COMMAND_PROMOTE_PROMOTED.toString() : TL.COMMAND_PROMOTE_DEMOTED.toString();

        // Success!
        target.setRole(promotion);
        if (target.isOnline()) {
            target.msg(TL.CMD_PROMOTE_TARGET.toString(), action, promotion.nicename);
        }
        fme.msg(TL.CMD_FPROMO_SUCCESS.toString(), action, target.getName(), promotion.nicename);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_PROMOTE_DESCRIPTION;
    }
}