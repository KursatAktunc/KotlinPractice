package com.kotlin.practice.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.kotlin.practice.databinding.ProductsItemBinding
import com.kotlin.practice.models.Products

class ProductsViewHolder(private val binding: ProductsItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Products) {
        binding.model = item
    }
}