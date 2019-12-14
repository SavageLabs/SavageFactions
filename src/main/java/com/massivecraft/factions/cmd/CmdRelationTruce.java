package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Relation;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdRelationTruce extends FRelationCommand {

    public CmdRelationTruce() {
        aliases.add("truce");
        targetRelation = Relation.TRUCE;
    }
}
