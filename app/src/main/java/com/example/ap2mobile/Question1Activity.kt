package com.example.ap2mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2mobile.databinding.ActivityQuestion1Binding

class Question1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestion1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestion1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera o nome do usuário da Intent
        val userName = intent.getStringExtra("USER_NAME")

        binding.nextButton1.setOnClickListener {
            val selectedId = binding.question1RadioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, getString(R.string.select_an_option), Toast.LENGTH_SHORT).show()
            } else {
                // Calcula a pontuação da resposta
                val score = when (selectedId) {
                    R.id.q1_option_a -> 0
                    R.id.q1_option_b -> 1
                    R.id.q1_option_c -> 2
                    else -> 0
                }

                // Inicia a próxima tela, passando nome e pontuação acumulada
                val intent = Intent(this, Question2Activity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("SCORE", score)
                startActivity(intent)
            }
        }
    }
}