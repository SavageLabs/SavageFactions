package com.massivecraft.factions.cmd;

import com.massivecraft.factions.*;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.util.fm.enums.TL;
import com.massivecraft.factions.zcore.fupgrades.UpgradeType;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class CmdJoin extends FCommand {

    public CmdJoin() {
        super();
        this.aliases.add("join");

        this.requiredArgs.add("faction name");
        this.optionalArgs.put("player", "you");

        this.permission = Permission.JOIN.node;
        this.disableOnLock = true;


        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        Faction faction = this.argAsFaction(0);
        if (faction == null) {
            return;
        }

        FPlayer fplayer = this.argAsBestFPlayerMatch(1, fme, false);
        boolean samePlayer = fplayer == fme;

        if (!samePlayer && !Permission.JOIN_OTHERS.has(sender, false)) {
            msg(TL.CMD_CANNOT_FORCE_JOIN);
            return;
        }

        if (!faction.isNormal()) {
            msg(TL.CMD_CANNOT_JOIN_SYSTEM_FACTION);
            return;
        }

        if (faction == fplayer.getFaction()) {
            //TODO:TL
            msg(TL.CMD_ALREADY_MEMBER, fplayer.describeTo(fme, true), (samePlayer ? "are" : "is"), faction.getTag(fme));
            return;
        }

        if (Conf.factionMemberLimit > 0 && faction.getFPlayers().size() >= getFactionMemberLimit(faction)) {
            msg(TL.CMD_MAX_LIMIT, faction.getTag(fme), getFactionMemberLimit(faction), fplayer.describeTo(fme, false));
            return;
        }

        if (fplayer.hasFaction()) {
            //TODO:TL
            msg(TL.CMD_FACTION_MUST_LEAVE, fplayer.describeTo(fme, true), (samePlayer ? "your" : "their"));
            return;
        }

        if (!Conf.canLeaveWithNegativePower && fplayer.getPower() < 0) {
            msg(TL.CMD_NEGATIVE_POWER_LEAVE, fplayer.describeTo(fme, true));
            return;
        }

        if (!(faction.getOpen() || faction.isInvited(fplayer) || fme.isAdminBypassing() || Permission.JOIN_ANY.has(sender, false))) {
            msg(TL.CMD_REQUIRES_INVITE);
            if (samePlayer) {
                faction.msg(TL.CMD_TRIED_TO_JOIN, fplayer.describeTo(faction, true));
            }
            return;
        }

        int altLimit = Conf.factionAltMemberLimit;

        if (altLimit > 0 && faction.getAltPlayers().size() >= altLimit && !faction.altInvited(fme)) {
            msg(TL.CMD_MAX_LIMIT, faction.getTag(fme), altLimit, fplayer.describeTo(fme, false));
            return;
        }

        // if economy is enabled, they're not on the bypass list, and this command has a cost set, make sure they can pay
        if (samePlayer && !canAffordCommand(Conf.econCostJoin, TL.COMMAND_JOIN_TOJOIN.toString())) {
            return;
        }

        // Check for ban
        if (!fme.isAdminBypassing() && faction.isBanned(fme)) {
            fme.msg(TL.CMD_FACTION_BANNED, faction.getTag(fme));
            return;
        }

        // trigger the join event (cancellable)
        FPlayerJoinEvent joinEvent = new FPlayerJoinEvent(FPlayers.getInstance().getByPlayer(me), faction, FPlayerJoinEvent.PlayerJoinReason.COMMAND);
        Bukkit.getServer().getPluginManager().callEvent(joinEvent);
        if (joinEvent.isCancelled()) {
            return;
        }

        // then make 'em pay (if applicable)
        if (samePlayer && !payForCommand(Conf.econCostJoin, TL.COMMAND_JOIN_TOJOIN.toString(), TL.COMMAND_JOIN_FORJOIN.toString())) {
            return;
        }

        fme.msg(TL.CMD_SUCCESS_JOIN, fplayer.describeTo(fme, true), faction.getTag(fme));

        if (!samePlayer) {
            fplayer.msg(TL.CMD_FACTION_MOVED, fme.describeTo(fplayer, true), faction.getTag(fplayer));
        }

        faction.msg(TL.CMD_SUCCESS_JOIN, fplayer.describeTo(faction, true));

        fplayer.resetFactionData();

        if (faction.altInvited(fplayer)) {
            fplayer.setAlt(true);
            fplayer.setFaction(faction, true);
        } else {
            fplayer.setFaction(faction, false);
        }

        faction.deinvite(fplayer);
        fme.setRole(faction.getDefaultRole());

        if (Conf.logFactionJoin) {
            if (samePlayer) {
                SavageFactions.plugin.log(TL.CMD_FACTION_JOIN_LOG.toString(), fplayer.getName(), faction.getTag());
            } else {
                SavageFactions.plugin.log(TL.CMD_FACTION_MOVED_LOG.toString(), fme.getName(), fplayer.getName(), faction.getTag());
            }
        }
    }

    private int getFactionMemberLimit(Faction f) {
        FileConfiguration config = Files.CONFIG.getFile();
        if (f.getUpgrade(UpgradeType.MEMBER) == 0) return Conf.factionMemberLimit;
        return Conf.factionMemberLimit + config.getInt("fupgrades.MainMenu.Members.Member-Boost.level-" + f.getUpgrade(UpgradeType.MEMBER));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_JOIN_DESCRIPTION;
    }
}