package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.Conf;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.event.LandUnclaimAllEvent;
import com.massivecraft.factions.integration.Econ;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.Bukkit;

public class CmdUnclaimall extends FCommand {

    public CmdUnclaimall() {
        this.aliases.add("unclaimall");
        this.aliases.add("declaimall");

        this.requirements = new CommandRequirements.Builder(Permission.UNCLAIM_ALL)
                .playerOnly()
                .memberOnly()
                .withAction(PermissableAction.TERRITORY) //TODO: Add UnclaimALl PermissableAction
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (Econ.shouldBeUsed()) {
            double refund = Econ.calculateTotalLandRefund(context.faction.getLandRounded());
            if (Conf.bankEnabled && Conf.bankFactionPaysLandCosts) {
                if (!Econ.modifyMoney(context.faction, refund, TL.COMMAND_UNCLAIMALL_TOUNCLAIM.toString(), TL.COMMAND_UNCLAIMALL_FORUNCLAIM.toString())) {
                    return;
                }
            } else {
                if (!Econ.modifyMoney(context.faction, refund, TL.COMMAND_UNCLAIMALL_TOUNCLAIM.toString(), TL.COMMAND_UNCLAIMALL_FORUNCLAIM.toString())) {
                    return;
                }
            }
        }

        LandUnclaimAllEvent unclaimAllEvent = new LandUnclaimAllEvent(context.faction, context.fPlayer);
        Bukkit.getScheduler().runTask(SavageFactions.plugin, () -> Bukkit.getServer().getPluginManager().callEvent(unclaimAllEvent));
        if (unclaimAllEvent.isCancelled()) {
            return;
        }

        Board.getInstance().unclaimAll(context.faction.getId());
        context.faction.msg(TL.COMMAND_UNCLAIMALL_UNCLAIMED, context.fPlayer.describeTo(context.faction, true));

        if (Conf.logLandUnclaims) {
            SavageFactions.plugin.log(TL.COMMAND_UNCLAIMALL_LOG.format(context.fPlayer.getName(), context.faction.getTag()));
        }
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_UNCLAIMALL_DESCRIPTION;
    }

}
