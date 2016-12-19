package com.example.mamingzhang.androidstructuretest.data.http.entity;

import io.realm.RealmObject;

/**
 * Created by mamingzhang on 16/12/19.
 */

public class MovieRealmCast extends RealmObject {
    private String id;
    private String name;
    private String alt;
    private MovieRealmAvatars avatars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public MovieRealmAvatars getAvatars() {
        return avatars;
    }

    public void setAvatars(MovieRealmAvatars avatars) {
        this.avatars = avatars;
    }
}
