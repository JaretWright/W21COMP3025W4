package com.example.w21comp3025w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w21comp3025w4.databinding.ActivityPassDetailsBinding

class PassDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPassDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
    }
}