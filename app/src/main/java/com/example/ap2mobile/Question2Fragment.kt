package com.example.ap2mobile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ap2mobile.databinding.ActivityQuestion2FragmentBinding
class Question2Fragment : Fragment() {

    private var _binding: ActivityQuestion2FragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityQuestion2FragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userName = arguments?.getString("USER_NAME")
        val scoreFromQ1 = arguments?.getInt("SCORE", 0) ?: 0

        binding.nextButton2.setOnClickListener {
            val selectedId = binding.question2RadioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(requireContext(), getString(R.string.select_an_option), Toast.LENGTH_SHORT).show()
            } else {
                val scoreFromQ2 = when (selectedId) {
                    R.id.q2_option_a -> 0
                    R.id.q2_option_b -> 1
                    R.id.q2_option_c -> 2
                    else -> 0
                }

                val totalScore = scoreFromQ1 + scoreFromQ2
                val intent = Intent(activity, Question3Activity::class.java)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("SCORE", totalScore)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}