package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.util.fm.enums.TL;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

public class CmdVault extends FCommand {

    public CmdVault() {
        this.aliases.add("vault");

        //this.requiredArgs.add("");

        this.permission = Permission.VAULT.node;
        this.disableOnLock = false;

        senderMustBePlayer = true;
        senderMustBeMember = true;
        senderMustBeModerator = false;
        senderMustBeAdmin = false;
    }

    @Override
    public void perform() {
        FileConfiguration config = Files.CONFIG.getFile();
        if (!config.getBoolean("fvault.Enabled")) {
            fme.msg(TL.GENERIC_COMMAND_DISABLED.toString());
            return;
        }
        Access access = fme.getFaction().getAccess(fme, PermissableAction.VAULT);
        if (access.equals(Access.DENY)) {
            fme.msg(TL.GENERIC_NO_CMD_PERMS.toString(), "vault");
            return;
        }

        if (fme.isInVault()) {
            me.closeInventory();
            return;
        }
        fme.setInVault(true);
        Location vaultLocation = fme.getFaction().getVault();
        if (vaultLocation == null) {
            fme.msg(TL.CMD_VAULT_INVALID_LOCATION.toString());
            return;
        }
        FLocation vaultFLocation = new FLocation(vaultLocation);
        if (Board.getInstance().getFactionAt(vaultFLocation) != fme.getFaction()) {
            fme.getFaction().setVault(null);
            fme.msg(TL.CMD_VAULT_INVALID_LOCATION.toString());
            return;
        }
        if (vaultLocation.getBlock().getType() != Material.CHEST) {
            fme.getFaction().setVault(null);
            fme.msg(TL.CMD_VAULT_INVALID_LOCATION.toString());
            return;
        }
        Chest chest = (Chest) vaultLocation.getBlock().getState();
        Inventory chestInv = chest.getBlockInventory();
        fme.msg(TL.CMD_VAULT_OPENING.toString());
        me.openInventory(chestInv);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_VAULT_DESCRIPTION;
    }
}