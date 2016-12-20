package com.example.mamingzhang.androidstructuretest.data.http.realm;

import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieRealmAvatars;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieRealmCast;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import io.realm.RealmList;

/**
 * Created by mamingzhang on 16/12/19.
 */

public class GsonRealmCastListDeserializer implements JsonDeserializer<RealmList<MovieRealmCast>> {

    @Override
    public RealmList<MovieRealmCast> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        RealmList<MovieRealmCast> realmCasts = new RealmList<>();

        JsonArray jsonArray = json.getAsJsonArray();
        if (jsonArray != null && jsonArray.size() > 0) {
            for (int index = 0; index < jsonArray.size(); index++) {
                JsonObject jsonObject = jsonArray.get(index).getAsJsonObject();

                MovieRealmCast movieRealmCast = new MovieRealmCast();

                movieRealmCast.setId(jsonObject.get("id").getAsString());
                movieRealmCast.setAlt(jsonObject.get("alt").getAsString());
                movieRealmCast.setName(jsonObject.get("name").getAsString());

                JsonObject avatarsJsonObject = jsonObject.get("avatars").getAsJsonObject();
                MovieRealmAvatars movieRealmAvatars = new MovieRealmAvatars();
                movieRealmAvatars.setSmall(avatarsJsonObject.get("small").getAsString());
                movieRealmAvatars.setMedium(avatarsJsonObject.get("medium").getAsString());
                movieRealmAvatars.setLarge(avatarsJsonObject.get("large").getAsString());
                movieRealmCast.setAvatars(movieRealmAvatars);

                realmCasts.add(movieRealmCast);
            }
        }

        return realmCasts;
    }

    public static Type getType() {
        return new TypeToken<RealmList<MovieRealmCast>>() {
        }.getType();
    }

}
