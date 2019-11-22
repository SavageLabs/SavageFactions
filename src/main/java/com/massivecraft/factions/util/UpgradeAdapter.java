package com.massivecraft.factions.util;


import com.google.gson.*;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.addon.upgradeaddon.Upgrade;

import java.lang.reflect.Type;

public class UpgradeAdapter implements JsonSerializer<Upgrade>, JsonDeserializer<Upgrade> {

    @Override
    public Upgrade deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();
        return SavageFactions.plugin.getUpgradeManager().getUpgradeByName(jsonObj.get("name").toString().replace("\"", ""));
    }

    @Override
    public JsonElement serialize(Upgrade src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("name", new JsonPrimitive(src.getUpgradeName()));
        return result;
    }
}
