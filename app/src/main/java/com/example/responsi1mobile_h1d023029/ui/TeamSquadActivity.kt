package com.example.responsi1mobile_h1d023029.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobile_h1d023029.adapter.PlayerAdapter
import com.example.responsi1mobile_h1d023029.databinding.ActivityTeamSquadBinding
import com.example.responsi1mobile_h1d023029.network.FootballApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TeamSquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamSquadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTeam.layoutManager = LinearLayoutManager(this)
        fetchSquadData()

        binding.btnBackSquad.setOnClickListener { finish() }
    }

    private fun fetchSquadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(FootballApiService::class.java)

        lifecycleScope.launch {
            try {
                // ID tim Le Havre AC = 533
                val response = api.getTeam(533)
                val players = response.squad

                val adapter = PlayerAdapter(players) { player ->
                    val fragment = TeamDetailFragment.newInstance(player)
                    fragment.show(supportFragmentManager, "TeamDetailFragment")
                }

                binding.rvTeam.adapter = adapter

            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    this@TeamSquadActivity,
                    "Gagal memuat data pemain",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

