package com.massivecraft.factions.addon;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.cmd.FCommand;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.Set;

public abstract class FactionsAddon {

    private String addonName;
    private SavageFactions plugin;

    public FactionsAddon(final SavageFactions plugin) {

        this.plugin = plugin;
        this.addonName = getClass().getName();

        enableAddon();

    }

    private void enableAddon() {

        for (Listener listener : listenersToRegister()) {

            if (listener != null) {

                plugin.getServer().getPluginManager().registerEvents(listener, plugin);

            }

        }

        for (FCommand fCommand : fCommandsToRegister()) {

            if (fCommand != null) {

                plugin.cmdBase.addSubCommand(fCommand);

            }

        }

        onEnable();

    }

    private void disableAddon() {

        for (Listener listener : listenersToRegister()) {

            HandlerList.unregisterAll(listener);

        }

        onDisable();

    }

    /**
     * Method called when addon enabled.
     */
    public abstract void onEnable();

    /**
     * Method called when addon disabled.
     */
    public abstract void onDisable();

    /**
     * Method to define listeners you want to register. You don't need to register them.
     * @return Set of listeners you want to register.
     */
    public abstract Set<Listener> listenersToRegister();

    /**
     * Method to define FCommands you want to register. You don't need to register them.
     * @return Set of commands you want to register.
     */
    public abstract Set<FCommand> fCommandsToRegister();

    /**
     * Addon name
     * @return Addon name.
     */
    public String getAddonName() {
        return addonName;
    }

    public SavageFactions getPlugin() {
        return plugin;
    }
}
