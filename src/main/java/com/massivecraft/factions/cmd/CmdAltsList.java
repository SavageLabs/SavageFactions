package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdAltsList extends FCommand{


    public CmdAltsList() {
        super();
        this.aliases.add("list");

        this.requirements = new CommandRequirements.Builder(Permission.LIST)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {

        ArrayList<String> ret = new ArrayList<>();
        for (FPlayer fp : context.faction.getAltPlayers()) {
            String humanized = DurationFormatUtils.formatDurationWords(System.currentTimeMillis() - fp.getLastLoginTime(), true, true) + TL.COMMAND_STATUS_AGOSUFFIX;
            String last = fp.isOnline() ? ChatColor.GREEN + TL.COMMAND_STATUS_ONLINE.toString() : (System.currentTimeMillis() - fp.getLastLoginTime() < 432000000 ? ChatColor.YELLOW + humanized : ChatColor.RED + humanized);
            String power = ChatColor.YELLOW + String.valueOf(fp.getPowerRounded()) + " / " + fp.getPowerMaxRounded() + ChatColor.RESET;
            ret.add(String.format(TL.COMMAND_ALTS_LIST_FORMAT.toString(), ChatColor.GOLD + fp.getName() + ChatColor.RESET, power, last).trim());
        }
        context.fPlayer.sendMessage(ret);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_ALTS_LIST_DESCRIPTION;
    }
}
