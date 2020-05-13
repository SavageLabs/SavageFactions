package com.massivecraft.factions;

import com.cryptomorin.xseries.XMaterial;
import com.massivecraft.factions.zcore.fshop.ShopItem;
import com.massivecraft.factions.zcore.persist.serializable.ConfigurableItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    private static transient Shop i = new Shop();

    public static String shopTitle = "&cFaction Shop";
    public static int rows = 3;

    public static ConfigurableItem backgroundItem = new ConfigurableItem("&7 ", Collections.emptyList(), XMaterial.BLUE_STAINED_GLASS_PANE, 1);

    public static Map<Integer, ShopItem> shopData = new HashMap<>();

    public static String notEnoughPoints = "&cYou dont have enough faction points";


    static {
        shopData.put(11, new ShopItem(new ConfigurableItem("&cChunkbuster", Arrays.asList("&cA powerful & magical item", "&cCost: 5 Points"), XMaterial.END_PORTAL_FRAME, 1),
                Arrays.asList("broadcast {player} bought a chunkbuster", "broadcast You probably should actually get a chunkbuster plugin and put in  command for giving one."), 5));
        shopData.put(12, new ShopItem(new ConfigurableItem("&eCrophopper", Arrays.asList("&eA powerful & magical item", "&cCost: 10 Points"), XMaterial.HOPPER, 1),
                Arrays.asList("broadcast {player} bought a crophopper", "broadcast You probably should actually get a crophopper plugin and put in  command for giving one."), 10));
        shopData.put(14, new ShopItem(new ConfigurableItem("&aSellWand", Arrays.asList("&aA powerful & magical item", "&aCost: 5 Points"), XMaterial.STICK, 1),
                Arrays.asList("broadcast {player} bought a sellwand", "broadcast You probably should actually get a sellwand plugin and put in  command for giving one."), 5));
        shopData.put(15, new ShopItem(new ConfigurableItem("&bCreeperEgg", Arrays.asList("&bSpawns 1 creeper", "&cCost: 2 Points"), XMaterial.CREEPER_SPAWN_EGG, 1),
                Arrays.asList("broadcast {player} bought a creeper spawn egg", "give {player} creeperegg 1"), 5));

    }

    public static void load() {
        SavageFactions.plugin.persist.loadOrSaveDefault(i, Shop.class, "shop");
    }

    public static void save() {
        SavageFactions.plugin.persist.save(i);
    }

    public static void saveSync() {
        SavageFactions.plugin.persist.saveSync(i);
    }
}
