package com.massivecraft.factions.util.fm;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager {

    private Plugin plugin;
    private String prefix = "";
    private Boolean log = false;
    private HashMap<Files, File> files = new HashMap<>();
    private ArrayList<String> homeFolders = new ArrayList<>();
    private ArrayList<CustomFile> customFiles = new ArrayList<>();
    private HashMap<String, String> autoGenerateFiles = new HashMap<>();
    private HashMap<Files, FileConfiguration> configurations = new HashMap<>();

    private static FileManager instance = new FileManager();

    public static FileManager getInstance() {
        return instance;
    }

    public FileManager setup(Plugin plugin) {
        prefix = "[" + plugin.getName() + "] ";
        this.plugin = plugin;
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }
        files.clear();
        customFiles.clear();
        for (Files file : Files.values()) {
            File newFile = new File(plugin.getDataFolder(), file.getFileLocation());
            if (log) System.out.println(prefix + "Loading the " + file.getFileName());
            if (!newFile.exists()) {
                try {
                    File serverFile = new File(plugin.getDataFolder(), "/" + file.getFileLocation());
                    InputStream jarFile = getClass().getResourceAsStream("/" + file.getFileLocation());
                    copyFile(jarFile, serverFile);
                } catch(Exception e) {
                    if (log) System.out.println(prefix + "Failed to load " + file.getFileName());
                    e.printStackTrace();
                    continue;
                }
            }
            files.put(file, newFile);
            configurations.put(file, YamlConfiguration.loadConfiguration(newFile));
            if (log) System.out.println(prefix + "Successfully loaded " + file.getFileName());
        }
        //Starts to load all the custom files.
        if (homeFolders.size() > 0) {
            if (log) System.out.println(prefix + "Loading custom files.");
            for (String homeFolder : homeFolders) {
                if (new File(plugin.getDataFolder(), "/" + homeFolder).exists()) {
                    for (String name : new File(plugin.getDataFolder(), "/" + homeFolder).list()) {
                        if (name.endsWith(".yml")) {
                            CustomFile file = new CustomFile(name, homeFolder, plugin);
                            if (file.exists()) {
                                customFiles.add(file);
                                if (log) System.out.println(prefix + "Loaded new custom file: " + homeFolder + "/" + name + ".");
                            }
                        }
                    }
                } else {
                    new File(plugin.getDataFolder(), "/" + homeFolder).mkdir();
                    if (log) System.out.println(prefix + "The folder " + homeFolder + "/ was not found so it was created.");
                    for (String fileName : autoGenerateFiles.keySet()) {
                        if (autoGenerateFiles.get(fileName).equalsIgnoreCase(homeFolder)) {
                            homeFolder = autoGenerateFiles.get(fileName);
                            try {
                                File serverFile = new File(plugin.getDataFolder(), homeFolder + "/" + fileName);
                                InputStream jarFile = getClass().getResourceAsStream(homeFolder + "/" + fileName);
                                copyFile(jarFile, serverFile);
                                if (fileName.toLowerCase().endsWith(".yml")) {
                                    customFiles.add(new CustomFile(fileName, homeFolder, plugin));
                                }
                                if (log) System.out.println(prefix + "Created new default file: " + homeFolder + "/" + fileName + ".");
                            } catch(Exception e) {
                                if (log) System.out.println(prefix + "Failed to create new default file: " + homeFolder + "/" + fileName + "!");
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            if (log) System.out.println(prefix + "Finished loading custom files.");
        }
        return this;
    }
    public FileManager logInfo(Boolean log) {
        this.log = log;
        return this;
    }
    public Boolean isLogging() {
        return log;
    }
    public FileManager registerCustomFilesFolder(String homeFolder) {
        homeFolders.add(homeFolder);
        return this;
    }
    public FileManager unregisterCustomFilesFolder(String homeFolder) {
        homeFolders.remove(homeFolder);
        return this;
    }
    public FileManager registerDefaultGenerateFiles(String fileName, String homeFolder) {
        autoGenerateFiles.put(fileName, homeFolder);
        return this;
    }
    public FileManager unregisterDefaultGenerateFiles(String fileName) {
        autoGenerateFiles.remove(fileName);
        return this;
    }
    public FileConfiguration getFile(Files file) {
        return configurations.get(file);
    }
    public CustomFile getFile(String name) {
        for (CustomFile file : customFiles) {
            if (file.getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())) {
                return file;
            }
        }
        return null;
    }
    public void saveFile(Files file) {
        try {
            configurations.get(file).save(files.get(file));
        } catch(IOException e) {
            System.out.println(prefix + "Could not save " + file.getFileName() + "!");
            e.printStackTrace();
        }
    }
    public void saveFile(String name) {
        CustomFile file = getFile(name);
        if (file != null) {
            try {
                file.getFile().save(new File(plugin.getDataFolder(), file.getHomeFolder() + "/" + file.getFileName()));
                if (log) System.out.println(prefix + "Successfully saved the " + file.getFileName() + ".");
            } catch(Exception e) {
                System.out.println(prefix + "Could not save " + file.getFileName() + "!");
                e.printStackTrace();
            }
        } else {
            if (log) System.out.println(prefix + "The file " + name + ".yml could not be found!");
        }
    }
    public Boolean saveFile(CustomFile file) {
        return file.saveFile();
    }
    public void reloadFile(Files file) {
        configurations.put(file, YamlConfiguration.loadConfiguration(files.get(file)));
    }
    public void reloadFile(String name) {
        CustomFile file = getFile(name);
        if (file != null) {
            try {
                file.file = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "/" + file.getHomeFolder() + "/" + file.getFileName()));
                if (log) System.out.println(prefix + "Successfully reload the " + file.getFileName() + ".");
            } catch(Exception e) {
                System.out.println(prefix + "Could not reload the " + file.getFileName() + "!");
                e.printStackTrace();
            }
        } else {
            if (log) System.out.println(prefix + "The file " + name + ".yml could not be found!");
        }
    }
    public Boolean reloadFile(CustomFile file) {
        return file.reloadFile();
    }
    private void copyFile(InputStream in, File out) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(out)) {
            byte[] buf = new byte[1024];
            int i;
            while((i = in.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public enum Files {
        LANG("lang.yml", "lang.yml"),
        CONFIG("config.yml", "config.yml");

        private String fileName;
        private String fileLocation;
        private Files(String fileName, String fileLocation) {
            this.fileName = fileName;
            this.fileLocation = fileLocation;
        }
        public String getFileName() {
            return fileName;
        }
        public String getFileLocation() {
            return fileLocation;
        }
        public FileConfiguration getFile() {
            return getInstance().getFile(this);
        }
        public void saveFile() {
            getInstance().saveFile(this);
        }
        public void reloadFile() {
            getInstance().reloadFile(this);
        }
    }

    public class CustomFile {

        private String name;
        private Plugin plugin;
        private String fileName;
        private String homeFolder;
        private FileConfiguration file;
        public CustomFile(String name, String homeFolder, Plugin plugin) {
            this.name = name.replace(".yml", "");
            this.plugin = plugin;
            this.fileName = name;
            this.homeFolder = homeFolder;
            if (new File(plugin.getDataFolder(), "/" + homeFolder).exists()) {
                if (new File(plugin.getDataFolder(), "/" + homeFolder + "/" + name).exists()) {
                    file = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "/" + homeFolder + "/" + name));
                } else {
                    file = null;
                }
            } else {
                new File(plugin.getDataFolder(), "/" + homeFolder).mkdir();
                if(log) System.out.println(prefix + "The folder " + homeFolder + "/ was not found so it was created.");
                file = null;
            }
        }
        public String getName() {
            return name;
        }
        public String getFileName() {
            return fileName;
        }
        public String getHomeFolder() {
            return homeFolder;
        }
        public Plugin getPlugin() {
            return plugin;
        }
        public FileConfiguration getFile() {
            return file;
        }
        public Boolean exists() {
            return file != null;
        }

        /**
         * Save the custom file.
         * @return True if it saved correct and false if something went wrong.
         */
        public Boolean saveFile() {
            if(file != null) {
                try {
                    file.save(new File(plugin.getDataFolder(), homeFolder + "/" + fileName));
                    if(log) System.out.println(prefix + "Successfully saved the " + fileName + ".");
                    return true;
                } catch(Exception e) {
                    System.out.println(prefix + "Could not save " + fileName + "!");
                    e.printStackTrace();
                    return false;
                }
            } else {
                if(log) System.out.println(prefix + "There was a null custom file that could not be found!");
            }
            return false;
        }

        /**
         * Overrides the loaded state file and loads the filesystems file.
         * @return True if it reloaded correct and false if the file wasn't found or errored.
         */
        public Boolean reloadFile() {
            if(file != null) {
                try {
                    file = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "/" + homeFolder + "/" + fileName));
                    if(log) System.out.println(prefix + "Successfully reloaded the " + fileName + ".");
                    return true;
                } catch(Exception e) {
                    System.out.println(prefix + "Could not reload the " + fileName + "!");
                    e.printStackTrace();
                }
            } else {
                if(log) System.out.println(prefix + "There was a null custom file that was not found!");
            }
            return false;
        }

    }
}