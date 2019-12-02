package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Relation;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdRelationAlly extends FRelationCommand {

    public CmdRelationAlly() {
        aliases.add("ally");
        targetRelation = Relation.ALLY;
    }
}
