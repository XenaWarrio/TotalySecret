package com.thescore.interview.di

import com.thescore.interview.repositories.TeamService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TeamModule {

    @Provides
    @Singleton
    fun getApiService() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/")
        .build()
        .create<TeamService>()
}