package com.kotlin.practice.ui.fragment.main.screens.pokedex.adapter

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kotlin.practice.R
import com.kotlin.practice.models.pokedex.Pokemon

class PokemonViewHolder(private val binding: com.kotlin.practice.databinding.PokemonItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Pokemon) {
        binding.pokeModel = item
        binding.imageView.load(item.imageurl) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
        }
        val colors = arrayListOf(
            R.color.blue,
            R.color.brown,
            R.color.indigo,
            R.color.red,
            R.color.teal,
            R.color.yellow
        )
        binding.pokeCardView.setCardBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(binding.root.context, colors.random())))
    }
}
