package com.example.w21comp3025w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.w21comp3025w4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup and intent to navigate to the PassDetail class and push whatever
        //content is in the editText to the PassDetail activity
        binding.detailsButton.setOnClickListener {

            if (binding.editTextTextPersonName.text.toString().isNotEmpty())
            {
                val intent = Intent(applicationContext, PassDetailsActivity::class.java)
                intent.putExtra("personName", binding.editTextTextPersonName.text.toString())
                startActivity(intent)
            }
            else
                Toast.makeText(this, "You need to enter your name", Toast.LENGTH_LONG).show()
        }

        //set up an intent ot navigate to the WebActivity
        binding.webButton.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }

        //set up an intent ot navigate to the SmsActivity
        binding.smsButton.setOnClickListener {
            val intent = Intent(this, SmsActivity::class.java)
            startActivity(intent)
        }

        //set up an intent to navigate to the copyToClipboard activity
        binding.copyButton.setOnClickListener {
            val intent = Intent(this, CopyToClipActivity::class.java)
            startActivity(intent)
        }
    }
}