package com.example.responsi1mobile_h1d023029.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobile_h1d023029.databinding.ItemPlayerBinding
import com.example.responsi1mobile_h1d023029.model.Player

class PlayerAdapter(
    private val players: List<Player>,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        with(holder.binding) {
            tvName.text = player.name ?: "-"
            tvPosition.text = player.position ?: "-"
            tvNationality.text = player.nationality ?: "-"

            val bgColor = when (player.position) {

                // 🟡 Goalkeeper
                "Goalkeeper", "GK" -> "#FFD54F" // Kuning

                // 🔵 Defender group
                "Defender", "Defence", "Centre Back", "CB", "Right Back", "RB", "Left Back", "LB" -> "#64B5F6" // Biru

                // 🟢 Midfielder group
                "Midfielder", "Midfield", "Defensive Midfield", "DMF", "Central Midfield", "CM", "Attacking Midfield", "AMF" -> "#81C784" // Hijau

                // 🔴 Forward group
                "Forward", "Offence", "Striker", "Centre-Forward", "CF", "Second Striker", "SS", "Winger" -> "#E57373" // Merah

                // ⚪ Default
                else -> "#E0E0E0"
            }


            cardView.setCardBackgroundColor(Color.parseColor(bgColor))

            // 🔹 Klik item → buka detail fragment
            root.setOnClickListener { onItemClick(player) }
        }
    }

    override fun getItemCount(): Int = players.size
}
