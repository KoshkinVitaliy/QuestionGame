package com.example.questiongame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {
    private lateinit var resultText: TextView
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultText = findViewById(R.id.result_tv)
        startButton = findViewById(R.id.start_btn)
        resultText.text = counter.toString()

        startButton.setOnClickListener {
            val intent = Intent(this,
                MainActivity::class.java)
            startActivity(intent)
        }
    }
}