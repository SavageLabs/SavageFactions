package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.fupgrades.FUpgradesMenu;
import com.massivecraft.factions.zcore.util.TL;

public class CmdUpgrades extends FCommand {
    public CmdUpgrades() {
        super();
        this.aliases.add("upgrades");
        this.aliases.add("upgrade");

        this.requirements = new CommandRequirements.Builder(Permission.UPGRADES)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (!SavageFactions.plugin.getConfig().getBoolean("fupgrades.Enabled")) {
            context.fPlayer.msg(TL.COMMAND_UPGRADES_DISABLED);
            return;
        }
        new FUpgradesMenu(context.faction).buildGUI(context.fPlayer);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_UPGRADES_DESCRIPTION;
    }

}
