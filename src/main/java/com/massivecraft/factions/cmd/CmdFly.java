package com.massivecraft.factions.cmd;

import com.massivecraft.factions.*;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.util.Particle.ParticleEffect;
import com.massivecraft.factions.util.WarmUpUtil;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.sql.BatchUpdateException;
import java.util.*;

public class CmdFly extends FCommand {


    public static HashMap<String,Boolean> flyMap = new HashMap<String,Boolean>();
    public static int id = -1;
    public static int flyid = -1;
    public CmdFly() {
        super();
        this.aliases.add("fly");

        this.optionalArgs.put("on/off", "flip");

        this.permission = Permission.FLY.node;
        this.senderMustBeMember = true;
        this.senderMustBeModerator = false;
    }

    @Override
    public void perform() {
        // Disabled by default.
        if (!P.p.getConfig().getBoolean("enable-faction-flight", false)) {
            fme.msg(TL.COMMAND_FLY_DISABLED);
            return;
        }

        FLocation myfloc = new FLocation(me.getLocation());
        if (Board.getInstance().getFactionAt(myfloc) != fme.getFaction()){
            fme.msg(TL.COMMAND_FLY_NO_ACCESS, Board.getInstance().getFactionAt(myfloc).getTag(fme));
            return;
        }
        List<Entity> entities = me.getNearbyEntities(16,256,16);
        for (int i = 0; i <= entities.size() -1;i++)
        {
            if (entities.get(i) instanceof Player)
            {
                Player eplayer = (Player) entities.get(i);
                FPlayer efplayer = FPlayers.getInstance().getByPlayer(eplayer);
                if (efplayer.getRelationTo(fme) == Relation.ENEMY)
                {
                   fme.msg(TL.COMMAND_FLY_CHECK_ENEMY);
                    return;
                }
            }
        }



        if (args.size() == 0) {
            if (!fme.canFlyAtLocation() && !fme.isFlying()) {
                Faction factionAtLocation = Board.getInstance().getFactionAt(fme.getLastStoodAt());
                fme.msg(TL.COMMAND_FLY_NO_ACCESS, factionAtLocation.getTag(fme));
                return;
            }

            toggleFlight(!fme.isFlying(),me);
        } else if (args.size() == 1) {
            if (!fme.canFlyAtLocation() && argAsBool(0)) {
                Faction factionAtLocation = Board.getInstance().getFactionAt(fme.getLastStoodAt());
                fme.msg(TL.COMMAND_FLY_NO_ACCESS, factionAtLocation.getTag(fme));
                return;
            }
            toggleFlight(argAsBool(0),me);
        }
    }

    public void startParticles(){
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(P.p, new Runnable() {
            @Override
            public void run() {
                for (String name : flyMap.keySet()) {
                    Player player = Bukkit.getPlayer(name);
                    if (player != null && player.isFlying()) {
                        ParticleEffect.CLOUD.display((float) 0.3,(float) 0.3,(float) 0.3,(float) 0.3,10,player.getLocation(),32);
                    }
                }
                if (flyMap.keySet().size() == 0){
                    Bukkit.getScheduler().cancelTask(id);
                    id = -1;
                }
            }
        },20L,20L);
    }

    public void startFlyCheck(){
        flyid = Bukkit.getScheduler().scheduleSyncRepeatingTask(P.p, new Runnable() {
            @Override
            public void run() {
                for (String name : flyMap.keySet()) {
                    Player player = Bukkit.getPlayer(name);
                    FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);

                    if (player == null || fPlayer == null) {
                        continue;
                    }

                    Faction myFaction = fPlayer.getFaction();
                    FLocation myFloc = new FLocation(player.getLocation());
                    if (Board.getInstance().getFactionAt(myFloc) != myFaction) {
                        fPlayer.setFlying(false);
                        flyMap.remove(name);
                        continue;
                    }

                    for (Entity e : player.getNearbyEntities(16, 255, 16)) {
                        if (e == null) { continue; }
                        if (e instanceof Player) {
                            Player eplayer = (((Player) e).getPlayer());
                            FPlayer efplayer = FPlayers.getInstance().getByPlayer(eplayer);
                            if (fme.getRelationTo(efplayer) == Relation.ENEMY) {
                                fPlayer.setFlying(false);
                                flyMap.remove(name);
                                fme.msg(TL.COMMAND_FLY_ENEMY_NEAR);
                                break;

                            }
                        }

                    }
                    if (flyMap.keySet().size() == 0) {
                        Bukkit.getScheduler().cancelTask(flyid);
                        flyid = -1;
                    }
                }
            }
        },20L,20L);
    }





    private void toggleFlight(final boolean toggle, final Player player) {
        if (!toggle) {
            fme.setFlying(false);
            flyMap.remove(player.getName());
            return;
        }
        
        this.doWarmUp(WarmUpUtil.Warmup.FLIGHT, TL.WARMUPS_NOTIFY_FLIGHT, "Fly", new Runnable() {
            @Override
            public void run() {
                fme.setFlying(true);
                flyMap.put(player.getName(),true);
                if (id == -1){
                    if (P.p.getConfig().getBoolean("ffly.Particles.Enabled")){
                        startParticles();
                    }
                }
                if (flyid == -1){
                    startFlyCheck();
                }
            }
        }, this.p.getConfig().getLong("warmups.f-fly", 0));
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_FLY_DESCRIPTION;
    }

}
