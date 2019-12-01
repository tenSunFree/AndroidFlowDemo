package com.home.androidflowdemo.model.keyparceler

import android.os.Parcelable

import flow.KeyParceler

/**
 * Assumes states are [Parcelable].
 * A more realistic implementation might rely on a library like auto-value-parcel,
 * auto-parcel, or parceler.
 */
class MyKeyParceler : KeyParceler {

    override fun toParcelable(key: Any): Parcelable {
        return key as Parcelable
    }

    override fun toKey(parcelable: Parcelable): Any {
        return parcelable
    }
}
