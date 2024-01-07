package com.example.selfad

import android.content.Intent
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
        val contactName = edittext_contact_name.text.toString()
        val contactNumber = edittext_contact_number.text.toString()
        val myDisplayedName = edittext_my_displayed_name.text.toString()
        val includeJunior = checkbox_include_junior.isChecked
        val jobTitle = spinner_job_title.selectedItem.toString()
        val immediateStart = checkbox_immediate_start.isChecked
        val startDate = edittext_start_date.text.toString()

        val previewIntent = Intent(this, PreviewActivity::class.java)
        previewIntent.putExtra("Contact Name", contactName)
        previewIntent.putExtra("Contact Number", contactNumber)
        previewIntent.putExtra("My Displayed Name", myDisplayedName)
        previewIntent.putExtra("Include Junior", includeJunior)
        previewIntent.putExtra("Job Title", jobTitle)
        previewIntent.putExtra("Immediate Start", immediateStart)
        previewIntent.putExtra("Start Date", startDate)
        startActivity(previewIntent)

    }
}
