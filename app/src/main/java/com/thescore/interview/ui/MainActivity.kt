package com.thescore.interview.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.thescore.interview.databinding.ActivityMainBinding
import com.thescore.interview.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    private val teamsAdapter by lazy { TeamsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getTeams()

        setUpUi()
        setObservers()
    }

    private fun setUpUi() {
        with(binding) {
            recyclerview.adapter = teamsAdapter
        }
    }

    private fun setObservers(){
        viewModel.teamListLiveData.observe(this){
            teamsAdapter.setTeams(it)
        }
    }
}