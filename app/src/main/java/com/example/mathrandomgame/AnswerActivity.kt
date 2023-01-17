package com.example.mathrandomgame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val intent = intent
        val number = intent.getStringExtra("result") //result
        val numberColor = intent.getStringExtra("resultColor")
        answerTextView.text = number
        answerTextView.setTextColor(Color.parseColor(numberColor))


    }
}