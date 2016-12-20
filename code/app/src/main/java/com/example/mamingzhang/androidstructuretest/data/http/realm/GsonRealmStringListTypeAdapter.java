package com.example.mamingzhang.androidstructuretest.data.http.realm;

import com.example.mamingzhang.androidstructuretest.data.http.realm.entity.RealmString;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

import io.realm.RealmList;

/**
 * Created by mamingzhang on 16/12/19.
 * <p>
 * 用于Gson解析RealmList<String>的解析类
 */

public class GsonRealmStringListTypeAdapter extends TypeAdapter<RealmList<RealmString>> {
    @Override
    public void write(JsonWriter out, RealmList<RealmString> value) throws IOException {

    }

    @Override
    public RealmList<RealmString> read(JsonReader in) throws IOException {
        RealmList<RealmString> realmList = new RealmList<>();

        in.beginArray();
        while (in.hasNext()) {
            realmList.add(new RealmString(in.nextString()));
        }
        in.endArray();

        return realmList;
    }

    public static Type getType() {
        return new TypeToken<RealmList<RealmString>>() {
        }.getType();
    }

}
