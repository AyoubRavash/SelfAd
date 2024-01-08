package com.example.selfad

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class PreviewActivity : AppCompatActivity() {

    private lateinit var messageTextView: TextView
    private lateinit var message: Message
    private lateinit var previewMessage: String
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        message = intent.getSerializableExtra("Message") as Message

        previewMessage = displayMessage()

        setupButton(previewMessage)
    }

    private fun displayMessage(): String {

        messageTextView = findViewById(R.id.textview_message)

        val previewMessage = """
                    Hello ${message.contactName}
                    
                    My name is ${message.myDisplayedName} and I am ${message.jobDescription()}.
                    
                    I have very good skills in developing android apps that I can show on request.
                    
                    I am able to start a new position ${message.startTime()}.
                    
                    Please get in touch if you have any suitable roles for me.
                    
                    Thanks and best regards.
                """.trimIndent()

        messageTextView.text = previewMessage
        return previewMessage
    }

    private fun setupButton(previewMessage: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("smsto:${message.contactNumber}")
            putExtra("sms_body", previewMessage)
            startActivity(intent)
        }
    }
}