package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import com.massivecraft.factions.zcore.util.TL;

public class FPromoteCommand extends FCommand {

    public int relative = 0;

    public FPromoteCommand() {
        super();
        this.requiredArgs.add("player");

        this.requirements = new CommandRequirements.Builder(Permission.PROMOTE)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        FPlayer target = context.argAsBestFPlayerMatch(0);
        if (target == null) {
            context.msg(TL.GENERIC_NOPLAYERFOUND, context.argAsString(0));
            return;
        }

        if (!target.getFaction().equals(context.faction)) {
            context.msg(TL.COMMAND_PROMOTE_WRONGFACTION, target.getName());
            return;
        }

        Role current = target.getRole();
        Role promotion = Role.getRelative(current, +relative);

        // Now it ain't that messy
        if (!context.fPlayer.isAdminBypassing()) {
            Access access = context.faction.getAccess(context.fPlayer, PermissableAction.PROMOTE);
            if (access != Access.ALLOW && context.fPlayer.getRole() != Role.LEADER) {
                context.msg(TL.GENERIC_NOPERMISSION, "manage ranks");
                return;
            }
            if (target == context.fPlayer) {
                context.msg(TL.COMMAND_PROMOTE_NOTSELF);
                return;
            }
            // Don't allow people to manage role of their same rank
            if (context.fPlayer.getRole() == current) {
                context.msg(TL.COMMAND_PROMOTE_NOT_SAME);
                return;
            }
            // Don't allow people to promote people to their same or higher rank.
            if (context.fPlayer.getRole().value <= promotion.value) {
                context.msg(TL.COMMAND_PROMOTE_NOT_ALLOWED);
                return;
            }
        }

        if (promotion == null) {
            context.msg(TL.COMMAND_PROMOTE_NOTTHATPLAYER);
            return;
        }

        // Don't allow people to promote people to their same or higher rnak.
        if (context.fPlayer.getRole().value <= promotion.value) {
            context.msg(TL.COMMAND_PROMOTE_NOT_ALLOWED);
            return;
        }

        String action = relative > 0 ? TL.COMMAND_PROMOTE_PROMOTED.toString() : TL.COMMAND_PROMOTE_DEMOTED.toString();

        // Success!
        target.setRole(promotion);
        if (target.isOnline()) {
            target.msg(TL.COMMAND_PROMOTE_TARGET, action, promotion.nicename);
        }

        context.msg(TL.COMMAND_PROMOTE_SUCCESS, action, target.getName(), promotion.nicename);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_PROMOTE_DESCRIPTION;
    }

}