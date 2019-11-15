package com.massivecraft.factions.addon.upgradeaddon;

import com.massivecraft.factions.SavageFactions;
import org.bukkit.event.HandlerList;
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

    public void initUpgrades(){

         new PowerUpgrade();
         new ChestUpgrade();
         new ExpUpgrade();
         new CropUpgrade();
         new MemberUpgrade();
         new SpawnerUpgrade();

        setupUpgrades();

    }

    protected void setupUpgrades(){

        registerUpgradesListeners();

    }

    public void addUpgrade(Upgrade upgrade){

        this.upgrades.add(upgrade);

    }

    public void removeUpgrade(Upgrade upgrade){

        this.upgrades.remove(upgrade);

    }

    public Upgrade getUpgradeByName(String upgradeName){

        Upgrade res = null;

        for (Upgrade upgrade : getUpgrades()){

            if (upgrade.getUpgradeName().equals(upgradeName)) {

                res = upgrade;
                break;

            }

        }

        return res;

    }

    private void registerUpgradesListeners(){

        for (Upgrade upgrade : upgrades) {

            for (Listener listener : upgrade.listenersToRegister()) {

                if (!HandlerList.getRegisteredListeners(plugin).contains(listener)) {
                    plugin.getServer().getPluginManager().registerEvents(listener, plugin);
                }

            }

        }

    }

    public Set<Upgrade> getUpgrades() {
        return upgrades;
    }
}
