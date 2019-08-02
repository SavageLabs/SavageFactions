package com.massivecraft.factions;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;

public class ConfigVersion {

    private FileConfiguration config;
    private int version = 0;
    protected final int currentVersion = 1;

    public ConfigVersion(FileConfiguration config) {
        this.config = config;
    }

    public void checkVersion() {
        if (config.isSet("Config-Version")) version = 0;
        else version = config.getInt("Config-Version");
        update();
    }

    public void update() {
           switch (version) {
               case 0:
                   // The only change in v0 - v1 is config version
                   config.addDefault("Config-Version", 1);
                   if (!save()) return;
                   SavageFactions.plugin.log("Config Version " + version + " found! Updated config to " + version + 1);
                   break;
               case currentVersion:
                   SavageFactions.plugin.log("Config.yml was found to be up-to-date!");
               default:
                   // Unknown number found, log it.
                   SavageFactions.plugin.log("Unsupported config version found!");
                   SavageFactions.plugin.log("Please reset your config to default!");
                   break;
           }
    }

    private boolean save() {
        try {
            config.save("config.yml");
        } catch (IOException er) {
            SavageFactions.plugin.log("There was an error saving the updates config.yml! Aborting!");
            er.printStackTrace();
            return false;
        }
        return true;
    }

}
