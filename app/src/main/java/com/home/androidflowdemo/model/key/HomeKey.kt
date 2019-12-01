package com.home.androidflowdemo.model.key

import android.os.Parcel
import android.os.Parcelable

class HomeKey : Parcelable {

    companion object CREATOR : Parcelable.Creator<HomeKey> {
        override fun createFromParcel(parcel: Parcel): HomeKey {
            return HomeKey()
        }

        override fun newArray(size: Int): Array<HomeKey?> {
            return arrayOfNulls(size)
        }
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return other is HomeKey
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {}
}
