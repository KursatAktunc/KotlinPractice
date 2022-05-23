package com.kotlin.practice.ui.fragment.main.screens.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.practice.R
import com.kotlin.practice.databinding.PokemonItemBinding
import com.kotlin.practice.models.pokedex.Pokemon

class PokemonAdapter(private var items: List<Pokemon>) :
    RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: PokemonItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}