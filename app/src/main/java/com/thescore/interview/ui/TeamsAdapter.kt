package com.thescore.interview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thescore.interview.data.domain.TeamLocalData
import com.thescore.interview.databinding.LayoutTeamBinding

class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {
    private val teams = mutableListOf<TeamLocalData>()

    fun setTeams(newTeams: List<TeamLocalData>) {
        teams.clear()
        teams.addAll(newTeams)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding: LayoutTeamBinding = LayoutTeamBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TeamViewHolder(binding)
    }

    override fun getItemCount() = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindView(teams[position])
    }

    class TeamViewHolder(
        private val binding: LayoutTeamBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {

        fun bindView(item: TeamLocalData) {
            with(binding) {
                tvNames.text = item.fullName
                tvLosses.text = "${item.losses}"
                tvWins.text = "${item.wins}"
            }
        }

    }

}

