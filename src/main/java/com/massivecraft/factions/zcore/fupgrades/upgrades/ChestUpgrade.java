package com.massivecraft.factions.zcore.fupgrades.upgrades;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.zcore.fupgrades.FactionUpgrade;
import com.massivecraft.factions.zcore.fupgrades.UpgradeListener;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class ChestUpgrade extends FactionUpgrade {

    public ChestUpgrade() {
        super("chest");
    }

    @Override
    public Set<Listener> listenersToRegister() {
        return null;
    }

    @Override
    public void onLevelUp(Faction faction) {

        updateChests(faction);

    }

    private void updateChests(Faction faction) {

        String invName = SavageFactions.plugin.color(Conf.fchestInventoryTitle);
        for (HumanEntity player : faction.getChestInventory().getViewers()) {
            if (player.getOpenInventory().getTitle().equalsIgnoreCase(invName)) //TODO Check if it's the same as : player.getInventory().getTitle()
                player.closeInventory();
        }
        int level = faction.getUpgrade(this);
        int size = SavageFactions.plugin.getConfig().getInt("fupgrades.upgrades." + "chest" + ".levels." + (level) +  ".boost");
        faction.setChestSize(size * 9);

    }

}
