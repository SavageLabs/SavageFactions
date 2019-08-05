package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.fm.enums.TL;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import mkremins.fanciful.FancyMessage;
import org.bukkit.ChatColor;

public class CmdDeinvite extends FCommand {

    public CmdDeinvite() {
        super();
        this.aliases.add("deinvite");
        this.aliases.add("deinv");

        this.optionalArgs.put("player name", "name");
        //this.optionalArgs.put("", "");

        this.permission = Permission.DEINVITE.node;
        this.disableOnLock = true;

        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = true;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FPlayer you = this.argAsBestFPlayerMatch(0);
        if (!fme.isAdminBypassing()) {
            Access access = myFaction.getAccess(fme, PermissableAction.INVITE);
            if (access != Access.ALLOW && fme.getRole() != Role.LEADER) {
                fme.msg(TL.CMD_FPERMS_DENY_ACTION.toString(), "manage invites");
                return;
            }
        }
        if (you == null) {
            FancyMessage msg = new FancyMessage(TL.CMD_CAN_DEINVITE.toString()).color(ChatColor.GOLD);
            for (String id : myFaction.getInvites()) {
                FPlayer fp = FPlayers.getInstance().getById(id);
                String name = fp != null ? fp.getName() : id;
                msg.then(name + " ").color(ChatColor.WHITE).tooltip(TL.CMD_CLICK_TO_DEINVITE.format(name)).command("/" + Conf.baseCommandAliases.get(0) + " deinvite " + name);
            }
            sendFancyMessage(msg);
            return;
        }

        if (you.getFaction() == myFaction) {
            msg(TL.CMD_ALREADY_A_MEMBER, you.getName(), myFaction.getTag());
            msg(TL.CMD_MIGHT_WANT_TO, p.cmdBase.cmdKick.getUseageTemplate(false));
            return;
        }

        myFaction.deinvite(you);

        you.msg(TL.CMD_INVITE_REVOKED.toString(), fme.describeTo(you), myFaction.describeTo(you));

        myFaction.msg(TL.CMD_INVITE_REVOKE.toString(), fme.describeTo(myFaction), you.describeTo(myFaction));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_DEINVITE_DESCRIPTION;
    }
}