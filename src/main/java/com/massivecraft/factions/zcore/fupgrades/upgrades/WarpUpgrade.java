package com.massivecraft.factions.zcore.fupgrades.upgrades;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.zcore.fupgrades.FactionUpgrade;
import org.bukkit.event.Listener;

import java.util.Set;

public class WarpUpgrade extends FactionUpgrade {

    public WarpUpgrade(){ super("warp"); }

    @Override
    public Set<Listener> listenersToRegister() {
        return null;
    }

    @Override
    public void onLevelUp(Faction faction) {
        faction.setMaxWarps(faction.getMaxWarps() + SavageFactions.plugin.getConfig().getInt("fupgrades.upgrades." + "warp" + ".levels." + faction.getUpgrade(this) + ".boost"));
    }
}
