package com.cesargurrola.liverpool_shopapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesargurrola.liverpool_shopapp.R

class ColorAdapter(private val colorList: List<String>) : RecyclerView.Adapter<ColorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(colorList[position])
    }

    override fun getItemCount() = colorList.size
}