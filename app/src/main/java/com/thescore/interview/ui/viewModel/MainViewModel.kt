package com.thescore.interview.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thescore.interview.data.domain.TeamLocalData
import com.thescore.interview.repositories.remote.RemoteRepository
import com.thescore.interview.util.toTeamLocalData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RemoteRepository) : ViewModel() {
    private val _teamListLiveData = MutableLiveData<List<TeamLocalData>>()
    val teamListLiveData = _teamListLiveData

    fun getTeams(scope: CoroutineScope? = viewModelScope) {
        scope?.launch {
            teamListLiveData.postValue(repository.getTeamList().map { it.toTeamLocalData() })
        }
    }

}

