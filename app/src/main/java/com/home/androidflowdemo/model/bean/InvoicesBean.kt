package com.home.androidflowdemo.model.bean

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InvoicesBean(
    @SerializedName("invoices")
    val invoices: List<Invoice>
) : Parcelable {
    @Parcelize
    data class Invoice(
        @SerializedName("name")
        val name: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("money")
        val money: String,
        @SerializedName("virtualPoints")
        val virtualPoints: String,
        @SerializedName("number")
        val number: String
    ) : Parcelable
}