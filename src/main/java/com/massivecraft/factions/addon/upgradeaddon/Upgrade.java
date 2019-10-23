package com.massivecraft.factions.addon.upgradeaddon;

import com.massivecraft.factions.SavageFactions;
import org.bukkit.Material;
import org.bukkit.event.Listener;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class Upgrade {

    private final SavageFactions plugin = SavageFactions.plugin;

    private final String upgradeName;
    private final Integer maxLevel;
    /**
     * Map representing each level cost
     */
    private final Map<Integer, Double> costPerLevel;
    private final Material guiItem;
    /**
     * Position the upgrade will take in f upgrades gui.
     * If position is already occupied, next free position will be used.
     */
    private final Integer guiPosition;

    public Upgrade(String upgradeName, Integer maxLevel, Map<Integer, Double> costPerLevel, Material guiItem, Integer guiPosition){

        this.upgradeName = upgradeName;

        if (maxLevel < 1) throw new IllegalArgumentException("maxLevel must be a positive number.");

        this.maxLevel = maxLevel;

        if (costPerLevel.keySet().size() > maxLevel) {

            throw new IllegalArgumentException("You have exceeded maxLevel level in costPerLevel. "
                    + "Your maxLevel is " + maxLevel + " and your costPerLevel gets to level "
                    + costPerLevel.keySet().size() + " please remove one pair from costPerLevel or increment your maxLevel");

        }

        this.costPerLevel = Collections.unmodifiableMap(costPerLevel);

        this.guiItem = guiItem;

        if (guiPosition < 0 || guiPosition > 53){

            throw new IllegalArgumentException("guiPosition must be an Integer between 0 and 53");

        }

        this.guiPosition = guiPosition;

        setupUpgrade();

    }

    /**
     * Method to define listeners you want to register. You don't need to register them.
     * @return Set of listeners you want to register.
     */
    public abstract Set<Listener> listenersToRegister();

    public final String getUpgradeName() {
        return upgradeName;
    }

    public final Integer getMaxLevel() {
        return maxLevel;
    }

    public final Material getGuiItem() {
        return guiItem;
    }

    public final Integer getGuiPosition() {
        return guiPosition;
    }

    public Map<Integer, Double> getCostPerLevel() {
        return costPerLevel;
    }

    /**
     * Returns level cost
     * @param level level you want to get cost
     * @return level cost
     */
    public final Double getLevelCost(final Integer level) {
        for (Integer lv : getCostPerLevel().keySet()) {
            if (level.equals(lv)) return getCostPerLevel().get(lv);
        }
        return 0.;
    }

    private void setupUpgrade() {

        // plugin.getUpgradeManagerInstance().addUpgrade(this);
        listenersToRegister();

    }

    public final SavageFactions getPlugin() {
        return plugin;
    }

}
