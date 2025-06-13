package com.example.ap2mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ap2mobile.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("USER_NAME")
        val finalScore = intent.getIntExtra("FINAL_SCORE", 0)

        binding.greetingTextView.text = getString(R.string.congratulations_name, userName)

        // Determina o perfil com base na pontuação final
        when (finalScore) {
            in 0..3 -> displayProfile(
                getString(R.string.profile_conservative),
                getString(R.string.desc_conservative),
                R.drawable.ic_profile_conservative
            )
            in 4..7 -> displayProfile(
                getString(R.string.profile_moderate),
                getString(R.string.desc_moderate),
                R.drawable.ic_profile_moderate
            )
            else -> displayProfile(
                getString(R.string.profile_aggressive),
                getString(R.string.desc_aggressive),
                R.drawable.ic_profile_aggressive
            )
        }

        binding.learnMoreButton.setOnClickListener {
            val webPage = Uri.parse("https://www.google.com/search?q=perfis+de+investimento&sca_esv=25c25e42fef10570&rlz=1C1VDKB_enBR1166BR1166&sxsrf=AE3TifOBk-arT-Q5t_bSQOM9VvDfrDWngA%3A1749822599326&ei=hyxMaJHaE4Pd1sQPwKeS2Qs&ved=0ahUKEwjRuc-Txe6NAxWDrpUCHcCTJLsQ4dUDCBA&uact=5&oq=perfis+de+investimento&gs_lp=Egxnd3Mtd2l6LXNlcnAiFnBlcmZpcyBkZSBpbnZlc3RpbWVudG8yChAAGIAEGBQYhwIyChAAGIAEGBQYhwIyBRAAGIAEMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB5I2xtQrQdYuhpwAXgBkAEAmAGGAaAB0RKqAQQxLjIxuAEDyAEA-AEBmAIXoAKVE8ICChAAGLADGNYEGEfCAg0QABiABBiwAxhDGIoFwgIKECMYgAQYJxiKBcICEBAAGIAEGLEDGEMYgwEYigXCAgsQABiABBixAxiDAcICCxAuGIAEGNEDGMcBwgIKEAAYgAQYQxiKBcICEBAjGPAFGIAEGCcYyQIYigXCAhMQLhiABBixAxjRAxhDGMcBGIoFwgIKEC4YgAQYQxiKBcICEBAuGIAEGNEDGEMYxwEYigXCAg4QLhiABBjHARiOBRivAcICCBAAGIAEGLEDwgIOEC4YgAQYsQMY0QMYxwHCAgsQLhiABBjHARivAcICBxAAGIAEGAqYAwCIBgGQBgqSBwQxLjIyoAe9nwGyBwQwLjIyuAeQE8IHBjAuMTcuNsgHPA&sclient=gws-wiz-serp")
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        binding.restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun displayProfile(profile: String, description: String, iconRes: Int) {
        binding.profileTextView.text = profile
        binding.descriptionTextView.text = description
        binding.profileImageView.setImageDrawable(ContextCompat.getDrawable(this, iconRes))
    }
}
