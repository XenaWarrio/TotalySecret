package com.thescore.interview.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.thescore.interview.data.remote.TeamRemoteData
import com.thescore.interview.repositories.remote.RemoteRepository
import com.thescore.interview.ui.viewModel.MainViewModel
import com.thescore.interview.util.toTeamLocalData
import com.thescore.interview.util.wrapper.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// @SmallTest
@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val repository = mockk<RemoteRepository>()
    //private val scope = CoroutineScope(ApplicationContext())
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = MainViewModel(repository)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun exampleCoroutineTest() = runBlockingTest {

    }

    @Test
    fun `get teams returns teams`() = runBlockingTest {
        val teams = listOf(TeamRemoteData(0, 0, "0", 0))
        coEvery {
            repository.getTeamList()
        } returns Resource.Success(teams)

        viewModel.getTeams(this)

        assert(viewModel.teamListLiveData.value == teams.map { it.toTeamLocalData() })
    }
}