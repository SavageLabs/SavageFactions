package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.util.fm.enums.TL;
import org.bukkit.configuration.file.FileConfiguration;

public class CmdReload extends FCommand {

    public CmdReload() {
        super();
        this.aliases.add("reload");

        this.permission = Permission.RELOAD.node;
        this.disableOnLock = false;

        senderMustBePlayer = false;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FileConfiguration config = Files.CONFIG.getFile();
        long timeInitStart = System.currentTimeMillis();
        Conf.load();
        Conf.save();
        Files.CONFIG.reloadFile();
        Files.LANG.reloadFile();

        if (config.getBoolean("enable-faction-flight")) {
            SavageFactions.plugin.factionsFlight = true;
        }

        long timeReload = (System.currentTimeMillis() - timeInitStart);

        msg(TL.GENERIC_CONFIG_RELOAD, timeReload);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_RELOAD_DESCRIPTION;
    }
}