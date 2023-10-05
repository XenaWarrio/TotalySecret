package com.thescore.interview.repositories.remote

import com.thescore.interview.repositories.TeamService
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val apiService : TeamService) {

    suspend fun getTeamList() = apiService.getTeams()

}