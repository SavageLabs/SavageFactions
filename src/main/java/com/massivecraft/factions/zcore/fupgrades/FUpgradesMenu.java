package com.massivecraft.factions.zcore.fupgrades;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.util.XMaterial;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FUpgradesMenu {

    private Gui gui;

    public FUpgradesMenu(Faction f) {
        gui = new Gui(SavageFactions.plugin,
                3,
                SavageFactions.plugin.color(SavageFactions.plugin.getConfig().getString("fupgrades.MainMenu.Title").replace("{faction}", f.getTag())));
    }

    public void buildGUI(FPlayer fplayer) {
        PaginatedPane pane = new PaginatedPane(0, 0, 9, gui.getRows());
        List<GuiItem> GUIItems = new ArrayList<>();
        ItemStack dumby = buildDummyItem();
        // Fill background of GUI with dumbyitem & replace GUI assets after
        for (int x = 0; x <= (gui.getRows() * 9) - 1; x++) GUIItems.add(new GuiItem(dumby, e ->  e.setCancelled(true)));
        Arrays.asList(UpgradeType.values()).forEach(value -> {
            GUIItems.set(value.getSlot(), new GuiItem(value.buildAsset(fplayer.getFaction()), e -> {
                e.setCancelled(true);
                FPlayer fme = FPlayers.getInstance().getByPlayer((Player) e.getWhoClicked());
                if (fme.getFaction().getUpgrade(value) == value.getMaxLevel()) return;
                int cost = SavageFactions.plugin.getConfig().getInt("fupgrades.MainMenu." + value.toString() + ".Cost.level-" + (fme.getFaction().getUpgrade(value) + 1));
                if (hasMoney(fme, cost)) {
                    takeMoney(fme, cost);
                    if (value == UpgradeType.CHEST) updateChests(fme.getFaction());
                    fme.getFaction().setUpgrade(value, fme.getFaction().getUpgrade(value) + 1);
                    fme.getPlayer().closeInventory();
                    buildGUI(fme);
                } else {
                    fme.msg(TL.GENERIC_NOTENOUGHMONEY);
                }
            }));
            pane.populateWithGuiItems(GUIItems);
            gui.addPane(pane);
            gui.update();
            gui.show(fplayer.getPlayer());
        });
    }

    private boolean hasMoney(FPlayer fme, int amt) {
        return fme.hasMoney(amt);
    }

    private void takeMoney(FPlayer fme, int amt) {
        fme.takeMoney(amt);
    }

    private void updateChests(Faction faction) {
        String invName = SavageFactions.plugin.color(SavageFactions.plugin.getConfig().getString("fchest.Inventory-Title"));

        for (Player player : faction.getOnlinePlayers()) {
            if (player.getOpenInventory().getTitle().equalsIgnoreCase(invName)) //TODO Check if it's the same as : player.getInventory().getTitle()
                player.closeInventory();
        }

        int level = faction.getUpgrade(UpgradeType.CHEST);
        int size = SavageFactions.plugin.getConfig().getInt("fupgrades.MainMenu.Chest.Chest-Size.level-" + level);
        faction.setChestSize(size * 9);
    }


    private ItemStack buildDummyItem() {
        ConfigurationSection config = SavageFactions.plugin.getConfig().getConfigurationSection("fupgrades.MainMenu.DummyItem");
        ItemStack item = XMaterial.matchXMaterial(config.getString("Type")).parseItem();
        ItemMeta meta = item.getItemMeta();
        meta.setLore(SavageFactions.plugin.colorList(config.getStringList("Lore")));
        meta.setDisplayName(SavageFactions.plugin.color(config.getString("Name")));
        item.setItemMeta(meta);
        return item;
    }
}
