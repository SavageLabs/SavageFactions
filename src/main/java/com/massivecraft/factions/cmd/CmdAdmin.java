package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.fm.enums.TL;
import org.bukkit.Bukkit;

public class CmdAdmin extends FCommand {

    public CmdAdmin() {
        super();
        this.aliases.add("admin");
        this.aliases.add("setadmin");
        this.aliases.add("leader");
        this.aliases.add("setleader");

        this.requiredArgs.add("player name");
        //this.optionalArgs.put("", "");

        this.permission = Permission.ADMIN.node;
        this.disableOnLock = true;


        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FPlayer target = this.argAsBestFPlayerMatch(0);
        if (target == null || target.getFaction().isWarZone() || target.getFaction().isWilderness() || target.getFaction().isSafeZone()) {
            return;
        }

        boolean permAny = Permission.ADMIN_ANY.has(sender, false);
        Faction targetFaction = target.getFaction();

        if (targetFaction != myFaction && !permAny) {
            msg(TL.CMD_NOT_A_MEMBER.toString(), target.describeTo(fme, true));
            return;
        }

        if (fme != null && fme.getRole() != Role.LEADER && !permAny) {
            msg(TL.CMD_NOT_ADMIN.toString());
            return;
        }

        if (target == fme && !permAny) {
            msg(TL.CMD_TARGET_IS_SELF.toString());
            return;
        }

        // only perform a FPlayerJoinEvent when newLeader isn't actually in the faction
        if (target.getFaction() != targetFaction) {
            FPlayerJoinEvent event = new FPlayerJoinEvent(FPlayers.getInstance().getByPlayer(me), targetFaction, FPlayerJoinEvent.PlayerJoinReason.LEADER);
            Bukkit.getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                return;
            }
        }

        FPlayer admin = targetFaction.getFPlayerAdmin();

        if (target == admin && target.getFaction().getSize() == 1) {
            msg(TL.CMD_COMMAND_ADMIN_NOMEMBERS.toString());
            return;
        }

        // if target player is currently admin, demote and replace him
        if (target == admin) {
            targetFaction.promoteNewLeader();
            msg(TL.CMD_ADMIN_DEMOTES.toString(), target.describeTo(fme, true));
            target.msg(TL.CMD_ADMIN_DEMOTED.toString(), senderIsConsole ? TL.GENERIC_SERVER_ADMIN.toString() : fme.describeTo(target, true));
            return;
        }

        // promote target player, and demote existing admin if one exists
        if (admin != null) {
            admin.setRole(Role.COLEADER);
        }
        target.setRole(Role.LEADER);
        msg(TL.CMD_ADMIN_PROMOTES.toString(), target.describeTo(fme, true));
        // Inform all players
        for (FPlayer fplayer : FPlayers.getInstance().getOnlinePlayers()) {
            fplayer.msg(TL.CMD_ADMIN_PROMOTED.toString(), senderIsConsole ? TL.GENERIC_SERVER_ADMIN.toString() : fme.describeTo(fplayer, true), target.describeTo(fplayer), targetFaction.describeTo(fplayer));
        }
    }

    public TL getUsageTranslation() {
        return TL.CMD_ADMIN_DESCRIPTION;
    }
}