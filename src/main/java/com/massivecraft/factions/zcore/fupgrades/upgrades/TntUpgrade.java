package com.massivecraft.factions.zcore.fupgrades.upgrades;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.addon.upgradeaddon.UpgradeManager;
import com.massivecraft.factions.zcore.fupgrades.FactionUpgrade;
import org.bukkit.event.Listener;

import java.util.Set;

public class TntUpgrade extends FactionUpgrade {

    public TntUpgrade(){
        super("tntbank");
    }

    @Override
    public Set<Listener> listenersToRegister() {
        return null;
    }

    @Override
    public void onLevelUp(Faction faction) {
        faction.setTntLimit(faction.getTntLimit() + SavageFactions.plugin.getConfig().getInt("fupgrades.upgrades." + "tntbank" + ".levels." + faction.getUpgrade(this) + ".boost"));
    }
}
