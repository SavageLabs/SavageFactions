package com.massivecraft.factions.util.fm.enums;

import com.massivecraft.factions.util.fm.FileManager.Files;
import com.massivecraft.factions.zcore.util.TextUtil;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.HashMap;
import java.util.List;

public enum Messages {
    // Root Actions
    CONFIG_RELOAD("config-reload", "&cYou have reloaded the plugin, It took %ms% to complete this task."),
    CONSOLE_ONLY("", ""),
    PLAYER_ONLY("", ""),
    NO_COMMAND_PERMS("", ""),
    NO_PLAYER_MATCH("", ""),
    NO_PLAYER_FOUND("", ""),
    ENABLED("", ""),
    DISABLED("", ""),
    ASK_LEADER("", ""),
    YOU_SHOULD("", ""),
    YOU_MAY_WANT("", ""),
    TOO_FEW_ARGS("", ""),
    TOO_MANY_ARGS("", ""),
    // Actions Section
    NO_FACTION_PERMS("", ""),
    NO_FACTION_PERMS_PAIN("", ""),
    FACTION_PERMS_NO_PERMISSION("", ""),
    NO_FACTION("", ""),
    NO_SAME_ROLE("", ""),
    MUST_BE_ROLE("", ""),
    NO_PAGES("", ""),
    INVALID_PAGE("", "");
    // Commands Section

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
