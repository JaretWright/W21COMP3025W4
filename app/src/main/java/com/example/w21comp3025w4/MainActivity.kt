package com.example.w21comp3025w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            val intent = Intent(applicationContext, PassDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}