package com.massivecraft.factions.zcore.fshop;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.Shop;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ShopGUI {

    private Gui gui;

    public ShopGUI(SavageFactions instance, String title, int rows) {
        gui = new Gui(instance, rows, ChatColor.translateAlternateColorCodes('&', title));
    }

    public void buildGUI(FPlayer fplayer) {
        PaginatedPane pane = new PaginatedPane(0, 0, 9, gui.getRows());
        List<GuiItem> shopGUI = new ArrayList<>();
        ItemStack backgroundPane = Shop.backgroundItem.buildItemStack(false);
        for (int x = 0; x <= (gui.getRows() * 9) - 1; x++) shopGUI.add(new GuiItem(backgroundPane, e -> e.setCancelled(true)));
        Shop.shopData.forEach((slot, data) ->
                // TODO: Enchantment for isGlowing in itembuilder breaks itemstack equal check on 1.12.2. Fix it.
                shopGUI.add(slot, new GuiItem(data.getItem().buildItemStack(false), inventoryClickEvent -> {
                    inventoryClickEvent.setCancelled(true);
                    if (fplayer.getFaction().getPoints() >= data.getCost()) {
                        fplayer.getFaction().takePoints(data.getCost());
                        data.processCommands(fplayer.getPlayer());
                    } else {
                        fplayer.sendMessage(SavageFactions.plugin.color(Shop.notEnoughPoints));
                    }
                })));
        pane.populateWithGuiItems(shopGUI);
        gui.addPane(pane);
        gui.update();
        gui.show(fplayer.getPlayer());
    }


}
