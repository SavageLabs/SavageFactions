package com.massivecraft.factions.zcore.fperms;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.util.Placeholder;
import com.massivecraft.factions.util.XMaterial;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PermissableAction {
    BAN("ban"), // Abilities to use /f ban & /f unban
    BUILD("build"), // Abilities to place blocks in claimed land
    DESTROY("destroy"), // Abilities to break blocks in claimed land
    FROST_WALK("frostwalk"), // 1.14 ONLY Abilities to use frost walker boots in claimed land
    PAIN_BUILD("painbuild"), // Whether a fplayer will take damage from attempting to build after deny.
    DOOR("door"), // Abilities to open doors in claimed land
    BUTTON("button"), // Abilities to use buttons in claimed land
    LEVER("lever"), // Abilities to use levers in claimed land
    CONTAINER("container"), // Abilities to open containers in claimed land
    INVITE("invite"), // Abilities to invite new members to a faction
    KICK("kick"), // Abilities to kick members from the faction
    ITEM("items"), // generic for most items use?
    SETHOME("sethome"), // Abilities to to set faction home (/f home)
    TERRITORY("territory"), // Abilities to claim, claimline, claimat, and unclaim
    ACCESS("access"), // No current use for this, unsure what is was?
    HOME("home"), // Abilities to use /f home
    DISBAND("disband"), // Abilities to disband the faction? Should probably be removed.
    PROMOTE("promote"), // Abilities to promote faction members.
    SETWARP("setwarp"), // Abilities to set a faction warp (/f setwarp)
    WARP("warp"), // Abilities to to use a faction warp (/f warp)
    FLY("fly"), // Abilities to fly in faction claims.
    VAULT("vault"), // Abilities to use faction vault.
    TNTBANK("tntbank"), // Abilities to interact with faction TNTBank
    TNTFILL("tntfill"), // Abilities to use TNTFill
    WITHDRAW("withdraw"), // Abilities to withdraw money from the faction bank
    CHEST("chest"), // Abilities to open, take, and put items into /f chest
    SPAWNER("spawner"); // Abilities to break spawners in claimed land

    private String name;

    PermissableAction(String name) {
        this.name = name;
    }

    /**
     * Case insensitive check for action.
     *
     * @param check
     * @return - action
     */
    public static PermissableAction fromString(String check) {
        for (PermissableAction permissableAction : values()) {
            if (permissableAction.name().equalsIgnoreCase(check)) {
                return permissableAction;
            }
        }

        return null;
    }

    public int getSlot() { return SavageFactions.plugin.getConfig().getInt("fperm-gui.action.slots." + this.name.toLowerCase()); }

    public static Map<PermissableAction, Access> fromDefaults(DefaultPermissions defaultPermissions) {
        Map<PermissableAction, Access> defaultMap = new HashMap<>();
        for (PermissableAction permissableAction : PermissableAction.values()) {
            defaultMap.put(permissableAction, defaultPermissions.getbyName(permissableAction.name) ? Access.ALLOW : Access.DENY);
        }
        return defaultMap;
    }

    /**
     * Get the friendly name of this action. Used for editing in commands.
     *
     * @return friendly name of the action as a String.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    public ItemStack buildAsset(FPlayer fme, Permissable perm) {
        ConfigurationSection section = SavageFactions.plugin.getConfig().getConfigurationSection("fperm-gui.action");
        ItemStack item = XMaterial.matchXMaterial(section.getString("Materials." + this.name)).parseItem();
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(SavageFactions.plugin.color(section.getString("placeholder-item.name").replace("{action}", this.name)));
            List<String> lore = section.getStringList("placeholder-item.lore");

            // TEMP: This check is required for factions created before `Undefined` permission was removed
            if (fme.getFaction().getPermissions().get(perm).get(this) == Access.UNDEFINED) {
                fme.getFaction().getPermissions().get(perm).put(this, Access.DENY);
            }

            lore = SavageFactions.plugin.replacePlaceholders(lore,
                    new Placeholder("{action-access-color}", fme.getFaction().getPermissions().get(perm).get(this).getColor()),
                    new Placeholder("{action-access}", fme.getFaction().getPermissions().get(perm).get(this).getName()));

            meta.setLore(SavageFactions.plugin.colorList(lore));
            item.setItemMeta(meta);
        }

        return item;
    }

    public static PermissableAction fromSlot(int slot) {
        for (PermissableAction action : PermissableAction.values()) {
            if  (action.getSlot() == slot) return action;
        }
        return null;
    }

}
