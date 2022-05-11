package com.kotlin.practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.practice.R
import com.kotlin.practice.adapter.viewholder.ProductsViewHolder
import com.kotlin.practice.databinding.ProductsItemBinding
import com.kotlin.practice.models.Products

class ProductsAdapter(private var items: List<Products>) :
    RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ProductsItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.products_item, parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size

}