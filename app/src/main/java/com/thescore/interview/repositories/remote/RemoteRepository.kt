package com.thescore.interview.repositories.remote

import com.thescore.interview.data.remote.TeamRemoteData
import com.thescore.interview.repositories.TeamService
import com.thescore.interview.util.wrapper.Resource
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val apiService: TeamService) {

    suspend fun getTeamList(): Resource<List<TeamRemoteData>> {
        val response = apiService.getTeams()
        return when {
            response.isSuccessful && response.body() != null -> Resource.Success(response.body()!!)
            response.isSuccessful -> Resource.Error("list is empty")
            else -> Resource.Error("error occurred")
        }
    }

}