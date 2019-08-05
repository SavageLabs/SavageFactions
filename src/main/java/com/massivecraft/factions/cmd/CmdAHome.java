package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.enums.TL;
import org.bukkit.event.player.PlayerTeleportEvent;

public class CmdAHome extends FCommand {

    public CmdAHome() {
        super();
        this.aliases.add("ahome");

        this.requiredArgs.add("player name");

        this.permission = Permission.AHOME.node;
        this.disableOnLock = false;

        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FPlayer target = argAsBestFPlayerMatch(0);
        if (target == null) {
            msg(TL.GENERIC_NO_PLAYER_MATCH.toString(), argAsString(0));
            return;
        }

        if (target.isOnline()) {
            Faction faction = target.getFaction();
            if (faction.hasHome()) {
                target.getPlayer().teleport(faction.getHome(), PlayerTeleportEvent.TeleportCause.PLUGIN);
                msg(TL.CMD_AHOME_SUCCESS, target.getName());
                target.msg(TL.CMD_TARGET_AHOME_MSG.toString());
            } else {
                msg(TL.CMD_NO_AHOME, target.getName());
            }
        } else {
            msg(TL.CMD_AHOME_OFFLINE, target.getName());
        }
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_AHOME_DESCRIPTION;
    }
}
