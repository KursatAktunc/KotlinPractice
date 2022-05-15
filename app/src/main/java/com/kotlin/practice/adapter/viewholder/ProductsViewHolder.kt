package com.kotlin.practice.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kotlin.practice.R
import com.kotlin.practice.databinding.ProductsItemBinding
import com.kotlin.practice.models.Products

class ProductsViewHolder(private val binding: ProductsItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Products) {
        binding.model = item
        binding.productImageView.load(item.image) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
        }
    }
}