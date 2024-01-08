package com.example.selfad

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PreviewActivity : AppCompatActivity() {

    private lateinit var messageTextView: TextView
    private lateinit var message: Message
    private lateinit var previewMessage: String
    private lateinit var sendSmsButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        @Suppress("DEPRECATION")
        message = intent.getSerializableExtra("Message") as Message

        previewMessage = displayMessage(message)

        sendSmsButton = findViewById(R.id.button_send_message)
        sendSmsButton.setOnClickListener {
            setupButton(previewMessage, message)
        }
    }

    private fun displayMessage(message: Message): String {

        messageTextView = findViewById(R.id.textview_message)

        previewMessage = """
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

    private fun setupButton(previewMessage: String, message: Message) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto: ${message.contactNumber}")
            putExtra("sms_body", previewMessage)
        }
        startActivity(intent)
    }
}