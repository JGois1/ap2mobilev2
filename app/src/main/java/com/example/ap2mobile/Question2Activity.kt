package com.example.ap2mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Question2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        if (savedInstanceState == null) {

            val fragment = Question2Fragment().apply {
                arguments = Bundle().apply {
                    putString("USER_NAME", intent.getStringExtra("USER_NAME"))
                    putInt("SCORE", intent.getIntExtra("SCORE", 0))
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}