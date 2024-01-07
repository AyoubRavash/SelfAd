package com.example.selfad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
class PreviewActivity : AppCompatActivity() {

    private val messageTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        setMessageText()
    }

    private fun setMessageText() {
        val contactName = intent.getStringExtra("Contact Name")
        val contactNumber = intent.getStringExtra("Contact Number")
        val myDisplayedName = intent.getStringExtra("My Displayed Name")
        val includeJunior = intent.getBooleanExtra("Include Junior", false)
        val jobTitle = intent.getStringExtra("Job Title")
        val immediateStart = intent.getBooleanExtra("Immediate Start", false)
        val startDate = intent.getStringExtra("Start Date")
        messageTextView?.text = "contactName : $contactName, contactNumber : $contactNumber, myDisplayedName : $myDisplayedName, includeJunior : $includeJunior, jobTitle : $jobTitle, immediateStart : $immediateStart, startDate : $startDate"
    }
}