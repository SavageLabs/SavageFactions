package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.enums.TL;

public class CmdChatSpy extends FCommand {

    public CmdChatSpy() {
        super();
        this.aliases.add("chatspy");

        this.optionalArgs.put("on/off", "flip");

        this.permission = Permission.CHATSPY.node;
        this.disableOnLock = false;

        senderMustBePlayer = true;
        senderMustBeMember = false;
        senderMustBeModerator = false;
        senderMustBeColeader = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        fme.setSpyingChat(this.argAsBool(0, !fme.isSpyingChat()));

        if (fme.isSpyingChat()) {
            fme.msg(TL.CMD_CHATSPY_ENABLE.toString());
            SavageFactions.plugin.log(fme.getName() + TL.CMD_ENABLE_LOG_F_CHATSPY.toString());
        } else {
            fme.msg(TL.CMD_CHATSPY_DISABLE.toString());
            SavageFactions.plugin.log(fme.getName() + TL.CMD_DISABLE_LOG_F_CHATSPY.toString());
        }
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_CHATSPY_DESCRIPTION;
    }
}