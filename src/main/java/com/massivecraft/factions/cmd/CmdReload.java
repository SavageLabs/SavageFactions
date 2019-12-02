package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.Shop;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdReload extends FCommand {

    public CmdReload() {
        super();
        this.aliases.add("reload");

        this.requirements = new CommandRequirements.Builder(Permission.RELOAD).build();
    }

    @Override
    public void perform(CommandContext context) {
        long timeInitStart = System.currentTimeMillis();
        Conf.load();
        Conf.save();
        Shop.load();
        Shop.save();
        SavageFactions.plugin.reloadConfig();
        SavageFactions.plugin.loadLang();


        if (SavageFactions.plugin.getConfig().getBoolean("enable-faction-flight")) {
            SavageFactions.plugin.factionsFlight = true;
        }
        long timeReload = (System.currentTimeMillis() - timeInitStart);

        context.msg(TL.COMMAND_RELOAD_TIME, timeReload);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_RELOAD_DESCRIPTION;
    }
}
