package com.massivecraft.factions.cmd;

import com.google.gson.internal.$Gson$Preconditions;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.LazyLocation;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import com.massivecraft.factions.zcore.util.TL;

public class CmdSetFWarp extends FCommand {

    public CmdSetFWarp() {
        super();

        this.aliases.add("setwarp");
        this.aliases.add("sw");
        this.requiredArgs.add("warp name");
        this.optionalArgs.put("password", "password");

        this.requirements = new CommandRequirements.Builder(Permission.SETWARP)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (!(context.fPlayer.getRelationToLocation() == Relation.MEMBER)) {
            context.msg(TL.COMMAND_SETFWARP_NOTCLAIMED);
            return;
        }

        // This statement allows us to check if they've specifically denied it, or default to
        // the old setting of allowing moderators to set warps.
        if (!context.fPlayer.isAdminBypassing()) {
            Access access = context.faction.getAccess(context.fPlayer, PermissableAction.SETWARP);
            if (access != Access.ALLOW && context.fPlayer.getRole() != Role.LEADER) {
                context.msg(TL.GENERIC_FPERM_NOPERMISSION, "set warps");
                return;
            }
        }

        String warp = context.argAsString(0);

        // Checks if warp with same name already exists and ignores maxWarp check if it does.
        boolean warpExists = context.faction.isWarp(warp);

        int maxWarps = SavageFactions.plugin.getConfig().getInt("max-warps", 5);
        boolean tooManyWarps = maxWarps <= context.faction.getWarps().size();
        if (tooManyWarps && !warpExists) {
            context.msg(TL.COMMAND_SETFWARP_LIMIT, maxWarps);
            return;
        }

        if (!transact(context.fPlayer, context)) {
            return;
        }

        String password = context.argAsString(1);

        LazyLocation loc = new LazyLocation(context.player.getLocation());
        context.faction.setWarp(warp, loc);
        if (password != null) {
            context.faction.setWarpPassword(warp, password);
        }
        context.msg(TL.COMMAND_SETFWARP_SET, warp, password != null ? password : "");
    }

    private boolean transact(FPlayer player, CommandContext context) {
        return !SavageFactions.plugin.getConfig().getBoolean("warp-cost.enabled", false) || player.isAdminBypassing() || context.payForCommand(SavageFactions.plugin.getConfig().getDouble("warp-cost.setwarp", 5), TL.COMMAND_SETFWARP_TOSET.toString(), TL.COMMAND_SETFWARP_FORSET.toString());
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_SETFWARP_DESCRIPTION;
    }
}
