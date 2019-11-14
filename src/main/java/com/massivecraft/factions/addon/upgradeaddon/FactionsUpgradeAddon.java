package com.massivecraft.factions.addon.upgradeaddon;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.addon.FactionsAddon;

import java.util.Set;

public abstract class FactionsUpgradeAddon extends FactionsAddon {

    public FactionsUpgradeAddon(SavageFactions plugin) {
        super(plugin);
        loadUpgrades();
    }

    private void loadUpgrades(){

        for (Upgrade upgrade : upgradesToLoad()) {
            SavageFactions.plugin.getUpgradeManager().addUpgrade(upgrade);
        }

        getPlugin().getUpgradeManager().setupUpgrades();

    }

    /**
     * Method to define upgrades you want to load.
     * @return Set of upgrades you want to load.
     */
    public abstract Set<Upgrade> upgradesToLoad();

}
