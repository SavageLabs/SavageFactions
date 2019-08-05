package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.scoreboards.FTeamWrapper;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.util.fm.enums.TL;
import org.bukkit.configuration.file.FileConfiguration;

public class CmdFocus
        extends FCommand {
    public CmdFocus() {
        aliases.add("focus");

        requiredArgs.add("player");

        permission = Permission.FOCUS.node;


        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = true;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    public void perform() {
        FileConfiguration config = Files.CONFIG.getFile();
        if (!config.getBoolean("ffocus.Enabled")) {
            fme.msg(TL.GENERIC_DISABLED);
            return;
        }
        FPlayer target = argAsFPlayer(0);
        if (target == null) {
            return;
        }
        if (target.getFaction().getId().equalsIgnoreCase(myFaction.getId())) {
            fme.msg(TL.CMD_FOCUS_SAME_FACTION);
            return;
        }
        if ((myFaction.getFocused() != null) && (myFaction.getFocused().equalsIgnoreCase(target.getName()))) {
            myFaction.setFocused(null);
            myFaction.msg(TL.CMD_NO_LONGER_FOCUSING, target.getName());
            FTeamWrapper.updatePrefixes(target.getFaction());
            return;
        }
        myFaction.msg(TL.CMD_CURRENTLY_FOCUSING, target.getName());
        myFaction.setFocused(target.getName());
        FTeamWrapper.updatePrefixes(target.getFaction());
    }

    public TL getUsageTranslation() {
        return TL.COMMAND_FOCUS_DESCRIPTION;
    }
}

