package com.massivecraft.factions.zcore.persist.serializable;

import com.massivecraft.factions.util.XMaterial;
import com.massivecraft.factions.zcore.util.ItemBuilder;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ConfigurableItem {

    private String name;
    private List<String> lore;
    private XMaterial material;
    private int amount;

    public ConfigurableItem(String name, List<String> lore, XMaterial material, int amount) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.amount = amount;
    }


    public ItemStack buildItemStack(boolean isSelected) {
        return new ItemBuilder(material.parseItem()).name(name).lore(lore).glowing(isSelected).amount(amount).build();
    }


}
