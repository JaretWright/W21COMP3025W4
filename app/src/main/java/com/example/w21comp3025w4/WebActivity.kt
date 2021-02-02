package com.example.w21comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.w21comp3025w4.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //create a clicklistener to navigate back to the main Activity using an explicit intent
        binding.backToMainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //create an implicit intent to open a browser to a particular web page
        binding.loadUrlButton.setOnClickListener {
            if (binding.urlEditText.text.toString().isNullOrBlank())
                Toast.makeText(this, "You need to enter a URL", Toast.LENGTH_LONG).show()
            else
            {
                var url = binding.urlEditText.text.toString()

                //check to make sure that it starts with http:// or  https://
                if (!(url.startsWith("http://") || url.startsWith("https://")))
                    url = "https://"+url

                //create an implicit intent
                val intent = Intent(Intent.ACTION_VIEW)

                //add data to the intent
                intent.data = Uri.parse(url)

                //launch the intent with startActivity
                startActivity(intent)
            }
        }
    }
}