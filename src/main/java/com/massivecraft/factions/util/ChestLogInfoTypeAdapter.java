package com.massivecraft.factions.util;

import com.google.gson.*;
import com.massivecraft.factions.struct.ChestLogInfo;

import java.lang.reflect.Type;

public class ChestLogInfoTypeAdapter implements JsonSerializer<ChestLogInfo>, JsonDeserializer<ChestLogInfo> {


    @Override
    public ChestLogInfo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        return new ChestLogInfo(object.get("user").getAsString(), object.get("time").getAsString(), object.get("amount").getAsInt(), Base64Util.fromBase64IS(object.get("item").getAsString()));
    }

    @Override
    public JsonElement serialize(ChestLogInfo chestLogInfo, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.add("item", new JsonPrimitive(Base64Util.toBase64(chestLogInfo.getItemStack())));
        object.add("time", new JsonPrimitive(chestLogInfo.getTime()));
        object.add("user", new JsonPrimitive(chestLogInfo.getUser()));
        object.add("amount", new JsonPrimitive(chestLogInfo.getAmount()));
        return object;
    }
}
