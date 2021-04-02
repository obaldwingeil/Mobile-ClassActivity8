package com.example.kotlinexample1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.service.autofill.FillEventHistory
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinexample1.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding

    private lateinit var textViewGreeting : TextView
    private lateinit var buttonHistory: Button

    private final val baseUrl = "https://www.behindthename.com/name/"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewGreeting = binding.textViewGreeting
        buttonHistory = binding.buttonHistory

        val message = intent.getStringExtra("name")
        textViewGreeting.text = "Hello, " + message

        // set the text of this button
        buttonHistory.text = "History of " + message
        buttonHistory.setOnClickListener{
            if (message != null) {
                launchBrowser(message)
            }
        }
    }

    // when the button is clicked
    // send an implicit intent with the name passed through intent
    // https://www.behindthename.come/name/NAME

    private fun launchBrowser(name : String){
        // Uri to parse the actual url
        // start an activity with action view
        val queryUrl : Uri = Uri.parse("${baseUrl}${name}")
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        startActivity(intent)
    }
}