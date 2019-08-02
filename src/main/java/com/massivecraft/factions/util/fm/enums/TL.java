package com.massivecraft.factions.util.fm.enums;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.text.SimpleDateFormat;

public enum TL {
    GENERIC_PREFIX("root.generic-prefix", "&8&l[&c&l!&8&l] "),
    GENERIC_COMMAND_DISABLED("root.generic-command-disabled", "&7This command is disabled."),
    GENERIC_CONFIG_RELOAD("root.generic-config-reload", "&7You have reloaded the plugin, It took &c{ms} &7to complete this task."),
    GENERIC_CONSOLE_ONLY("root.generic-console-only", "&7This command can only be used in console."),
    GENERIC_PLAYER_ONLY("root.generic-player-only", "&7You must be a player to use this command."),
    GENERIC_NO_CMD_PERMS("root.generic-no-cmd-perms", "&7You do not have permission to use this command."),
    GENERIC_NO_PLAYER_MATCH("root.generic-no-player-match", "&7No player match found for &c{target}&7."),
    GENERIC_NO_PLAYER_FOUND("root.generic-no-player-found", "&7No player named &c{target}&7 could be found."),
    GENERIC_ENABLED("root.generic-enabled", "&4Enabled"),
    GENERIC_DISABLED("root.generic-disabled", "&aDisabled"),
    GENERIC_ASK_LEADER("root.generic-faction-misc.generic-ask-leader", " Ask your leader to:"),
    GENERIC_YOU_SHOULD("root.generic-faction-misc.generic-you-should", "You should:"),
    GENERIC_YOU_MAY_WANT("root.generic-faction-misc.generic-you-may-want", "You may want to: "),
    GENERIC_TOO_FEW("root.generic-faction-misc.generic-args.generic-too-few", "&7Too few arguments. &7Use like this:"),
    GENERIC_TOO_MANY("root.generic-faction-misc.generic-args.generic-too-many", "&7Strange Argument, &c{arg}&7. Use the command like this:"),
    GENERIC_DEFAULT_DESCRIPTION("root.generic-faction-misc.generic-default-description", "&7Default Faction Description :("),
    GENERIC_OWNERS("root.generic-faction-misc.generic-owners", "&7Owner(s): &c{owners}"),
    GENERIC_PUBLIC_LAND("root.generic-faction-misc.generic-public-land", "&aPublic Faction Land"),
    GENERIC_FACTION_LESS("root.generic-faction-misc.generic-faction-less", "&7FactionLess"),
    GENERIC_SERVER_ADMIN("root.generic-faction-misc.generic-server-admin", "&4A Server Admin"),
    GENERIC_INFINITY("root.generic-faction-misc.generic-infinity", ""),
    GENERIC_NOT_ENOUGH_MONEY("root.generic-faction-misc.generic-not-enough-money", "&7You do not have enough money"),
    GENERIC_MONEY_TAKE("root.generic-faction-misc.generic-money-take", "&c{amount}&7 has been taken from your account."),
    GENERIC_PLACEHOLDER("<This is a placeholder for a message you should not see>"),
    // Factions WarmsUp
    WARMUP_FLIGHT("actions.commands-warmsup-notify.warmup-flight", "&7Flight will enable in &c{seconds} &7seconds."),
    WARMUP_TELEPORT("actions.commands-warmsup-notify.warmup-teleport", "&7You will teleport to &c{loc}&7 in &c{seconds}&7 seconds"),
    WARMUP_ALREADY("actions.commands-warmsup-notify.warmup-already", "&7You are already warming up."),
    WARMUP_CANCELLED("actions.commands-warmsup-notify.warmup-cancelled", "&7You have cancelled your warmup."),
    // Factions F Near
    CMD_MSG("commands.f-near.disabled.cmd-msg", "&7This command is disabled."),
    CMD_FORMAT("commands.f-near.cmd-format", "&c{playername} &8(&c{distance}&8)"),
    CMD_NO_AHOME("commands.f-ahome.cmd-no-home", "&c{target} does not have an f home."),
    CMD_AHOME_SUCCESS("commands.f-ahome.cmd-home-success", "&c{target} was sent to their f home."),
    CMD_AHOME_OFFLINE("commands.f-ahome.cmd-target-offline", "&c{target} is offline."),
    CMD_TARGET_AHOME_MSG("commands.f-ahome.cmd-target-send-msg", "&cYou were sent to your f home."),
    // Factions Alts
    CMD_FORMAT_F_ALTS("commands.f-alts.cmd-format", "&c{power} &7Power: &c{target} &7Last Seen: &c{timestamp}"),
    CMD_ALT_INVITE("commands.f-alts.cmd-alt-invite", "&c{player}&7 invited &c{target}&7 to your faction as an alt."),
    CMD_NOT_AN_ALT_KICK("commands.f-alts.cmd-not-an-alt-kick", "&7Player is not an alt."),
    CMD_NOT_A_MEMBER("commands.f-alts.cmd-not-a-member", "&7This player is not a member/alt of your faction."),
    // Factions Autoclaim
    AUTOCLAIM_ENABLE("commands.f-autoclaim.autoclaim-enable", "&7Now &cauto-claiming&7 land for &c{faction}&7."),
    AUTOCLAIM_DISABLED("commands.f-autoclaim.autoclaim-disabled", "&cAuto-Claiming&7 of land is now disabled."),
    AUTOCLAIM_REQUIRED_RANK("commands.f-autoclaim.autoclaim-required-rank", "&7You must be &c{rank}&7 in order to claim land."),
    AUTOCLAIM_DENY_OTHER_FACTION("commands.f-autoclaim.autoclaim-deny-other-faction", "&7You cannot claim land for &c{otherfaction}&7."),
    // Factions Bans
    CMD_BAN_TARGET("commands.f-ban.cmd-ban-target", "&7You were banned from &c{faction}&7."),
    CMD_SUCCESSFUL_BAN("commands.f-ban.cmd-successful-ban", "&c{target} &7has banned &c{banned}&7."),
    CMD_NO_BAN_SELF("commands.f-ban.cmd-no-ban-self", "&7You may not ban yourself."),
    CMD_INSUFFICIENT_RANK("commands.f-ban.cmd-insufficient-rank", "&7Your rank is not high enough to ban &c{target}&7."),
    CMD_ALREADY_BANNED("commands.f-ban.cmd-already-banned", "&7This player is already banned."),
    CMD_BANLIST_NOFACTION("", ""),
    CMD_BAN_HEADER("commands.f-banlist.cmd-ban-header", "&7There are &c{bans}&7 bans for &c{faction}&7."),
    CMD_BAN_ENTRY("commands.f-banlist.cmd-ban-entry", "&7"),
    CMD_BAN_NO_FACTION("commands.f-banlist.cmd-ban-no-faction", "&7You are not in a Faction."),
    CMD_BANLIST_INVALID("commands.f-banlist.cmd-invalid-ban-lookup", "&7The faction &c{faction} &7does not exist."),
    // Factions Boom
    CMD_PEACEFUL_ONLY("commands.f-boom.cmd-peaceful-only", "&7This command is only usable by factions which are specifically designated as peaceful."),
    CMD_BOOM_ENABLED("commands.f-boom.cmd-boom-enabled", "&c{target}&7 has &c{toggled}&7 explosions in your faction's territory."),
    // Factions Bypass
    CMD_BYPASS_ENABLE("commands.f-bypass.cmd-bypass-enable", "&7You have enabled admin bypass mode. You will be able to build or destroy anywhere."),
    CMD_BYPASS_ENABLE_LOG("commands.f-bypass.cmd-enable-log", " has ENABLED admin bypass mode."),
    CMD_BYPASS_DISABLE("commands.f-bypass.cmd-bypass-disable", "&7You have disabled admin bypass mode."),
    CMD_BYPASS_DISABLE_LOG("commands.f-bypass.cmd-disable-log", " has DISABLED admin bypass mode."),
    CMD_NOT_SET("commands.f-tpbanner.cmd-not-set", "&7Your faction does not have a &c&lWarBanner &7placed!"),
    CMD_SUCCESS("commands.f-tpbanner.cmd-success", "&cTeleporting to your faction's &c&lWarBanner&7."),
    // Factions Chat
    CMD_FCHAT_DISABLED("commands.f-chat.cmd-fchat-disabled", "&7The built in chats are disabled on this server."),
    CMD_INVALID_CHAT("commands.f-chat.cmd-invalid", "&7 Unrecognized Chat Mode, Please enter either &dA&7, &fP&7, &aF&7, &2T&7, &6M&7."),
    // Mod Only Chat
    CMD_MOD_ONLY_MODE("commands.f-chat.cmd-mod-only-mode", "&7Only mods can talk through this chat mode."),
    CMD_PUBLIC_MODE("commands.f-chat.cmd-chat-mode.cmd-public-mode", "&7Public Chat Mode"),
    CMD_ALLY_MODE("commands.f-chat.cmd-chat-mode.cmd-ally-mode", "&dAlliance Only Chat Mode."),
    CMD_TRUCE_MODE("commands.f-chat.cmd-chat-mode.cmd-truce-mode", "&aFaction Only Chat Mode."),
    CMD_FACTION_MODE("commands.f-chat.cmd-chat-mode.cmd-faction-mode", "&dMod Only Chat Mode."),
    // Factions ChatSpy
    CMD_CHATSPY_ENABLE("commands.f-chatspy.cmd-chatspy-enable", "&7you have enabled chat spying mode."),
    CMD_ENABLE_LOG_F_CHATSPY("commands.f-chatspy.cmd-enable-log", " has ENABLED chat spying mode."),
    CMD_CHATSPY_DISABLE("commands.f-chatspy.cmd-chatspy-disable", "&7You have disabled chat spying mode."),
    CMD_DISABLE_LOG_F_CHATSPY("commands.f-chatspy.cmd-disable-log", " has DISABLED chat spying mode."),
    // Factions Claiming
    CMD_INVALID_CLAIM_RADIUS("commands.f-claim.cmd-invalid-claim-radius", "&7If you specify a radius, It must be at least &c{radius}&7."),
    CMD_CLAIM_DENY("commands.f-claim.cmd-claim-deny", "&7You do not have permission to claim in a radius."),
    CMD_PROTECTED_LAND("commands.f-claim.cmd-protected-land", "&7This land is protected."),
    CMD_DISABLED_CLAIM_IN_WORLD("commands.f-claim.cmd-disabled-claim-in-world", "&7Sorry, this world has land claiming disabled."),
    CMD_CANNOT_CLAIM("commands.f-claim.cmd-cannot-claim", "&7You cannot claim land for &c{faction}&7."),
    CMD_ALREADY_OWN("commands.f-claim.cmd-already-own", "&c{faction}&7 already owns this land."),
    CMD_MUST_BE("commands.f-claim.cmd-must-be", "&7You must be &c{role}&7 to claim land."),
    CMD_MEMBERS("commands.f-claim.cmd-members", "&7Factions must have at least &c{members}&7 members to claim land."),
    CMD_POWER("commands.f-claim.cmd-power", "&7You cannot claim more land, You need more power!"),
    CMD_CLAIM_LIMIT("commands.f-claim.cmd-limit", "&7Claim Limit Reached, You cannot claim any more land!"),
    CMD_ALLY("commands.f-claim.cmd-ally", "&7You cannot claim the land of your allies"),
    CMD_CONTIGIOUS("commands.f-claim.cmd-contigious", "&7You can only claim additional land which is connected to your first claim or controlled by another faction!"),
    CMD_FACTION_CONTIGUOUS("commands.f-claim.cmd-faction-contiguous", "&7You can only claim additional land which is connected to your first claim."),
    CMD_PEACEFUL("commands.f-claim.cmd-peaceful", "&c{faction}&7 owns this land, Your faction is peaceful meaning you cannot overclaim land from other factions."),
    CMD_PEACEFUL_TARGET("commands.f-claim.cmd-peaceful-target", "&c{faction}&7 owns this land and is a peaceful faction, You cannot claim land from them."),
    CMD_THIS_IS_SPARTA("commands.f-claim.cmd-this-is-sparta", "&c{faction}&7 owns this land and is strong enough to keep it."),
    CMD_BORDER("commands.f-claim.cmd-border", "&7You must start claiming land at the border of the territory."),
    CMD_CLAIMED("commands.f-claim.cmd-claimed", "&c{target}&7 claimed land for &c{faction}&7 from &c{faction-2}&7."),
    CMD_CLAIMED_LOG("commands.f-claim.cmd-claimed-log", "&c{target} &7claimed land at &8(&c{coords}&8)&7 for the faction: &c{faction}"),
    CMD_OVER_CLAIM_DISABLED("commands.f-claim.cmd-over-claim-disabled", "&7Overclaiming has been disabled on this server."),
    CMD_TOO_CLOSE_TOO_OTHER_FACTION("commands.f-claim.cmd-too-close-too-other-faction", "&7Your claim is too close to another Faction, Buffer Required is &c{requiredbuffer}&7."),
    CMD_OUTSIDE_WORLD_BORDER("commands.f-claim.cmd-outside-world-border", "&7Your claim is outside the border."),
    CMD_OUTSIDE_BORDER_BUFFER("commands.f-claim.cmd-outside-border-buffer", "&7Your claim is outside the border, &c{distance}&7 chunks away from world edge required."),
    CMD_CLICK_TO_CLAIM("commands.f-claim.cmd-click-to-claim", "&7Click to try and claim &8(&c{loc-1}&7, &c{loc-2}&8)"),
    CMD_MAP_OUTSIDE_BORDER("commands.f-claim.cmd-map-outside-border", "&7This claim is outside the worldborder!"),
    CMD_YOU_ARE_HERE("commands.f-claim.cmd-you-are-here", "&7You are here."),
    CMD_NO_TERRITORY_PERMS("commands.f-claim.cmd-no-territory-perms", "&7You do not have permission from your faction leader to do this."),
    CMD_INVALID_LINECLAIM_RADIUS("commands.f-claimline.cmd-invalid-lineclaim-radius", "&7If you specify a distance, It must be at least &c{distance}&7."),
    CMD_CLAIMLINE_DENY("commands.f-claimline.cmd-claimline-deny", "&7You do not have permission to claim in a line."),
    // Factions Coords
    CMD_COORDS_MSG("commands.f-coords.cmd-coords-msg", "&c{target}&7's coords are &c{x}, {y}, {z}, &7in &c{world}"),
    // Factions Checkpoint
    CMD_CHECKPOINT_DISABLED("commands.f-checkpoint.cmd-checkpoint-disabled", "&7You cannot use the checkpoints while it is disabled."),
    CMD_CHECKPOINT_SET("commands.f-checkpoint.cmd-checkpoint-set", "&7You have set the faction checkpoint at your Location!"),
    CMD_CHECKPOINT_GO("commands.f-checkpoint.cmd-checkpoint-go", "&7Teleporting to Faction checkpoint."),
    CMD_CHECKPOINT_INVALID_LOCATION("commands.f-checkpoint.cmd-checkpoint-invalid-location", "&7Invalid Location, You can set checkpoints in y our"),
    CMD_CHECKPOINT_NOT_SET("commands.f-checkpoint.cmd-checkpoint-not-set", "&7You have to set the faction checkpoint first."),
    CMD_CHECKPOINT_CLAIMED("commands.f-checkpoint.cmd-checkpoint-claimed", "&7Your current faction checkpoint is claimed, Set a new one!"),
    // Factions Create
    CMD_FACTION_MUST_LEAVE("commands.f-create.must-leave", "&7You must leave your current faction first."),
    CMD_FACTION_NAME_IN_USE("commands.f-create.name-in-use", "&7That tag is already in use."),
    CMD_FACTION_CREATED("commands.f-create.created", "&c{target}&7 has created a new faction called &c{faction}&7."),
    CMD_FACTION_YOU_SHOULD("commands.f-create.you-should", "&7You should now do /f desc <desc>."),
    CMD_FACTION_CREATE_LOG("commands.f-create.cmd-create-log", " created a new faction: "),
    CMD_FACTION_CREATE_ERROR("commands.f-create.cmd-create-error", "&7There was an internal error while trying to create your faction, Please try again ( Check Console 2 )"),
    // Factions Deinvite
    CMD_CAN_DEINVITE("commands.f-deinvite.cmd-can-deinvite", "&7Players you can deinvite: "),
    CMD_CLICK_TO_DEINVITE("commands.f-deinvite.cmd-click-to-deinvite", "&7Click to revoke invite for &c{target}&7."),
    CMD_ALREADY_A_MEMBER("commands.f-deinvite.cmd-already-a-member", "&c{target}&7 is already a member of &c{faction}&7."),
    CMD_MIGHT_WANT_TO("commands.f-deinvite.cmd-might-want-to", "&7You might want to: &c{wantto}&7."),
    CMD_INVITE_REVOKE("commands.f-deinvite.cmd-invite-revoke", "&7{mod} revoked your invitation to {faction}&7."),
    CMD_INVITE_REVOKED("commands.f-deinvite.cmd-invite-revoked", "&7{mod} revoked {target}'s invitation."),
    // Factions Delwarp
    CMD_DELETED_WARP("commands.f-delwarp.cmd-deleted-warp", "&7Deleted Warp &c{warp}&7."),
    CMD_INVALID_WARP("commands.f-delwarp.cmd-invalid-warp", "&7Could not find warp &c{warp}&7."),
    // Factions Disband
    CMD_SYSTEM_FACTION("commands.f-disband.cmd-system-faction", "&7You cannot disband &2Wilderness&c, &eSafezone &7or &4Warzone."),
    CMD_PERM_FACTION("commands.f-disband.cmd-perm-faction", "&7This faction has been set as permanent, You cannot disband it."),
    CMD_YOUR_FACTION("commands.f-disband.cmd-broadcast-disband.cmd-your-faction", "&c{target}&7 disbanded your faction."),
    CMD_NOT_YOUR_FACTION("commands.f-disband.cmd-broadcast-disband.cmd-not-your-faction", "&c{target}&7 disbanded the faction &c{faction}&7."),
    CMD_BANK_TRANSFER("commands.f-disband.cmd-broadcast-disband.cmd-bank-transfer", "&7You have been given the factions bank which totals &c{value}&7."),
    CMD_PLAYER_DISBAND("commands.f-disband.cmd-broadcast-disband.cmd-player-disband", "&7You have disbanded your faction."),
    // Factions Fly
    CMD_FLIGHT_DISABLED("commands.f-fly.cmd-disabled", "&7Sorry, Faction Flight is disabled on this server."),
    CMD_CHANGE("commands.f-fly.cmd-change", "&7Faction Flight &c{toggled}&7."),
    CMD_COOLDOWN("commands.f-fly.cmd-cooldown", "&7You will not take fall damage for &c{amount} &7seconds."),
    CMD_DAMAGE("commands.f-fly.cmd-damage", "&7Faction Flight disabled due to entering combat."),
    CMD_OTHER_TERRITORY("commands.f-fly.cmd-anti-fly.cmd-other-territory", "&7Cannot fly in the territory of &c{faction}&7."),
    CMD_ANTI_EPEARL("commands.f-fly.cmd-anti-fly.cmd-anti-epearl", "&7Cannot throw pearls while flying!"),
    CMD_ENEMY_NEAR("commands.f-fly.cmd-enemy-checks.cmd-enemy-near", "&7Flight has been disabled, an enemy is nearby."),
    CMD_ENEMY_NEAR_ALERT("commands.f-fly.cmd-enemy-checks.cmd-enemy-near-alert", "&7Cannot fly here, an enemy is nearby."),
    // Factions Focus
    CMD_FOCUS_SAME_FACTION("commands.f-focus.cmd-focus-same-faction", "&7You may not focus players in your faction!"),
    CMD_CURRENTLY_FOCUSING("commands.f-focus.cmd-currently-focusing", "&7Your faction is now focusing on &c{focused}&7."),
    CMD_NO_LONGER_FOCUSING("commands.f-focus.cmd-no-longer-focusing", "&7Your faction is no longer focusing on &c{focused}&7."),
    // Factions Warps
    CMD_CLICK_TO_WARP("commands.f-warp.cmd-click-to-warp", "&7Click To Warp!"),
    CMD_FWARP_FORMAT("commands.f-warp.cmd-fwarp-format", "&7/f warp <warpname> &c[password]"),
    CMD_SUCCESSFUL_WARP("commands.f-warp.cmd-successful-warp", "&7Warped To &c{warp}&7."),
    CMD_WARP("commands.f-warp.cmd-invalid-warp.cmd-warp", "&7Could not find warp &c{invalid-warp}&7."),
    CMD_PASSWORD("commands.f-warp.cmd-invalid-warp.cmd-password", "&7Invalid Password!"),
    CMD_WARPS("commands.f-warp.cmd-warps", "&7Warps: "),
    CMD_REQUIRED("commands.f-warp.cmd-warp-password.cmd-required", "&7Warp Password:"),
    CMD_TIME_OUT("commands.f-warp.cmd-warp-password.cmd-time-out", "&7Warp Password Timed Out."),
    // Factions Perms
    CMD_PERMISSION("commands.f-perms.cmd-permission", "&7You do not have permission to edit faction perms."),
    CMD_DESCRIPTION("commands.f-perms.cmd-description", "&7Edit or list your Faction's permissions."),
    CMD_FPERMS_DENY_ACTION("commands.f-perms.cmd-fperms-deny-action", "&7The faction leader does not allow you to &c{action}&7."),
    CMD_RELATION("commands.f-perms.cmd-invalid.cmd-relation", "&7Invalid Relation Defined, Try something like Ally."),
    CMD_ACCESS("commands.f-perms.cmd-invalid.cmd-access", "&7Invalid Access Defined, Try something like Allow."),
    CMD_ACTION("commands.f-perms.cmd-invalid.cmd-action", "&7Invalid Action Defined, Try something like Build."),
    CMD_SET("commands.f-perms.cmd-invalid.cmd-set", "&7Set Permission &c{perm}&7 to &c{toggled}&7 for relation &c{relation}&7."),
    CMD_TOP("commands.f-perms.cmd-invalid.cmd-top", "RCT MEM OFF ALLY TRUCE NEUT ENEMY"),
    CMD_LOCKED("commands.f-perms.cmd-invalid.cmd-locked", "&cThis permission has been locked by the server."),
    // Factions Homes
    CMD_DISABLED_F_HOME("commands.f-home.cmd-disabled", "&7Faction Homes are disabled on this server."),
    CMD_TELEPORT_DISABLED("commands.f-home.cmd-teleport-disabled", "&7The ability to teleport to Faction Homes is disabled on this server."),
    CMD_NO_HOME_F_HOME("commands.f-home.cmd-no-home", "&7Your faction does not have a home."),
    CMD_ENEMY_TERRITORY_DENY("commands.f-home.cmd-enemy-territory-deny", "&7You cannot teleport your faction home while in the territory of an enemy."),
    CMD_WRONG_WORLD("commands.f-home.cmd-wrong-world", "&7You cannot teleport to your faction home while in a different world."),
    CMD_ENEMY_NEAR_F_HOME("commands.f-home.cmd-enemy-near", "&7You cannot teleport to your faction home while an enemy is within &c{radius} &7blocks of you."),
    CMD_BLOCKED("commands.f-home.cmd-blocked", "&7You may not teleport to a home that is claimed by &c{faction}&7."),
    // Factions Inspect
    CMD_DISABLED_MSG("commands.f-inspect.cmd-disabled-msg", "&7Inspection Mode is now disabled."),
    CMD_ENABLED_MSG("commands.f-inspect.cmd-enabled-msg", "&7Inspection Mode is now enabled."),
    CMD_NO_FAC_MSG("commands.f-inspect.cmd-no-fac-msg", "&7Inspection Mode is now disabled because you do not have a faction."),
    CMD_INSPECT_HEADER("commands.f-inspect.cmd-inspect-header", "&c&m---&7Inspect Data&c&m---&c//&7x:{x},y:{y},z:{z}"),
    CMD_INSPECT_ROW("commands.f-inspect.cmd-inspect-row", "&c{time} &7// &c{action} &7// &c{player} &7// &c{block-type}"),
    CMD_INSPECT_NO_DATE("commands.f-inspect.cmd-inspect-no-date", "&7No data was found!"),
    CMD_INSPECT_NOT_IN_CLAIM("commands.f-inspect.cmd-inspect-not-in-claim", "&7You can only inspect in your faction claims."),
    CMD_INSPECT_BYPASS("commands.f-inspect.cmd-inspect-bypass", "&7Inspecting in Bypass Mode."),
    // Factions Invite
    CMD_INVITED_YOU("commands.f-invite.cmd-invited-you", "&c{player}&7 has invited you to join &c{faction}&7."),
    CMD_INVITE_SENT("commands.f-invite.cmd-invite-sent", "&c{player}&7 invited &c{target}&7 to your faction."),
    CMD_ALREADY_INVITED("commands.f-invite.cmd-already-invited", "&c{target}&7 already has an invite pending."),
    CMD_ALREADY_MEMBER("commands.f-invite.cmd-already-member", "&c{target}&7 is already a member of &c{faction}&7."),
    CMD_BANNED_MEMBER("commands.f-invite.cmd-banned-member", "&c{target}&7 is banned from your faction, Invite is not being sent."),
    // Factions Join
    CMD_CANNOT_FORCE_JOIN("commands.f-join.cmd-cannot-force-join", "&7You do not have permission to move other players into a faction."),
    CMD_CANNOT_JOIN_SYSTEM_FACTION("commands.f-join.cmd-cannot-join-system-faction", "&7Players may only join normal factions, This is a system faction."),
    CMD_MAX_LIMIT("commands.f-join.cmd-max-limit", "&cThe faction &c{faction}&7 is at the limit of &c{allowed}&7 members so &c{target}&7 cannot join."),
    CMD_NEGATIVE_POWER_LEAVE("commands.f-join.cmd-negative-power-leave", "&c{target}&7 cannot join another faction with a negative power level."),
    CMD_REQUIRES_INVITE("commands.f-join.cmd-requires-invite", "&c{faction}&7 requires an invite to join."),
    CMD_TRIED_TO_JOIN("commands.f-join.cmd-tried-to-join", "&c{target}&7 tried to join your faction."),
    CMD_SUCCESS_JOIN("commands.f-join.cmd-success-join", "&c{target}&7 successfully joined &c{faction}&7."),
    CMD_FACTION_MOVED("commands.f-join.cmd-faction-moved", "&c{staff}&7 moved the player &c{target}&7 into the faction &c{faction}&7."),
    CMD_FACTION_BANNED("commands.f-join.cmd-faction-banned", "&7You are banned from &c{faction}&7 for &c{reason}&7."),
    CMD_FACTION_JOIN_LOG("commands.f-join.cmd-faction-join-log", ""),
    CMD_FACTION_MOVED_LOG("commands.f-join.cmd-faction-moved-log", ""),
    // Factions kick
    CMD_AVAILABLE_KICKS("commands.f-kick.cmd-available-kicks", "&cPlayers you can kick: "),
    CMD_CLICK_TO_KICK("commands.f-kick.cmd-click-to-kick", "&6Click To Kick "),
    CMD_CANNOT_KICK_SELF("commands.f-kick.cmd-cannot-kick-self", "&6You cannot kick yourself."),
    CMD_FACTIONLESS_PLAYER("commands.f-kick.cmd-factionless-player", "&6That player is not in a faction."),
    CMD_NOT_A_MEMBER_F_KICK("commands.f-kick.cmd-not-a-member", "&c{target}&7 is not a member of {faction}."),
    CMD_INSUFFICIENT_RANK_F_KICK("commands.f-kick.cmd-insufficient-rank", "&7Your rank is not high enough to kick this player."),
    CMD_NEGATIVE_POWER_KICK("commands.f-kick.cmd-negative-power-kick", "&7You cannot kick that member until their power is in the positives."),
    CMD_FACTION_SUCCESS_KICK("commands.f-kick.cmd-faction-success-kick", "&c{player}&7 has kicked &c{target}&7 from the faction!"),
    CMD_FACTION_YOU_ARE_KICKED("commands.f-kick.cmd-faction-you-are-kicked", "&c{player}&7 has kicked you from &c{faction}&7."),
    // Factions List
    CMD_FACTION_LIST("commands.f-list.cmd-faction-list", "&7Faction List "),
    CMD_ONLINE_FACTIONLESS("commands.f-list.cmd-online-factionless", "&7Online Factionless: "),
    // Factions Lock
    CMD_FAC_LOCKED("commands.f-lock.cmd-fac-locked", "&7Factions is now locked."),
    CMD_FAC_UNLOCKED("commands.f-lock.cmd-fac-unlocked", "&7Factions is now unlocked."),
    // Login
    CMD_TOGGLE_MSG("commands.f-login.cmd-toggle-msg", "&7Set login / logout notifications for Faction Members to: &c{toggled}&7."),
    // Map Auto Update
    CMD_UPDATE_ENABLED("commands.f-map.cmd-update-enabled", "&7Map Auto Update &aENABLED."),
    CMD_UPDATE_DISABLED("commands.f-map.cmd-update-disabled", "&7Map Auto Update &cDISABLED>"),
    // Map Height
    CMD_MAP_SET("commands.f-mapheight.cmd-map-set", "&7Set /f map lines to &c{lines}&7."),
    CMD_MAP_CURRENT("commands.f-mapheight.cmd-map-current", "&7Current Map-Height: &c{map-height}&7."),
    // Faction Ranks
    CMD_CANDIDATES("commands.faction-ranks-promo.cmd-candidates", "&7Players you can promote: "),
    CMD_CLICK_TO_PROMOTE("commands.faction-ranks-promo.cmd-click-to-promote", "&7Click to promote "),
    CMD_NOT_MEMBER("commands.faction-ranks-promo.cmd-not-member", "&c{target}&7 is not a member in your faction."),
    CMD_NOT_ADMIN("commands.faction-ranks-promo.cmd-not-admin", "&7You are not the faction admin."),
    CMD_TARGET_IS_SELF("commands.faction-ranks-promo.cmd-target-is-self", "&7You cannot promote yourself."),
    CMD_TARGET_IS_ADMIN("commands.faction-ranks-promo.cmd-target-is-admin", "&7The target is a faction admin, demote them first."),
    CMD_ADMIN_NOMEMBERS("commands.faction-ranks.promo.cmd-admin-nomembers", "&7No one else to promote, Please disband faction."),
    CMD_ADMIN_NOTADMIN("commands.faction-ranks.promo.cmd-admin-notadmin", "&7You are not the faction admin."),
    CMD_ADMIN_TARGETSELF("commands.faction-ranks.promo.cmd-admin-targetself", "&7The target player must not be yourself."),
    CMD_ADMIN_DEMOTES("commands.faction-ranks.promo.cmd-admin-demotes", "&7You have demoted &c{target} &7from the position of faction admin."),
    CMD_ADMIN_DEMOTED("commands.faction-ranks.promo.cmd-admin-demoted", "&7You have been demoted from the position of faction admin by &c{target}&7."),
    CMD_ADMIN_PROMOTES("commands.faction-ranks.promo.cmd-admin-promotes", "&7You have promoted &c{target}&7 to the position of faction admin."),
    CMD_ADMIN_PROMOTED("commands.faction-ranks.promo.cmd-admin-promoted", "&c{target}&7 gave &c{target-2}&7 the leadership of &c{faction}&7."),
    CMD_ADMIN_DESCRIPTION("", ""),
    // Faction Mods/CoLeaders
    CMD_REVOKES_MOD("commands.f-mod.cmd-revokes-mod", "&7You have removed moderator status from &c{target}&7."),
    CMD_REVOKED_MOD("commands.f-mod.cmd-revoked-mod", "&c{target}&7 is no longer a moderator in your faction."),
    CMD_MOD_PROMOTES("commands.f-mod.cmd-mod-promotes", "&c{target}&7 was promoted to moderator in your faction."),
    CMD_MOD_PROMOTED("commands.f-mod.cmd-mod-promoted", "&7You have promoted &c{target}&7 to moderator."),
    CMD_REVOKES_COLEADER("commands.f-coleader.cmd-revokes-coleader", "&7You have removed co-leader status from &c{target}&7."),
    CMD_REVOKED_COLEADER("commands.f-coleader.cmd-revoked-coleader", "&c{target}&7 is no longer a co-leader in your faction."),
    CMD_CO_PROMOTES("commands.f-coleader.cmd-co-promotes", "&c{target}&7 was promoted to co-leader in your faction."),
    CMD_CO_PROMOTED("commands.f-coleader.cmd-co-promoted", "&7You have promoted &c{target}&7 to co-leader."),
    // Modified Power
    CMD_POWER_ADDED("commands.f-modifypower.cmd-power-added", "&7Added &c{power}&7 power to &c{target}&7, New total rounded power: &c{totalpower}&7."),
    // Faction Economy
    CMD_MONEY_DESCRIPTION("commands.f-money.cmd-money-description", "&7Faction Money Commands."),
    CMD_MONEY_BALANCE("commands.f-money.cmd-money-balance", "&c{bank}&7 >> This is your current faction balance."),
    CMD_MONEY_DEPOSIT("commands.f-money.cmd-money-deposit", "&c{target}&7 deposited &c{amount} in the faction bank: &c{newamount}&7."),
    CMD_MONEY_TRANSFER_FACTION("commands.f-money.transfer-money.cmd-money-transfer-faction", "&c{target}&7 transferred &c{amount}&7 from the faction &c{faction} to the faction &c{faction-2}&7."),
    CMD_MONEY_TRANSFER_PLAYER("commands.f-money.transfer-money.cmd-money-transfer-player", "&c{target}&7 transferred &c{amount}&7 from the faction &c{faction} to the player &c{target}&7."),
    CMD_MONEY_TRANSFER_PLAYER_FACTION("commands.f-money.transfer-money.cmd-money-transfer-player-faction", "&c{target}&7 transferred &c{amount}&7 from the player &c{target} to the faction &c{faction}&7."),
    CMD_MONEY_WITHDRAW_FACTION("commands.f-money.transfer-money.cmd-money-withdraw-faction", "&c{target} withdrew &c{amount} from the faction bank: &c{value-taken}"),
    // Factions Opened
    CMD_OPENED_CHANGES("commands.f-open.cmd-opened-changes", "&c{target}&7 has changed the faction to be &c{toggled}&7."),
    CMD_OPENED_CHANGED("commands.f-open.cmd-opened-changed", "&7The faction &c{faction} is now &c{toggled}&7."),
    // F OwnerList
    CMD_FOWNER_DISABLED("commands.f-owner.cmd-fowner-disabled", "&7Sorry, Owned Areas are disabled on this server."),
    CMD_FOWNER_LIMIT("commands.f-owner.cmd-fowner-limit", "&7Sorry but you have reached the server's limit of &c{owned}&7 owned areas per faction."),
    CMD_FOWNER_WRONG_FACTION("commands.f-owner.cmd-fowner-wrong-faction", "&7This land is not claimed by your faction so you cannot set ownership of it."),
    CMD_FOWNER_NOT_CLAIMED("commands.f-owner.cmd-fowner-not-claimed", "&7This land is not claimed by a faction, Ownership is not possible."),
    CMD_FOWNER_NOT_MEMBER("commands.f-owner.cmd-fowner-not-member", "&c{target}&7 is not a member of this faction."),
    CMD_FOWNER_CLEARED("commands.f-owner.cmd-fowner-cleared", "&7You have cleared ownership for this claimed area."),
    CMD_FOWNER_REMOVED("commands.f-owner.cmd-fowner-removed", "&7You have removed ownership of this claimed land from &c{target}&7."),
    CMD_FOWNER_ADDED("commands.f-owner.cmd-fowner-added", "&7You have added &c{target} to the owner list for this claimed land."),
    CMD_NONE("commands.f-ownerlist.cmd-none", "&7No owners are set here, Everyone in the faction has access."),
    CMD_OWNERS("commands.f-ownerlist.cmd-owners", "&7Current Owner(s) of this land: &c{owners}&7."),
    // F Particles
    CMD_NO_SELECTED_PARTICLE("commands.f-particle.cmd-no-selected-particle", "&7You can select a particle using &c/f particle&7."),
    CMD_SELECTED_PARTICLE("commands.f-particle.cmd-selected-particle", "&7You have selected the &c{particle} particle type!"),
    // Faction Paypal
    CMD_DESCRIPTION_F_PAYPAL("commands.f-paypal-set.cmd-description", "&7Set the email of your faction to claim rewards."),
    CMD_PAYPAL_CREATED("commands.f-paypal-set.cmd-created", "&7Make sure to type &c/f <paypal/setpaypal> <email>&7."),
    CMD_SUCCESSFUL("commands.f-paypal-set.cmd-successful", "&7Successfully set your factions email - &c{email}&7."),
    CMD_DESCRIPTION_F_PAYPALSEE("commands.f-paypal-see.cmd-description", "View the specific factions paypal email with &c/f <seepaypal/getpaypal> <faction>&7."),
    CMD_PAYPAL("commands.f-paypal-see.cmd-faction.cmd-paypal", "&c{faction}'s &&faction has their paypal set to &c{email}&7."),
    CMD_NOT_SET_F_PAYPALSEE("commands.f-paypal-see.cmd-faction.cmd-not-set", "&c{faction}'s&7 paypal has not yet been set."),
    CMD_NO_FACTION("commands.f-paypal-see.cmd-faction.cmd-no-faction", "&c{target} &7 does not have a faction."),
    // Faction Peaceful
    CMD_FPEACEFUL_DESCRIPTION("commands.f-peaceful.cmd-fpeaceful-description", "&7Set a faction to peaceful."),
    CMD_FPEACEFUL_YOURS("commands.f-peaceful.cmd-fpeaceful-yours", "&c{target}&7 has &c{relation-changed}&7 your faction."),
    CMD_FPEACEFUL_OTHER("commands.f-peaceful.cmd-fpeaceful-other", "&c{target}&7 has &c{relation-changed}&7 the faction &c{faction}&7."),
    CMD_FPEACEFUL_REVOKE("commands.f-peaceful.cmd-fpeaceful-revoke", "&7Granted peaceful status to"),
    CMD_FPEACEFUL_GRANT("commands.f-peaceful.cmd-fpeaceful-grant", "&7Removed peaceful status from"),
    // Faction Permanent
    CMD_FPERMN_DESCRIPTION("commands.f-permanent.cmd-fpermn-description", "&7Toggle permanent faction power option."),
    CMD_FPERMN_GRANT("commands.f-permanent.cmd-fpermn-grant", "&7Added permanentpower status to"),
    CMD_FPERMN_REVOKE("commands.f-permanent.cmd-fpermn-revoke", "&7Removed permanentpower status from"),
    CMD_FPERMN_YOURS("commands.f-permanent.cmd-fpermn-yours", "&7You &c{power} {status}&7."),
    CMD_FPERMN_OTHER("commands.f-permanent.cmd-fpermn-other", "&c{power} {status} &7your faction."),
    // Faction Promotions
    CMD_DESCRIPTION_F_PROMOTE("commands.f-promote.cmd-description", "/f promote <name>"),
    CMD_COMMAND_ADMIN_NOMEMBERS("commands.f-promote.cmd-admin-nomembers", "&7No one else to promote, Please disband faction."),
    CMD_FPROMO_SUCCESS("commands.f-promote.cmd-fpromo-success", "&7You have successfully promoted &c{target} to &c{role}&7."),
    CMD_PROMOTE_TARGET("&7You have been promoted to &c{role}&7."),
    CMD_ADMIN("commands.f-promote.cmd-co-leader.cmd-admin", "&7"),
    CMD_WRONG_FACTION("commands.f-promote.cmd-wrong-faction", "&c{target}&7 is not a part of your faction."),
    CMD_NOT_THAT_PLAYER("commands.f-promote.cmd-not-that-player", "&7That player cannot be promoted."),
    CMD_NOT_ALLOWED("commands.f-promote.cmd-not-allowed", "&7You cannot promote to the same rank as yourself."),
    CMD_NOT_SELF("commands.f-promote.cmd-not-self", "&7You cannot manage your own rank."),
    // Faction Power
    CMD_POWER_F_POWER("commands.f-power.cmd-power", "&c{power} » &7Power / &7MaxPower &8» &c{power} &7/ &c{maxpower}&7."),
    CMD_BONUS("commands.f-power.cmd-bonus", " (bonus: "),
    CMD_PENALTY("commands.f-power.cmd-penalty", " (penalty: "),
    CMD_DESCRIPTION_F_POWER("commands.f-power.cmd-description", "&7Show Player Power Info"),
    CMD_SAVEALL_SUCCESS("commands.f-saveall.cmd-saveall-success", "&7Factions was saved to disk!"),
    CMD_SETBANNER_SUCCESS("commands.f-setbanner.cmd-setbanner-success", "&7Banner Pattern Set!"),
    CMD_NOT_BANNER("commands.f-setbanner.cmd-not-banner", "&7This item is not a banner!"),
    CMD_NOT_THAT_ROLE("commands.f-setdefaultrole.cmd-not-that-role", "&7You cannot set the default to admin."),
    CMD_DEFAULTROLE_SUCCESS("commands.f-setdefaultrole.cmd-defaultrole-success", "&7Set default role of your faction to &c{role}&7."),
    CMD_INVALID_ROLE("commands.f-setdefaultrole.cmd-invalid-role", "&7Could not find a matching role for &c{role}&7."),
    CMD_NOT_CLAIMED("commands.f-setwarp.cmd-not-claimed", "&7You can only set warps in your faction territory."),
    CMD_LIMIT_F_SETWARP("commands.f-setwarp.cmd-limit", "&7Your faction already has the max amount of warps set &8(&c{warps}&8)."),
    CMD_SET_F_SETWARP("commands.f-setwarp.cmd-set", "&7Set Warp &c{warp} &7and password &c{password} &7to your location."),
    CMD_FHOME_DISABLED("commands.f-sethome.cmd-fhome-disabled", "&7Sorry, Faction Homes are disabled on this server."),
    CMD_FHOME_NOT_CLAIMED("commands.f-sethome.cmd-fhome-not-claimed", "&7Sorry, You can only have a faction home inside your claimed territory."),
    CMD_FHOME_SET("commands.f-sethome.cmd-fhome-set", "&c{target}&7 set the home for your faction. You can now use:"),
    CMD_FHOME_SET_OTHER("commands.f-sethome.cmd-fhome-set-other", "&7You have set the f-home for the &c{faction}&7 faction."),
    CMD_MAXVAULTS_SUCCESS("commands.f-setmaxvaults.cmd-maxvaults-success", "&7Set max vaults from &c{oldmax} &7to &c{newmax}&7."),
    CMD_INVALID_F_VAULT("commands.f-vault.cmd-invalid", "&7Your vault was either claimed, broken and or has not been placed yet."),
    CMD_VAULT_OPENING("commands.f-vault.cmd-opening", "&7Opening faction vault..."),
    CMD_NO_HOPPER_NEAR_VAULT("commands.f-vault.cmd-no-hopper-near-vault", "&7You cannot place a hopper near a vault."),
    CMD_VAULT_ALREADY_SET("commands.f-getvault.cmd-vault-already-set", "&7Vault has already been set!"),
    CMD_VAULT_ALREADY_HAVE("commands.f-getvault.cmd-vault-already-have", "&7You already have a vault in your inventory!"),
    CMD_VAULT_CHEST_NEAR("commands.f-getvault.cmd-vault-chest-near", "&7There is a chest/hopper nearby."),
    CMD_VAULT_SUCCESS("commands.f-getvault.cmd-vault-success", "&7Successfully set a vault."),
    CMD_VAULT_INVALID_LOCATION("commands.f-getvault.cmd-vault-invalid-location", "&7Vault can only be placed in faction land!"),
    CMD_VAULT_RECEIVE("commands.f-getvault.cmd-vault-receive", "&7You have received a faction vault!"),
    CMD_VAULT_NO_MONEY("commands.f-getvault.cmd-vault-no-money", "&7You do not have enough money."),
    CMD_VAULT_MONEY_TAKE("commands.f-getvault.cmd-vault-money-take", "&c{amount} &7has been taken from your account."),
    CMD_SELF("commands.f-show.cmd-no-faction.cmd-self", "&7You are not in a faction."),
    CMD_OTHER("commands.f-show.cmd-no-faction.cmd-other", "&7That is not a faction."),
    CMD_PEACEFULF_SHOW("commands.f-show.cmd-peaceful", "&7This faction is a peaceful faction."),
    CMD_PERMANENT("commands.f-show.cmd-permanent", "&7This faction is permanent remaining even with no members."),
    CMD_JOINING("commands.f-show.cmd-joining", "&7Joining: &c{faction}&7."),
    CMD_INVITATION("commands.f-show.cmd-invitation", "&7Invitation is required."),
    CMD_UNINVITED("commands.f-show.cmd-uninvited", "&7No invite is required."),
    CMD_NO_HOME_F_HOME_2("commands.f-show.cmd-no-home", "&7N/A"),
    CMD_POWER_F_SHOW("commands.f-show.cmd-power", "&7Land / Power / MaxPower: &c{land}&7/&c{power}&7/&c{maxpower}."),
    CMD_BONUS_F_SHOW("commands.f-show.cmd-bonus", "(bonus: "),
    CMD_PENALTY_F_SHOW("commands.f-show.cmd-penalty", "(penalty: "),
    CMD_DEPRECIATED("commands.f-show.cmd-depreciated", "&8(&c{1} &7depreciated&8)"),
    CMD_LAND_VALUE("commands.f-show.cmd-land-value", "&7Total Land Value: &c{v-1} {v-2}"),
    CMD_BANK_CONTAINS("commands.f-show.cmd-bank-contains", "&7Bank Contains: &c{bank}&7."),
    CMD_ALLIES("commands.f-show.cmd-allies", "&7Allies: "),
    CMD_ENEMIES("commands.f-show.cmd-enemies", "&7Enemies: "),
    CMD_MEMBERS_ONLINE("commands.f-show.cmd-members-online", "&7Members Online: "),
    CMD_MEMBERS_OFFLINE("commands.f-show.cmd-members-offline", "&7Members Offline: "),
    CMD_DEATHS_TILL_RAIDABLE("commands.f-show.cmd-deaths-till-raidable", "&7DTR: &c{dtr}&7."),
    CMD_EXEMPT("commands.f-show.cmd-exempt", "&7This faction is exempt and cannot be seen."),
    CMD_NEED_FACTION("commands.f-show.cmd-need-faction", "&7You need to join a faction to view your own!"),
    CMD_HEADER("commands.f-showclaims.cmd-header", "&8&m-------------&8<}faction}(s) claims&8>&8&m-------------"),
    CMD_FORMAT_F_SHOWCLAIMS("commands.f-showclaims.cmd-format", "&8[{world}]:"),
    CMD_CHUNKS_FORMAT("commands.f-showclaims.cmd-chunks-format", "&8(&c{x}&8,&c{z}&8)"),
    CMD_PENDING("commands.f-showinvites.cmd-pending", "&7Players with pending invites: "),
    CMD_CLICK_TO_REVOKE("commands.f-showinvites.cmd-click-to-revoke", "&7Click to revoke invite for &c{invite}&7."),
    CMD_TOGGLE("commands.f-spawnertoggle.cmd-toggle", "&7Spawner placing has been toggled &c{toggled}&7."),
    CMD_PLACE_DENY("commands.f-spawnertoggle.cmd-place-deny", "&7Spawner placing is currently disabled."),
    CMD_FORMAT_F_STATUS("commands.f-status.cmd-format", "&c{power}&7 Power: &c{target}&7 last seen: &c{timestamp}&7."),
    CMD_ONLINE("commands.f-status.cmd-online", "&7Online"),
    CMD_AGO_SUFFIX("commands.f-status.cmd-ago-suffix", " ago."),
    CMD_CHANGED("commands.f-strikes.cmd-changed", "&7You have set &c{faction}&7 strikes to &c{strikes}&7."),
    CMD_INFO("commands.f-strikes.cmd-info", "&c{faction}&7 has &c{strikes}&7 strikes."),
    CMD_TARGET_INVALID("commands.f-strikes.cmd-target-invalid", "&7The faction &c{faction}&7 is invalid."),
    CMD_STRUCK("commands.f-strikes.cmd-struck", "&7Your faction has been changed by &c{target}&7, Your faction now has &c{strikes&7/&c{maxstrikes}&7."),
    CMD_ENABLE("commands.f-stealth.cmd-enable", "&cStealth &8» &7You enabled stealth mode."),
    CMD_DISABLE("commands.f-stealth.cmd-disable", "&cStealth &8» &7You disabled stealth mode."),
    CMD_MUST_BE_MEMBER("commands.f-stealth.cmd-must-be-member", "&cStealth &8» &7You must be in a faction to use this command."),
    CMD_CANCELLED("commands.f-stuck.cmd-cancelled", "&7Teleporting cancelled because you were damaged."),
    CMD_OUTSIDE("commands.f-stuck.cmd-outside", "&7Teleport cancelled because you left &c{radius}&7 block radius."),
    CMD_EXISTS("commands.f-stuck.cmd-exists", "&7You are already teleporting, You must wait &c{time}&7."),
    CMD_START("commands.f-stuck.cmd-start", "&7Teleport will commence in &c{time}&7. Do not take or deal damage."),
    CMD_TELEPORT("commands.f-stuck.cmd-teleport", "&7Teleported safely to &c{x}&7, &c{y}&7, &c{z}&7."),
    CMD_ENABLED_F_SEECHUNK("commands.f-seechunk.cmd-enabled", "&7See-Chunk Disabled!"),
    CMD_DISABLED_F_SEECHUNK("commands.f-seechunk.cmd-disabled", "&7See-Chunk Enabled!"),
    // Factions Titles
    CMD_TAG_TAKEN("commands.f-tag.cmd-tag-taken", "&7This tag is already taken."),
    CMD_TAG_FACTION("commands.f-tag.cmd-tag-faction", "&c{target} changed your faction tag to &c{tag}&7."),
    CMD_TAG_CHANGED("commands.f-tag.cmd-tag-changed", "&7The faction &c{target}&7 has changed their name to &c{tag}&7."),
    CMD_CHANGED_F_TITLE("commands.f-title.cmd-changed", "&c{target} &7changed a title: &c{target-2}&7."),
    // Factions Scoreboard
    CMD_DISABLED_F_SCOREBOARD("commands.f-togglescoreboard.cmd-disabled", "&7You cannot toggle scoreboards while they are disabled."),
    // Factions Top
    CMD_TOP_TOP("commands.f-top.cmd-top-top", "&7Top Factions By &c{target}. Page }1}/}2}"),
    CMD_TOP_LINE("commands.f-top.cmd-top-line", "&7{rank}. &6{faction}: &c{value}"),
    CMD_TOP_INVALID("commands.f-top.cmd-top-invalid", "&7Could not sort by &c{option}&7. try Balance, Online, Members, Power Or Land."),
    // Factions TNT Category
    CMD_TNT_DISABLED_MSG("commands.f-tnt.cmd-tnt-disabled-msg", "&7This command is disabled."),
    CMD_TNT_INVALID_NUM("commands.f-tnt.cmd-tnt-invalid-num", "&7The amount needs to be a number."),
    CMD_TNT_DEPOSIT_SUCCESS("commands.f-tnt.cmd-tnt-deposit-success", "&7Successfully deposited TNT."),
    CMD_TNT_EXCEED_LIMIT("commands.f-tnt.cmd-tnt-exceed-limit", "&7This exceeds the bank limit!"),
    CMD_TNT_WITHDRAW_SUCCESS("commands.f-tnt.cmd-tnt-withdraw-success", "&7Successfully withdrew TNT."),
    CMD_TNT_WITHDRAW_NOT_ENOUGH("commands.f-tnt.cmd-tnt-withdraw-not-enough", "&7Not enough TNT in bank."),
    CMD_TNT_DEPOSIT_NOT_ENOUGH("commands.f-tnt.cmd-tnt-deposit-not-enough", "&7Not enough TNT in the inventory."),
    CMD_TNT_AMOUNT("commands.f-tnt.cmd-tnt-amount", "&7Your faction has &c{amount} TNT in the TNT Bank."),
    CMD_TNT_POSITIVE("commands.f-tnt.cmd-tnt-positive", "&7Please use positive numbers!"),
    CMD_TNT_WITHDRAW_NOT_ENOUGH_SPACE("commands.f-tnt.cmd-tnt-withdraw-not-enough-space", "&7Not enough space in your inventory."),
    CMD_TNT_ADD_ARGS("commands.f-tnt.cmd-tnt-add-args", "&c/f tnt add <amount>"),
    CMD_TNT_REMOVE_ARGS("commands.f-tnt.cmd-tnt-remove-args", "&c/f tnt take <amount>"),
    CMD_TNTFILL_HEADER("commands.f-tntfill.cmd-tntfill-header", "&7Filling TNT in dispensers..."),
    CMD_TNTFILL_SUCCESS("commands.f-tntfill.cmd-tntfill-success", "&7Filled &c{amount}&7 TNT in &c{dispensers} &7dispensers."),
    CMD_TNTFILL_NOT_ENOUGH("commands.f-tntfill.cmd-tntfill-not-enough", "&7Not enough TNT in inventory."),
    CMD_TNTFILL_RADIUS_MAX("commands.f-tntfill.cmd-tntfill-radius-max", "&7The max radius is &c{max}&7."),
    CMD_TNTFILL_AMOUNT_MAX("commands.f-tntfill.cmd-tntfill-amount-max", "&7The max amount is &c{max}&7."),
    CMD_TNTFILL_MOD("commands.f-tntfill.cmd-tntfill-mod", "&7TNT will be used from the faction bank because you do not have the specified amount."),
    // Factions Unban Category
    CMD_TARGET_NOT_BANNED("commands.f-unban.cmd-target-not-banned", "&c{target}&7 is not banned, Not performing anything."),
    CMD_TARGET_UNBANNED("commands.f-unban.cmd-target-unbanned", "&c{mod}&7 unbanned &c{target}&7."),
    CMD_UNBAN_TARGET("commands.f-unban.cmd-unban-target", "&7You have been unbanned from &c{faction}&7."),
    // Factions Unclaim Category
    CMD_SAFEZONE_UNCLAIM_SUCCESS("commands.f-unclaim.cmd-unclaim-safezone.cmd-unclaim-success", "&6SafeZone&7 was unclaimed."),
    CMD_SAFEZONE_UNCLAIM_NO_PERMS("commands.f-unclaim.cmd-unclaim-safezone.cmd-unclaim-no-perms", "&7This is a SafeZone, You lack permission to unclaim."),
    CMD_UNCLAIMALL_SAFEZONE("commands.f-unclaim.cmd-unclaim-safezone.cmd-unclaimall-safezone", "&7You have unclaimed ALL &6&lSafeZone&7 land."),
    CMD_UNCLAIMALL_SAFEZONE_LOG("commands.f-unclaim.cmd-unclaim-safezone.cmd-unclaimall-safezone-log", "&c{target}&7 unclaimed all &6&lSafeZone&7."),
    CMD_SAFEZONE_ENTER("commands.f-unclaim.cmd-unclaim-safezone.cmd-safezone-enter", "&6Safezone"),
    CMD_SAFEZONE_DESCRIPTION("commands.f-unclaim.cmd-unclaim-safezone.cmd-safezone-description", "&6Free from PvP & Monsters."),
    CMD_SAFEZONE_CLAIM("commands.f-unclaim.cmd-unclaim-safezone.cmd-safezone-claim", "&7You have claimed &6&lSafeZone&7."),
    CMD1_WARZONE_UNCLAIM_SUCCESS("commands.f-unclaim.cmd-unclaim-warzone.cmd1-unclaim-success", "&4WarZone&7 was unclaimed."),
    CMD1_WARZONE_UNCLAIM_NO_PERM("commands.f-unclaim.cmd-unclaim-warzone.cmd1-unclaim-no-perm", "&7This is a WarZone, You lack permission to unclaim"),
    CMD1_UNCLAIMALL_WARZONE("commands.f-unclaim.cmd-unclaim-warzone.cmd1-unclaimall-warzone", "&7You have unclaimed ALL &4&lWarZone&7 land."),
    CMD1_UNCLAIMALL_WARZONE_LOG("commands.f-unclaim.cmd-unclaim-warzone.cmd1-unclaimall-warzone-log", "&c{target}&7 unclaimed all &4&lWarZone&7."),
    CMD1_WARZONE_ENTER("commands.f-unclaim.cmd-unclaim-warzone.cmd1-warzone-enter", "&4WarZone"),
    CMD1_WARZONE_DESCRIPTION("commands.f-unclaim.cmd-unclaim-warzone.cmd1-warzone-description", "&4Not the safest place to be."),
    CMD1_WARZONE_CLAIM("commands.f-unclaim.cmd-unclaim-warzone.cmd1-warzone-claim", "&7You have claimed &4&lWarZone&7."),
    CMD_F_UNCLAIMED("commands.f-unclaim.cmd-f-unclaimed", "&c{target} &7unclaimed some of your land."),
    CMD_F_UNCLAIMS("commands.f-unclaim.cmd-f-unclaims", "&7You unclaimed this land."),
    CMD_UNCLAIM_LOG("commands.f-unclaim.cmd-unclaim-log", "&c{target} &7unclaimed everything for the Faction: &c{faction}&7."),
    CMD_UNCLAIM_WRONG_FACTION("commands.f-unclaim.cmd-unclaim-wrong-faction", "&7You do not own this land."),
    CMD_CLICK_TO_UNCLAIM("commands.f-unclaim.cmd-click-to-unclaim", "&7Click To Unclaim &8(&c{loc-1}&7, &c{loc-2}&8)"),
    CMD_UNCLAIMALL_UNCLAIMED("commands.f-unclaimall.cmd-unclaimall-unclaimed", "&c{target} &7unclaimed ALL of your factions land."),
    CMD_UNCLAIMALL_LOG("commands.f-unclaimall.cmd-unclaimall-log", "&c{target} &7unclaimed everything for the Faction: &c{faction}&7."),
    CMD_UNCLAIM_FACTIONUNCLAIMED("commands.f-unclaim.cmd-unclaim-factionsunclaimed","&c{target}&7 unclaimed some land."),
    // Version Section
    CMD_PLUGIN_NAME("commands.f-version.cmd-plugin-name", "&c&k||| &r&4SavageFactions&7 &c&k|||&r &c» &7By ProSavage."),
    CMD_FACTION_VERSION("commands.f-version.cmd-faction-version", "&7Version » &c{version}&7."),
    // Factions Rules
    RULES_DISABLED_MSG("commands.f-rules.rules-disabled-msg", "&7This command is disabled."),
    CMD_ADD_INVALID_ARGS("commands.f-rules.f-rules-add.cmd-add-invalid-args", "&7Please include a rule!"),
    CMD_ADD_SUCCESS("commands.f-rules.f-rules-add.cmd-add-success", "&7Rule added successfully!"),
    CMD_SET_INVALID_ARGS("commands.f-rules.f-rules-set.cmd-set-invalid-args", "&7Please include a line number & rule!"),
    CMD_SET_SUCCESS("commands.f-rules.f-rules-set.cmd-set-success", "&7Rule set successfully!"),
    CMD_REMOVE_INVALID_ARGS("commands.f-rules.f-rules-remove.cmd-remove-invalid-args", "&7Please include a line number!"),
    CMD_REMOVE_SUCCESS("commands.f-rules.f-rules-remove.cmd-remove-success", "&7Rule removed successfully!"),
    CMD_CLEAR_SUCCESS("commands.f-rules.f-rules-clear.cmd-clear-success", "&7Rule has been cleared successfully!"),
    // Faction Grace
    CMD_GRACE_TOGGLED("commands.f-grace.cmd-grace-toggled", "&c&lGrace Period has been }toggled}"),
    // Faction Leave
    CMD_LEAVE_PASS_ADMIN("commands.f-leave.cmd-leave-pass-admin", "&7You must give leadership to someone else first."),
    CMD_LEAVE_NEGATIVE_POWER("commands.f-leave.cmd-leave-negative-power", "&7You cannot leave until your power is in the positive."),
    CMD_LEAVE_MSG("commands.f-leave.cmd-leave-msg", "&c{target}&7 has left faction &c{faction}&7."),
    CMD_LEAVE_DISBANDED("commands.f-leave.cmd-leave-disbanded", "&c{faction}&7 was disbanded."),
    CMD_LEAVE_DISBANDED_LOG("commands.f-leave.cmd-leave-disbanded-log", "&c{faction}&7 was disbanded due to the last player &8(&c{target}&8)&7 leaving."),
    // War Banners
    CMD_WARBANNER_NO_FACTION("commands.f-warbanner.cmd-warbanner-no-faction", "&7You need a faction to use a WarBanner!"),
    CMD_WARBANNER_COOLDOWN("commands.f-warbanner.cmd-warbanner-cooldown", "&7The WarBanner is on cooldown for your faction!"),
    CMD_WARBANNER_INVALID_LOC("commands.f-warbanner.cmd-warbanner-invalid-loc", "&7You can only use WarBanners in enemy land or the warzone."),
    CMD_BANNER_SUCCESS("commands.f-warbanner.cmd-banner-success", "&7You have created a &c&lWarBanner."),
    CMD_BANNER_DISABLED("commands.f-warbanner.cmd-banner-disabled", "&7Creation of &c&lWarBanner&7 is disabled."),
    CMD_BANNER_MONEY_TAKE("commands.f-warbanner.cmd-banner-money-take", "&c{amount} &7has been taken from your account."),
    CMD_BANNER_NOT_ENOUGH_MONEY("commands.f-warbanner.cmd-banner-not-enough-money", "&7You do not have enough money."),
    // Compass & Faction Chats
    NORTH("commands.factions-utils.f-map-compass.short.north", "N"),
    EAST("commands.factions-utils.f-map-compass.short.east", "E"),
    SOUTH("commands.factions-utils.f-map-compass.short.south", "S"),
    WEST("commands.factions-utils.f-map-compass.short.west", "W"),
    F_MOD("commands.factions-utils.f-chat.f-mod", "mod chat"),
    F_FACTION("commands.factions-utils.f-chat.f-faction", "faction chat"),
    F_ALLIANCE("commands.factions-utils.f-chat.f-alliance", "alliance chat"),
    F_TRUCE("commands.factions-utils.f-chat.f-truce", "truce chat"),
    F_PUBLIC("commands.factions-utils.f-chat.f-public", "public chat"),
    FORMAT("commands.factions-utils.econ.format", "###,###.###"),
    // F Roles
    M_SINGULAR("commands.factions-utils.f-relations.f-member.m-singular", "member"),
    M_PLURAL("commands.factions-utils.f-relations.f-member.m-plural", "members"),
    A_SINGULAR("commands.factions-utils.f-relations.f-ally.a-singular", "ally"),
    A_PLURAL("commands.factions-utils.f-relations.f-ally.a-plural", "allies"),
    T_SINGULAR("commands.factions-utils.f-relations.f-truce.t-singular", "truce"),
    T_PLURAL("commands.factions-utils.f-relations.f-truce.t-plural", "truces"),
    N_SINGULAR("commands.factions-utils.f-relations.f-neutral.n-singular", "neutral"),
    N_PLURAL("commands.factions-utils.f-relations.f-neutral.n-plural", "neutrals"),
    E_SINGULAR("commands.factions-utils.f-relations.f-enemy.e-singular", "enemy"),
    E_PLURAL("commands.factions-utils.f-relations.f-enemy.e-plural", "enemies"),
    R_LEADER("commands.factions-utils.f-relations.f-roles.r-leader", "leader"),
    R_COLEADER("commands.factions-utils.f-relations.f-roles.r-coleader", "coleader"),
    R_MODERATOR("commands.factions-utils.f-relations.f-roles.r-moderator", "moderator"),
    R_NORMAL("commands.factions-utils.f-relations.f-roles.r-normal", "normal member"),
    R_RECRUIT("commands.factions-utils.f-relations.f-roles.r-recruit", "recruit"),
    // Regions Category
    REG_SAFEZONE("commands.factions-utils.f-relations.region.reg-safezone", "safezone"),
    REG_WARZONE("commands.factions-utils.f-relations.region.reg-warzone", "warzone"),
    REG_WILDERNESS("commands.factions-utils.f-relations.region.reg-wilderness", "wilderness"),
    REG_PEACEFUL("commands.factions-utils.f-relations.region.reg-peaceful", "peaceful territory"),
    // Player Misc
    CMD_PLAYER_CANNOT_HURT("commands.factions-utils.f-relations.player-misc.cmd-player-cannot-hurt", "&7You may not harm other players in &c{territory}."),
    CMD_PLAYER_SAFE_AUTO("commands.factions-utils.f-relations.player-misc.cmd-player-safe-auto", "&7This land is now a safe zone."),
    CMD_PLAYER_WAR_AUTO("commands.factions-utils.f-relations.player-misc.cmd-player-war-auto", "&7This land is now a warzone."),
    CMD_PLAYER_OUCH("commands.factions-utils.f-relations.player-misc.cmd-player-ouch", "&7Ouch, that is starting to hurt. You should give it a rest."),
    // Player Use Category
    CMD_PLAYER_USE_WILDERNESS("commands.factions-utils.f-relations.player-use.cmd-player-use-wilderness", "&7You cannot use &c{item} &7in the wilderness."),
    CMD_PLAYER_USE_SAFEZONE("commands.factions-utils.f-relations.player-use.cmd-player-use-safezone", "&7You cannot use &c{item} &7in a safezone."),
    CMD_PLAYER_USE_WARZONE("commands.factions-utils.f-relations.player-use.cmd-player-use-warzone", "&7You cannot use &c{item} &7in a warzone."),
    CMD_PLAYER_USE_TERRITORY("commands.factions-utils.f-relations.player-use.cmd-player-use-territory", "&7You cannot &c{item} &7in the territory of &c{territory}."),
    CMD_PLAYER_USE_OWNED("commands.factions-utils.f-relations.player-use.cmd-player-use-owned", "&7You cannot use &c{item} &7in this territory, It is owned by: &c{faction}."),
    // Command Prevention Category
    CMD_PLAYER_CMD_WARZONE("commands.factions-utils.f-relations.player-command.cmd-player-cmd-warzone", "&7You cannot use the command &c{cmd} &7in warzone."),
    CMD_PLAYER_CMD_NEUTRAL("commands.factions-utils.f-relations.player-command.cmd-player-cmd-neutral", "&7You cannot use the command &c{cmd} &7in neutral territory."),
    CMD_PLAYER_CMD_ENEMY("commands.factions-utils.f-relations.player-command.cmd-player-cmd-enemy", "&7You cannot use the command &c{cmd} &7in enemy territory."),
    CMD_PLAYER_CMD_PERMANENT("commands.factions-utils.f-relations.player-command.cmd-player-cmd-permanent", "&7You cannot use the command &c{cmd} &7because you are in a permanent faction."),
    CMD_PLAYER_CMD_ALLY("commands.factions-utils.f-relations.player-command.cmd-player-cmd-ally", "&7You cannot use the command &c{cmd} &7in ally territory."),
    CMD_PLAYER_CMD_WILDERNESS("commands.factions-utils.f-relations.player-command.cmd-player-cmd-wilderness", "&7You cannot use the command &c{cmd} &7in the wilderness."),
    // Power Loss Category
    CMD_NO_LOSS_PEACEFUL("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-peaceful", "&7You did not lose any power since you are in a peaceful faction."),
    CMD_NO_LOSS_WORLD("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-world", "&7You did not lose any power due to the world you die in."),
    CMD_NO_LOSS_WILDERNESS("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-wilderness", "&7You did not lose any power since you were in wilderness."),
    CMD_NO_LOSS_WARZONE("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-warzone", "&7You did not lose power since warzone power loss was disabled."),
    CMD_LOSS_WARZONE("commands.factions-utils.f-relations.player-power.player-loss.cmd-loss-warzone", "&7The world you are in has power loss normally disabled but you still lost power since you were in the warzone."),
    CMD_POWER_NOW("commands.factions-utils.f-relations.player-power.player-loss.cmd-power-now", "&7Your power is now &c{power} &7/ &c{maxpower}."),

    // Player PVP Category
    CMD_PLAYER_LOGIN("commands.factions-utils.f-relations.player-pvp.cmd-player-login", "&7You cannot hurt other players for &c{time} &7seconds after logging in."),
    CMD_PLAYER_REQUIRE_FACTION("commands.factions-utils.f-relations.player-pvp.cmd-player-require-faction", "&7You cannot hurt others players until you join a faction."),
    CMD_PLAYER_FACTION_LESS("commands.factions-utils.f-relations.player-pvp.cmd-player-faction-less", "&7You cannot hurt players who are currently not in a faction."),
    CMD_PLAYER_PEACEFUL("commands.factions-utils.f-relations.player-pvp.cmd-player-peaceful", "&7Peaceful Players cannot participate in combat."),
    CMD_PLAYER_NEUTRAL("commands.factions-utils.f-relations.player-pvp.cmd-player-neutral", "&7You cannot hurt neutral factions, Declare them as an enemy."),
    CMD_PLAYER_CANNOT_HURT_2("commands.factions-utils.f-relations.player-pvp.cmd-player-cannot-hurt", "&7You cannot hurt &c{target}&7."),
    CMD_PLAYER_NEUTRAL_FAIL("commands.factions-utils.f-relations.player-pvp.cmd-player-neutral-fail", "&7You cannot hurt &c{target} &7in their own territory unless you declare them as an enemy."),
    CMD_PLAYER_TRIED_TO_HURT("commands.factions-utils.f-relations.player-pvp.cmd-player-tried-to-hurt", "&c{attacker} &7tried to hurt you."),

    // Relation Messages
    CMD_RELATIONS_PROPOSAL_1("&c{faction} &7wishes to be your &c{relation}&7."),
    CMD_RELATIONS_PROPOSAL_2("&7Type &c/f {relation} {faction}&7 to accept."),
    CMD_RELATIONS_PROPOSAL_SENT("&c{faction}&7 were informed that you wish to be &c{relation}&7."),

    CMD_RELATIONS_ALLTHENOPE("&c&l[!]&7 &cNope! You can't."),
    CMD_RELATIONS_MORENOPE("&c&l[!]&7 &cNope! &7You can't declare a relation to &cyourself"),
    CMD_RELATIONS_ALREADYINRELATIONSHIP("&c&l[!]&7 You &calready&7 have that relation wish set with&c %1$s."),
    CMD_RELATIONS_MUTUAL("&c&l[!]&7 Your faction is now %1$s to %2$s"),
    CMD_RELATIONS_PEACEFUL("&c&l[!]&7 This will have no effect while your faction is peaceful."),
    CMD_RELATIONS_PEACEFULOTHER("&c&l[!]&7 This will have &cno effect&7 while their faction is peaceful."),
    CMD_RELATIONS_EXCEEDS_ME("&c&l[!]&7 Failed to set relation wish. You can only have %1$s %2$s."),
    CMD_RELATIONS_EXCEEDS_THEY("&c&l[!]&7 Failed to set relation wish. They can only have %1$s %2$s."),

    // Econ Messages
    ECON_OFF("commands.factions-utils.econ.econ-off", "No {balance}"),
    ECON_FORMAT("commands.factions-utils.econ.econ-format", "###,###,###"),

    // Extra Shit I forgot -> goes in lang.yml at bottom

    COMMAND_PROMOTE_PROMOTED("promoted"),
    COMMAND_PROMOTE_DEMOTED("demoted"),

    COMMAND_AUTOHELP_HELPFOR("", "Help For Command \""),

    // Config Stuff -> goes in another file
    COMMAND_CONFIG_NOEXIST("&c&l[!]&7 No configuration setting \"&c%1$s&7\" exists."),
    COMMAND_CONFIG_SET_TRUE("\" option set to true (enabled)."),
    COMMAND_CONFIG_SET_FALSE("\" option set to false (disabled)."),
    COMMAND_CONFIG_OPTIONSET("\" option set to "),
    COMMAND_CONFIG_COLOURSET("\" color option set to \""),
    COMMAND_CONFIG_INTREQUIRED("Cannot set \"%1$s\": An integer (whole number) value required."),
    COMMAND_CONFIG_LONGREQUIRED("Cannot set \"%1$s\": A long integer (whole number) value required."),
    COMMAND_CONFIG_DOUBLEREQUIRED("Cannot set \"%1$s\": A double (numeric) value required."),
    COMMAND_CONFIG_FLOATREQUIRED("Cannot set \"%1$s\": A float (numeric) value required."),
    COMMAND_CONFIG_INVALID_COLOUR("Cannot set \"%1$s\": \"%2$s\" is not a valid color."),
    COMMAND_CONFIG_INVALID_COLLECTION("\"%1$s\" is not a data collection type which can be modified with this command."),
    COMMAND_CONFIG_INVALID_MATERIAL("Cannot change \"%1$s\" set: \"%2$s\" is not a valid material."),
    COMMAND_CONFIG_INVALID_TYPESET("\"%1$s\" is not a data type set which can be modified with this command."),
    COMMAND_CONFIG_MATERIAL_ADDED("\"%1$s\" set: Material \"%2$s\" added."),
    COMMAND_CONFIG_MATERIAL_REMOVED("\"%1$s\" set: Material \"%2$s\" removed."),
    COMMAND_CONFIG_SET_ADDED("\"%1$s\" set: \"%2$s\" added."),
    COMMAND_CONFIG_SET_REMOVED("\"%1$s\" set: \"%2$s\" removed."),
    COMMAND_CONFIG_LOG(" (Command was run by %1$s.)"),
    COMMAND_CONFIG_ERROR_SETTING("Error setting configuration setting \"%1$s\" to \"%2$s\"."),
    COMMAND_CONFIG_ERROR_MATCHING("Configuration setting \"%1$s\" couldn't be matched, though it should be... please report this error."),
    COMMAND_CONFIG_ERROR_TYPE("'%1$s' is of type '%2$s', which cannot be modified with this command."),

    // Back End Convert -> goes in another file
    COMMAND_CONVERT_BACKEND_RUNNING("&7Already running that backend."),
    COMMAND_CONVERT_BACKEND_INVALID("&7Invalid Backend."),

    // Hints -> goes in another file
    COMMAND_HINT_PERMISSION("&aYou can manage your factions permissions using &7/f perms"),

    // Commands Tag
    COMMANDS_NO_FACTION_PERMS("actions.commands-no-faction-perms", "&c{faction} &7does not allow you to &c{action}&7."),
    COMMANDS_NO_FACTION_PERMS_PAIN("actions.commands-no-faction-perms-pain", "&7It is painful to try &c{action}&7 in the territory of &c{faction}&7."),
    COMMANDS_NO_FACTION("actions.commands-no-faction", "&7You are not a member of any faction."),
    COMMANDS_NO_SAME_ROLE("actions.commands-no-same-role", "&c{role} cannot control each other."),
    COMMANDS_MUST_BE_ROLE("actions.commands-must-be-role", "&7You must be &c{role}&7 to &c{action}&7."),
    COMMANDS_NO_PAGES("actions.commands-no-pages", "&7Sorry, No Pages Available"),
    COMMANDS_INVALID_PAGE("actions.commands-invalid-page", "&7Invalid Page, Must be between &c1&7 and &c{pages}&7."),
    COMMANDS_TITLE("actions.commands-title", "&bFactions &0|&r"),
    COMMANDS_TOGGLE_SB("actions.commands-toggle-sb", "&7You now have scoreboards set to {value}"),
    COMMANDS_FACTION_LEAVE("actions.commands-faction-leave", "&7Leaving &c{territ-1}&7, Entering &c{territ-2}&7."),
    COMMANDS_FACTION_ANNOUNCEMENT_TOP("actions.commands-faction-announcement-top", "&d--Unread Faction Announcements--"),
    COMMANDS_FACTION_ANNOUNCEMENT_BOTTOM("actions.commands-faction-announcement-bottom", "&d--Unread Faction Announcements--"),
    COMMANDS_DEFAULT_FACTION_PREFIX("actions.commands-default-faction-prefix", "{relationcolor}[{faction}]"),
    COMMANDS_FACTION_LOGIN("actions.commands-faction-login", "&c{member}&7 logged in."),
    COMMANDS_FACTION_LOGOUT("actions.commands-faction-logout", "&c{member}&7 logged out."),
    COMMANDS_NO_FACTIONS_PREFIX("actions.commands-no-factions-prefix", "&6[&a4-&6]&r"),
    COMMANDS_DATE_FORMAT("actions.commands-date-format", "MM/d/yy h:ma"),
    COMMANDS_RAIDABLE_TRUE("actions.commands-raidable-true", "true"),
    COMMANDS_RAIDABLE_FALSE("actions.commands-raidable-false", "false"),

    // Command Descriptions -> Goes in another file
    COMMAND_HELP_DESCRIPTION("\n  &a&l» &7Display a &ahelp &7page"),
    COMMAND_NEAR_DESCRIPTION("Get nearby faction players in a radius."),
    COMMAND_UPGRADES_DESCRIPTION("&cOpen the Upgrades Menu"),
    COMMAND_AHOME_DESCRIPTION("commands.f-ahome.cmd-ahome-description", "&cThis sends a player to their home no matter what."),
    COMMAND_ANNOUNCE_DESCRIPTION("Announce a message to players in faction."),
    COMMAND_ALTS_LIST_DESCRIPTION("List all alts in your faction"),
    COMMAND_ALTINVITE_DESCRIPTION("Invite Alts to your faction."),
    COMMAND_ALTKICK_DESCRIPTION("Kick alts from your faction"),
    COMMAND_AUTOCLAIM_DESCRIPTION("Auto-claim land as you walk around"),
    COMMAND_BAN_DESCRIPTION("Ban players from joining your Faction."),
    COMMAND_BANLIST_DESCRIPTION("View a Faction's ban list"),
    COMMAND_BYPASS_DESCRIPTION("Enable admin bypass mode"),
    COMMAND_BANNER_DESCRIPTION("Turn a held banner into a war banner"),
    COMMAND_TPBANNER_DESCRIPTION("Teleport to your faction banner"),
    COMMAND_CHAT_DESCRIPTION("Change chat mode"),
    COMMAND_CHATSPY_DESCRIPTION("Enable admin chat spy mode"),
    COMMAND_CLAIM_DESCRIPTION("Claim land from where you are standing"),
    COMMAND_CLAIMLINE_DESCRIPTION("Claim land in a straight line."),
    COMMAND_CONFIG_DESCRIPTION("Change a conf.json setting"),
    COMMAND_CONVERT_DESCRIPTION("Convert the plugin backend"),
    COMMAND_COORDS_DESCRIPTION("broadcast your coords to your faction"),
    COMMAND_CHECKPOINT_DESCRIPTION("Set or go to your faction checkpoint!"),
    COMMAND_CREATE_DESCRIPTION("Create a new faction"),
    COMMAND_DEINVITE_DESCRIPTION("Remove a pending invitation"),
    COMMAND_DELFWARP_DESCRIPTION("Delete a faction warp"),
    COMMAND_DELFWARP_TODELETE("to delete warp"),
    COMMAND_DELFWARP_FORDELETE("for deleting warp"),
    COMMAND_DESCRIPTION_DESCRIPTION("Change the faction description"),
    COMMAND_DISBAND_DESCRIPTION("Disband a faction"),
    COMMAND_FLY_DESCRIPTION("Enter or leave Faction flight mode"),
    COMMAND_FOCUS_DESCRIPTION("Focus a Specific Player"),
    COMMAND_FWARP_DESCRIPTION("Teleport to a faction warp"),
    COMMAND_HOME_DESCRIPTION("Teleport to the faction home"),
    COMMAND_INSPECT_DESCRIPTION("Inspect blocks!"),
    COMMAND_INVITE_DESCRIPTION("Invite a player to your faction"),
    COMMAND_JOIN_DESCRIPTION("&a&l» &7Join a faction"),
    COMMAND_KICK_DESCRIPTION("Kick a player from the faction"),
    COMMAND_LIST_DESCRIPTION("&a&l» &7See a list of the factions"),
    COMMAND_LOCK_DESCRIPTION("Lock all write stuff. Apparently."),
    COMMAND_LOGINS_DESCRIPTION("Toggle(?) login / logout notifications for Faction members"),
    COMMAND_MAP_DESCRIPTION("Show the territory map, and set optional auto update"),
    COMMAND_MAPHEIGHT_DESCRIPTION("&eUpdate the lines that /f map sends"),
    COMMAND_MOD_DESCRIPTION("Give or revoke moderator rights"),
    COMMAND_COLEADER_DESCRIPTION("Give or revoke coleader rights"),
    COMMAND_MODIFYPOWER_DESCRIPTION("Modify the power of a faction/player"),
    COMMAND_MONEYBALANCE_DESCRIPTION("Show your factions current money balance"),
    COMMAND_MONEYDEPOSIT_DESCRIPTION("Deposit money"),
    COMMAND_MONEYTRANSFERFF_DESCRIPTION("Transfer f -> f"),
    COMMAND_MONEYTRANSFERFP_DESCRIPTION("Transfer f -> plugin"),
    COMMAND_MONEYTRANSFERPF_DESCRIPTION("Transfer plugin -> f"),
    COMMAND_MONEYWITHDRAW_DESCRIPTION("Withdraw money"),
    COMMAND_OWNER_DESCRIPTION("Set ownership of claimed land"),
    COMMAND_KILLHOLOGRAMS_DESCRIPTION("Kill holograms in a radius, admin command"),
    COMMAND_OWNERLIST_DESCRIPTION("List owner(s) of this claimed land"),
    COMMAND_PARTICLE_DESCRIPTION("Select the particle for your player"),
    COMMAND_PERM_DESCRIPTION("&c&l[!]&7&6Edit or list your Faction's permissions."),
    COMMAND_POWER_DESCRIPTION("&a&l» &7Show player &apower &7info"),
    COMMAND_POWERBOOST_DESCRIPTION("Apply permanent power bonus/penalty to specified player or faction"),
    COMMAND_RELATIONS_DESCRIPTION("Set relation wish to another faction"),
    COMMAND_RELOAD_DESCRIPTION("Reload data file(s) from disk"),
    COMMAND_SAFEUNCLAIMALL_DESCRIPTION("Unclaim all safezone land"),
    COMMAND_SAVEALL_DESCRIPTION("Save all data to disk"),
    COMMAND_SCOREBOARD_DESCRIPTION("Scoreboardy Things"),
    COMMAND_SETBANNER_DESCRIPTION("set banner pattern for your faction"),
    COMMAND_SETDEFAULTROLE_DESCRIPTION("/f defaultrole <role> - set your Faction's default role."),
    COMMAND_SETFWARP_DESCRIPTION("Set a faction warp"),
    COMMAND_SETHOME_DESCRIPTION("Set the faction home"),
    COMMAND_SETMAXVAULTS_DESCRIPTION("Set max vaults for a Faction."),
    COMMAND_VAULT_DESCRIPTION("Open your placed faction vault!"),
    COMMAND_GETVAULT_DESCRIPTION("Get the faction vault item!"),
    COMMAND_GRACE_DESCRIPTION("Does grace toggling"),
    COMMAND_SHOWCLAIMS_DESCRIPTION("show your factions claims!"),
    COMMAND_SHOWINVITES_DESCRIPTION("Show pending faction invites"),
    COMMAND_SPAWNERTOGGLE_DESCRIPTION("Disables / Enabled factions being able to place spawners."),
    COMMAND_STATUS_DESCRIPTION("Show the status of a player"),
    COMMAND_STRIKES_DESCRIPTION("Set strikes on factions to warn them"),
    COMMAND_STRIKESGIVE_DESCRIPTION("Give a faction 1 strike"),
    COMMAND_STRIKETAKE_DESCRIPTION("Take a strike from a faction"),
    COMMAND_STRIKESET_DESCRIPTION("Set a faction's strikes explicitly."),
    COMMAND_STRIKESINFO_DESCRIPTION("Get a faction's strikes"),
    COMMAND_STEALTH_DESCRIPTION("Enable and Disable Stealth Mode"),
    COMMAND_STUCK_DESCRIPTION("Safely teleports you out of enemy faction"),
    COMMAND_TAG_DESCRIPTION("&7Change the faction tag"),
    COMMAND_TITLE_DESCRIPTION("&7Set or remove a players title"),
    COMMAND_TOGGLEALLIANCECHAT_DESCRIPTION("&7Toggles whether or not you will see alliance chat"),
    COMMAND_TOP_DESCRIPTION("&7Sort Factions to see the top of some criteria."),
    COMMAND_TNT_DESCRIPTION("&7/withdraw from faction's tnt bank."),
    COMMAND_TNTFILL_DESCRIPTION("&7Fill tnt into dispensers around you"),
    COMMAND_UNBAN_DESCRIPTION("&7Unban someone from your Faction"),
    COMMAND_UNCLAIM_DESCRIPTION("&7Unclaim the land where you are standing"),
    COMMAND_UNCLAIMALL_DESCRIPTION("&7Unclaim all of your factions land"),
    COMMAND_WARUNCLAIMALL_DESCRIPTION("&7Unclaim all warzone land"),
    COMMAND_RULES_DESCRIPTION("&7set/remove/add rules!"),
    COMMAND_BOOM_DESCRIPTION("&7Toggle explosions (peaceful factions only)"),
    COMMAND_BOOM_TOTOGGLE("&7to toggle explosions"),
    COMMAND_BOOM_FORTOGGLE("&7for toggling explosions"),
    COMMAND_VERSION_DESCRIPTION("&7Show plugin and translation version information"),
    LEAVE_DESCRIPTION("&7Leave your faction"),
    COMMAND_UNCLAIMALL_TOUNCLAIM("to unclaim all faction land"),
    COMMAND_UNCLAIMALL_FORUNCLAIM("for unclaiming all faction land"),
    COMMAND_UNCLAIM_TOUNCLAIM("to unclaim this land"),
    COMMAND_UNCLAIM_FORUNCLAIM("for unclaiming this land"),
    CMD_RELATIONS_DESCRIPTION("to change a relation wish"),
    CMD_RELATIONS_DESCRIPTION_2("for changing a relation wish"),
    COMMAND_CREATE_TOCREATE("to create a new faction"),
    COMMAND_CREATE_FORCREATE("for creating a new faction"),
    COMMAND_DESCRIPTION_TOCHANGE("to change faction description"),
    COMMAND_DESCRIPTION_FORCHANGE("for changing faction description"),

    // Messages - F Help -> may go in another file.
    COMMAND_HELP_NEXTCREATE("Learn how to create a faction on the next page."),
    COMMAND_HELP_INVITATIONS("command.help.invitations", "You might want to close it and use invitations:"),
    COMMAND_HELP_HOME("And don't forget to set your home:"),
    COMMAND_HELP_404("&c&l» &7This page does &cnot &7exist"),
    COMMAND_HELP_BANK_1("Your faction has a bank which is used to pay for certain"), //Move to last /f help page
    COMMAND_HELP_BANK_2("things, so it will need to have money deposited into it."), //Move to last /f help page
    COMMAND_HELP_BANK_3("To learn more, use the money command."), //Move to last /f help page
    COMMAND_HELP_PLAYERTITLES("Player titles are just for fun. No rules connected to them."), //Move to last /f help page
    COMMAND_HELP_OWNERSHIP_1("Claimed land with ownership set is further protected so"), //Move to last /f help page
    COMMAND_HELP_OWNERSHIP_2("that only the owner(s), faction admin, and possibly the"), //Move to last /f help page
    COMMAND_HELP_OWNERSHIP_3("faction moderators have full access."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_1("Set the relation you WISH to have with another faction."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_2("Your default relation with other factions will be neutral."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_3("If BOTH factions choose ALLY, you will be allies."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_4("If ONE faction chooses ENEMY, you will be enemies."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_5("You can never hurt members or allies."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_6("You can not hurt neutrals in their own territory."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_7("You can always hurt enemies and players without faction."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_8(""),
    COMMAND_HELP_RELATIONS_9("Damage from enemies is reduced in your own territory."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_10("When you die you lose power. It is restored over time."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_11("The power of a faction is the sum of all member power."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_12("The power of a faction determines how much land it can hold."), //Move to last /f help page
    COMMAND_HELP_RELATIONS_13("You can claim land from factions with too little power."), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_1("Only faction members can build and destroy in their own"), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_2("territory. Usage of the following items is also restricted:"), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_3("Door, Chest, Furnace, Dispenser, Diode."), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_4(""),
    COMMAND_HELP_PERMISSIONS_5("Make sure to put pressure plates in front of doors for your"), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_6("guest visitors. Otherwise they can't get through. You can"), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_7("also use this to create member only areas."), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_8("As dispensers are protected, you can create traps without"), //Move to last /f help page
    COMMAND_HELP_PERMISSIONS_9("worrying about those arrows getting stolen."), //Move to last /f help page
    COMMAND_HELP_ADMIN_1("&a&l» &a/f claim safezone \n   &7claim land for the Safe Zone"),
    COMMAND_HELP_ADMIN_2("&a&l» &a/f claim warzone \n   &7claim land for the War Zone"),
    COMMAND_HELP_ADMIN_3("&a&l» &a/f autoclaim [safezone|warzone] \n   &7Take a guess"),
    COMMAND_HELP_MORE_1("Finally some commands for the server admins:"),
    COMMAND_HELP_MORE_2("More commands for server admins:"),
    COMMAND_HELP_MORE_3("Even more commands for server admins:");

    public static SimpleDateFormat sdf;
    private static YamlConfiguration LANG;
    private String path;
    private String def;

    /**
     * Lang enum constructor.
     *
     * @param path  The string path.
     * @param start The default string.
     */
    TL(String path, String start) {
        this.path = path;
        this.def = start;
    }

    /**
     * Lang enum constructor. Use this when your desired path simply exchanges '_' for '.'
     *
     * @param start The default string.
     */
    TL(String start) {
        this.path = this.name().replace('_', '.');
        if (this.path.startsWith(".")) {
            path = "root" + path;
        }
        this.def = start;
    }

    /**
     * Set the {@code YamlConfiguration} to use.
     *
     * @param config The config to set.
     */
    public static void setFile(YamlConfiguration config) {
        LANG = config;
        sdf = new SimpleDateFormat(COMMANDS_DATE_FORMAT.toString());
    }

    @Override
    public String toString() {
        return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def)) + (this == COMMANDS_TITLE ? " " : "");
    }

    public String format(Object... args) {
        return String.format(toString(), args);
    }

    /**
     * Get the default value of the path.
     *
     * @return The default value of the path.
     */
    public String getDefault() {
        return this.def;
    }

    /**
     * Get the path to the string.
     *
     * @return The path to the string.
     */
    public String getPath() {
        return this.path;
    }
}
