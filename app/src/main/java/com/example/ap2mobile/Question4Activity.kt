package com.example.ap2mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2mobile.databinding.ActivityQuestion4Binding

class Question4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestion4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestion4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("USER_NAME")
        val currentScore = intent.getIntExtra("SCORE", 0)

        binding.finishButton.setOnClickListener {
            val selectedId4 = binding.question4RadioGroup.checkedRadioButtonId
            val selectedId5 = binding.question5RadioGroup.checkedRadioButtonId

            if (selectedId4 == -1 || selectedId5 == -1) {
                Toast.makeText(this, getString(R.string.answer_all_questions), Toast.LENGTH_SHORT).show()
            } else {
                val score4 = when (selectedId4) {
                    R.id.q4_option_a -> 0
                    R.id.q4_option_b -> 1
                    R.id.q4_option_c -> 2
                    else -> 0
                }
                val score5 = when (selectedId5) {
                    R.id.q5_option_a -> 0
                    R.id.q5_option_b -> 1
                    R.id.q5_option_c -> 2
                    else -> 0
                }

                val finalScore = currentScore + score4 + score5
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("FINAL_SCORE", finalScore)
                // Limpa as activities anteriores para que o usuário não possa voltar
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}