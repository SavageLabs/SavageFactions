package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import com.massivecraft.factions.zcore.util.TL;

public class CmdChest extends FCommand {

    public CmdChest() {
        this.aliases.add("chest");
        this.aliases.add("pv");

        this.requirements = new CommandRequirements.Builder(Permission.CHEST)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {


        if (!SavageFactions.plugin.getConfig().getBoolean("fchest.Enabled")) {
            context.fPlayer.sendMessage("This command is disabled!");
            return;
        }
        // This permission check is way too explicit but it's clean
        if (!context.fPlayer.isAdminBypassing()) {
            Access access = context.faction.getAccess(context.fPlayer, PermissableAction.CHEST);
            if (access != Access.ALLOW && context.fPlayer.getRole() != Role.LEADER) {
                context.msg(TL.GENERIC_FPERM_NOPERMISSION, "access chest");
                return;
            }
        }

        context.player.openInventory(context.faction.getChestInventory());


    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_VAULT_DESCRIPTION;
    }
}
