package com.thescore.interview.repositories

import com.thescore.interview.data.remote.TeamRemoteData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface TeamService {

    @GET("input.json")
    suspend fun getTeams(): List<TeamRemoteData>
}