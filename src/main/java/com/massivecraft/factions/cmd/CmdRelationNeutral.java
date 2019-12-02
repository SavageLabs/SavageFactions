package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Relation;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdRelationNeutral extends FRelationCommand {

    public CmdRelationNeutral() {
        aliases.add("neutral");
        targetRelation = Relation.NEUTRAL;
    }
}
