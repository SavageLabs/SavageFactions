package com.massivecraft.factions.zcore.fupgrades.upgrades;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.zcore.fupgrades.FactionUpgrade;
import com.massivecraft.factions.zcore.fupgrades.UpgradeListener;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class SpawnerUpgrade extends FactionUpgrade {

    public SpawnerUpgrade() {
        super("spawner");
    }

    @Override
    public Set<Listener> listenersToRegister() {

        Set<Listener> upgradeListeners = new HashSet<>();
        upgradeListeners.add(new UpgradeListener());

        return upgradeListeners;

    }

}
