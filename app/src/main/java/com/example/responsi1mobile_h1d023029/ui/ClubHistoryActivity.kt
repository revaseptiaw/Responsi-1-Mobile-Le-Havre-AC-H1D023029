package com.example.responsi1mobile_h1d023029.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobile_h1d023029.R
import com.example.responsi1mobile_h1d023029.databinding.ActivityClubHistoryBinding

class ClubHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClubHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set teks sejarah klub
        binding.tvHistory.text = """
        Le Havre Athletic Club, didirikan pada tahun 1872, adalah klub sepak bola tertua di Prancis dan memiliki sejarah panjang yang kaya dalam dunia olahraga. Klub ini awalnya terbentuk sebagai bagian dari kegiatan olahraga umum di kota pelabuhan Le Havre, sebelum berfokus secara khusus pada sepak bola. Keberadaannya telah menjadi simbol penting dalam perkembangan sepak bola profesional di Prancis, menjadikannya salah satu institusi olahraga paling berpengaruh di negara ini.

        Sejak awal berdirinya, Le Havre AC dikenal karena komitmennya dalam membina talenta muda. Akademi klub telah melahirkan banyak pemain berbakat yang kemudian menembus liga-liga top Eropa. Pendekatan ini menekankan pengembangan keterampilan teknis, disiplin, dan pemahaman taktik sejak usia dini, sehingga membentuk reputasi Le Havre sebagai pusat pengembangan pemain muda terbaik di Prancis.

        Klub ini juga mengalami berbagai pasang surut dalam kompetisi domestik. Le Havre AC telah beberapa kali merasakan promosi dan degradasi antara Ligue 1 dan Ligue 2. Meskipun tidak selalu bersaing di papan atas, klub ini tetap menjaga stabilitas manajemen dan fokus pada strategi jangka panjang, terutama dalam membangun tim yang kompetitif dari bakat-bakat muda sendiri.

        Selain prestasi di lapangan, Le Havre AC memiliki hubungan yang kuat dengan komunitas lokal. Klub ini sering mengadakan program sosial dan kegiatan yang melibatkan warga kota, memperkuat identitasnya sebagai simbol kebanggaan kota Le Havre. Keberadaan klub ini tidak hanya berpengaruh dalam dunia olahraga, tetapi juga dalam membangun ikatan sosial dan budaya di sekitarnya.

        Hingga kini, Le Havre AC terus mempertahankan warisan dan tradisinya. Dengan fokus pada pengembangan pemain muda, stabilitas organisasi, dan komitmen terhadap komunitas, klub ini tetap menjadi salah satu pilar sepak bola Prancis yang dihormati. Masa depan Le Havre AC diyakini akan terus cerah, seiring generasi-generasi pemain baru lahir dan membawa semangat serta prestasi lebih tinggi bagi klub dan kota Le Havre.
        """.trimIndent()

        // Tombol kembali ke halaman utama
        binding.btnBackHistory.setOnClickListener {
            finish()
        }
    }
}
