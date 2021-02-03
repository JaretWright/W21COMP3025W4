package com.example.w21comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.w21comp3025w4.databinding.ActivitySmsBinding

class SmsActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set an onclick listener to navigate back to the main activity
        binding.backToMain2Button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //setup an inplicit intent to send information to the messages app
        binding.smsButton2.setOnClickListener {
            var phoneNum = binding.editTextPhone.text.toString()
            var message = binding.messageEditText.text.toString()

            if (phoneNum.isNotEmpty() && message.isNotEmpty())
            {
                val uri = Uri.parse("smsto:$phoneNum")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Phone number and message must have values", Toast.LENGTH_LONG).show()
        }
    }
}