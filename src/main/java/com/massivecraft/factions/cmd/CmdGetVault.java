package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.ItemBuilder;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdGetVault extends FCommand {
    public CmdGetVault() {
        super();
        this.aliases.add("getvault");

        this.requirements = new CommandRequirements.Builder(Permission.GETVAULT)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (!SavageFactions.plugin.getConfig().getBoolean("fvault.Enabled")) {
            context.fPlayer.sendMessage("This command is disabled!");
            return;
        }
        Location vaultLocation = context.faction.getVault();
        ItemStack vault = new ItemBuilder(Material.CHEST)
                .amount(1)
                .name(SavageFactions.plugin.getConfig().getString("fvault.Item.Name"))
                .lore(SavageFactions.plugin.getConfig().getStringList("fvault.Item.Lore"))
                .build();
        //check if vault is set
        if (vaultLocation != null) {
            context.msg(TL.COMMAND_GETVAULT_ALREADYSET);
            return;
        }


        //has enough money?
        int amount = SavageFactions.plugin.getConfig().getInt("fvault.Price");
        if (!context.fPlayer.hasMoney(amount)) {
            return;
        }


        //success :)
        context.fPlayer.takeMoney(amount);
        context.player.getInventory().addItem(vault);
        context.fPlayer.msg(TL.COMMAND_GETVAULT_RECEIVE);

    }

    public boolean inventoryContains(Inventory inventory, ItemStack item) {
        int count = 0;
        for (ItemStack itemStack : inventory.getContents()) {
            if (itemStack != null && itemStack.getType() == item.getType() && itemStack.getDurability() == item.getDurability()) {
                count += itemStack.getAmount();
            }
            if (count >= item.getAmount()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_GETVAULT_DESCRIPTION;
    }

}
