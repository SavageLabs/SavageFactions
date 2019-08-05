package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.fm.enums.TL;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import mkremins.fanciful.FancyMessage;
import org.bukkit.ChatColor;

public class CmdInvite extends FCommand {

    public CmdInvite() {
        super();
        this.aliases.add("invite");
        this.aliases.add("inv");

        this.requiredArgs.add("player name");
        //this.optionalArgs.put("", "");

        this.permission = Permission.INVITE.node;
        this.disableOnLock = true;


        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FPlayer target = this.argAsBestFPlayerMatch(0);
        if (target == null) {
            return;
        }

        if (target.getFaction() == myFaction) {
            msg(TL.CMD_ALREADY_MEMBER, target.getName(), myFaction.getTag());
            msg(TL.GENERIC_YOU_MAY_WANT.toString() + p.cmdBase.cmdKick.getUseageTemplate(false));
            return;
        }

        // if economy is enabled, they're not on the bypass list, and this command has a cost set, make 'em pay
        if (!payForCommand(Conf.econCostInvite, TL.COMMAND_INVITE_TOINVITE.toString(), TL.COMMAND_INVITE_FORINVITE.toString())) {
            return;
        }

        if (!fme.isAdminBypassing()) {
            Access access = myFaction.getAccess(fme, PermissableAction.INVITE);
            if (access != Access.ALLOW && fme.getRole() != Role.LEADER) {
                fme.msg(TL.CMD_FPERMS_DENY_ACTION, "manage invites");
                return;
            }
        }

        if (myFaction.isInvited(target)) {
            fme.msg(TL.CMD_ALREADY_INVITED, target.getName());
            return;
        }
        if (myFaction.isBanned(target)) {
            fme.msg(TL.CMD_BANNED_MEMBER, target.getName());
            return;
        }

        myFaction.invite(target);
        // Send the invitation to the target player when online, otherwise just ignore
        if (target.isOnline()) {
            // Tooltips, colors, and commands only apply to the string immediately before it.
            FancyMessage message = new FancyMessage(fme.describeTo(target, true))
                    .tooltip(TL.COMMAND_INVITE_CLICKTOJOIN.toString())
                    .command("/" + Conf.baseCommandAliases.get(0) + " join " + myFaction.getTag())
                    .then(TL.CMD_INVITED_YOU.toString())
                    .color(ChatColor.YELLOW)
                    .tooltip(TL.COMMAND_INVITE_CLICKTOJOIN.toString())
                    .command("/" + Conf.baseCommandAliases.get(0) + " join " + myFaction.getTag())
                    .then(myFaction.describeTo(target)).tooltip(TL.COMMAND_INVITE_CLICKTOJOIN.toString())
                    .command("/" + Conf.baseCommandAliases.get(0) + " join " + myFaction.getTag());

            message.send(target.getPlayer());
        }

        myFaction.msg(TL.CMD_INVITE_SENT, fme.describeTo(myFaction, true), target.describeTo(myFaction));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_INVITE_DESCRIPTION;
    }
}