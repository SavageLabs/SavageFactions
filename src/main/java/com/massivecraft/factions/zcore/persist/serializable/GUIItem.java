package com.massivecraft.factions.zcore.persist.serializable;

import com.massivecraft.factions.util.MultiversionMaterials;

import java.util.List;

public class GUIItem extends Item {

    private int slot;

    public GUIItem(String name, List<String> lore, MultiversionMaterials material, boolean isGlowing, int amount, int slot) {
        super(name, lore, material, isGlowing, amount);
        this.slot = slot;
    }

    public int getSlot() {
        return this.slot;
    }

}
