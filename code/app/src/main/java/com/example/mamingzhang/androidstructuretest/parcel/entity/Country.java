package com.example.mamingzhang.androidstructuretest.parcel.entity;

import com.example.mamingzhang.androidstructuretest.data.http.realm.entity.RealmString;
import com.example.mamingzhang.androidstructuretest.parcel.RealmListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;

import io.realm.CountryRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by horsege on 2016/12/26.
 */

@Parcel(
        implementations = {CountryRealmProxy.class},
        value = Parcel.Serialization.FIELD,
        analyze = {Country.class}
)
public class Country extends RealmObject {
    public String countryName;

    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public RealmList<RealmString> languages;
}
