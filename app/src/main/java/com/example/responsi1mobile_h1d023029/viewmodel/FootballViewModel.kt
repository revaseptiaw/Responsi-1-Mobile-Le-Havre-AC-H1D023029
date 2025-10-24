package com.example.responsi1mobile_h1d023029.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobile_h1d023029.model.TeamResponse
import com.example.responsi1mobile_h1d023029.repository.FootballRepository
import kotlinx.coroutines.launch

class FootballViewModel : ViewModel() {
    private val repo = FootballRepository()
    private val _team = MutableLiveData<TeamResponse>()
    val team: LiveData<TeamResponse> = _team

    fun loadTeam(teamId: Int) {
        viewModelScope.launch {
            try {
                val data = repo.getTeamData(teamId)
                _team.value = data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
