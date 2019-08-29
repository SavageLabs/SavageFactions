package com.massivecraft.factions.zcore.fupgrades;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.massivecraft.factions.*;
import com.massivecraft.factions.util.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
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
        Bukkit.getScheduler().runTaskAsynchronously(SavageFactions.plugin, () -> {
            PaginatedPane pane = new PaginatedPane(0, 0, 9, gui.getRows());
            List<GuiItem> GUIItems = new ArrayList<>();
            ItemStack dumby = buildDummyItem();
            // Fill background of GUI with dumbyitem & replace GUI assets after
            for (int x = 0; x <= (gui.getRows() * 9) - 1; x++)
                GUIItems.add(new GuiItem(dumby, e -> e.setCancelled(true)));
            for (UpgradeType value : UpgradeType.values()) {
                if (value.getSlot() == -1) continue;
                GUIItems.set(value.getSlot(), new GuiItem(value.buildAsset(fplayer.getFaction()), e -> {
                    e.setCancelled(true);
                    FPlayer fme = FPlayers.getInstance().getByPlayer((Player) e.getWhoClicked());
                    if (fme.getFaction().getUpgrade(value) == value.getMaxLevel()) return;
                    int cost = SavageFactions.plugin.getConfig().getInt("fupgrades.MainMenu." + value.toString() + ".Cost.level-" + (fme.getFaction().getUpgrade(value) + 1));
                    if (fme.hasMoney(cost)) {
                        fme.takeMoney(cost);
                        if (value == UpgradeType.CHEST) updateChests(fme.getFaction());
                        if (value == UpgradeType.POWER) updateFactionPowerBoost(fme.getFaction());
                        fme.getFaction().setUpgrade(value, fme.getFaction().getUpgrade(value) + 1);
                        buildGUI(fme);
                    }
                }));
                pane.populateWithGuiItems(GUIItems);
                gui.addPane(pane);
                gui.update();
                Bukkit.getScheduler().runTask(SavageFactions.plugin, () -> gui.show(fplayer.getPlayer()));
            }
        });
    }

    private void updateChests(Faction faction) {
        String invName = SavageFactions.plugin.color(Conf.fchestInventoryTitle);
        for (Player player : faction.getOnlinePlayers()) {
            if (player.getOpenInventory().getTitle().equalsIgnoreCase(invName)) //TODO Check if it's the same as : player.getInventory().getTitle()
                player.closeInventory();
        }
        int level = faction.getUpgrade(UpgradeType.CHEST);
        int size = SavageFactions.plugin.getConfig().getInt("fupgrades.MainMenu.Chest.Chest-Size.level-" + (level + 1));
        faction.setChestSize(size * 9);
    }

    private void updateFactionPowerBoost(Faction f) {
        double boost = SavageFactions.plugin.getConfig().getDouble("fupgrades.MainMenu.Power.Power-Boost.level-" + (f.getUpgrade(UpgradeType.POWER) + 1));
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
}
