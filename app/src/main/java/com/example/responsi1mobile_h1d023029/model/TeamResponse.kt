package com.example.responsi1mobile_h1d023029.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// 🔹 Data utama tim
data class TeamResponse(
    val id: Int,
    val name: String,
    val shortName: String,
    val crest: String,
    val coach: Coach,
    val squad: List<Player>
)

// 🔹 Data pelatih
data class Coach(
    val id: Int?,
    val name: String?,
    val nationality: String?,
    val dateOfBirth: String? // sesuai format dari API (contoh: "1982-08-02")
)

// 🔹 Data pemain (pakai @Parcelize agar bisa dikirim antar fragment/activity)
@Parcelize
data class Player(
    val id: Int?,
    val name: String?,
    val position: String?,
    val nationality: String?,
    val dateOfBirth: String? // ⚠️ pakai nama ini, bukan birthdate, supaya sesuai API Football-Data
) : Parcelable
