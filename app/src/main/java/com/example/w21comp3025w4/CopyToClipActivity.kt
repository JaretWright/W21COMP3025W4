package com.example.w21comp3025w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w21comp3025w4.databinding.ActivityCopyToClipBinding

class CopyToClipActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCopyToClipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCopyToClipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToMain2Button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //create an intent to copy to the clipboard
        binding.copyButton.setOnClickListener {
            val intent = Intent().apply{
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, binding.copyMessageEditText.text.toString())
                type = "text/plain"
            }
            startActivity(intent)
        }
    }
}