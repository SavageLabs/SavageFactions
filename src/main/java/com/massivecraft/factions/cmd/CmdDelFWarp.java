package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.util.fm.enums.TL;
import org.bukkit.configuration.file.FileConfiguration;

public class CmdDelFWarp extends FCommand {

    public CmdDelFWarp() {
        super();
        this.aliases.add("delwarp");
        this.aliases.add("dw");
        this.aliases.add("deletewarp");
        this.requiredArgs.add("warp name");
        this.senderMustBeMember = true;
        this.senderMustBeModerator = true;
        this.senderMustBePlayer = true;
        this.permission = Permission.SETWARP.node;
    }

    @Override
    public void perform() {
        String warp = argAsString(0);
        if (myFaction.isWarp(warp)) {
            if (!transact(fme)) {
                return;
            }
            myFaction.removeWarp(warp);
            fme.msg(TL.CMD_DELETED_WARP.toString().replace("{warp}", warp));
        } else {
            fme.msg(TL.CMD_INVALID_WARP.toString().replace("{warp}", warp));
        }
    }

    private boolean transact(FPlayer player) {
        FileConfiguration config = Files.CONFIG.getFile();
        return !config.getBoolean("warp-cost.enabled", false) || player.isAdminBypassing() || payForCommand(config.getDouble("warp-cost.delwarp", 5), TL.COMMAND_DELFWARP_TODELETE.toString(), TL.COMMAND_DELFWARP_FORDELETE.toString());
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_DELFWARP_DESCRIPTION;
    }
}