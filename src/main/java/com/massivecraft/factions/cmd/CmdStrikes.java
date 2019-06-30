package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdStrikes extends FCommand {


    public CmdStrikesGive cmdStrikesGive = new CmdStrikesGive();
    public CmdStrikesInfo cmdStrikesInfo = new CmdStrikesInfo();
    public CmdStrikesSet cmdStrikesSet = new CmdStrikesSet();
    public CmdStrikesTake cmdStrikesTake = new CmdStrikesTake();

    public CmdStrikes() {
        super();

        this.aliases.add("strikes");

        this.permission = Permission.STRIKES.node;
        this.disableOnLock = false;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;


        this.addSubCommand(cmdStrikesGive);
        this.addSubCommand(cmdStrikesInfo);
        this.addSubCommand(cmdStrikesSet);
        this.addSubCommand(cmdStrikesTake);
    }

    @Override
    public void perform() {
        commandChain.add(this);
        SavageFactions.plugin.cmdAutoHelp.execute(sender, args, commandChain);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_STRIKES_DESCRIPTION;
    }

}