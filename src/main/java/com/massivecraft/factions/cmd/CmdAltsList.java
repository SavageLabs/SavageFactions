package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.enums.TL;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;

public class CmdAltsList extends FCommand{


    public CmdAltsList() {
        super();
        this.aliases.add("list");

        this.permission = Permission.LIST.node;
        this.disableOnLock = false;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;

    }

    @Override
    public void perform() {

        ArrayList<String> ret = new ArrayList<>();
        for (FPlayer fp : myFaction.getAltPlayers()) {
            String humanized = DurationFormatUtils.formatDurationWords(System.currentTimeMillis() - fp.getLastLoginTime(), true, true) + TL.CMD_AGO_SUFFIX;
            String last = fp.isOnline() ? ChatColor.GREEN + TL.CMD_FORMAT_F_STATUS.toString() : (System.currentTimeMillis() - fp.getLastLoginTime() < 432000000 ? ChatColor.YELLOW + humanized : ChatColor.RED + humanized);
            String power = ChatColor.YELLOW + String.valueOf(fp.getPowerRounded()) + " / " + fp.getPowerMaxRounded() + ChatColor.RESET;
            ret.add(String.format(TL.CMD_FORMAT_F_ALTS.toString(), ChatColor.GOLD + fp.getName() + ChatColor.RESET, power, last).trim());
        }
        fme.sendMessage(ret);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.CMD_ADMIN_DESCRIPTION;
    }
}