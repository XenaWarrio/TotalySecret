package com.thescore.interview.util

import com.thescore.interview.data.domain.TeamLocalData
import com.thescore.interview.data.remote.TeamRemoteData
import java.util.UUID

fun TeamRemoteData.toTeamLocalData() =
    TeamLocalData(
        wins = wins ?: 0,
        losses = losses ?: 0,
        fullName = fullName ?: "no team name",
        id = id?.toString() ?: UUID.randomUUID().toString()
    )