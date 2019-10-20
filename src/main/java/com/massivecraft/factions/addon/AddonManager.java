package com.massivecraft.factions.addon;

import com.massivecraft.factions.SavageFactions;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public final class AddonManager {

    private static AddonManager addonManagerInstance;

    private File addonFolder;
    private SavageFactions plugin;

    private AddonManager(final SavageFactions plugin) {

        this.plugin = plugin;

        addonFolder = new File(plugin.getDataFolder() + "/addons");

        if (!addonFolder.exists()) {

            addonFolder.mkdir();

        }

    }

    public static AddonManager getAddonManagerInstance() {

        if (addonManagerInstance == null) {

            addonManagerInstance = new AddonManager(SavageFactions.plugin);

        }

        return addonManagerInstance;

    }

    private File[] loadAddonFiles() {

        File[] files = addonFolder.listFiles(new FileFilter() {
            @Override
            public boolean accept(final File file) {
                boolean res = true;
                if (file.isDirectory() || !file.getName().endsWith("jar")) {
                    res = false;
                }
                return res;
            }
        });

        return files;

    }

    public void loadAddons() {

        for (File addon : loadAddonFiles()) {
            try {

                URLClassLoader child = new URLClassLoader(
                        new URL[] {addon.toURI().toURL()},
                        this.getClass().getClassLoader()
                );

                Class clazz = Class.forName(addon.getName().replace(".jar", ""), true, child);
                Constructor<?> constructor = clazz.getConstructor(SavageFactions.class);
                FactionsAddon factionsAddon = (FactionsAddon) constructor.newInstance(plugin);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
