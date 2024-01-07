package com.example.selfad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.button_submit
import kotlinx.android.synthetic.main.activity_main.button_submit
import kotlinx.android.synthetic.main.activity_main.checkbox_immediate_start
import kotlinx.android.synthetic.main.activity_main.checkbox_include_junior
import kotlinx.android.synthetic.main.activity_main.edittext_contact_name
import kotlinx.android.synthetic.main.activity_main.edittext_contact_number
import kotlinx.android.synthetic.main.activity_main.edittext_my_displayed_name
import kotlinx.android.synthetic.main.activity_main.edittext_start_date
import kotlinx.android.synthetic.main.activity_main.spinner_job_title

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_submit.setOnClickListener(){
            submitButtonClick()
        }
    }

    private fun submitButtonClick() {
        val contactName = edittext_contact_name
        val contactNumber = edittext_contact_number
        val myDisplayedName = edittext_my_displayed_name
        val includeJunior = checkbox_include_junior
        val jobTitle = spinner_job_title
        val immediateStart = checkbox_immediate_start
        val startDate = edittext_start_date
    }
}