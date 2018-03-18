package com.massivecraft.factions.cmd;

import com.massivecraft.factions.P;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CmdGetVault extends FCommand
{
    public CmdGetVault(){
        super();

        this.aliases.add("getvault");

        this.permission = Permission.GETVAULT.node;
        this.disableOnLock = true;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform(){
        if (!P.p.getConfig().getBoolean("fvault.Enabled")){
            fme.sendMessage("This command is disabled!");
            return;
        }
        Location vaultLocation = fme.getFaction().getVault();

        if (vaultLocation != null){
            fme.msg(TL.COMMAND_GETVAULT_ALREADYSET);
            return;
        }

        ItemStack vault = P.p.createItem(Material.CHEST,1,(short) 0,P.p.color(P.p.getConfig().getString("fvault.Item.Name")),P.p.colorList(P.p.getConfig().getStringList("fvault.Item.Lore")));
        me.getInventory().addItem(vault);
        fme.msg(TL.COMMAND_GETVAULT_RECEIVE);

    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_GETVAULT_DESCRIPTION;
    }

}
