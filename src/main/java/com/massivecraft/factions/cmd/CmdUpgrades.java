package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.zcore.fupgrades.FUpgradesMenu;
import org.bukkit.configuration.file.FileConfiguration;

public class CmdUpgrades extends FCommand {
    FileConfiguration config = Files.CONFIG.getFile();
    public CmdUpgrades() {
        super();
        this.aliases.add("upgrades");
        this.aliases.add("upgrade");

        //this.requiredArgs.add("");
        this.optionalArgs.put("mobs/crops/exp", "");

        this.permission = Permission.UPGRADES.node;
        this.disableOnLock = true;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;

    }

    @Override
    public void perform() {
        if (!config.getBoolean("fupgrades.Enabled")) {
            fme.sendMessage("This command is disabled!");
            return;
        }
        new FUpgradesMenu(fme.getFaction()).buildGUI(fme);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_UPGRADES_DESCRIPTION;
    }

}
