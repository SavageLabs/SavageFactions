package com.massivecraft.factions.zcore.persist.serializable;

import com.massivecraft.factions.util.MultiversionMaterials;
import com.massivecraft.factions.zcore.util.ItemBuilder;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Item {

    private String name;
    private List<String> lore;
    private MultiversionMaterials material;
    private boolean isGlowing;
    private int amount;

    public Item(String name, List<String> lore, MultiversionMaterials material, boolean isGlowing, int amount) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.isGlowing = isGlowing;
        this.amount = amount;
    }


    public ItemStack getItem() {
        return new ItemBuilder(material.parseMaterial()).name(name).lore(lore).glowing(isGlowing).amount(amount).build();
    }


}
