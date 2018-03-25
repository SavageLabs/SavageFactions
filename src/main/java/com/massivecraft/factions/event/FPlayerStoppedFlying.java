package com.massivecraft.factions.event;
import com.massivecraft.factions.FPlayer;
import org.bukkit.event.HandlerList;

public class FPlayerStoppedFlying extends FactionPlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private FPlayer fPlayer;


    public FPlayerStoppedFlying(FPlayer fPlayer) {
        super(fPlayer.getFaction(), fPlayer);
        this.fPlayer = fPlayer;
    }

    @Override
    public FPlayer getfPlayer() {
        return fPlayer;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
