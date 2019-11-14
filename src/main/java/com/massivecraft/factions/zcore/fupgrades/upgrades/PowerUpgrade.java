package com.massivecraft.factions.zcore.fupgrades.upgrades;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.zcore.fupgrades.FactionUpgrade;
import com.massivecraft.factions.zcore.fupgrades.UpgradeListener;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.Set;

public class PowerUpgrade extends FactionUpgrade {

    public PowerUpgrade() {
        super("power");
    }

    @Override
    public Set<Listener> listenersToRegister() {

        Set<Listener> upgradeListeners = new HashSet<>();
        upgradeListeners.add(new UpgradeListener());

        return upgradeListeners;

    }

    @Override
    public ItemStack buildGuiItem(Faction f){

        /**ConfigurationSection config = SavageFactions.plugin.getConfig().getConfigurationSection("fupgrades.MainMenu." + this.getUpgradeName() + ".DisplayItem");
        ItemStack item = XMaterial.matchXMaterial(config.getString("Type")).parseItem();
        int level = f.getUpgrade(this);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setLore(SavageFactions.plugin.colorList(SavageFactions.plugin.replacePlaceholders(config.getStringList("Lore"), new Placeholder("{level}", level + ""))));
            meta.setDisplayName(SavageFactions.plugin.color(config.getString("Name")));
            item.setItemMeta(meta);
        }**/
        ItemMeta meta = getGuiItem().getItemMeta();

        return getGuiItem();

    }

}
