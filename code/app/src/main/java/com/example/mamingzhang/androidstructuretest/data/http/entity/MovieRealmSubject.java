package com.example.mamingzhang.androidstructuretest.data.http.entity;

import com.example.mamingzhang.androidstructuretest.data.http.realm.entity.RealmString;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by mamingzhang on 16/12/19.
 * <p>
 * 实质上和{@link MovieSubject}的作用是一样的，本类的主要作用就是测试利用Realm存储
 */

public class MovieRealmSubject extends RealmObject {

    private String id;
    private String alt;
    private String year;
    private String title;
    private String original_title;
    private RealmList<RealmString> genres;
    private RealmList<MovieRealmCast> casts;
    private RealmList<MovieRealmCast> directors;
    private MovieRealmAvatars images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public RealmList<RealmString> getGenres() {
        return genres;
    }

    public void setGenres(RealmList<RealmString> genres) {
        this.genres = genres;
    }

    public RealmList<MovieRealmCast> getCasts() {
        return casts;
    }

    public void setCasts(RealmList<MovieRealmCast> casts) {
        this.casts = casts;
    }

    public RealmList<MovieRealmCast> getDirectors() {
        return directors;
    }

    public void setDirectors(RealmList<MovieRealmCast> directors) {
        this.directors = directors;
    }

    public MovieRealmAvatars getImages() {
        return images;
    }

    public void setImages(MovieRealmAvatars images) {
        this.images = images;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("subject id = ").append(id).append("; ");
        builder.append("casts = ").append(casts).append("; ");
        builder.append("directors = ").append(directors).append("; ");

        return builder.toString();
    }

}
