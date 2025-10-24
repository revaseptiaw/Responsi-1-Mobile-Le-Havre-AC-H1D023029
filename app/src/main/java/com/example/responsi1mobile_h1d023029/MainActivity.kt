package com.example.responsi1mobile_h1d023029

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobile_h1d023029.databinding.ActivityMainBinding
import com.example.responsi1mobile_h1d023029.ui.ClubHistoryActivity
import com.example.responsi1mobile_h1d023029.ui.HeadCoachActivity
import com.example.responsi1mobile_h1d023029.ui.TeamSquadActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Atur teks dari strings.xml
        binding.tvClubName.text = getString(R.string.club_name)
        binding.tvDescription.text = getString(R.string.desc_club)

        // Atur teks & ikon tiap menu
        binding.layoutHistory.tvLayout.text = getString(R.string.history)
        binding.layoutHistory.imgIcon.setImageResource(R.drawable.ic_history)

        binding.layoutCoach.tvLayout.text = getString(R.string.coach)
        binding.layoutCoach.imgIcon.setImageResource(R.drawable.ic_coach)

        binding.layoutTeam.tvLayout.text = getString(R.string.teamm)
        binding.layoutTeam.imgIcon.setImageResource(R.drawable.ic_team)

        // Tombol navigasi ke Activity
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, ClubHistoryActivity::class.java))
        }

        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, HeadCoachActivity::class.java))
        }

        binding.layoutTeam.root.setOnClickListener {
            startActivity(Intent(this, TeamSquadActivity::class.java))
        }

        // Tombol kembali
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

