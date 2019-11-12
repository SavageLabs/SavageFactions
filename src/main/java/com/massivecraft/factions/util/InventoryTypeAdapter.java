package com.massivecraft.factions.util;

import com.google.gson.*;
import com.massivecraft.factions.Conf;
import org.bukkit.inventory.Inventory;

import java.lang.reflect.Type;

public class InventoryTypeAdapter implements JsonSerializer<Inventory>, JsonDeserializer<Inventory> {


    @Override
    public JsonElement serialize(Inventory inventory, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject object = new JsonObject();
        object.add("contents", new JsonPrimitive(Base64Util.toBase64(inventory)));
        return object;
    }


    @Override
    public Inventory deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject object = jsonElement.getAsJsonObject();
        return Base64Util.fromBase64(object.get("contents").getAsString(), Conf.fchestInventoryTitle);
    }


}
