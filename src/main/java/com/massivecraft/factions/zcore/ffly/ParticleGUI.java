package com.massivecraft.factions.zcore.ffly;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ParticleGUI {


    private Gui gui;

    public ParticleGUI(SavageFactions instance, String title, int rows) {
        gui = new Gui(instance, rows, ChatColor.translateAlternateColorCodes('&', title));
    }

    public void buildGUI(FPlayer fplayer) {
        PaginatedPane pane = new PaginatedPane(0, 0, 9, gui.getRows());
        List<GuiItem> particleEffectItems = new ArrayList<>();
       Conf.particleEffectSettings.forEach((particle, data) ->
               // TODO: Enchantment for isGlowing in itembuilder breaks itemstack equal check on 1.12.2. Fix it.
               particleEffectItems.add(new GuiItem(data.getItem().buildItemStack(false), inventoryClickEvent -> {
            inventoryClickEvent.setCancelled(true);
            fplayer.setSelectedParticle(particle);
            fplayer.msg(TL.COMMAND_PARTICLE_SELECTED_PARTICLE.toString().replace("{particle}", particle.name()));
        })));
        pane.populateWithGuiItems(particleEffectItems);
        gui.addPane(pane);
        gui.update();
        gui.show(fplayer.getPlayer());
    }


}
