package com.example.timerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var chronometerViewModel: ChronometerViewModel
    lateinit var timeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometerViewModel = ViewModelProvider(this).get(ChronometerViewModel::class.java)
        timeText = findViewById(R.id.textView)

        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObeserver = Observer<Long>(){
            timeText.text = resources.getString(R.string.seconds, it)
        }
        chronometerViewModel.getElapsedTime().observe(this, elapsedTimeObeserver)
    }
}