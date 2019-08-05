package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.Methods;
import com.massivecraft.factions.util.fm.enums.TL;

public class CmdLockSpawners extends FCommand {

    public CmdLockSpawners() {
        super();

        this.aliases.add("lockspawners");
        this.aliases.add("spawnerlock");


        this.permission = Permission.LOCKSPAWNERS.node;
        this.disableOnLock = false;

        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        SavageFactions.plugin.spawnersPlacing = !SavageFactions.plugin.spawnersPlacing;
        msg(TL.COMMAND_SPAWNERTOGGLE_TOGGLE, SavageFactions.plugin.spawnersPlacing ? Methods.pl("&aEnabled") : Methods.pl("&4Disabled"));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_SPAWNERTOGGLE_DESCRIPTION;
    }
}