package com.example.questiongame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

var counter: Int = 0
class MainActivity : ComponentActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var firstAnswerBtn: Button
    private lateinit var secondAnswerBtn: Button
    private lateinit var thirdAnswerBtn: Button
    private lateinit var fourthAnswerBtn: Button
    private var currentIndex = 0

    private val questions = listOf(
        Question(R.string.question_one, 1),
        Question(R.string.question_two, 2),
        Question(R.string.question_three, 3),
        Question(R.string.question_four, 4),
        Question(R.string.question_five, 2),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        questionTextView = findViewById(R.id.question_tv)
        firstAnswerBtn = findViewById(R.id.first_answer_btn)
        secondAnswerBtn = findViewById(R.id.second_answer_btn)
        thirdAnswerBtn = findViewById(R.id.third_answer_btn)
        fourthAnswerBtn = findViewById(R.id.fourth_answer_btn)

        updateQuestion()
        updateAnswers()

        firstAnswerBtn.setOnClickListener {
            checkAnswer(1)
        }
       secondAnswerBtn.setOnClickListener {
            checkAnswer(2)
        }
        thirdAnswerBtn.setOnClickListener {
            checkAnswer(3)
        }
        fourthAnswerBtn.setOnClickListener {
            checkAnswer(4)
        }
    }

    private fun checkAnswer(answer: Int) {
        if (questions[currentIndex].trueAnswerNumber == answer) {
            counter++
        }
        updateQuestion()
    }

    private fun updateQuestion() {
        if (currentIndex == 4) {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
        else {
            currentIndex = (currentIndex + 1) % questions.size
            val questionTextResId = questions[currentIndex].question
            questionTextView.setText(questionTextResId)
            updateAnswers()
        }



    }

    private fun updateAnswers() {
        firstAnswerBtn.text = R.string.answer_one.toString()
        secondAnswerBtn.text = R.string.answer_one.toString()
        thirdAnswerBtn.text = R.string.answer_one.toString()
        fourthAnswerBtn.text = R.string.answer_one.toString()
    }
}