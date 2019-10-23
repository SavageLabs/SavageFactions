package com.massivecraft.factions.addon.upgradeaddon;

import com.massivecraft.factions.SavageFactions;
import org.bukkit.event.Listener;

import java.util.HashSet;
import java.util.Set;

public class UpgradeManager {

    private static UpgradeManager upgradeManagerInstance;

    private Set<Upgrade> upgrades = new HashSet<>();
    private SavageFactions plugin;

    private UpgradeManager(final SavageFactions plugin){

        this.plugin = plugin;

    }

    public static UpgradeManager getUpgradeManagerInstance() {

        if (upgradeManagerInstance == null) {

           upgradeManagerInstance = new UpgradeManager(SavageFactions.plugin);

        }

        return upgradeManagerInstance;

    }

    public void addUpgrade(Upgrade upgrade){

        this.upgrades.add(upgrade);

    }

    public void removeUpgrade(Upgrade upgrade){

        this.upgrades.remove(upgrade);

    }

    private void registerUpgradesListeners(){

        for (Upgrade upgrade : upgrades) {

            for (Listener listener : upgrade.listenersToRegister()) {

                plugin.getServer().getPluginManager().registerEvents(listener, plugin);

            }

        }

    }
}
