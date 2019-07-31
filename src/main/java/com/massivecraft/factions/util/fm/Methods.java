package com.massivecraft.factions.util.fm;

import org.bukkit.ChatColor;

import java.util.List;

public class Methods {

    public static String pl(String line) {
        line = ChatColor.translateAlternateColorCodes('&', line);
        return line;
    }

    //colors a string list
    public static List<String> plList(List<String> lore) {
        for (int i = 0; i <= lore.size() - 1; i++) {
            lore.set(i, pl(lore.get(i)));
        }
        return lore;
    }
}
