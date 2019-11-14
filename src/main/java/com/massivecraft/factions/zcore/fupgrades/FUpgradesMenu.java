package com.massivecraft.factions.zcore.fupgrades;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.massivecraft.factions.*;
import com.massivecraft.factions.addon.upgradeaddon.Upgrade;
import com.massivecraft.factions.util.XMaterial;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FUpgradesMenu {

    private Gui gui;

    public FUpgradesMenu(Faction f) {
        gui = new Gui(SavageFactions.plugin,
                SavageFactions.plugin.getConfig().getInt("fupgrades.MainMenu.rows", 3),
                SavageFactions.plugin.color(SavageFactions.plugin.getConfig().getString("fupgrades.MainMenu.Title").replace("{faction}", f.getTag())));
    }

    public void buildGUI(FPlayer fplayer) {
        PaginatedPane pane = new PaginatedPane(0, 0, 9, gui.getRows());
        List<GuiItem> GUIItems = new ArrayList<>();
        ItemStack dumby = buildDummyItem();
        // Fill background of GUI with dumbyitem & replace GUI assets after
        for (int x = 0; x <= (gui.getRows() * 9) - 1; x++) GUIItems.add(new GuiItem(dumby, e ->  e.setCancelled(true)));
        for (Upgrade upgrade : SavageFactions.plugin.getUpgradeManager().getUpgrades()) {
            if (upgrade.getGuiPosition() == -1) continue;
            GUIItems.set(upgrade.getGuiPosition(), new GuiItem(upgrade.buildGuiItem(fplayer.getFaction()), e -> {
                e.setCancelled(true);
                FPlayer fme = FPlayers.getInstance().getByPlayer((Player) e.getWhoClicked());
                if (fme.getFaction().getUpgrade(upgrade) == upgrade.getMaxLevel()) return;
                int cost = upgrade.getLevelCost(fme.getFaction().getUpgrade(upgrade)+1);
                if (fme.hasMoney(cost)) {
                    fme.takeMoney(cost);
                    if (upgrade == SavageFactions.plugin.getUpgradeManager().getUpgradeByName("chest")) updateChests(fme.getFaction());
                    if (upgrade == SavageFactions.plugin.getUpgradeManager().getUpgradeByName("power")) updateFactionPowerBoost(fme.getFaction());
                    fme.getFaction().setUpgrade(upgrade, fme.getFaction().getUpgrade(upgrade) + 1);
                    buildGUI(fme);
                }
            }));
            pane.populateWithGuiItems(GUIItems);
            gui.addPane(pane);
            gui.update();
            gui.show(fplayer.getPlayer());
        }
    }

    private void updateChests(Faction faction) {
        String invName = SavageFactions.plugin.color(Conf.fchestInventoryTitle);
        for (HumanEntity player : faction.getChestInventory().getViewers()) {
            if (player.getOpenInventory().getTitle().equalsIgnoreCase(invName)) //TODO Check if it's the same as : player.getInventory().getTitle()
                player.closeInventory();
        }
        int level = faction.getUpgrade(SavageFactions.plugin.getUpgradeManager().getUpgradeByName("chest"));
        int size = SavageFactions.plugin.getConfig().getInt("fupgrades.upgrades." + "chest" + ".levels." + (level+1) +  ".boost");
        faction.setChestSize(size * 9);
    }

    private void updateFactionPowerBoost(Faction f) {
        //Pillar nueva config
        double boost = SavageFactions.plugin.getConfig().getDouble("fupgrades.upgrades." + "power" + ".levels." + (f.getUpgrade(SavageFactions.plugin.getUpgradeManager().getUpgradeByName("power"))+ 1) +  ".boost");
        if (boost < 0) return;
        f.setPowerBoost(f.getPowerBoost() + boost);
    }

    private ItemStack buildDummyItem() {
        ConfigurationSection config = SavageFactions.plugin.getConfig().getConfigurationSection("fupgrades.MainMenu.DummyItem");
        ItemStack item = XMaterial.matchXMaterial(config.getString("Type")).parseItem();
        ItemMeta meta = item.getItemMeta();
        // meta is null for air.
        if (meta != null) {
            meta.setLore(SavageFactions.plugin.colorList(config.getStringList("Lore")));
            meta.setDisplayName(SavageFactions.plugin.color(config.getString("Name")));
            item.setItemMeta(meta);
        }
        return item;
    }
    private ItemStack enchant(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            item.setItemMeta(itemMeta);
        }
        return item;
    }
}
