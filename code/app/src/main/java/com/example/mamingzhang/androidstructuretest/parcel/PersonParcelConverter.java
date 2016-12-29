package com.example.mamingzhang.androidstructuretest.parcel;

import android.os.Parcel;

import com.example.mamingzhang.androidstructuretest.parcel.entity.Person;

import org.parceler.Parcels;
import org.parceler.converter.ArrayListParcelConverter;

/**
 * Created by horsege on 2016/12/26.
 */

public class PersonParcelConverter extends ArrayListParcelConverter<Person> {
    @Override
    public void itemToParcel(Person input, Parcel parcel) {
        parcel.writeParcelable(Parcels.wrap(input), 0);

    }

    @Override
    public Person itemFromParcel(Parcel parcel) {
        return Parcels.unwrap(parcel.readParcelable(Person.class.getClassLoader()));
    }
}
