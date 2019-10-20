package com.massivecraft.factions.cmd;


import com.massivecraft.factions.*;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.util.WarmUpUtil;
import com.massivecraft.factions.zcore.ffly.FlyParticle;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CmdFly extends FCommand {


    public static ConcurrentHashMap<String, Boolean> flyMap = new ConcurrentHashMap<String, Boolean>();
    public static BukkitTask particleTask = null;

    public CmdFly() {
        super();
        this.aliases.add("fly");
        this.optionalArgs.put("on/off", "flip");

        this.requirements = new CommandRequirements.Builder(Permission.FLY)
                .playerOnly()
                .memberOnly()
                .build();
    }

    public static void startParticles() {

        particleTask = Bukkit.getScheduler().runTaskTimerAsynchronously(SavageFactions.plugin, () -> {
            for (String name : flyMap.keySet()) {
                Player player = Bukkit.getPlayer(name);
                if (player == null) continue;
                if (!player.isFlying()) continue;
                if (!SavageFactions.plugin.mc17) {
                    if (player.getGameMode() == GameMode.SPECTATOR) continue;
                }

                FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);
                if (fplayer.isVanished()) continue;

                FlyParticle selectedParticle = fplayer.getSelectedParticle();
                if (selectedParticle == null) {
                    // This is so we can gracefully accept people flying through autoenable.
                    selectedParticle = FlyParticle.WHITE_CLOUD;
                }
                selectedParticle.getData().display(player.getLocation().add(0, -0.35, 0));

            }
            if (flyMap.isEmpty()) {
                particleTask.cancel();
                particleTask = null;
            }
        }, 10L, 3L);
    }

    public static boolean checkBypassPerms(FPlayer fme, Player me, Faction toFac) {

        if (Conf.denyFlightIfInNoClaimingWorld && !Conf.worldsNoClaiming.isEmpty() && Conf.worldsNoClaiming.stream().anyMatch(me.getWorld().getName()::equalsIgnoreCase)) return false;
        if (toFac != fme.getFaction()) {
            if (!me.hasPermission("factions.fly.wilderness") && toFac.isWilderness() || !me.hasPermission("factions.fly.safezone") && toFac.isSafeZone() || !me.hasPermission("factions.fly.warzone") && toFac.isWarZone()) {
                fme.msg(TL.COMMAND_FLY_NO_ACCESS, toFac.getTag(fme));
                return false;
            }
            Access access = toFac.getAccess(fme, PermissableAction.FLY);
            if ((!(me.hasPermission("factions.fly.enemy") || access == Access.ALLOW)) && toFac.getRelationTo(fme.getFaction()) == Relation.ENEMY) {
                fme.msg(TL.COMMAND_FLY_NO_ACCESS, toFac.getTag(fme));
                return false;
            }
            if (!(me.hasPermission("factions.fly.ally") || access == Access.ALLOW) && toFac.getRelationTo(fme.getFaction()) == Relation.ALLY) {
                fme.msg(TL.COMMAND_FLY_NO_ACCESS, toFac.getTag(fme));
                return false;
            }
            if (!(me.hasPermission("factions.fly.truce") || access == Access.ALLOW) && toFac.getRelationTo(fme.getFaction()) == Relation.TRUCE) {
                fme.msg(TL.COMMAND_FLY_NO_ACCESS, toFac.getTag(fme));
                return false;
            }

            if (!(me.hasPermission("factions.fly.neutral") || access == Access.ALLOW) && toFac.getRelationTo(fme.getFaction()) == Relation.NEUTRAL && !isSystemFaction(toFac)) {
                fme.msg(TL.COMMAND_FLY_NO_ACCESS, toFac.getTag(fme));
                return false;
            }

            return me.hasPermission("factions.fly") && (access != Access.DENY || toFac.isSystemFaction());
        }
        return true;
    }

    public static Boolean isSystemFaction(Faction faction) {
        return faction.isSafeZone() ||
                faction.isWarZone() ||
                faction.isWilderness();
    }

    public static void disableFlight(final FPlayer fme) {
        fme.setFlying(false);
        flyMap.remove(fme.getPlayer().getName());
    }



    public boolean isInFlightChecker(Player player) {
        return flyMap.containsKey(player.getName());
    }

    @Override
    public void perform(CommandContext context) {
        // Disabled by default.
        if (!SavageFactions.plugin.getConfig().getBoolean("enable-faction-flight", false)) {
            context.fPlayer.msg(TL.COMMAND_FLY_DISABLED);
            return;
        }

        if (Conf.enableFlyParticles && context.fPlayer.getSelectedParticle() == null) {
            context.msg(TL.COMMAND_PARTICLE_NO_SELECTED_PARTICLE);
            return;
        }
        FLocation myfloc = new FLocation(context.player.getLocation());
        Faction toFac = Board.getInstance().getFactionAt(myfloc);
        if (!checkBypassPerms(context.fPlayer, context.player, toFac)) return;
        if (!context.player.hasPermission("factions.fly.bypassnearbyenemycheck") && context.fPlayer.checkIfNearbyEnemies()) {
            return;
        }

        if (context.args.size() == 1) {
            toggleFlight(context.argAsBool(0), context.fPlayer, context);
        } else {
            toggleFlight(context.fPlayer.isFlying(), context.fPlayer, context);
        }
    }

    private void toggleFlight(final boolean toggle, final FPlayer fme, CommandContext context) {
        if (toggle) {
            fme.setFlying(false);
            flyMap.remove(fme.getPlayer().getName());
            return;
        }


        if (fme.canFlyAtLocation())
            context.doWarmUp(WarmUpUtil.Warmup.FLIGHT, TL.WARMUPS_NOTIFY_FLIGHT, "Fly", () -> {
                fme.setFlying(true);
                flyMap.put(fme.getPlayer().getName(), true);
                if (particleTask == null) {
                    if (Conf.enableFlyParticles) {
                        startParticles();
                    }
                }
            }, SavageFactions.plugin.getConfig().getLong("warmups.f-fly", 0));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_FLY_DESCRIPTION;
    }

}
