package com.massivecraft.factions.addon;

import com.massivecraft.factions.SavageFactions;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

        File[] files = addonFolder.listFiles(file -> {
            boolean res = true;
            if (file.isDirectory() || !file.getName().endsWith("jar")) {
                res = false;
            }
            return res;
        });

        return files;

    }


    public void loadAddons() {

        for (File addon : loadAddonFiles()) {

            Class addonMainClass = getAddonMainClass(addon);

            if (addonMainClass != null) {

                Constructor<?> constructor;
                FactionsAddon factionsAddon;

                try {
                    constructor = addonMainClass.getConstructor(SavageFactions.class);
                    factionsAddon = (FactionsAddon) constructor.newInstance(plugin);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
            
        }

    }

    private Class<?> getAddonMainClass(final File addon) {

        //Setup this so we go deep into directories

        Class<?> mainClass = null;
        try {
            URLClassLoader child = new URLClassLoader(
                    new URL[]{addon.toURI().toURL()},
                    this.getClass().getClassLoader()
            );
            JarFile jarFile = new JarFile(addon);
            Enumeration allEntries = jarFile.entries();
            while (allEntries.hasMoreElements()) {
                JarEntry entry = (JarEntry) allEntries.nextElement();
                System.out.println(entry.getName());
                if (!entry.getName().endsWith(".class")) continue;
                String className = entry.getName().replace(".class", "");
                className = className.split("/")[className.split("/").length - 1];
                Class clazz = Class.forName(className, true, child);
                if (clazz.getSuperclass().equals(FactionsAddon.class)) {
                    mainClass = clazz;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       return mainClass;

    }

}
