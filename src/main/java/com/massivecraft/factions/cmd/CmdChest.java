package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.zcore.fchest.FChestGUI;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import com.massivecraft.factions.zcore.util.TL;

public class CmdChest extends FCommand {

    public CmdChest() {
        this.aliases.add("chest");
        this.aliases.add("pv");

        this.optionalArgs.put("faction", "yours");

        this.requirements = new CommandRequirements.Builder(Permission.CHEST)
                .playerOnly()
                .memberOnly()
                .withAction(PermissableAction.CHEST)
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (!Conf.fchestEnabled) {
            context.fPlayer.msg(TL.GENERIC_DISABLED);
            return;
        }
        if (context.args.size() == 1) {
            Faction target = context.argAsFaction(0);
            if (target == null) return;
            if (!context.fPlayer.isAdminBypassing()) {
                Access access = target.getAccess(context.fPlayer, PermissableAction.CHEST);
                if (access != Access.ALLOW) {
                    context.msg(TL.GENERIC_FPERM_NOPERMISSION, "access chest");
                    return;
                }
            }
            new FChestGUI(target.getChestInventory().getSize() / 9, target.getTag() + "'s faction chest").build(target.getChestInventory().getContents(), context.player);
            return;
        }
        context.player.openInventory(context.faction.getChestInventory());
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_VAULT_DESCRIPTION;
    }
}
