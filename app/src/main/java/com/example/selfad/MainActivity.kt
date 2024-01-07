package com.example.selfad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var contactNameEditText: TextInputEditText? = null
    private var contactNumberEditText: TextInputEditText? = null
    private var myDisplayedNameEditText: TextInputEditText? = null
    private var includeJuniorCheckBox: CheckBox? = null
    private var jobTitleSpinner: Spinner? = null
    private var immediateStartCheckbox: CheckBox? = null
    private var startDateEditText: TextInputEditText? = null
    private var submitButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton = findViewById(R.id.button_submit)

        submitButton?.setOnClickListener(){
            submitButtonClick()
        }
    }

    private fun submitButtonClick() {

        contactNameEditText = findViewById(R.id.edittext_contact_name)
        contactNumberEditText = findViewById(R.id.edittext_contact_number)
        myDisplayedNameEditText = findViewById(R.id.edittext_my_displayed_name)
        includeJuniorCheckBox = findViewById(R.id.checkbox_include_junior)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)
        immediateStartCheckbox = findViewById(R.id.checkbox_immediate_start)
        startDateEditText = findViewById(R.id.edittext_start_date)

        val contactNameEditText = contactNameEditText?.text.toString()
        val contactNumberEditText = contactNumberEditText?.text.toString()
        val myDisplayedNameEditText = myDisplayedNameEditText?.text.toString()
        val includeJuniorCheckBox = includeJuniorCheckBox?.isChecked
        val jobTitleSpinner = jobTitleSpinner?.selectedItem.toString()
        val immediateStartCheckbox = immediateStartCheckbox?.isChecked
        val startDateEditText = startDateEditText?.text.toString()

        val previewIntent = Intent(this, PreviewActivity::class.java)
        previewIntent.putExtra("Contact Name", contactNameEditText)
        previewIntent.putExtra("Contact Number", contactNumberEditText)
        previewIntent.putExtra("My Displayed Name", myDisplayedNameEditText)
        previewIntent.putExtra("Include Junior", includeJuniorCheckBox)
        previewIntent.putExtra("Job Title", jobTitleSpinner)
        previewIntent.putExtra("Immediate Start", immediateStartCheckbox)
        previewIntent.putExtra("Start Date", startDateEditText)
        startActivity(previewIntent)

    }
}
