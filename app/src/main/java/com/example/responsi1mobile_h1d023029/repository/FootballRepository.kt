package com.example.responsi1mobile_h1d023029.repository

import com.example.responsi1mobile_h1d023029.model.TeamResponse
import com.example.responsi1mobile_h1d023029.network.ApiClient

class FootballRepository {
    suspend fun getTeamData(teamId: Int): TeamResponse {
        return ApiClient.instance.getTeam(teamId)
    }
}
