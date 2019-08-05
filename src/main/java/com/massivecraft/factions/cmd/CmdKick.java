package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.event.FPlayerLeaveEvent;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.fm.enums.TL;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import mkremins.fanciful.FancyMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class CmdKick extends FCommand {

    public CmdKick() {
        super();
        this.aliases.add("kick");

        this.optionalArgs.put("player name", "player name");
        //this.optionalArgs.put("", "");

        this.permission = Permission.KICK.node;
        this.disableOnLock = false;


        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FPlayer toKick = this.argIsSet(0) ? this.argAsBestFPlayerMatch(0) : null;
        if (toKick == null) {
            FancyMessage msg = new FancyMessage(TL.CMD_AVAILABLE_KICKS.toString()).color(ChatColor.GOLD);
            for (FPlayer player : myFaction.getFPlayersWhereRole(Role.NORMAL)) {
                String s = player.getName();
                msg.then(s + " ").color(ChatColor.WHITE).tooltip(TL.CMD_CLICK_TO_KICK.toString() + s).command("/" + Conf.baseCommandAliases.get(0) + " kick " + s);
            }
            if (fme.getRole().isAtLeast(Role.COLEADER)) {
                // For both coleader and admin, add mods.
                for (FPlayer player : myFaction.getFPlayersWhereRole(Role.MODERATOR)) {
                    String s = player.getName();
                    msg.then(s + " ").color(ChatColor.GRAY).tooltip(TL.CMD_CLICK_TO_KICK.toString() + s).command("/" + Conf.baseCommandAliases.get(0) + " kick " + s);
                }
                if (fme.getRole() == Role.LEADER) {
                    // Only add coleader to this for the leader.
                    for (FPlayer player : myFaction.getFPlayersWhereRole(Role.COLEADER)) {
                        String s = player.getName();
                        msg.then(s + " ").color(ChatColor.RED).tooltip(TL.CMD_CLICK_TO_KICK.toString() + s).command("/" + Conf.baseCommandAliases.get(0) + " kick " + s);
                    }
                }
            }

            sendFancyMessage(msg);
            return;
        }

        if (fme == toKick) {
            msg(TL.CMD_CANNOT_KICK_SELF);
            msg(TL.GENERIC_YOU_MAY_WANT.toString() + p.cmdBase.cmdLeave.getUseageTemplate(false));
            return;
        }

        Faction toKickFaction = toKick.getFaction();

        if (toKickFaction.isWilderness()) {
            sender.sendMessage(TL.CMD_KICK_FACTIONLESS_PLAYER.toString());
            return;
        }

        // This permission check has been cleaned to be more understandable and logical
        // Unless is admin,
        // - Check for the kick permission.
        // - Make sure the player is in the faction.
        // - Make sure the kicked player has lower rank than the kicker.
        if (!fme.isAdminBypassing()) {
            Access access = myFaction.getAccess(fme, PermissableAction.KICK);
            if (access != Access.ALLOW && fme.getRole() != Role.LEADER) {
                fme.msg(TL.CMD_FPERMS_DENY_ACTION, "kick");
                return;
            }
            if (toKickFaction != myFaction) {
                msg(TL.CMD_NOT_A_MEMBER_F_KICK, toKick.describeTo(fme, true), myFaction.describeTo(fme));
                return;
            }
            if (toKick.getRole().value >= fme.getRole().value) {
                msg(TL.CMD_INSUFFICIENT_RANK_F_KICK);
                return;
            }
            if (!Conf.canLeaveWithNegativePower && toKick.getPower() < 0) {
                msg(TL.CMD_NEGATIVE_POWER_KICK);
                return;
            }
        }

        // if economy is enabled, they're not on the bypass list, and this command has a cost set, make sure they can pay
        if (!canAffordCommand(Conf.econCostKick, TL.COMMAND_KICK_TOKICK.toString())) {
            return;
        }

        // trigger the leave event (cancellable) [reason:kicked]
        FPlayerLeaveEvent event = new FPlayerLeaveEvent(toKick, toKick.getFaction(), FPlayerLeaveEvent.PlayerLeaveReason.KICKED);
        Bukkit.getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            return;
        }

        // then make 'em pay (if applicable)
        if (!payForCommand(Conf.econCostKick, TL.COMMAND_KICK_TOKICK.toString(), TL.COMMAND_KICK_FORKICK.toString())) {
            return;
        }

        toKickFaction.msg(TL.CMD_FACTION_SUCCESS_KICK, fme.describeTo(toKickFaction, true), toKick.describeTo(toKickFaction, true));

        toKick.msg(TL.CMD_FACTION_YOU_ARE_KICKED, fme.describeTo(toKick, true), toKickFaction.describeTo(toKick));
        if (toKickFaction != myFaction) {
            fme.msg(TL.CMD_FACTION_KICK_KICKS, toKick.describeTo(fme), toKickFaction.describeTo(fme));
        }
        if (Conf.logFactionKick) {
            SavageFactions.plugin.log((senderIsConsole ? "A console command" : fme.getName()) + " kicked " + toKick.getName() + " from the faction: " + toKickFaction.getTag());
        }
        if (toKick.getRole() == Role.LEADER) {
            toKickFaction.promoteNewLeader();
        }
        toKickFaction.deinvite(toKick);
        toKick.resetFactionData();
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_KICK_DESCRIPTION;
    }
}