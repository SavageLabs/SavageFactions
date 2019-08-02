package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.integration.Econ;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;


public class CmdHelp extends FCommand {

    public ArrayList<ArrayList<String>> helpPages;

    public CmdHelp() {
        super();
        this.aliases.add("help");
        this.aliases.add("h");
        this.aliases.add("?");

        //this.requiredArgs.add("");
        this.optionalArgs.put("page", "1");

        this.requirements = new CommandRequirements.Builder(Permission.HELP)
                .build();
    }

    //----------------------------------------------//
    // Build the help pages
    //----------------------------------------------//

    @Override
    public void perform(CommandContext context) {
        if (SavageFactions.plugin.getConfig().getBoolean("use-old-help", true)) {
            if (helpPages == null) {
                updateHelp(context);
            }

            int page = context.argAsInt(0, 1);
            context.sendMessage(SavageFactions.plugin.txt.titleize("Factions Help (" + page + "/" + helpPages.size() + ")"));

            page -= 1;

            if (page < 0 || page >= helpPages.size()) {
                context.msg(TL.COMMAND_HELP_404.format(String.valueOf(page)));
                return;
            }
            context.sendMessage(helpPages.get(page));
            return;
        }
        ConfigurationSection help = SavageFactions.plugin.getConfig().getConfigurationSection("help");
        if (help == null) {
            help = SavageFactions.plugin.getConfig().createSection("help"); // create new help section
            List<String> error = new ArrayList<>();
            error.add("&cUpdate help messages in config.yml!");
            error.add("&cSet use-old-help for legacy help messages");
            help.set("'1'", error); // add default error messages
        }
        String pageArg =context.argAsString(0, "1");
        List<String> page = help.getStringList(pageArg);
        if (page == null || page.isEmpty()) {
            context.msg(TL.COMMAND_HELP_404.format(pageArg));
            return;
        }
        for (String helpLine : page) {
            context.sendMessage(SavageFactions.plugin.txt.parse(helpLine));
        }
    }

    public void updateHelp(CommandContext context) {
        helpPages = new ArrayList<>();
        ArrayList<String> pageLines;

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.cmdBase.cmdHelp.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdList.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdShow.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdPower.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdJoin.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdLeave.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdChat.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdToggleAllianceChat.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdHome.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_NEXTCREATE.toString()));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.cmdBase.cmdCreate.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdDescription.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdTag.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_INVITATIONS.toString()));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdOpen.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdInvite.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdDeinvite.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_HOME.toString()));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdSethome.getUseageTemplate(context));
        helpPages.add(pageLines);

        if (Econ.isSetup() && Conf.econEnabled && Conf.bankEnabled) {
            pageLines = new ArrayList<>();
            pageLines.add("");
            pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_BANK_1.toString()));
            pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_BANK_2.toString()));
            pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_BANK_3.toString()));
            pageLines.add("");
            pageLines.add(SavageFactions.plugin.cmdBase.cmdMoney.getUseageTemplate(context));
            pageLines.add("");
            pageLines.add("");
            pageLines.add("");
            helpPages.add(pageLines);
        }

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.cmdBase.cmdClaim.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdAutoClaim.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdUnclaim.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdUnclaimall.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdKick.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdMod.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdAdmin.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdTitle.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdSB.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdSeeChunk.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdStatus.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PLAYERTITLES.toString()));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.cmdBase.cmdMap.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdBoom.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdOwner.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdOwnerList.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_OWNERSHIP_1.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_OWNERSHIP_2.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_OWNERSHIP_3.toString()));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.cmdBase.cmdDisband.getUseageTemplate(context));
        pageLines.add("");
        pageLines.add(SavageFactions.plugin.cmdBase.cmdRelationAlly.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdRelationNeutral.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdRelationEnemy.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_1.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_2.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_3.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_4.toString()));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_5.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_6.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_7.toString()));
        pageLines.add(TL.COMMAND_HELP_RELATIONS_8.toString());
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_9.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_10.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_11.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_12.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_RELATIONS_13.toString()));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_1.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_2.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_3.toString()));
        pageLines.add(TL.COMMAND_HELP_PERMISSIONS_4.toString());
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_5.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_6.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_7.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_8.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_PERMISSIONS_9.toString()));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(TL.COMMAND_HELP_MOAR_1.toString());
        pageLines.add(SavageFactions.plugin.cmdBase.cmdBypass.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_ADMIN_1.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_ADMIN_2.toString()));
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_ADMIN_3.toString()));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdSafeunclaimall.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdWarunclaimall.getUseageTemplate(context));
        //TODO:TL
        pageLines.add(SavageFactions.plugin.txt.parse("<i>Note: " + SavageFactions.plugin.cmdBase.cmdUnclaim.getUseageTemplate(context) + SavageFactions.plugin.txt.parse("<i>") + " works on safe/war zones as well."));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdPeaceful.getUseageTemplate(context));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_MOAR_2.toString()));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdChatSpy.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdPermanent.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdPermanentPower.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdPowerBoost.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdConfig.getUseageTemplate(context));
        helpPages.add(pageLines);

        pageLines = new ArrayList<>();
        pageLines.add(SavageFactions.plugin.txt.parse(TL.COMMAND_HELP_MOAR_3.toString()));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdLock.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdReload.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdSaveAll.getUseageTemplate(context));
        pageLines.add(SavageFactions.plugin.cmdBase.cmdVersion.getUseageTemplate(context));
        helpPages.add(pageLines);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_HELP_DESCRIPTION;
    }
}

