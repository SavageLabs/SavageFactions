package com.massivecraft.factions.cmd.money;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.cmd.*;
import com.massivecraft.factions.zcore.util.TL;

public class CmdMoney extends FCommand {

    public CmdMoneyBalance cmdMoneyBalance = new CmdMoneyBalance();
    public CmdMoneyDeposit cmdMoneyDeposit = new CmdMoneyDeposit();
    public CmdMoneyWithdraw cmdMoneyWithdraw = new CmdMoneyWithdraw();
    public CmdMoneyTransferFf cmdMoneyTransferFf = new CmdMoneyTransferFf();
    public CmdMoneyTransferFp cmdMoneyTransferFp = new CmdMoneyTransferFp();
    public CmdMoneyTransferPf cmdMoneyTransferPf = new CmdMoneyTransferPf();

    public CmdMoney() {
        super();
        this.aliases.add("money");
        this.aliases.add("bank");

        //this.requiredArgs.add("");
        //this.optionalArgs.put("","")

        this.helpLong.add(SavageFactions.plugin.txt.parseTags(TL.COMMAND_MONEY_LONG.toString()));

        this.addSubCommand(this.cmdMoneyBalance);
        this.addSubCommand(this.cmdMoneyDeposit);
        this.addSubCommand(this.cmdMoneyWithdraw);
        this.addSubCommand(this.cmdMoneyTransferFf);
        this.addSubCommand(this.cmdMoneyTransferFp);
        this.addSubCommand(this.cmdMoneyTransferPf);
    }

    @Override
    public void perform(CommandContext context) {
        context.commandChain.add(this);
        SavageFactions.plugin.cmdAutoHelp.execute(context);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_MONEY_DESCRIPTION;
    }

}
