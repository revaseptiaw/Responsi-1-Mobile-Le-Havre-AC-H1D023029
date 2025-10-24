package com.example.responsi1mobile_h1d023029.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.responsi1mobile_h1d023029.databinding.ActivityHeadCoachBinding
import com.example.responsi1mobile_h1d023029.network.FootballApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeadCoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeadCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali
        binding.btnBackCoach.setOnClickListener {
            finish()
        }

        // Ambil data coach dari API
        fetchCoachData()
    }

    private fun fetchCoachData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data.org/") // ✅ Base URL benar
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(FootballApiService::class.java)

        lifecycleScope.launch {
            try {
                // ID 533 = Le Havre AC
                val response = api.getTeam(533)
                val coach = response.coach

                if (coach != null) {
                    binding.tvCoachName.text = coach.name ?: "Tidak diketahui"
                    binding.tvCoachBirth.text = "Tanggal Lahir: ${coach.dateOfBirth ?: "-"}"
                    binding.tvCoachCountry.text = "Kebangsaan: ${coach.nationality ?: "-"}"
                } else {
                    Toast.makeText(this@HeadCoachActivity, "Data pelatih tidak ditemukan", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@HeadCoachActivity, "Gagal mengambil data pelatih: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
