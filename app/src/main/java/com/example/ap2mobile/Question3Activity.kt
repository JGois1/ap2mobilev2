package com.example.ap2mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2mobile.databinding.ActivityQuestion3Binding

class Question3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestion3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestion3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("USER_NAME")
        val currentScore = intent.getIntExtra("SCORE", 0)

        binding.nextButton3.setOnClickListener {
            val selectedId = binding.question3RadioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, getString(R.string.select_an_option), Toast.LENGTH_SHORT).show()
            } else {
                val score = when (selectedId) {
                    R.id.q3_option_a -> 0
                    R.id.q3_option_b -> 1
                    R.id.q3_option_c -> 2
                    else -> 0
                }

                val totalScore = currentScore + score
                val intent = Intent(this, Question4Activity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("SCORE", totalScore)
                startActivity(intent)
            }
        }
    }
}