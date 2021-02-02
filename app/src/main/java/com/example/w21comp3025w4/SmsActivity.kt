package com.example.w21comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w21comp3025w4.databinding.ActivitySmsBinding

class SmsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //intent for the back button
        binding.backToMainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //an intent for the sms
        binding.smsButton.setOnClickListener{
            if (binding.editTextPhone.text.isNotEmpty() && binding.messageEditText.text.toString().isNotEmpty()){
                val phone = binding.editTextPhone.text.toString()
                val message = binding.messageEditText.text.toString()
                val uri = Uri.parse("smsto:$phone")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", message)
                startActivity(intent)
            }
        }
    }
}