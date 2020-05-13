package com.massivecraft.factions.zcore.fchest;

import com.cryptomorin.xseries.XMaterial;
import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.zcore.util.ItemBuilder;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FChestGUI {

    private String title;
    private int rows;

    public FChestGUI(int rows, String title) {
        this.rows = rows;
        this.title = title;
    }


    public void build(ItemStack[] items, HumanEntity humanEntity) {
        Gui gui = new Gui(SavageFactions.plugin, rows, title);
        // Paginated because I want some way to be able to scroll between them later.
        PaginatedPane pane = new PaginatedPane(0, 0, 9, rows);
        List<GuiItem> guiItems = new ArrayList<>();
        for (ItemStack itemStack : items)
            guiItems.add(new GuiItem(itemStack, event -> event.setCancelled(true)));
        ItemStack dummyItem = new ItemBuilder(XMaterial.GLASS_PANE.parseItem()).name("&cEMPTY").build();
        for (int i = 0; i < 54; i++) {
            guiItems.add(new GuiItem(dummyItem, event -> event.setCancelled(true)));
        }
        pane.populateWithGuiItems(guiItems);
        gui.addPane(pane);
        gui.update();
        gui.show(humanEntity);
    }


}
