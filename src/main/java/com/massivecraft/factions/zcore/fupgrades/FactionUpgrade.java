package com.massivecraft.factions.zcore.fupgrades;

import com.cryptomorin.xseries.XMaterial;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.addon.upgradeaddon.Upgrade;
import com.massivecraft.factions.util.Placeholder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public abstract class FactionUpgrade extends Upgrade {
    
    protected FactionUpgrade(String upgradeName){

        super(upgradeName);

        int maxLevel = 0;

        for (String levelString : SavageFactions.plugin.getConfig().getConfigurationSection("fupgrades.upgrades." + this.getUpgradeName() + ".levels").getKeys(false)) {

            Integer level = Integer.parseInt(levelString);

            this.getCostPerLevel().put(level, SavageFactions.plugin.getConfig().getInt("fupgrades.upgrades." + this.getUpgradeName() + ".levels." + level + ".cost"));

            maxLevel++;

        }

        this.setMaxLevel(maxLevel);

        this.setGuiPosition(SavageFactions.plugin.getConfig().getInt("fupgrades.upgrades." + this.getUpgradeName() + ".displayitem.slot"));

        ItemStack item = new ItemStack(XMaterial.matchXMaterial(SavageFactions.plugin.getConfig().getString("fupgrades.upgrades." + this.getUpgradeName() + ".displayitem.type")).get().parseMaterial());
        ItemMeta guiItemMeta = item.getItemMeta();
        guiItemMeta.setDisplayName(SavageFactions.plugin.color(SavageFactions.plugin.getConfig().getString("fupgrades.upgrades." + this.getUpgradeName() + ".displayitem.name")));
        guiItemMeta.setLore(SavageFactions.plugin.colorList(SavageFactions.plugin.getConfig().getStringList("fupgrades.upgrades." + this.getUpgradeName() + ".displayitem.lore")));
        item.setItemMeta(guiItemMeta);

        this.setGuiItem(item);

    }

    @Override
    public ItemStack buildGuiItem(Faction faction){

        ItemStack item = getGuiItem();
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(SavageFactions.plugin.color(SavageFactions.plugin.getConfig().getString("fupgrades.upgrades." + this.getUpgradeName() + ".displayitem.name")));
        itemMeta.setLore(SavageFactions.plugin.colorList(SavageFactions.plugin.replacePlaceholders(SavageFactions.plugin.getConfig().getStringList("fupgrades.upgrades." + this.getUpgradeName() + ".displayitem.lore"), new Placeholder("{level}", faction.getUpgrade(this) + ""))));
        item.setItemMeta(itemMeta);

        return item;

    }

}
