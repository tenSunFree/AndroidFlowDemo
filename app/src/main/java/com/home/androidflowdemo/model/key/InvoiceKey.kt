package com.home.androidflowdemo.model.key

import android.os.Parcel
import android.os.Parcelable
import com.home.androidflowdemo.model.bean.InvoicesBean

class InvoiceKey : Parcelable {

    val invoicesBean: InvoicesBean?

    constructor(invoicesBean: InvoicesBean) {
        this.invoicesBean = invoicesBean
    }

    private constructor(`in`: Parcel) {
        invoicesBean = `in`.readParcelable(InvoicesBean::class.java.classLoader)
    }

    companion object CREATOR : Parcelable.Creator<InvoiceKey> {
        override fun createFromParcel(parcel: Parcel): InvoiceKey {
            return InvoiceKey(parcel)
        }

        override fun newArray(size: Int): Array<InvoiceKey?> {
            return arrayOfNulls(size)
        }
    }

    override fun hashCode(): Int {
        return invoicesBean!!.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as InvoiceKey?
        return invoicesBean == that!!.invoicesBean
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {}
}