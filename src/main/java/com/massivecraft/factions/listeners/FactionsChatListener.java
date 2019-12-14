package com.massivecraft.factions.listeners;

import com.massivecraft.factions.*;
import com.massivecraft.factions.struct.ChatMode;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.WarmUpUtil;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UnknownFormatConversionException;
import java.util.logging.Level;

public class FactionsChatListener implements Listener {

    // this is for handling slashless command usage and faction/alliance chat, set at lowest priority so Factions gets to them first
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerEarlyChat(AsyncPlayerChatEvent event) {
        Player talkingPlayer = event.getPlayer();
        String msg = event.getMessage();
        FPlayer me = FPlayers.getInstance().getByPlayer(talkingPlayer);
        ChatMode chat = me.getChatMode();
        // Is the player entering a password for a warp?
        if (me.isEnteringPassword()) {
            event.setCancelled(true);
            me.sendMessage(ChatColor.DARK_GRAY + event.getMessage().replaceAll("(?s).", "*"));
            if (me.getFaction().isWarpPassword(me.getEnteringWarp(), event.getMessage())) {
                doWarmup(me.getEnteringWarp(), me);
            } else {
                // Invalid Password
                me.msg(TL.COMMAND_FWARP_INVALID_PASSWORD);
            }
            me.setEnteringPassword(false, "");
            return;
        }

        //Is it a MOD chat
        if (chat == ChatMode.MOD) {
            Faction myFaction = me.getFaction();

            String message = String.format(Conf.modChatFormat, ChatColor.stripColor(me.getNameAndTag()), msg);

            //Send to all mods
            if (me.getRole().isAtLeast(Role.MODERATOR)) {
                // Iterates only through the factions' members so we enhance performance.
                for (FPlayer fplayer : myFaction.getFPlayers()) {
                    if (fplayer.getRole().isAtLeast(Role.MODERATOR)) {
                        fplayer.sendMessage(message);
                    } else if (fplayer.isSpyingChat() && me != fplayer) {
                        fplayer.sendMessage("[MCspy]: " + message);
                    }
                }
            } else {
                // Just in case player gets demoted while in faction chat.
                me.msg(TL.COMMAND_CHAT_MOD_ONLY);
                event.setCancelled(true);
                me.setChatMode(ChatMode.FACTION);
                return;
            }


            Bukkit.getLogger().log(Level.INFO, ChatColor.stripColor("Mod Chat: " + message));

            event.setCancelled(true);
        } else if (chat == ChatMode.FACTION) {
            Faction myFaction = me.getFaction();

            String message = String.format(Conf.factionChatFormat, me.describeTo(myFaction), msg);
            myFaction.sendMessage(message);

            Bukkit.getLogger().log(Level.INFO, ChatColor.stripColor("FactionChat " + myFaction.getTag() + ": " + message));

            //Send to any players who are spying chat
            for (FPlayer fplayer : FPlayers.getInstance().getOnlinePlayers()) {
                if (fplayer.isSpyingChat() && fplayer.getFaction() != myFaction && me != fplayer) {
                    fplayer.sendMessage("[FCspy] " + myFaction.getTag() + ": " + message);
                }
            }

            event.setCancelled(true);
        } else if (chat == ChatMode.ALLIANCE) {
            Faction myFaction = me.getFaction();

            String message = String.format(Conf.allianceChatFormat, ChatColor.stripColor(me.getNameAndTag()), msg);

            //Send message to our own faction
            myFaction.sendMessage(message);

            //Send to all our allies
            for (FPlayer fplayer : FPlayers.getInstance().getOnlinePlayers()) {
                if (myFaction.getRelationTo(fplayer) == Relation.ALLY && !fplayer.isIgnoreAllianceChat()) {
                    fplayer.sendMessage(message);
                } else if (fplayer.isSpyingChat() && me != fplayer) {
                    fplayer.sendMessage("[ACspy]: " + message);
                }
            }

            Bukkit.getLogger().log(Level.INFO, ChatColor.stripColor("AllianceChat: " + message));

            event.setCancelled(true);
        } else if (chat == ChatMode.TRUCE) {
            Faction myFaction = me.getFaction();

            String message = String.format(Conf.truceChatFormat, ChatColor.stripColor(me.getNameAndTag()), msg);

            //Send message to our own faction
            myFaction.sendMessage(message);

            //Send to all our truces
            for (FPlayer fplayer : FPlayers.getInstance().getOnlinePlayers()) {
                if (myFaction.getRelationTo(fplayer) == Relation.TRUCE) {
                    fplayer.sendMessage(message);
                } else if (fplayer.isSpyingChat() && fplayer != me) {
                    fplayer.sendMessage("[TCspy]: " + message);
                }
            }

            Bukkit.getLogger().log(Level.INFO, ChatColor.stripColor("TruceChat: " + message));
            event.setCancelled(true);
        }
    }


    // this is for handling insertion of the player's faction tag, set at highest priority to give other plugins a chance to modify chat first
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        // Are we to insert the Faction tag into the format?
        // If we are not to insert it - we are done.
        if (!Conf.chatTagEnabled || Conf.chatTagHandledByAnotherPlugin) {
            return;
        }

        Player talkingPlayer = event.getPlayer();
        String msg = event.getMessage();
        String eventFormat = event.getFormat();
        FPlayer me = FPlayers.getInstance().getByPlayer(talkingPlayer);

        if (!Conf.chatTagReplaceString.isEmpty() && eventFormat.contains(Conf.chatTagReplaceString)) {
            // we're using the "replace" method of inserting the faction tags
            if (eventFormat.contains(Conf.chatTagReplaceTitleString)) {
                eventFormat = eventFormat.replace(Conf.chatTagReplaceTitleString, me.getTitle());
            }
            if (!me.hasFaction() || !Conf.chatTagRelationColored) {
                eventFormat = eventFormat.replace(Conf.chatTagReplaceString, me.hasFaction() ? me.getChatTag().trim() : TL.NOFACTION_PREFIX.toString());
            } else {
                for (Player listeningPlayer : event.getRecipients()) {
                    FPlayer you = FPlayers.getInstance().getByPlayer(listeningPlayer);
                    String yourFormat = eventFormat.replace(Conf.chatTagReplaceString,me.getChatTag(you).trim());
                    try {
                        listeningPlayer.sendMessage(String.format(yourFormat, talkingPlayer.getDisplayName(), msg));
                    } catch (UnknownFormatConversionException ex) {
                        SavageFactions.plugin.log(Level.SEVERE, "UnknownFormatConversionException - ChatTagReplace RelationColored");
                        return;
                    }
                }

                // Messages are sent to players individually
                // This still leaves a chance for other plugins to pick it up
                event.getRecipients().clear();
            }
        }

        // Message with no relation color.
        event.setFormat(eventFormat);
    }

    private void doWarmup(final String warp, final FPlayer fme) {
        WarmUpUtil.process(fme, WarmUpUtil.Warmup.WARP, TL.WARMUPS_NOTIFY_TELEPORT, warp, () -> {
            Player player = Bukkit.getPlayer(fme.getPlayer().getUniqueId());
            if (player != null) {
                player.teleport(fme.getFaction().getWarp(warp).getLocation());
                fme.msg(TL.COMMAND_FWARP_WARPED, warp);
            }
        }, SavageFactions.plugin.getConfig().getLong("warmups.f-warp", 0));
    }

}