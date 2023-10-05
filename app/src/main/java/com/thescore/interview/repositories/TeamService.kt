package com.thescore.interview.repositories

import com.thescore.interview.data.remote.TeamRemoteData
import retrofit2.Response
import retrofit2.http.GET

interface TeamService {

    @GET("input.json")
    suspend fun getTeams(): Response<List<TeamRemoteData>>
}