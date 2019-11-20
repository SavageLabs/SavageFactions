package com.massivecraft.factions.addon.upgradeaddon;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.zcore.fupgrades.upgrades.*;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UpgradeManager {

    private static UpgradeManager upgradeManagerInstance;

    private Set<Upgrade> upgrades = new HashSet<>();
    private SavageFactions plugin;
    private List<Listener> listenerList = new ArrayList<>();

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
         new TntUpgrade();

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

            if (upgrade.listenersToRegister() == null) continue;

            for (Listener listener : upgrade.listenersToRegister()) {
                if (!listenerList.contains(listener)) {
                    plugin.getServer().getPluginManager().registerEvents(listener, plugin);
                    listenerList.add(listener);
                }

            }

        }

    }

    public Set<Upgrade> getUpgrades() {
        return upgrades;
    }
}
