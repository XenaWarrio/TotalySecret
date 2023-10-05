package com.thescore.interview.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thescore.interview.data.domain.TeamLocalData
import com.thescore.interview.repositories.remote.RemoteRepository
import com.thescore.interview.util.toTeamLocalData
import com.thescore.interview.util.wrapper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RemoteRepository) : ViewModel() {

    private val _teamListLiveData = MutableLiveData<List<TeamLocalData>>()
    val teamListLiveData = _teamListLiveData

    private val _teamListError = MutableLiveData<String>()
    val teamListError = _teamListError

    fun getTeams(scope: CoroutineScope? = viewModelScope) {
        scope?.launch {

            when (val dataResource = repository.getTeamList()) {
                is Resource.Success -> teamListLiveData.postValue(dataResource.data?.map { it.toTeamLocalData() })
                is Resource.Error -> _teamListError.postValue(dataResource.message)
            }
        }
    }

}

