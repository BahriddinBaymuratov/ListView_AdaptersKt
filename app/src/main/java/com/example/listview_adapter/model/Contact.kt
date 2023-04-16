package com.example.listview_adapter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    var name: String,
    var number: String,
) : Parcelable {
    override fun toString(): String {
        return "Contact(name='$name', number='$number')"
    }
}