package com.massivecraft.factions.addon.upgradeaddon;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Upgrade {

    private final transient SavageFactions plugin = SavageFactions.plugin;

    private String upgradeName;
    private Integer maxLevel;
    /**
     * Map representing each level cost
     */
    private Map<Integer, Integer> costPerLevel = new HashMap<>();
    private ItemStack guiItem;
    private Integer guiPosition;

    protected Upgrade(String upgradeName){
        this.upgradeName = upgradeName;
        setupUpgrade();
    }

    public Upgrade(String upgradeName, Integer maxLevel, Map<Integer, Integer> costPerLevel, ItemStack guiItem, Integer guiPosition){

        this.upgradeName = upgradeName;

        if (maxLevel < 1) throw new IllegalArgumentException("maxLevel must be a positive number.");

        this.maxLevel = maxLevel;

        if (costPerLevel.keySet().size() > maxLevel) {

            throw new IllegalArgumentException("You have exceeded maxLevel level in costPerLevel. "
                    + "Your maxLevel is " + maxLevel + " and your costPerLevel gets to level "
                    + costPerLevel.keySet().size() + " please remove one pair from costPerLevel or increment your maxLevel");

        }

        this.costPerLevel = costPerLevel;

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

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public final ItemStack getGuiItem() {
        return guiItem;
    }

    public void setGuiItem(ItemStack guiItem) {
        this.guiItem = guiItem;
    }

    public final Integer getGuiPosition() {
        return guiPosition;
    }

    public void setGuiPosition(Integer guiPosition) {
        this.guiPosition = guiPosition;
    }

    public Map<Integer, Integer> getCostPerLevel() {
        return costPerLevel;
    }

    /**
     * Returns level cost
     * @param level level you want to get cost
     * @return level cost
     */
    public final Integer getLevelCost(final Integer level) {
        for (Integer lv : getCostPerLevel().keySet()) {
            if (level.equals(lv)) return getCostPerLevel().get(lv);
        }
        return 0;
    }

    /**
     * Method called on level up.
     */
    public abstract void onLevelUp(Faction faction);

    private void setupUpgrade() {

        SavageFactions.plugin.getUpgradeManager().addUpgrade(this);

    }
    /**
     * Method to build the item that will appear in upgrade menu. You can return guiItem instance variable.
     * @param faction faction
     * @return ItemStack
     */
    public abstract ItemStack buildGuiItem(Faction faction);

    public final SavageFactions getPlugin() {
        return plugin;
    }

}
