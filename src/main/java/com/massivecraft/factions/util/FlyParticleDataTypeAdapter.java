package com.massivecraft.factions.util;

import com.google.gson.*;
import com.massivecraft.factions.util.Particles.ParticleEffect;
import com.massivecraft.factions.util.Particles.Particles;
import com.massivecraft.factions.zcore.ffly.flyparticledata.ColorableCloud;
import com.massivecraft.factions.zcore.ffly.flyparticledata.FlyParticleData;
import com.massivecraft.factions.zcore.persist.serializable.ConfigurableItem;
import org.bukkit.Location;

import java.lang.reflect.Type;

public class FlyParticleDataTypeAdapter implements JsonSerializer<FlyParticleData>, JsonDeserializer<FlyParticleData> {
    @Override
    public FlyParticleData deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        ConfigurableItem particleItem = new Gson().fromJson(object.get("item").getAsString(), ConfigurableItem.class);
        if (object.has("type")) {
            String[] rgb = object.get("color").getAsString().split(",");
            return new ColorableCloud(object.get("name").getAsString(), particleItem, Particles.valueOf(object.get("particle").getAsString()), new ParticleEffect.OrdinaryColor(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])));
        }
        return new FlyParticleData(object.get("name").getAsString(), particleItem, Particles.valueOf(object.get("particle").getAsString())) {
            @Override
            public void display(Location origin) {

            }
        };
    }

    @Override
    public JsonElement serialize(FlyParticleData data, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        if (data instanceof ColorableCloud) {
            object.add("type", new JsonPrimitive("colorablecloud"));
            object.add("color", new JsonPrimitive(((ColorableCloud) data).getColor().getRed() + "," + ((ColorableCloud) data).getColor().getGreen() + "," + ((ColorableCloud) data).getColor().getBlue()));
        }
        object.add("name", new JsonPrimitive(data.getName()));
        object.add("particle", new JsonPrimitive(data.getParticleEffect().name()));
        object.add("item", new JsonPrimitive(new Gson().toJson(data.getItem())));
        return object;

    }
}
