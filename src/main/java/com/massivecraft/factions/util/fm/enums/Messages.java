package com.massivecraft.factions.util.fm.enums;

import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.zcore.util.TextUtil;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.HashMap;
import java.util.List;

public enum Messages {
    GENERIC_PREFIX("root.generic-prefix", "&8&l[&c&l!&8&l] "),
    GENERIC_CONFIG_RELOAD("root.generic-config-reload", "&7You have reloaded the plugin, It took &c{ms} &7to complete this task."),
    GENERIC_CONSOLE_ONLY("root.generic-console-only", "&7This command can only be used in console."),
    GENERIC_PLAYER_ONLY("root.generic-player-only", "&7You must be a player to use this command."),
    GENERIC_NO_CMD_PERMS("root.generic-no-cmd-perms", "&7You do not have permission to use this command."),
    GENERIC_NO_PLAYER_MATCH("root.generic-no-player-match", "&7No player match found for &c{target}&7."),
    GENERIC_NO_PLAYER_FOUND("root.generic-no-player-found", "&7No player named &c{target}&7 could be found."),
    GENERIC_ENABLED("root.generic-enabled", "&4Disabled"),
    GENERIC_DISABLED("root.generic-disabled", "&aEnabled"),
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
    WARMUP_FLIGHT("actions.commands-warmsup-notify.warmup-flight", "&7Flight will enable in &c{seconds} &7seconds."),
    WARMUP_TELEPORT("actions.commands-warmsup-notify.warmup-teleport", "&7You will teleport to &c{loc}&7 in &c{seconds}&7 seconds"),
    WARMUP_ALREADY("actions.commands-warmsup-notify.warmup-already", "&7You are already warming up."),
    WARMUP_CANCELLED("actions.commands-warmsup-notify.warmup-cancelled", "&7You have cancelled your warmup."),
    CMD_MSG("commands.f-near.disabled.cmd-msg", "&7This command is disabled."),
    CMD_FORMAT("commands.f-near.cmd-format", "&c{playername} &8(&c{distance}&8)"),
    CMD_NO_HOME("commands.f-ahome.cmd-no-home", "&c{target} does not have an f home."),
    CMD_HOME_SUCCESS("commands.f-ahome.cmd-home-success", "&c{target} was sent to their f home."),
    CMD_TARGET_OFFLINE("commands.f-ahome.cmd-target-offline", "&c{target} is offline."),
    CMD_TARGET_SEND_MSG("commands.f-ahome.cmd-target-send-msg", "&cYou were sent to your f home."),
    CMD_FORMAT_F_ALTS("commands.f-alts.cmd-format", "&c{power} &7Power: &c{target} &7Last Seen: &c{timestamp}"),
    CMD_ALT_INVITE("commands.f-alts.cmd-alt-invite", "&c{player}&7 invited &c{target}&7 to your faction as an alt."),
    CMD_NOT_AN_ALT_KICK("commands.f-alts.cmd-not-an-alt-kick", "&7Player is not an alt."),
    CMD_NOT_A_MEMBER("commands.f-alts.cmd-not-a-member", "&7This player is not a member/alt of your faction."),
    AUTOCLAIM_ENABLE("commands.f-autoclaim.autoclaim-enable", "&7Now &cauto-claiming&7 land for &c{faction}&7."),
    AUTOCLAIM_DISABLED("commands.f-autoclaim.autoclaim-disabled", "&cAuto-Claiming&7 of land is now disabled."),
    AUTOCLAIM_REQUIRED_RANK("commands.f-autoclaim.autoclaim-required-rank", "&7You must be &c{rank}&7 in order to claim land."),
    AUTOCLAIM_DENY_OTHER_FACTION("commands.f-autoclaim.autoclaim-deny-other-faction", "&7You cannot claim land for &c{otherfaction}&7."),
    CMD_BAN_TARGET("commands.f-ban.cmd-ban-target", "&7You were banned from &c{faction}&7."),
    CMD_SUCCESSFUL_BAN("commands.f-ban.cmd-successful-ban", "&c{target} &7has banned &c{banned}&7."),
    CMD_NO_BAN_SELF("commands.f-ban.cmd-no-ban-self", "&7You may not ban yourself."),
    CMD_INSUFFICIENT_RANK("commands.f-ban.cmd-insufficient-rank", "&7Your rank is not high enough to ban &c{target}&7."),
    CMD_ALREADY_BANNED("commands.f-ban.cmd-already-banned", "&7This player is already banned."),
    CMD_BAN_HEADER("commands.f-banlist.cmd-ban-header", "&7There are &c{bans}&7 bans for &c{faction}&7."),
    CMD_BAN_ENTRY("commands.f-banlist.cmd-ban-entry", "&7"),
    CMD_BAN_NO_FACTION("commands.f-banlist.cmd-ban-no-faction", "&7You are not in a Faction."),
    CMD_INVALID_BAN_LOOKUP("commands.f-banlist.cmd-invalid-ban-lookup", "&7The faction &c{faction} &7does not exist."),
    CMD_PEACEFUL_ONLY("commands.f-boom.cmd-peaceful-only", "&7This command is only usable by factions which are specifically designated as peaceful."),
    CMD_BOOM_ENABLED("commands.f-boom.cmd-boom-enabled", "&c{target}&7 has &c{toggled}&7 explosions in your faction's territory."),
    CMD_BYPASS_ENABLE("commands.f-bypass.cmd-bypass-enable", "&7You have enabled admin bypass mode. You will be able to build or destroy anywhere."),
    CMD_ENABLE_LOG("commands.f-bypass.cmd-enable-log", " has ENABLED admin bypass mode."),
    CMD_BYPASS_DISABLE("commands.f-bypass.cmd-bypass-disable", "&7You have disabled admin bypass mode."),
    CMD_DISABLE_LOG("commands.f-bypass.cmd-disable-log", " has DISABLED admin bypass mode."),
    CMD_NOT_SET("commands.f-tpbanner.cmd-not-set", "&7Your faction does not have a &c&lWarBanner &7placed!"),
    CMD_SUCCESS("commands.f-tpbanner.cmd-success", "&cTeleporting to your faction's &c&lWarBanner&7."),
    CMD_FCHAT_DISABLED("commands.f-chat.cmd-fchat-disabled", "&7The built in chats are disabled on this server."),
    CMD_INVALID("commands.f-chat.cmd-invalid", "&7 Unrecognized Chat Mode, Please enter either &dA&7, &fP&7, &aF&7, &2T&7, &6M&7."),
    CMD_MOD_ONLY_MODE("commands.f-chat.cmd-mod-only-mode", "&7Only mods can talk through this chat mode."),
    CMD_PUBLIC_MODE("commands.f-chat.cmd-chat-mode.cmd-public-mode", "&7Public Chat Mode"),
    CMD_ALLY_MODE("commands.f-chat.cmd-chat-mode.cmd-ally-mode", "&dAlliance Only Chat Mode."),
    CMD_TRUCE_MODE("commands.f-chat.cmd-chat-mode.cmd-truce-mode", "&aFaction Only Chat Mode."),
    CMD_FACTION_MODE("commands.f-chat.cmd-chat-mode.cmd-faction-mode", "&dMod Only Chat Mode."),
    CMD_CHATSPY_ENABLE("commands.f-chatspy.cmd-chatspy-enable", "&7you have enabled chat spying mode."),
    CMD_ENABLE_LOG_F_CHATSPY("commands.f-chatspy.cmd-enable-log", " has ENABLED chat spying mode."),
    CMD_CHATSPY_DISABLE("commands.f-chatspy.cmd-chatspy-disable", "&7You have disabled chat spying mode."),
    CMD_DISABLE_LOG_F_CHATSPY("commands.f-chatspy.cmd-disable-log", " has DISABLED chat spying mode."),
    CMD_INVALID_CLAIM_RADIUS("commands.f-claim.cmd-invalid-claim-radius", "&7If you specify a radius, It must be at least &c{radius}&7."),
    CMD_CLAIM_DENY("commands.f-claim.cmd-claim-deny", "&7You do not have permission to claim in a radius."),
    CMD_PROTECTED_LAND("commands.f-claim.cmd-protected-land", "&7This land is protected."),
    CMD_DISABLED_CLAIM_IN_WORLD("commands.f-claim.cmd-disabled-claim-in-world", "&7Sorry, this world has land claiming disabled."),
    CMD_CANNOT_CLAIM("commands.f-claim.cmd-cannot-claim", "&7You cannot claim land for &c{faction}&7."),
    CMD_ALREADY_OWN("commands.f-claim.cmd-already-own", "&c{faction}&7 already owns this land."),
    CMD_MUST_BE("commands.f-claim.cmd-must-be", "&7You must be &c{role}&7 to claim land."),
    CMD_MEMBERS("commands.f-claim.cmd-members", "&7Factions must have at least &c{members}&7 members to claim land."),
    CMD_POWER("commands.f-claim.cmd-power", "&7You cannot claim more land, You need more power!"),
    CMD_LIMIT("commands.f-claim.cmd-limit", "&7Claim Limit Reached, You cannot claim any more land!"),
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
    CMD_COORDS_MSG("commands.f-coords.cmd-coords-msg", "&c{target}&7's coords are &c{x}, {y}, {z}, &7in &c{world}"),
    CMD_CHECKPOINT_DISABLED("commands.f-checkpoint.cmd-checkpoint-disabled", "&7You cannot use the checkpoints while it is disabled."),
    CMD_CHECKPOINT_SET("commands.f-checkpoint.cmd-checkpoint-set", "&7You have set the faction checkpoint at your Location!"),
    CMD_CHECKPOINT_GO("commands.f-checkpoint.cmd-checkpoint-go", "&7Teleporting to Faction checkpoint."),
    CMD_CHECKPOINT_INVALID_LOCATION("commands.f-checkpoint.cmd-checkpoint-invalid-location", "&7Invalid Location, You can set checkpoints in y our"),
    CMD_CHECKPOINT_NOT_SET("commands.f-checkpoint.cmd-checkpoint-not-set", "&7You have to set the faction checkpoint first."),
    CMD_CHECKPOINT_CLAIMED("commands.f-checkpoint.cmd-checkpoint-claimed", "&7Your current faction checkpoint is claimed, Set a new one!"),
    MUST_LEAVE("commands.f-create.must-leave", "&7You must leave your current faction first."),
    NAME_IN_USE("commands.f-create.name-in-use", "&7That tag is already in use."),
    CREATED("commands.f-create.created", "&c{target}&7 has created a new faction called &c{faction}&7."),
    YOU_SHOULD("commands.f-create.you-should", "&7You should now do /f desc <desc>."),
    CMD_CREATE_LOG("commands.f-create.cmd-create-log", " created a new faction: "),
    CMD_CREATE_ERROR("commands.f-create.cmd-create-error", "&7There was an internal error while trying to create your faction, Please try again ( Check Console 2 )"),
    CMD_CAN_DEINVITE("commands.f-deinvite.cmd-can-deinvite", "&7Players you can deinvite: "),
    CMD_CLICK_TO_DEINVITE("commands.f-deinvite.cmd-click-to-deinvite", "&7Click to revoke invite for &c{target}&7."),
    CMD_ALREADY_A_MEMBER("commands.f-deinvite.cmd-already-a-member", "&c{target}&7 is already a member of &c{faction}&7."),
    CMD_MIGHT_WANT_TO("commands.f-deinvite.cmd-might-want-to", "&7You might want to: &c{wantto}&7."),
    CMD_INVITE_REVOKE("commands.f-deinvite.cmd-invite-revoke", "&7{mod} revoked your invitation to {faction}&7."),
    CMD_INVITE_REVOKED("commands.f-deinvite.cmd-invite-revoked", "&7{mod} revoked {target}'s invitation."),
    CMD_DELETED_WARP("commands.f-delwarp.cmd-deleted-warp", "&7Deleted Warp &c{warp}&7."),
    CMD_INVALID_WARP("commands.f-delwarp.cmd-invalid-warp", "&7Could not find warp &c{warp}&7."),
    CMD_SYSTEM_FACTION("commands.f-disband.cmd-system-faction", "&7You cannot disband &2Wilderness&c, &eSafezone &7or &4Warzone."),
    CMD_PERM_FACTION("commands.f-disband.cmd-perm-faction", "&7This faction has been set as permanent, You cannot disband it."),
    CMD_YOUR_FACTION("commands.f-disband.cmd-broadcast-disband.cmd-your-faction", "&c{target}&7 disbanded your faction."),
    CMD_NOT_YOUR_FACTION("commands.f-disband.cmd-broadcast-disband.cmd-not-your-faction", "&c{target}&7 disbanded the faction &c{faction}&7."),
    CMD_BANK_TRANSFER("commands.f-disband.cmd-broadcast-disband.cmd-bank-transfer", "&7You have been given the factions bank which totals &c{value}&7."),
    CMD_PLAYER_DISBAND("commands.f-disband.cmd-broadcast-disband.cmd-player-disband", "&7You have disbanded your faction."),
    CMD_DISABLED("commands.f-fly.cmd-disabled", "&7Sorry, Faction Flight is disabled on this server."),
    CMD_CHANGE("commands.f-fly.cmd-change", "&7Faction Flight &c{toggled}&7."),
    CMD_COOLDOWN("commands.f-fly.cmd-cooldown", "&7You will not take fall damage for &c{amount} &7seconds."),
    CMD_DAMAGE("commands.f-fly.cmd-damage", "&7Faction Flight disabled due to entering combat."),
    CMD_OTHER_TERRITORY("commands.f-fly.cmd-anti-fly.cmd-other-territory", "&7Cannot fly in the territory of &c{faction}&7."),
    CMD_ANTI_EPEARL("commands.f-fly.cmd-anti-fly.cmd-anti-epearl", "&7Cannot throw pearls while flying!"),
    CMD_ENEMY_NEAR("commands.f-fly.cmd-enemy-checks.cmd-enemy-near", "&7Flight has been disabled, an enemy is nearby."),
    CMD_ENEMY_NEAR_ALERT("commands.f-fly.cmd-enemy-checks.cmd-enemy-near-alert", "&7Cannot fly here, an enemy is nearby."),
    CMD_FOCUS_SAME_FACTION("commands.f-focus.cmd-focus-same-faction", "&7You may not focus players in your faction!"),
    CMD_CURRENTLY_FOCUSING("commands.f-focus.cmd-currently-focusing", "&7Your faction is now focusing on &c{focused}&7."),
    CMD_NO_LONGER_FOCUSING("commands.f-focus.cmd-no-longer-focusing", "&7Your faction is no longer focusing on &c{focused}&7."),
    CMD_CLICK_TO_WARP("commands.f-warp.cmd-click-to-warp", "&7Click To Warp!"),
    CMD_FWARP_FORMAT("commands.f-warp.cmd-fwarp-format", "&7/f warp <warpname> &c[password]"),
    CMD_SUCCESSFUL_WARP("commands.f-warp.cmd-successful-warp", "&7Warped To &c{warp}&7."),
    CMD_WARP("commands.f-warp.cmd-invalid-warp.cmd-warp", "&7Could not find warp &c{invalid-warp}&7."),
    CMD_PASSWORD("commands.f-warp.cmd-invalid-warp.cmd-password", "&7Invalid Password!"),
    CMD_WARPS("commands.f-warp.cmd-warps", "&7Warps: "),
    CMD_REQUIRED("commands.f-warp.cmd-warp-password.cmd-required", "&7Warp Password:"),
    CMD_TIME_OUT("commands.f-warp.cmd-warp-password.cmd-time-out", "&7Warp Password Timed Out."),
    CMD_PERMISSION("commands.f-perms.cmd-permission", "&7You do not have permission to edit faction perms."),
    CMD_DESCRIPTION("commands.f-perms.cmd-description", "&7Edit or list your Faction's permissions."),
    CMD_FPERMS_DENY_ACTION("commands.f-perms.cmd-fperms-deny-action", "&7The faction leader does not allow you to &c{action}&7."),
    CMD_RELATION("commands.f-perms.cmd-invalid.cmd-relation", "&7Invalid Relation Defined, Try something like Ally."),
    CMD_ACCESS("commands.f-perms.cmd-invalid.cmd-access", "&7Invalid Access Defined, Try something like Allow."),
    CMD_ACTION("commands.f-perms.cmd-invalid.cmd-action", "&7Invalid Action Defined, Try something like Build."),
    CMD_SET("commands.f-perms.cmd-invalid.cmd-set", "&7Set Permission &c{perm}&7 to &c{toggled}&7 for relation &c{relation}&7."),
    CMD_TOP("commands.f-perms.cmd-invalid.cmd-top", "RCT MEM OFF ALLY TRUCE NEUT ENEMY"),
    CMD_LOCKED("commands.f-perms.cmd-invalid.cmd-locked", "&cThis permission has been locked by the server."),
    CMD_DISABLED_F_HOME("commands.f-perms.f-home.cmd-disabled", "&7Faction Homes are disabled on this server."),
    CMD_TELEPORT_DISABLED("commands.f-perms.f-home.cmd-teleport-disabled", "&7The ability to teleport to Faction Homes is disabled on this server."),
    CMD_NO_HOME_F_HOME("commands.f-perms.f-home.cmd-no-home", "&7Your faction does not have a home."),
    CMD_ENEMY_TERRITORY_DENY("commands.f-perms.f-home.cmd-enemy-territory-deny", "&7You cannot teleport your faction home while in the territory of an enemy."),
    CMD_WRONG_WORLD("commands.f-perms.f-home.cmd-wrong-world", "&7You cannot teleport to your faction home while in a different world."),
    CMD_ENEMY_NEAR_F_HOME("commands.f-perms.f-home.cmd-enemy-near", "&7You cannot teleport to your faction home while an enemy is within &c{radius} &7blocks of you."),
    CMD_BLOCKED("commands.f-perms.f-home.cmd-blocked", "&7You may not teleport to a home that is claimed by &c{faction}&7."),
    CMD_DISABLED_MSG("commands.f-perms.f-inspect.cmd-disabled-msg", "&7Inspection Mode is now disabled."),
    CMD_ENABLED_MSG("commands.f-perms.f-inspect.cmd-enabled-msg", "&7Inspection Mode is now enabled."),
    CMD_NO_FAC_MSG("commands.f-perms.f-inspect.cmd-no-fac-msg", "&7Inspection Mode is now disabled because you do not have a faction."),
    CMD_INSPECT_HEADER("commands.f-perms.f-inspect.cmd-inspect-header", "&c&m---&7Inspect Data&c&m---&c//&7x:{x},y:{y},z:{z}"),
    CMD_INSPECT_ROW("commands.f-perms.f-inspect.cmd-inspect-row", "&c{time} &7// &c{action} &7// &c{player} &7// &c{block-type}"),
    CMD_INSPECT_NO_DATE("commands.f-perms.f-inspect.cmd-inspect-no-date", "&7No data was found!"),
    CMD_INSPECT_NOT_IN_CLAIM("commands.f-perms.f-inspect.cmd-inspect-not-in-claim", "&7You can only inspect in your faction claims."),
    CMD_INSPECT_BYPASS("commands.f-perms.f-inspect.cmd-inspect-bypass", "&7Inspecting in Bypass Mode."),
    CMD_INVITED_YOU("commands.f-perms.f-invite.cmd-invited-you", "&c{player}&7 has invited you to join &c{faction}&7."),
    CMD_INVITE_SENT("commands.f-perms.f-invite.cmd-invite-sent", "&c{player}&7 invited &c{target}&7 to your faction."),
    CMD_ALREADY_INVITED("commands.f-perms.f-invite.cmd-already-invited", "&c{target}&7 already has an invite pending."),
    CMD_ALREADY_MEMBER("commands.f-perms.f-invite.cmd-already-member", "&c{target}&7 is already a member of &c{faction}&7."),
    CMD_BANNED_MEMBER("commands.f-perms.f-invite.cmd-banned-member", "&c{target}&7 is banned from your faction, Invite is not being sent."),
    CMD_CANNOT_FORCE_JOIN("commands.f-perms.f-join.cmd-cannot-force-join", "&7You do not have permission to move other players into a faction."),
    CMD_CANNOT_JOIN_SYSTEM_FACTION("commands.f-perms.f-join.cmd-cannot-join-system-faction", "&7Players may only join normal factions, This is a system faction."),
    CMD_MAX_LIMIT("commands.f-perms.f-join.cmd-max-limit", "&cThe faction &c{faction}&7 is at the limit of &c{allowed}&7 members so &c{target}&7 cannot join."),
    CMD_NEGATIVE_POWER_LEAVE("commands.f-perms.f-join.cmd-negative-power-leave", "&c{target}&7 cannot join another faction with a negative power level."),
    CMD_REQUIRES_INVITE("commands.f-perms.f-join.cmd-requires-invite", "&c{faction}&7 requires an invite to join."),
    CMD_TRIED_TO_JOIN("commands.f-perms.f-join.cmd-tried-to-join", "&c{target}&7 tried to join your faction."),
    CMD_SUCCESS_JOIN("commands.f-perms.f-join.cmd-success-join", "&c{target}&7 successfully joined &c{faction}&7."),
    CMD_FACTION_MOVED("commands.f-perms.f-join.cmd-faction-moved", "&c{staff}&7 moved the player &c{target}&7 into the faction &c{faction}&7."),
    CMD_FACTION_BANNED("commands.f-perms.f-join.cmd-faction-banned", "&7You are banned from &c{faction}&7 for &c{reason}&7."),
    CMD_FACTION_JOIN_LOG("commands.f-perms.f-join.cmd-faction-join-log", ""),
    CMD_FACTION_MOVED_LOG("commands.f-perms.f-join.cmd-faction-moved-log", ""),
    CMD_AVAILABLE_KICKS("commands.f-perms.f-kick.cmd-available-kicks", "&cPlayers you can kick: "),
    CMD_CLICK_TO_KICK("commands.f-perms.f-kick.cmd-click-to-kick", "&6Click To Kick "),
    CMD_CANNOT_KICK_SELF("commands.f-perms.f-kick.cmd-cannot-kick-self", "&6You cannot kick yourself."),
    CMD_FACTIONLESS_PLAYER("commands.f-perms.f-kick.cmd-factionless-player", "&6That player is not in a faction."),
    CMD_NOT_A_MEMBER_F_KICK("commands.f-perms.f-kick.cmd-not-a-member", "&c{target}&7 is not a member of {faction}."),
    CMD_INSUFFICIENT_RANK_F_KICK("commands.f-perms.f-kick.cmd-insufficient-rank", "&7Your rank is not high enough to kick this player."),
    CMD_NEGATIVE_POWER_KICK("commands.f-perms.f-kick.cmd-negative-power-kick", "&7You cannot kick that member until their power is in the positives."),
    CMD_FACTION_SUCCESS_KICK("commands.f-perms.f-kick.cmd-faction-success-kick", "&c{player}&7 has kicked &c{target}&7 from the faction!"),
    CMD_FACTION_YOU_ARE_KICKED("commands.f-perms.f-kick.cmd-faction-you-are-kicked", "&c{player}&7 has kicked you from &c{faction}&7."),
    CMD_FACTION_LIST("commands.f-perms.f-list.cmd-faction-list", "&7Faction List "),
    CMD_ONLINE_FACTIONLESS("commands.f-perms.f-list.cmd-online-factionless", "&7Online Factionless: "),
    CMD_FAC_LOCKED("commands.f-perms.f-lock.cmd-fac-locked", "&7Factions is now locked."),
    CMD_FAC_UNLOCKED("commands.f-perms.f-lock.cmd-fac-unlocked", "&7Factions is now unlocked."),
    CMD_TOGGLE_MSG("commands.f-perms.f-login.cmd-toggle-msg", "&7Set login / logout notifications for Faction Members to: &c{toggled}&7."),
    CMD_UPDATE_ENABLED("commands.f-perms.f-map.cmd-update-enabled", "&7Map Auto Update &aENABLED."),
    CMD_UPDATE_DISABLED("commands.f-perms.f-map.cmd-update-disabled", "&7Map Auto Update &cDISABLED>"),
    CMD_MAP_SET("commands.f-perms.f-mapheight.cmd-map-set", "&7Set /f map lines to &c{lines}&7."),
    CMD_MAP_CURRENT("commands.f-perms.f-mapheight.cmd-map-current", "&7Current Map-Height: &c{map-height}&7."),
    CMD_CANDIDATES("commands.f-perms.faction-ranks-promo.cmd-candidates", "&7Players you can promote: "),
    CMD_CLICK_TO_PROMOTE("commands.f-perms.faction-ranks-promo.cmd-click-to-promote", "&7Click to promote "),
    CMD_NOT_MEMBER("commands.f-perms.faction-ranks-promo.cmd-not-member", "&c{target}&7 is not a member in your faction."),
    CMD_NOT_ADMIN("commands.f-perms.faction-ranks-promo.cmd-not-admin", "&7You are not the faction admin."),
    CMD_TARGET_IS_SELF("commands.f-perms.faction-ranks-promo.cmd-target-is-self", "&7You cannot promote yourself."),
    CMD_TARGET_IS_ADMIN("commands.f-perms.faction-ranks-promo.cmd-target-is-admin", "&7The target is a faction admin, demote them first."),
    CMD_REVOKES_MOD("commands.f-perms.f-mod.cmd-revokes-mod", "&7You have removed moderator status from &c{target}&7."),
    CMD_REVOKED_MOD("commands.f-perms.f-mod.cmd-revoked-mod", "&c{target}&7 is no longer a moderator in your faction."),
    CMD_MOD_PROMOTES("commands.f-perms.f-mod.cmd-mod-promotes", "&c{target}&7 was promoted to moderator in your faction."),
    CMD_MOD_PROMOTED("commands.f-perms.f-mod.cmd-mod-promoted", "&7You have promoted &c{target}&7 to moderator."),
    CMD_REVOKES_COLEADER("commands.f-perms.f-coleader.cmd-revokes-coleader", "&7You have removed co-leader status from &c{target}&7."),
    CMD_REVOKED_COLEADER("commands.f-perms.f-coleader.cmd-revoked-coleader", "&c{target}&7 is no longer a co-leader in your faction."),
    CMD_CO_PROMOTES("commands.f-perms.f-coleader.cmd-co-promotes", "&c{target}&7 was promoted to co-leader in your faction."),
    CMD_CO_PROMOTED("commands.f-perms.f-coleader.cmd-co-promoted", "&7You have promoted &c{target}&7 to co-leader."),
    CMD_POWER_ADDED("commands.f-perms.f-modifypower.cmd-power-added", "&7Added &c{power}&7 power to &c{target}&7, New total rounded power: &c{totalpower}&7."),
    CMD_MONEY_DESCRIPTION("commands.f-perms.f-money.cmd-money-description", "&7Faction Money Commands."),
    CMD_MONEY_BALANCE("commands.f-perms.f-money.cmd-money-balance", "&c{bank}&7 >> This is your current faction balance."),
    CMD_MONEY_DEPOSIT("commands.f-perms.f-money.cmd-money-deposit", "&c{target}&7 deposited &c{amount} in the faction bank: &c{newamount}&7."),
    CMD_MONEY_TRANSFER_FACTION("commands.f-perms.f-money.transfer-money.cmd-money-transfer-faction", "&c{target}&7 transferred &c{amount}&7 from the faction &c{faction} to the faction &c{faction-2}&7."),
    CMD_MONEY_TRANSFER_PLAYER("commands.f-perms.f-money.transfer-money.cmd-money-transfer-player", "&c{target}&7 transferred &c{amount}&7 from the faction &c{faction} to the player &c{target}&7."),
    CMD_MONEY_TRANSFER_PLAYER_FACTION("commands.f-perms.f-money.transfer-money.cmd-money-transfer-player-faction", "&c{target}&7 transferred &c{amount}&7 from the player &c{target} to the faction &c{faction}&7."),
    CMD_MONEY_WITHDRAW_FACTION("commands.f-perms.f-money.transfer-money.cmd-money-withdraw-faction", "&c{target} withdrew &c{amount} from the faction bank: &c{value-taken}"),
    CMD_OPENED_CHANGES("commands.f-perms.f-open.cmd-opened-changes", "&c{target}&7 has changed the faction to be &c{toggled}&7."),
    CMD_OPENED_CHANGED("commands.f-perms.f-open.cmd-opened-changed", "&7The faction &c{faction} is now &c{toggled}&7."),
    CMD_FOWNER_DISABLED("commands.f-perms.f-owner.cmd-fowner-disabled", "&7Sorry, Owned Areas are disabled on this server."),
    CMD_FOWNER_LIMIT("commands.f-perms.f-owner.cmd-fowner-limit", "&7Sorry but you have reached the server's limit of &c{owned}&7 owned areas per faction."),
    CMD_FOWNER_WRONG_FACTION("commands.f-perms.f-owner.cmd-fowner-wrong-faction", "&7This land is not claimed by your faction so you cannot set ownership of it."),
    CMD_FOWNER_NOT_CLAIMED("commands.f-perms.f-owner.cmd-fowner-not-claimed", "&7This land is not claimed by a faction, Ownership is not possible."),
    CMD_FOWNER_NOT_MEMBER("commands.f-perms.f-owner.cmd-fowner-not-member", "&c{target}&7 is not a member of this faction."),
    CMD_FOWNER_CLEARED("commands.f-perms.f-owner.cmd-fowner-cleared", "&7You have cleared ownership for this claimed area."),
    CMD_FOWNER_REMOVED("commands.f-perms.f-owner.cmd-fowner-removed", "&7You have removed ownership of this claimed land from &c{target}&7."),
    CMD_FOWNER_ADDED("commands.f-perms.f-owner.cmd-fowner-added", "&7You have added &c{target} to the owner list for this claimed land."),
    CMD_NONE("commands.f-perms.f-ownerlist.cmd-none", "&7No owners are set here, Everyone in the faction has access."),
    CMD_OWNERS("commands.f-perms.f-ownerlist.cmd-owners", "&7Current Owner(s) of this land: &c{owners}&7."),
    CMD_NO_SELECTED_PARTICLE("commands.f-perms.f-particle.cmd-no-selected-particle", "&7You can select a particle using &c/f particle&7."),
    CMD_SELECTED_PARTICLE("commands.f-perms.f-particle.cmd-selected-particle", "&7You have selected the &c{particle} particle type!"),
    CMD_DESCRIPTION_F_PAYPAL("commands.f-perms.f-paypal-set.cmd-description", "&7Set the email of your faction to claim rewards."),
    CMD_CREATED("commands.f-perms.f-paypal-set.cmd-created", "&7Make sure to type &c/f <paypal/setpaypal> <email>&7."),
    CMD_SUCCESSFUL("commands.f-perms.f-paypal-set.cmd-successful", "&7Successfully set your factions email - &c{email}&7."),
    CMD_DESCRIPTION_F_PAYPALSEE("commands.f-perms.f-paypal-see.cmd-description", "View the specific factions paypal email with &c/f <seepaypal/getpaypal> <faction>&7."),
    CMD_PAYPAL("commands.f-perms.f-paypal-see.cmd-faction.cmd-paypal", "&c{faction}'s &&faction has their paypal set to &c{email}&7."),
    CMD_NOT_SET_F_PAYPALSEE("commands.f-perms.f-paypal-see.cmd-faction.cmd-not-set", "&c{faction}'s&7 paypal has not yet been set."),
    CMD_NO_FACTION("commands.f-perms.f-paypal-see.cmd-faction.cmd-no-faction", "&c{target} &7 does not have a faction."),
    CMD_FPEACEFUL_DESCRIPTION("commands.f-perms.f-peaceful.cmd-fpeaceful-description", "&7Set a faction to peaceful."),
    CMD_FPEACEFUL_YOURS("commands.f-perms.f-peaceful.cmd-fpeaceful-yours", "&c{target}&7 has &c{relation-changed}&7 your faction."),
    CMD_FPEACEFUL_OTHER("commands.f-perms.f-peaceful.cmd-fpeaceful-other", "&c{target}&7 has &c{relation-changed}&7 the faction &c{faction}&7."),
    CMD_FPEACEFUL_REVOKE("commands.f-perms.f-peaceful.cmd-fpeaceful-revoke", "&7Granted peaceful status to"),
    CMD_FPEACEFUL_GRANT("commands.f-perms.f-peaceful.cmd-fpeaceful-grant", "&7Removed peaceful status from"),
    CMD_FPERMN_DESCRIPTION("commands.f-perms.f-permanent.cmd-fpermn-description", "&7Toggle permanent faction power option."),
    CMD_FPERMN_GRANT("commands.f-perms.f-permanent.cmd-fpermn-grant", "&7Added permanentpower status to"),
    CMD_FPERMN_REVOKE("commands.f-perms.f-permanent.cmd-fpermn-revoke", "&7Removed permanentpower status from"),
    CMD_FPERMN_YOURS("commands.f-perms.f-permanent.cmd-fpermn-yours", "&7You &c{power} {status}&7."),
    CMD_FPERMN_OTHER("commands.f-perms.f-permanent.cmd-fpermn-other", "&c{power} {status} &7your faction."),
    CMD_DESCRIPTION_F_PROMOTE("commands.f-perms.f-promote.cmd-description", "/f promote <name>"),
    CMD_FPROMO_SUCCESS("commands.f-perms.f-promote.cmd-fpromo-success", "&7You have successfully promoted &c{target} to &c{role}&7."),
    CMD_ADMIN("commands.f-perms.f-promote.cmd-co-leader.cmd-admin", "&7"),
    CMD_WRONG_FACTION("commands.f-perms.f-promote.cmd-wrong-faction", "&c{target}&7 is not a part of your faction."),
    CMD_NOT_THAT_PLAYER("commands.f-perms.f-promote.cmd-not-that-player", "&7That player cannot be promoted."),
    CMD_NOT_ALLOWED("commands.f-perms.f-promote.cmd-not-allowed", "&7You cannot promote to the same rank as yourself."),
    CMD_NOT_SELF("commands.f-perms.f-promote.cmd-not-self", "&7You cannot manage your own rank."),
    CMD_POWER_F_POWER("commands.f-perms.f-power.cmd-power", "&c{power} » &7Power / &7MaxPower &8» &c{power} &7/ &c{maxpower}&7."),
    CMD_BONUS("commands.f-perms.f-power.cmd-bonus", " (bonus: "),
    CMD_PENALTY("commands.f-perms.f-power.cmd-penalty", " (penalty: "),
    CMD_DESCRIPTION_F_POWER("commands.f-perms.f-power.cmd-description", "&7Show Player Power Info"),
    CMD_SAVEALL_SUCCESS("commands.f-perms.f-saveall.cmd-saveall-success", "&7Factions was saved to disk!"),
    CMD_SETBANNER_SUCCESS("commands.f-perms.f-setbanner.cmd-setbanner-success", "&7Banner Pattern Set!"),
    CMD_NOT_BANNER("commands.f-perms.f-setbanner.cmd-not-banner", "&7This item is not a banner!"),
    CMD_NOT_THAT_ROLE("commands.f-perms.f-setdefaultrole.cmd-not-that-role", "&7You cannot set the default to admin."),
    CMD_DEFAULTROLE_SUCCESS("commands.f-perms.f-setdefaultrole.cmd-defaultrole-success", "&7Set default role of your faction to &c{role}&7."),
    CMD_INVALID_ROLE("commands.f-perms.f-setdefaultrole.cmd-invalid-role", "&7Could not find a matching role for &c{role}&7."),
    CMD_NOT_CLAIMED("commands.f-perms.f-setwarp.cmd-not-claimed", "&7You can only set warps in your faction territory."),
    CMD_LIMIT_F_SETWARP("commands.f-perms.f-setwarp.cmd-limit", "&7Your faction already has the max amount of warps set &8(&c{warps}&8)."),
    CMD_SET_F_SETWARP("commands.f-perms.f-setwarp.cmd-set", "&7Set Warp &c{warp} &7and password &c{password} &7to your location."),
    CMD_FHOME_DISABLED("commands.f-perms.f-sethome.cmd-fhome-disabled", "&7Sorry, Faction Homes are disabled on this server."),
    CMD_FHOME_NOT_CLAIMED("commands.f-perms.f-sethome.cmd-fhome-not-claimed", "&7Sorry, You can only have a faction home inside your claimed territory."),
    CMD_FHOME_SET("commands.f-perms.f-sethome.cmd-fhome-set", "&c{target}&7 set the home for your faction. You can now use:"),
    CMD_FHOME_SET_OTHER("commands.f-perms.f-sethome.cmd-fhome-set-other", "&7You have set the f-home for the &c{faction}&7 faction."),
    CMD_MAXVAULTS_SUCCESS("commands.f-perms.f-setmaxvaults.cmd-maxvaults-success", "&7Set max vaults from &c{oldmax} &7to &c{newmax}&7."),
    CMD_INVALID_F_VAULT("commands.f-perms.f-vault.cmd-invalid", "&7Your vault was either claimed, broken and or has not been placed yet."),
    CMD_OPENING("commands.f-perms.f-vault.cmd-opening", "&7Opening faction vault..."),
    CMD_NO_HOPPER_NEAR_VAULT("commands.f-perms.f-vault.cmd-no-hopper-near-vault", "&7You cannot place a hopper near a vault."),
    CMD_VAULT_ALREADY_SET("commands.f-perms.f-getvault.cmd-vault-already-set", "&7Vault has already been set!"),
    CMD_VAULT_ALREADY_HAVE("commands.f-perms.f-getvault.cmd-vault-already-have", "&7You already have a vault in your inventory!"),
    CMD_VAULT_CHEST_NEAR("commands.f-perms.f-getvault.cmd-vault-chest-near", "&7There is a chest/hopper nearby."),
    CMD_VAULT_SUCCESS("commands.f-perms.f-getvault.cmd-vault-success", "&7Successfully set a vault."),
    CMD_VAULT_INVALID_LOCATION("commands.f-perms.f-getvault.cmd-vault-invalid-location", "&7Vault can only be placed in faction land!"),
    CMD_VAULT_RECEIVE("commands.f-perms.f-getvault.cmd-vault-receive", "&7You have received a faction vault!"),
    CMD_VAULT_NO_MONEY("commands.f-perms.f-getvault.cmd-vault-no-money", "&7You do not have enough money."),
    CMD_VAULT_MONEY_TAKE("commands.f-perms.f-getvault.cmd-vault-money-take", "&c{amount} &7has been taken from your account."),
    CMD_SELF("commands.f-perms.f-show.cmd-no-faction.cmd-self", "&7You are not in a faction."),
    CMD_OTHER("commands.f-perms.f-show.cmd-no-faction.cmd-other", "&7That is not a faction."),
    CMD_PEACEFULF_SHOW("commands.f-perms.f-show.cmd-peaceful", "&7This faction is a peaceful faction."),
    CMD_PERMANENT("commands.f-perms.f-show.cmd-permanent", "&7This faction is permanent remaining even with no members."),
    CMD_JOINING("commands.f-perms.f-show.cmd-joining", "&7Joining: &c{faction}&7."),
    CMD_INVITATION("commands.f-perms.f-show.cmd-invitation", "&7Invitation is required."),
    CMD_UNINVITED("commands.f-perms.f-show.cmd-uninvited", "&7No invite is required."),
    CMD_NO_HOME_F_HOME_2("commands.f-perms.f-show.cmd-no-home", "&7N/A"),
    CMD_POWER_F_SHOW("commands.f-perms.f-show.cmd-power", "&7Land / Power / MaxPower: &c{land}&7/&c{power}&7/&c{maxpower}."),
    CMD_BONUS_F_SHOW("commands.f-perms.f-show.cmd-bonus", "(bonus: "),
    CMD_PENALTY_F_SHOW("commands.f-perms.f-show.cmd-penalty", "(penalty: "),
    CMD_DEPRECIATED("commands.f-perms.f-show.cmd-depreciated", "&8(&c{1} &7depreciated&8)"),
    CMD_LAND_VALUE("commands.f-perms.f-show.cmd-land-value", "&7Total Land Value: &c{v-1} {v-2}"),
    CMD_BANK_CONTAINS("commands.f-perms.f-show.cmd-bank-contains", "&7Bank Contains: &c{bank}&7."),
    CMD_ALLIES("commands.f-perms.f-show.cmd-allies", "&7Allies: "),
    CMD_ENEMIES("commands.f-perms.f-show.cmd-enemies", "&7Enemies: "),
    CMD_MEMBERS_ONLINE("commands.f-perms.f-show.cmd-members-online", "&7Members Online: "),
    CMD_MEMBERS_OFFLINE("commands.f-perms.f-show.cmd-members-offline", "&7Members Offline: "),
    CMD_DEATHS_TILL_RAIDABLE("commands.f-perms.f-show.cmd-deaths-till-raidable", "&7DTR: &c{dtr}&7."),
    CMD_EXEMPT("commands.f-perms.f-show.cmd-exempt", "&7This faction is exempt and cannot be seen."),
    CMD_NEED_FACTION("commands.f-perms.f-show.cmd-need-faction", "&7You need to join a faction to view your own!"),
    CMD_HEADER("commands.f-perms.f-showclaims.cmd-header", "&8&m-------------&8<}faction}(s) claims&8>&8&m-------------"),
    CMD_FORMAT_F_SHOWCLAIMS("commands.f-perms.f-showclaims.cmd-format", "&8[{world}]:"),
    CMD_CHUNKS_FORMAT("commands.f-perms.f-showclaims.cmd-chunks-format", "&8(&c{x}&8,&c{z}&8)"),
    CMD_PENDING("commands.f-perms.f-showinvites.cmd-pending", "&7Players with pending invites: "),
    CMD_CLICK_TO_REVOKE("commands.f-perms.f-showinvites.cmd-click-to-revoke", "&7Click to revoke invite for &c{invite}&7."),
    CMD_TOGGLE("commands.f-perms.f-spawnertoggle.cmd-toggle", "&7Spawner placing has been toggled &c{toggled}&7."),
    CMD_PLACE_DENY("commands.f-perms.f-spawnertoggle.cmd-place-deny", "&7Spawner placing is currently disabled."),
    CMD_FORMAT_F_STATUS("commands.f-perms.f-status.cmd-format", "&c{power}&7 Power: &c{target}&7 last seen: &c{timestamp}&7."),
    CMD_ONLINE("commands.f-perms.f-status.cmd-online", "&7Online"),
    CMD_AGO_SUFFIX("commands.f-perms.f-status.cmd-ago-suffix", " ago."),
    CMD_CHANGED("commands.f-perms.f-strikes.cmd-changed", "&7You have set &c{faction}&7 strikes to &c{strikes}&7."),
    CMD_INFO("commands.f-perms.f-strikes.cmd-info", "&c{faction}&7 has &c{strikes}&7 strikes."),
    CMD_TARGET_INVALID("commands.f-perms.f-strikes.cmd-target-invalid", "&7The faction &c{faction}&7 is invalid."),
    CMD_STRUCK("commands.f-perms.f-strikes.cmd-struck", "&7Your faction has been changed by &c{target}&7, Your faction now has &c{strikes&7/&c{maxstrikes}&7."),
    CMD_ENABLE("commands.f-perms.f-stealth.cmd-enable", "&cStealth &8» &7You enabled stealth mode."),
    CMD_DISABLE("commands.f-perms.f-stealth.cmd-disable", "&cStealth &8» &7You disabled stealth mode."),
    CMD_MUST_BE_MEMBER("commands.f-perms.f-stealth.cmd-must-be-member", "&cStealth &8» &7You must be in a faction to use this command."),
    CMD_CANCELLED("commands.f-perms.f-stuck.cmd-cancelled", "&7Teleporting cancelled because you were damaged."),
    CMD_OUTSIDE("commands.f-perms.f-stuck.cmd-outside", "&7Teleport cancelled because you left &c{radius}&7 block radius."),
    CMD_EXISTS("commands.f-perms.f-stuck.cmd-exists", "&7You are already teleporting, You must wait &c{time}&7."),
    CMD_START("commands.f-perms.f-stuck.cmd-start", "&7Teleport will commence in &c{time}&7. Do not take or deal damage."),
    CMD_TELEPORT("commands.f-perms.f-stuck.cmd-teleport", "&7Teleported safely to &c{x}&7, &c{y}&7, &c{z}&7."),
    CMD_ENABLED_F_SEECHUNK("commands.f-perms.f-seechunk.cmd-enabled", "&7See-Chunk Disabled!"),
    CMD_DISABLED_F_SEECHUNK("commands.f-perms.f-seechunk.cmd-disabled", "&7See-Chunk Enabled!"),
    CMD_TAG_TAKEN("commands.f-perms.f-tag.cmd-tag-taken", "&7This tag is already taken."),
    CMD_TAG_FACTION("commands.f-perms.f-tag.cmd-tag-faction", "&c{target} changed your faction tag to &c{tag}&7."),
    CMD_TAG_CHANGED("commands.f-perms.f-tag.cmd-tag-changed", "&7The faction &c{target}&7 has changed their name to &c{tag}&7."),
    CMD_CHANGED_F_TITLE("commands.f-perms.f-title.cmd-changed", "&c{target} &7changed a title: &c{target-2}&7."),
    CMD_DISABLED_F_SCOREBOARD("commands.f-perms.f-togglescoreboard.cmd-disabled", "&7You cannot toggle scoreboards while they are disabled."),
    CMD_TOP_TOP("commands.f-perms.f-top.cmd-top-top", "&7Top Factions By &c{target}. Page }1}/}2}"),
    CMD_TOP_LINE("commands.f-perms.f-top.cmd-top-line", "&7{rank}. &6{faction}: &c{value}"),
    CMD_TOP_INVALID("commands.f-perms.f-top.cmd-top-invalid", "&7Could not sort by &c{option}&7. try Balance, Online, Members, Power Or Land."),
    CMD_TNT_DISABLED_MSG("commands.f-perms.f-tnt.cmd-tnt-disabled-msg", "&7This command is disabled."),
    CMD_TNT_INVALID_NUM("commands.f-perms.f-tnt.cmd-tnt-invalid-num", "&7The amount needs to be a number."),
    CMD_TNT_DEPOSIT_SUCCESS("commands.f-perms.f-tnt.cmd-tnt-deposit-success", "&7Successfully deposited TNT."),
    CMD_TNT_EXCEED_LIMIT("commands.f-perms.f-tnt.cmd-tnt-exceed-limit", "&7This exceeds the bank limit!"),
    CMD_TNT_WITHDRAW_SUCCESS("commands.f-perms.f-tnt.cmd-tnt-withdraw-success", "&7Successfully withdrew TNT."),
    CMD_TNT_WITHDRAW_NOT_ENOUGH("commands.f-perms.f-tnt.cmd-tnt-withdraw-not-enough", "&7Not enough TNT in bank."),
    CMD_TNT_DEPOSIT_NOT_ENOUGH("commands.f-perms.f-tnt.cmd-tnt-deposit-not-enough", "&7Not enough TNT in the inventory."),
    CMD_TNT_AMOUNT("commands.f-perms.f-tnt.cmd-tnt-amount", "&7Your faction has &c{amount} TNT in the TNT Bank."),
    CMD_TNT_POSITIVE("commands.f-perms.f-tnt.cmd-tnt-positive", "&7Please use positive numbers!"),
    CMD_TNT_WITHDRAW_NOT_ENOUGH_SPACE("commands.f-perms.f-tnt.cmd-tnt-withdraw-not-enough-space", "&7Not enough space in your inventory."),
    CMD_TNT_ADD_ARGS("commands.f-perms.f-tnt.cmd-tnt-add-args", "&c/f tnt add <amount>"),
    CMD_TNT_REMOVE_ARGS("commands.f-perms.f-tnt.cmd-tnt-remove-args", "&c/f tnt take <amount>"),
    CMD_TNTFILL_HEADER("commands.f-perms.f-tntfill.cmd-tntfill-header", "&7Filling TNT in dispensers..."),
    CMD_TNTFILL_SUCCESS("commands.f-perms.f-tntfill.cmd-tntfill-success", "&7Filled &c{amount}&7 TNT in &c{dispensers} &7dispensers."),
    CMD_TNTFILL_NOT_ENOUGH("commands.f-perms.f-tntfill.cmd-tntfill-not-enough", "&7Not enough TNT in inventory."),
    CMD_TNTFILL_RADIUS_MAX("commands.f-perms.f-tntfill.cmd-tntfill-radius-max", "&7The max radius is &c{max}&7."),
    CMD_TNTFILL_AMOUNT_MAX("commands.f-perms.f-tntfill.cmd-tntfill-amount-max", "&7The max amount is &c{max}&7."),
    CMD_TNTFILL_MOD("commands.f-perms.f-tntfill.cmd-tntfill-mod", "&7TNT will be used from the faction bank because you do not have the specified amount."),
    CMD_TARGET_NOT_BANNED("commands.f-perms.f-unban.cmd-target-not-banned", "&c{target}&7 is not banned, Not performing anything."),
    CMD_TARGET_UNBANNED("commands.f-perms.f-unban.cmd-target-unbanned", "&c{mod}&7 unbanned &c{target}&7."),
    CMD_UNBAN_TARGET("commands.f-perms.f-unban.cmd-unban-target", "&7You have been unbanned from &c{faction}&7."),
    CMD_UNCLAIM_SUCCESS("commands.f-perms.f-unclaim.cmd-unclaim-safezone.cmd-unclaim-success", "&6SafeZone&7 was unclaimed."),
    CMD_UNCLAIM_NO_PERMS("commands.f-perms.f-unclaim.cmd-unclaim-safezone.cmd-unclaim-no-perms", "&7This is a SafeZone, You lack permission to unclaim."),
    CMD_UNCLAIMALL_SAFEZONE("commands.f-perms.f-unclaim.cmd-unclaim-safezone.cmd-unclaimall-safezone", "&7You have unclaimed ALL &6&lSafeZone&7 land."),
    CMD_UNCLAIMALL_SAFEZONE_LOG("commands.f-perms.f-unclaim.cmd-unclaim-safezone.cmd-unclaimall-safezone-log", "&c{target}&7 unclaimed all &6&lSafeZone&7."),
    CMD_SAFEZONE_ENTER("commands.f-perms.f-unclaim.cmd-unclaim-safezone.cmd-safezone-enter", "&6Safezone"),
    CMD_SAFEZONE_DESCRIPTION("commands.f-perms.f-unclaim.cmd-unclaim-safezone.cmd-safezone-description", "&6Free from PvP & Monsters."),
    CMD_SAFEZONE_CLAIM("commands.f-perms.f-unclaim.cmd-unclaim-safezone.cmd-safezone-claim", "&7You have claimed &6&lSafeZone&7."),
    CMD1_UNCLAIM_SUCCESS("commands.f-perms.f-unclaim.cmd-unclaim-warzone.cmd1-unclaim-success", "&4WarZone&7 was unclaimed."),
    CMD1_UNCLAIM_NO_PERM("commands.f-perms.f-unclaim.cmd-unclaim-warzone.cmd1-unclaim-no-perm", "&7This is a WarZone, You lack permission to unclaim"),
    CMD1_UNCLAIMALL_WARZONE("commands.f-perms.f-unclaim.cmd-unclaim-warzone.cmd1-unclaimall-warzone", "&7You have unclaimed ALL &4&lWarZone&7 land."),
    CMD1_UNCLAIMALL_WARZONE_LOG("commands.f-perms.f-unclaim.cmd-unclaim-warzone.cmd1-unclaimall-warzone-log", "&c{target}&7 unclaimed all &4&lWarZone&7."),
    CMD1_WARZONE_ENTER("commands.f-perms.f-unclaim.cmd-unclaim-warzone.cmd1-warzone-enter", "&4WarZone"),
    CMD1_WARZONE_DESCRIPTION("commands.f-perms.f-unclaim.cmd-unclaim-warzone.cmd1-warzone-description", "&4Not the safest place to be."),
    CMD1_WARZONE_CLAIM("commands.f-perms.f-unclaim.cmd-unclaim-warzone.cmd1-warzone-claim", "&7You have claimed &4&lWarZone&7."),
    CMD_F_UNCLAIMED("commands.f-perms.f-unclaim.cmd-f-unclaimed", "&c{target} &7unclaimed some of your land."),
    CMD_F_UNCLAIMS("commands.f-perms.f-unclaim.cmd-f-unclaims", "&7You unclaimed this land."),
    CMD_UNCLAIM_LOG("commands.f-perms.f-unclaim.cmd-unclaim-log", "&c{target} &7unclaimed everything for the Faction: &c{faction}&7."),
    CMD_UNCLAIM_WRONG_FACTION("commands.f-perms.f-unclaim.cmd-unclaim-wrong-faction", "&7You do not own this land."),
    CMD_CLICK_TO_UNCLAIM("commands.f-perms.f-unclaim.cmd-click-to-unclaim", "&7Click To Unclaim &8(&c{loc-1}&7, &c{loc-2}&8)"),
    CMD_UNCLAIMALL_UNCLAIMED("commands.f-perms.f-unclaimall.cmd-unclaimall-unclaimed", "&c{target} &7unclaimed ALL of your factions land."),
    CMD_UNCLAIMALL_LOG("commands.f-perms.f-unclaimall.cmd-unclaimall-log", "&c{target} &7unclaimed everything for the Faction: &c{faction}&7."),
    CMD_PLUGIN_NAME("commands.f-perms.f-version.cmd-plugin-name", "&c&k||| &r&4SavageFactions&7 &c&k|||&r &c» &7By ProSavage."),
    CMD_FACTION_VERSION("commands.f-perms.f-version.cmd-faction-version", "&7Version » &c{version}&7."),
    RULES_DISABLED_MSG("commands.f-perms.f-rules.rules-disabled-msg", "&7This command is disabled."),
    CMD_ADD_INVALID_ARGS("commands.f-perms.f-rules.f-rules-add.cmd-add-invalid-args", "&7Please include a rule!"),
    CMD_ADD_SUCCESS("commands.f-perms.f-rules.f-rules-add.cmd-add-success", "&7Rule added successfully!"),
    CMD_SET_INVALID_ARGS("commands.f-perms.f-rules.f-rules-set.cmd-set-invalid-args", "&7Please include a line number & rule!"),
    CMD_SET_SUCCESS("commands.f-perms.f-rules.f-rules-set.cmd-set-success", "&7Rule set successfully!"),
    CMD_REMOVE_INVALID_ARGS("commands.f-perms.f-rules.f-rules-remove.cmd-remove-invalid-args", "&7Please include a line number!"),
    CMD_REMOVE_SUCCESS("commands.f-perms.f-rules.f-rules-remove.cmd-remove-success", "&7Rule removed successfully!"),
    CMD_CLEAR_SUCCESS("commands.f-perms.f-rules.f-rules-clear.cmd-clear-success", "&7Rule has been cleared successfully!"),
    CMD_GRACE_TOGGLED("commands.f-perms.f-grace.cmd-grace-toggled", "&c&lGrace Period has been }toggled}"),
    CMD_LEAVE_PASS_ADMIN("commands.f-perms.f-leave.cmd-leave-pass-admin", "&7You must give leadership to someone else first."),
    CMD_LEAVE_NEGATIVE_POWER("commands.f-perms.f-leave.cmd-leave-negative-power", "&7You cannot leave until your power is in the positive."),
    CMD_LEAVE_MSG("commands.f-perms.f-leave.cmd-leave-msg", "&c{target}&7 has left faction &c{faction}&7."),
    CMD_LEAVE_DISBANDED("commands.f-perms.f-leave.cmd-leave-disbanded", "&c{faction}&7 was disbanded."),
    CMD_LEAVE_DISBANDED_LOG("commands.f-perms.f-leave.cmd-leave-disbanded-log", "&c{faction}&7 was disbanded due to the last player &8(&c{target}&8)&7 leaving."),
    CMD_WARBANNER_NO_FACTION("commands.f-perms.f-warbanner.cmd-warbanner-no-faction", "&7You need a faction to use a WarBanner!"),
    CMD_WARBANNER_COOLDOWN("commands.f-perms.f-warbanner.cmd-warbanner-cooldown", "&7The WarBanner is on cooldown for your faction!"),
    CMD_WARBANNER_INVALID_LOC("commands.f-perms.f-warbanner.cmd-warbanner-invalid-loc", "&7You can only use WarBanners in enemy land or the warzone."),
    CMD_BANNER_SUCCESS("commands.f-perms.f-warbanner.cmd-banner-success", "&7You have created a &c&lWarBanner."),
    CMD_BANNER_DISABLED("commands.f-perms.f-warbanner.cmd-banner-disabled", "&7Creation of &c&lWarBanner&7 is disabled."),
    CMD_BANNER_MONEY_TAKE("commands.f-perms.f-warbanner.cmd-banner-money-take", "&c{amount} &7has been taken from your account."),
    CMD_BANNER_NOT_ENOUGH_MONEY("commands.f-perms.f-warbanner.cmd-banner-not-enough-money", "&7You do not have enough money."),
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
    REG_SAFEZONE("commands.factions-utils.f-relations.region.reg-safezone", "safezone"),
    REG_WARZONE("commands.factions-utils.f-relations.region.reg-warzone", "warzone"),
    REG_WILDERNESS("commands.factions-utils.f-relations.region.reg-wilderness", "wilderness"),
    REG_PEACEFUL("commands.factions-utils.f-relations.region.reg-peaceful", "peaceful territory"),
    CMD_PLAYER_CANNOT_HURT("commands.factions-utils.f-relations.player-misc.cmd-player-cannot-hurt", "&7You may not harm other players in &c{territory}."),
    CMD_PLAYER_SAFE_AUTO("commands.factions-utils.f-relations.player-misc.cmd-player-safe-auto", "&7This land is now a safe zone."),
    CMD_PLAYER_WAR_AUTO("commands.factions-utils.f-relations.player-misc.cmd-player-war-auto", "&7This land is now a warzone."),
    CMD_PLAYER_OUCH("commands.factions-utils.f-relations.player-misc.cmd-player-ouch", "&7Ouch, that is starting to hurt. You should give it a rest."),
    CMD_PLAYER_USE_WILDERNESS("commands.factions-utils.f-relations.player-use.cmd-player-use-wilderness", "&7You cannot use &c{item} &7in the wilderness."),
    CMD_PLAYER_USE_SAFEZONE("commands.factions-utils.f-relations.player-use.cmd-player-use-safezone", "&7You cannot use &c{item} &7in a safezone."),
    CMD_PLAYER_USE_WARZONE("commands.factions-utils.f-relations.player-use.cmd-player-use-warzone", "&7You cannot use &c{item} &7in a warzone."),
    CMD_PLAYER_USE_TERRITORY("commands.factions-utils.f-relations.player-use.cmd-player-use-territory", "&7You cannot &c{item} &7in the territory of &c{territory}."),
    CMD_PLAYER_USE_OWNED("commands.factions-utils.f-relations.player-use.cmd-player-use-owned", "&7You cannot use &c{item} &7in this territory, It is owned by: &c{faction}."),
    CMD_PLAYER_CMD_WARZONE("commands.factions-utils.f-relations.player-command.cmd-player-cmd-warzone", "&7You cannot use the command &c{cmd} &7in warzone."),
    CMD_PLAYER_CMD_NEUTRAL("commands.factions-utils.f-relations.player-command.cmd-player-cmd-neutral", "&7You cannot use the command &c{cmd} &7in neutral territory."),
    CMD_PLAYER_CMD_ENEMY("commands.factions-utils.f-relations.player-command.cmd-player-cmd-enemy", "&7You cannot use the command &c{cmd} &7in enemy territory."),
    CMD_PLAYER_CMD_PERMANENT("commands.factions-utils.f-relations.player-command.cmd-player-cmd-permanent", "&7You cannot use the command &c{cmd} &7because you are in a permanent faction."),
    CMD_PLAYER_CMD_ALLY("commands.factions-utils.f-relations.player-command.cmd-player-cmd-ally", "&7You cannot use the command &c{cmd} &7in ally territory."),
    CMD_PLAYER_CMD_WILDERNESS("commands.factions-utils.f-relations.player-command.cmd-player-cmd-wilderness", "&7You cannot use the command &c{cmd} &7in the wilderness."),
    CMD_NO_LOSS_PEACEFUL("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-peaceful", "&7You did not lose any power since you are in a peaceful faction."),
    CMD_NO_LOSS_WORLD("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-world", "&7You did not lose any power due to the world you die in."),
    CMD_NO_LOSS_WILDERNESS("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-wilderness", "&7You did not lose any power since you were in wilderness."),
    CMD_NO_LOSS_WARZONE("commands.factions-utils.f-relations.player-power.player-no-loss.cmd-no-loss-warzone", "&7You did not lose power since warzone power loss was disabled."),
    CMD_LOSS_WARZONE("commands.factions-utils.f-relations.player-power.player-loss.cmd-loss-warzone", "&7The world you are in has power loss normally disabled but you still lost power since you were in the warzone."),
    CMD_POWER_NOW("commands.factions-utils.f-relations.player-power.player-loss.cmd-power-now", "&7Your power is now &c{power} &7/ &c{maxpower}."),
    CMD_PLAYER_LOGIN("commands.factions-utils.f-relations.player-pvp.cmd-player-login", "&7You cannot hurt other players for &c{time} &7seconds after logging in."),
    CMD_PLAYER_REQUIRE_FACTION("commands.factions-utils.f-relations.player-pvp.cmd-player-require-faction", "&7You cannot hurt others players until you join a faction."),
    CMD_PLAYER_FACTION_LESS("commands.factions-utils.f-relations.player-pvp.cmd-player-faction-less", "&7You cannot hurt players who are currently not in a faction."),
    CMD_PLAYER_PEACEFUL("commands.factions-utils.f-relations.player-pvp.cmd-player-peaceful", "&7Peaceful Players cannot participate in combat."),
    CMD_PLAYER_NEUTRAL("commands.factions-utils.f-relations.player-pvp.cmd-player-neutral", "&7You cannot hurt neutral factions, Declare them as an enemy."),
    CMD_PLAYER_CANNOT_HURT_2("commands.factions-utils.f-relations.player-pvp.cmd-player-cannot-hurt", "&7You cannot hurt &c{target}&7."),
    CMD_PLAYER_NEUTRAL_FAIL("commands.factions-utils.f-relations.player-pvp.cmd-player-neutral-fail", "&7You cannot hurt &c{target} &7in their own territory unless you declare them as an enemy."),
    CMD_PLAYER_TRIED_TO_HURT("commands.factions-utils.f-relations.player-pvp.cmd-player-tried-to-hurt", "&c{attacker} &7tried to hurt you.");

    private String path;
    private String defaultMessage;
    private List<String> defaultListMessage;

    private Messages(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }

    private Messages(String path, List<String> defaultListMessage) {
        this.path = path;
        this.defaultListMessage = defaultListMessage;
    }

    public static String convertList(List<String> list) {
        String message = "";
        for (String m : list) {
            message += TextUtil.parseColor(m) + "\n";
        }
        return message;
    }

    public static String convertList(List<String> list, HashMap<String, String> placeholders) {
        String message = "";
        for (String m : list) {
            message += TextUtil.parseColor(m) + "\n";
        }
        for (String ph : placeholders.keySet()) {
            message = TextUtil.parseColor(message.replaceAll(ph, placeholders.get(ph)));
        }
        return message;
    }

    public static void addMissingMessages() {
        FileConfiguration messages = Files.LANG.getFile();
        boolean saveFile = false;
        for (Messages message : values()) {
            if (!messages.contains("Messages." + message.getPath())) {
                saveFile = true;
                if (message.getDefaultMessage() != null) {
                    messages.set("Messages." + message.getPath(), message.getDefaultMessage());
                } else {
                    messages.set("Messages." + message.getPath(), message.getDefaultListMessage());
                }
            }
        }
        if (saveFile) {
            Files.LANG.saveFile();
        }
    }

    public String getMessage() {
        if (isList()) {
            if (exists()) {
                return TextUtil.parseColor(convertList(Files.LANG.getFile().getStringList("Messages." + path)));
            } else {
                return TextUtil.parseColor(convertList(getDefaultListMessage()));
            }
        } else {
            if (exists()) {
                return TextUtil.getPrefix(Files.LANG.getFile().getString("Messages." + path));
            } else {
                return TextUtil.getPrefix(getDefaultMessage());
            }
        }
    }

    public String getMessage(HashMap<String, String> placeholders) {
        String message;
        if (isList()) {
            if (exists()) {
                message = TextUtil.parseColor(convertList(Files.LANG.getFile().getStringList("Messages." + path), placeholders));
            } else {
                message = TextUtil.parseColor(convertList(getDefaultListMessage(), placeholders));
            }
        } else {
            if (exists()) {
                message = TextUtil.getPrefix(Files.LANG.getFile().getString("Messages." + path));
            } else {
                message = TextUtil.getPrefix(getDefaultMessage());
            }
            for (String ph : placeholders.keySet()) {
                if (message.contains(ph)) {
                    message = message.replaceAll(ph, placeholders.get(ph));
                }
            }
        }
        return message;
    }

    public String getMessageNoPrefix() {
        if (isList()) {
            if (exists()) {
                return TextUtil.parseColor(convertList(Files.LANG.getFile().getStringList("Messages." + path)));
            } else {
                return TextUtil.parseColor(convertList(getDefaultListMessage()));
            }
        } else {
            if (exists()) {
                return TextUtil.parseColor(Files.LANG.getFile().getString("Messages." + path));
            } else {
                return TextUtil.parseColor(getDefaultMessage());
            }
        }
    }

    public String getMessageNoPrefix(HashMap<String, String> placeholders) {
        String message;
        if (isList()) {
            if (exists()) {
                message = TextUtil.parseColor(convertList(Files.LANG.getFile().getStringList("Messages." + path), placeholders));
            } else {
                message = TextUtil.parseColor(convertList(getDefaultListMessage(), placeholders));
            }
        } else {
            if (exists()) {
                message = TextUtil.parseColor(Files.LANG.getFile().getString("Messages." + path));
            } else {
                message = TextUtil.parseColor(getDefaultMessage());
            }
            for (String ph : placeholders.keySet()) {
                if (message.contains(ph)) {
                    message = message.replaceAll(ph, placeholders.get(ph));
                }
            }
        }
        return message;
    }

    private boolean exists() {
        return Files.LANG.getFile().contains("Messages." + path);
    }

    private boolean isList() {
        if (Files.LANG.getFile().contains("Messages." + path)) {
            return !Files.LANG.getFile().getStringList("Messages." + path).isEmpty();
        } else {
            return defaultMessage == null;
        }
    }

    private String getPath() {
        return path;
    }

    private String getDefaultMessage() {
        return defaultMessage;
    }

    private List<String> getDefaultListMessage() {
        return defaultListMessage;
    }
}
