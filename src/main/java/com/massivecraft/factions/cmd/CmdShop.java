package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.Shop;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.fshop.ShopGUI;
import com.massivecraft.factions.zcore.util.TL;

public class CmdShop extends FCommand {

    public CmdShop() {
        this.aliases.add("shop");

        this.requirements = new CommandRequirements.Builder(Permission.SHOP).playerOnly().memberOnly().build();
    }



    @Override
    public void perform(CommandContext context) {
        new ShopGUI(SavageFactions.plugin, SavageFactions.plugin.color(Shop.shopTitle), Shop.rows).buildGUI(context.fPlayer);
    }

    @Override
    public TL getUsageTranslation() {
        return null;
    }
}
