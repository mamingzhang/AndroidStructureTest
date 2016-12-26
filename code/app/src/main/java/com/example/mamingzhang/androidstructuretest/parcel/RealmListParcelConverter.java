package com.example.mamingzhang.androidstructuretest.parcel;

import android.os.Parcel;
import android.os.Parcelable;

import org.parceler.Parcels;
import org.parceler.TypeRangeParcelConverter;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by horsege on 2016/12/26.
 */

public class RealmListParcelConverter implements TypeRangeParcelConverter<RealmList<? extends RealmObject>, RealmList<? extends RealmObject>> {

    private static final int NULL = -1;

    @Override
    public void toParcel(RealmList<? extends RealmObject> input, Parcel parcel) {
        parcel.writeInt(input == null ? NULL : input.size());
        if (input != null) {
            for (RealmObject item : input) {
                parcel.writeParcelable(Parcels.wrap(item), 0);
            }
        }
    }

    //TODO: 将返回值替换为RealmList<? extends RealmObject>试试看
    @Override
    public RealmList fromParcel(Parcel parcel) {
        int size = parcel.readInt();
        RealmList result = new RealmList();
        for (int index = 0; index < size; index++) {
            Parcelable parcelable = parcel.readParcelable(getClass().getClassLoader());
            result.add((RealmObject) Parcels.unwrap(parcelable));
        }
        return result;
    }
}
