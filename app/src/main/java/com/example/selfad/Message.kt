package com.example.selfad

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayedName: String,
    val includeJunior: Boolean,
    val jobTitle: String,
    val immediateStart: Boolean,
    val startDate: String
) : Serializable {

    fun jobDescription() = if (includeJunior) "a junior $jobTitle" else "an $jobTitle"
    fun startTime() = if (immediateStart) "immediately" else "from $startDate"
}