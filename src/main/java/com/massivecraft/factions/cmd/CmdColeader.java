package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.fm.enums.TL;
import mkremins.fanciful.FancyMessage;
import org.bukkit.ChatColor;

public class CmdColeader extends FCommand {
    public CmdColeader() {
        super();
        this.aliases.add("co");
        this.aliases.add("setcoleader");
        this.aliases.add("coleader");
        this.aliases.add("setco");

        this.optionalArgs.put("player name", "name");
        //this.optionalArgs.put("", "");

        this.permission = Permission.COLEADER.node;
        this.disableOnLock = true;


        senderMustBePlayer = false;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = true;
    }

    @Override
    public void perform() {
        FPlayer you = this.argAsBestFPlayerMatch(0);
        if (you == null) {
            FancyMessage msg = new FancyMessage(TL.CMD_CANDIDATES.toString()).color(ChatColor.GOLD);
            for (FPlayer player : myFaction.getFPlayersWhereRole(Role.NORMAL)) {
                String s = player.getName();
                msg.then(s + " ").color(ChatColor.WHITE).tooltip(TL.CMD_CLICK_TO_PROMOTE.toString() + s).command("/" + Conf.baseCommandAliases.get(0) + " coleader " + s);
            }
            for (FPlayer player : myFaction.getFPlayersWhereRole(Role.MODERATOR)) {
                String s = player.getName();
                msg.then(s + " ").color(ChatColor.WHITE).tooltip(TL.CMD_CLICK_TO_PROMOTE.toString() + s).command("/" + Conf.baseCommandAliases.get(0) + " coleader " + s);
            }

            sendFancyMessage(msg);
            return;
        }

        boolean permAny = Permission.COLEADER_ANY.has(sender, false);
        Faction targetFaction = you.getFaction();

        if (targetFaction != myFaction && !permAny) {
            msg(TL.CMD_NOT_MEMBER, you.describeTo(fme, true));
            return;
        }

        if (fme != null && fme.getRole() != Role.LEADER && !permAny) {
            msg(TL.CMD_ADMIN_NOTADMIN);
            return;
        }

        if (you == fme && !permAny) {
            msg(TL.CMD_ADMIN_NOTADMIN);
            return;
        }

        if (you.getRole() == Role.LEADER) {
            msg(TL.CMD_TARGET_IS_ADMIN);
            return;
        }

        if (you.getRole() == Role.COLEADER) {
            // Revoke
            you.setRole(Role.MODERATOR);
            targetFaction.msg(TL.CMD_REVOKED_COLEADER.toString(), you.describeTo(targetFaction, true));
            msg(TL.CMD_REVOKES_COLEADER, you.describeTo(fme, true));
        } else {
            // Give
            you.setRole(Role.COLEADER);
            targetFaction.msg(TL.CMD_CO_PROMOTED.toString(), you.describeTo(targetFaction, true));
            msg(TL.CMD_CO_PROMOTES, you.describeTo(fme, true));
        }
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_COLEADER_DESCRIPTION;
    }
}
