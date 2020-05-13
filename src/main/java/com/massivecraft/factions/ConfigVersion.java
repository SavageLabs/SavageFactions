package com.massivecraft.factions;

import java.io.IOException;

public class ConfigVersion {

    /**
     * Config Version Tool:
     *
     * Changes to the config need to be added to the default config
     * but also need to be coded into the version number slot of the update.
     *
     * This allows default configs to be updated to the latest version on load, but older
     * config version to be updated without needing to reset the config or transfer old config stats.
     */
    public static class Checker {

        private final int currentVersion = 1;
        private int version = 0;


        public Checker checkLevel() {
            if (!SavageFactions.plugin.getConfig().isSet("Config-Version")) version = 0;
            else version = SavageFactions.plugin.getConfig().getInt("Config-Version");
            return this;
        }

        public Checker TakeActionIfRequired() {
            switch (version) {
                case 0:
                    // The only change in v0 - v1 is config version
                    SavageFactions.plugin.getConfig().addDefault("Config-Version", 1);
                    SavageFactions.plugin.log("Config Version " + version + " found! Updated config to " + (version + 1));
                    break;
                case currentVersion:
                    SavageFactions.plugin.log("Config.yml was found to be up-to-date!");
                    break;
                default:
                    // Unknown number found, log it.
                    SavageFactions.plugin.log("Unsupported config version found!");
                    SavageFactions.plugin.log("Please reset your config to default!");
                    break;
            }
            return this;
        }

        public boolean save() {
            try {
                SavageFactions.plugin.getConfig().save("config.yml");
            } catch (IOException er) {
                SavageFactions.plugin.log("There was an error saving the updates to config.yml! Aborting!");
                er.printStackTrace();
                return false;
            }
            return true;
        }

    }

}
