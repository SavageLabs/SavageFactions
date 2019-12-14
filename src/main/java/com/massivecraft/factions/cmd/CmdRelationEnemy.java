package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Relation;

/**
 * This class was originally written by Dariasc (FactionsUUID)
 **/

public class CmdRelationEnemy extends FRelationCommand {

    public CmdRelationEnemy() {
        aliases.add("enemy");
        targetRelation = Relation.ENEMY;
    }
}
