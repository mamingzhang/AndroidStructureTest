package com.example.mamingzhang.androidstructuretest.parcel.entity;

import com.example.mamingzhang.androidstructuretest.parcel.PersonListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;
import org.parceler.ParcelPropertyConverter;

import java.util.List;

/**
 * Created by horsege on 2016/12/26.
 */

@Parcel
public class Family {
    @ParcelPropertyConverter(PersonListParcelConverter.class)
    List<Person> familyPersons1;

    List<Person> familyPersons2;

    @ParcelConstructor
    public Family(List<Person> familyPersons1, List<Person> familyPersons2) {
        this.familyPersons1 = familyPersons1;
        this.familyPersons2 = familyPersons2;
    }

    public List<Person> getFamilyPersons1() {
        return familyPersons1;
    }

    public List<Person> getFamilyPersons2() {
        return familyPersons2;
    }
}
