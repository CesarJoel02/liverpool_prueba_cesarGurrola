package com.cesargurrola.liverpool_shopapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesargurrola.liverpool_shopapp.R
import com.cesargurrola.liverpool_shopapp.model.Record

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {
    private var productList = listOf<Record>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(itemView, parent.context)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount() = productList.size

    fun submitList(productList: List<Record>) {
        this.productList = productList
        notifyDataSetChanged()
    }
}