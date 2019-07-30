package com.massivecraft.factions.iface;

public interface EconomyParticipator extends RelationParticipator {

    String getAccountId();

    void msg(String str, Object... args);

    void msg(TL translation, Object... args);
}