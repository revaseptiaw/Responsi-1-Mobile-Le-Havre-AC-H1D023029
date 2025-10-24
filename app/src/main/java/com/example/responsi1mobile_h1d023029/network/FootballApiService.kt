package com.example.responsi1mobile_h1d023029.network

import com.example.responsi1mobile_h1d023029.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FootballApiService {
    @Headers("X-Auth-Token: 81a3d86a978e47149cef9ddbae7d8f28")
    @GET("v4/teams/{id}")
    suspend fun getTeam(@Path("id") teamId: Int): TeamResponse
}