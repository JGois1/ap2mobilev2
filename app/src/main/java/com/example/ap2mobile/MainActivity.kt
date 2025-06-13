package com.example.ap2mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap2mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            if (name.isBlank()) {
                // Mostra um aviso se o nome estiver vazio
                Toast.makeText(this, getString(R.string.please_enter_name), Toast.LENGTH_SHORT).show()
            } else {
                // Inicia a primeira pergunta, passando o nome do usuário
                val intent = Intent(this, Question1Activity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            }
        }
    }
}


