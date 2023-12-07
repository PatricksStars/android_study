package com.example.studyapplication.baseattr;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * android默认序列化接口  要快
 */
public class UserParcelable implements Parcelable {
    public String name;
    public int age;


    public UserParcelable(){

    }

    protected UserParcelable(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel in) {
            return new UserParcelable(in);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }
}
