package com.massivecraft.factions.zcore.util;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.util.fm.Methods;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class ItemBuilder {

    private final ItemMeta meta;
    private final ItemStack item;

    public ItemBuilder(ItemStack item) {
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public ItemBuilder(Material material, int amount, int durability) {
        this(new ItemStack(material, amount, (short) durability));
    }

    public ItemBuilder(Material material, int amount) {
        this(material, amount, 0);
    }

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    public static List<String> color(List<String> string) {
        List<String> colored = new ArrayList<>();
        for (String line : string) {
            colored.add(Methods.pl(line));
        }
        return colored;
    }

    public ItemBuilder durability(short durability) {
        item.setDurability(durability);
        return this;
    }

    public ItemBuilder lore(String... lore) {
        if (lore != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String line : lore) {
                arrayList.add(Methods.pl(line));
            }
            this.meta.setLore(arrayList);
        }
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        meta.setLore(color(lore));
        return this;
    }

    public ItemBuilder name(String name) {
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

    public ItemBuilder amount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemBuilder glowing(boolean status) {
        if (status) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        } else {
            meta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.removeEnchant(Enchantment.DURABILITY);
        }
        return this;
    }

    public ItemBuilder addLineToLore(String line) {
        List<String> lore = meta.getLore();
        lore.add(Methods.pl(line));
        meta.setLore(lore);
        return this;
    }


}