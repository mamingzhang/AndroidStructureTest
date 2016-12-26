package com.example.mamingzhang.androidstructuretest.parcel;

import android.os.Parcel;

import com.example.mamingzhang.androidstructuretest.parcel.entity.Person;

import org.parceler.ParcelConverter;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by horsege on 2016/12/26.
 */

public class PersonListParcelConverter implements ParcelConverter<List<Person>> {
    @Override
    public void toParcel(List<Person> input, Parcel parcel) {
        if (input == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(input.size());
            for (Person person : input) {
                parcel.writeParcelable(Parcels.wrap(person), 0);
            }
        }
    }

    @Override
    public List<Person> fromParcel(Parcel parcel) {
        int size = parcel.readInt();
        if (size < 0) {
            return null;
        } else {
            List<Person> result = new ArrayList<>(size);
            for (int index = 0; index < size; index++) {
                result.add((Person) Parcels.unwrap(parcel.readParcelable(Person.class.getClassLoader())));
            }

            return result;
        }
    }
}
