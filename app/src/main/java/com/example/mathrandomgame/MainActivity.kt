package com.example.mathrandomgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var x1 = 0
    var y1 = 0
    var userAnswer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onRandom()

        checkButton.setOnClickListener {
            if (answerEditText.text.toString() == ""){
                Toast.makeText(this, "Заполните ячейку", Toast.LENGTH_SHORT).show()
            }
            else{
                userAnswer = answerEditText.text.toString().toInt()
                onCheck()
                onRandom()
                answerEditText.text.clear()
            }

        }
    }

    fun onRandom(){
        val x = ((Math.random()*89)+10).toInt() //45
        val y = ((Math.random()*89)+10).toInt() //55

        x1 = x
        y1 = y

        firstNumber.text = x.toString()
        secondNumber.text = y.toString()


    }

    fun onCheck(){
        var result = x1 + y1
        if (result == userAnswer){
            Toast.makeText(this, "Правильно", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra("result", result.toString())
            intent.putExtra("resultColor", "#89F40D")
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Непривильно", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra("result", result.toString())
            intent.putExtra("resultColor", "#DD0B0B")
            startActivity(intent)
        }
    }
}