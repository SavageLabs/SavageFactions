package com.massivecraft.factions.zcore.fupgrades;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Placeholder;
import com.massivecraft.factions.util.XMaterial;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum UpgradeType {

    CHEST("Chest", 3),
    SPAWNER("Spawners", 3),
    EXP("EXP", 3),
    CROP("Crops", 3),
    MEMBER("Members", 3),
    POWER("Power", 3);

    private String id;
    private int maxLevel;

    UpgradeType(String id, int maxLevel) {
        this.id = id;
        this.maxLevel = maxLevel;
    }

    @Override
    public String toString() {
        return this.id;
    }

    public int getSlot() { return SavageFactions.plugin.getConfig().getInt("fupgrades.MainMenu." + this.id + ".DisplayItem.Slot"); }

    public int getMaxLevel() {
        return maxLevel;
    }

    public ItemStack buildAsset(Faction f) {
        ConfigurationSection config = SavageFactions.plugin.getConfig().getConfigurationSection("fupgrades.MainMenu." + this.id + ".DisplayItem");
        ItemStack item = XMaterial.matchXMaterial(config.getString("Type")).parseItem();
        int level = f.getUpgrade(this);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(SavageFactions.plugin.colorList(SavageFactions.plugin.replacePlaceholders(config.getStringList("Lore"), new Placeholder("{level}", level + ""))));
        meta.setDisplayName(SavageFactions.plugin.color(config.getString("Name")));
        item.setItemMeta(meta);
        return updateLevelStatus(item, level);
    }

    private ItemStack updateLevelStatus(ItemStack item, int level) {
        if (level > 0) item = enchant(item);
        if (level >= 2) item.setAmount(level);
        return item;
    }

    private ItemStack enchant(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        item.setItemMeta(itemMeta);
        return item;
    }
}
