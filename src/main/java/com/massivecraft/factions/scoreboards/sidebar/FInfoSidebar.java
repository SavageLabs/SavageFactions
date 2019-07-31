package com.massivecraft.factions.scoreboards.sidebar;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.scoreboards.FSidebarProvider;
import com.massivecraft.factions.util.fm.FileManager.Files;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.ListIterator;

public class FInfoSidebar extends FSidebarProvider {
    private final Faction faction;

    public FInfoSidebar(Faction faction) {
        this.faction = faction;
    }

    @Override
    public String getTitle(FPlayer fplayer) {
        return faction.getRelationTo(fplayer).getColor() + faction.getTag();
    }

    @Override
    public List<String> getLines(FPlayer fplayer) {
        FileConfiguration config = Files.CONFIG.getFile();
        List<String> lines = config.getStringList("scoreboard.finfo");

        ListIterator<String> it = lines.listIterator();
        while (it.hasNext()) {
            it.set(replaceTags(faction, fplayer, it.next()));
        }
        return lines;
    }
}