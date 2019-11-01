package com.massivecraft.factions.zcore.fshop;

import com.massivecraft.factions.zcore.persist.serializable.ConfigurableItem;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ShopItem {

    private ConfigurableItem item;
    private List<String> commands;
    private int cost;


    public ShopItem(ConfigurableItem item, List<String> commands, int cost) {
        this.item = item;
        this.commands = commands;
        this.cost = cost;
    }


    public ConfigurableItem getItem() {
        return item;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void processCommands(Player contextPlayer) {
        commands.forEach(command -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command
                .replace("{player}", contextPlayer.getName())
                .replace("{uuid}", contextPlayer.getUniqueId().toString())
        ));
    }

    public int getCost() {
        return cost;
    }
}
