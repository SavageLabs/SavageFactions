package com.massivecraft.factions.cmd;

import com.massivecraft.factions.*;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.WarmUpUtil;
import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.util.fm.enums.TL;
import org.bukkit.configuration.file.FileConfiguration;

public class CmdCheckpoint extends FCommand {
    public CmdCheckpoint() {
        super();
        this.aliases.add("checkp");
        this.aliases.add("checkpoint");
        this.aliases.add("cpoint");

        this.optionalArgs.put("set", "");

        this.permission = Permission.CHECKPOINT.node;
        this.disableOnLock = false;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FileConfiguration config = Files.CONFIG.getFile();
        if (!config.getBoolean("checkpoints.Enabled")) {
            fme.msg(TL.CMD_CHECKPOINT_DISABLED.toString());
            return;
        }
        if (args.size() == 1) {
            FLocation myLocation = new FLocation(fme.getPlayer().getLocation());
            Faction myLocFaction = Board.getInstance().getFactionAt(myLocation);
            if (myLocFaction == Factions.getInstance().getWilderness() || myLocFaction == fme.getFaction()) {
                fme.getFaction().setCheckpoint(fme.getPlayer().getLocation());
                fme.msg(TL.CMD_CHECKPOINT_SET.toString());
                return;
            } else {
                fme.msg(TL.CMD_CHECKPOINT_INVALID_LOCATION.toString());
                return;
            }
        }
        if (fme.getFaction().getCheckpoint() == null) {
            fme.msg(TL.CMD_CHECKPOINT_NOT_SET.toString());
            return;
        }
        FLocation checkLocation = new FLocation(fme.getFaction().getCheckpoint());
        Faction checkfaction = Board.getInstance().getFactionAt(checkLocation);

        if (checkfaction.getId().equals(Factions.getInstance().getWilderness().getId()) || checkfaction.getId().equals(fme.getFaction().getId())) {
            fme.msg(TL.CMD_CHECKPOINT_GO.toString());
            this.doWarmUp(WarmUpUtil.Warmup.CHECKPOINT, TL.WARMUP_TELEPORT, "Checkpoint", new Runnable() {
                @Override
                public void run() {
                    fme.getPlayer().teleport(fme.getFaction().getCheckpoint());
                }
            }, this.p.getConfig().getLong("warmups.f-checkpoint", 0));
        } else {
            fme.msg(TL.CMD_CHECKPOINT_CLAIMED.toString());
        }
    }
    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_CHECKPOINT_DESCRIPTION;
    }
}