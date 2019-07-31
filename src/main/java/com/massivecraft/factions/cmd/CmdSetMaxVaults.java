package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.Methods;
import org.bukkit.ChatColor;

public class CmdSetMaxVaults extends FCommand {

    public CmdSetMaxVaults() {
        this.aliases.add("setmaxvaults");
        this.aliases.add("smv");

        this.requiredArgs.add("faction");
        this.requiredArgs.add("number");

        this.permission = Permission.SETMAXVAULTS.node;
        this.disableOnLock = false;

        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;

    }

    @Override
    public void perform() {
        Faction targetFaction = argAsFaction(0);
        int value = argAsInt(1, -1);
        if (value < 0) {
            sender.sendMessage(Methods.pl("&cNumber must be greater than 0."));
            return;
        }

        if (targetFaction == null) {
            sender.sendMessage(Methods.pl("Couldn't find Faction: " + Methods.pl("&e ") + argAsString(0)));
            return;
        }

        targetFaction.setMaxVaults(value);
        sender.sendMessage(TL.COMMAND_SETMAXVAULTS_SUCCESS.format(targetFaction.getTag(), value));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_SETMAXVAULTS_DESCRIPTION;
    }
}
