package com.massivecraft.factions.zcore.fupgrades;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.material.Crops;

import java.util.concurrent.ThreadLocalRandom;

public class UpgradeListener implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        Entity killer = e.getEntity().getKiller();
        if (killer == null || !(killer instanceof Player)) return;
        FLocation floc = new FLocation(e.getEntity().getLocation());
        Faction faction = Board.getInstance().getFactionAt(floc);
        if (!faction.isWilderness()) {
            int level = faction.getUpgrade(UpgradeType.EXP);
            double multiplier = SavageFactions.plugin.getConfig().getDouble("fupgrades.MainMenu.EXP.EXP-Boost.level-" + level);
            if (level != 0 && multiplier > 0.0) spawnMoreExp(e, multiplier);
        }
    }

    private void spawnMoreExp(EntityDeathEvent e, double multiplier) {
        double newExp = e.getDroppedExp() * multiplier;
        e.setDroppedExp((int) newExp);
    }

    @EventHandler
    public void onSpawn(SpawnerSpawnEvent e) {
        FLocation floc = new FLocation(e.getLocation());
        Faction factionAtLoc = Board.getInstance().getFactionAt(floc);
        if (!factionAtLoc.isWilderness()) {
            int level = factionAtLoc.getUpgrade(UpgradeType.SPAWNER);
            if (level == 0) return;
            lowerSpawnerDelay(e, SavageFactions.plugin.getConfig().getDouble("fupgrades.MainMenu.Spawners.Spawner-Boost.level-" + level));
        }
    }

    private void lowerSpawnerDelay(SpawnerSpawnEvent e, double multiplier) {
        int lowerby = (int) Math.round(e.getSpawner().getDelay() * multiplier);
        e.getSpawner().setDelay(e.getSpawner().getDelay() - lowerby);
    }

    @EventHandler
    public void onCropGrow(BlockGrowEvent e) {
        FLocation floc = new FLocation(e.getBlock().getLocation());
        Faction factionAtLoc = Board.getInstance().getFactionAt(floc);
        if (!factionAtLoc.isWilderness()) {
            int level = factionAtLoc.getUpgrade(UpgradeType.CROP);
            int chance = SavageFactions.plugin.getConfig().getInt("fupgrades.MainMenu.Crops.Crop-Boost.level-" + level);
            if (level == 0 || chance == 0) return;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            if (randomNum <= chance) growCrop(e);
        }
    }


    private void growCrop(BlockGrowEvent e) {
        if (e.getBlock().getType().equals(SavageFactions.plugin.CROPS)) {
            e.setCancelled(true);
            Crops c = new Crops(CropState.RIPE);
            BlockState bs = e.getBlock().getState();
            bs.setData(c);
            bs.update();
        }
        Block below = e.getBlock().getLocation().subtract(0, 1, 0).getBlock();
        if (below.getType() == SavageFactions.plugin.SUGAR_CANE_BLOCK) {
            Block above = e.getBlock().getLocation().add(0, 1, 0).getBlock();

            if (above.getType() == Material.AIR && above.getLocation().add(0, -2, 0).getBlock().getType() != Material.AIR) {
                above.setType(SavageFactions.plugin.SUGAR_CANE_BLOCK);
            }
        } else if (below.getType() == Material.CACTUS) {
            Block above = e.getBlock().getLocation().add(0, 1, 0).getBlock();

            if (above.getType() == Material.AIR && above.getLocation().add(0, -2, 0).getBlock().getType() != Material.AIR) {
                above.setType(Material.CACTUS);
            }
        }
    }

}
