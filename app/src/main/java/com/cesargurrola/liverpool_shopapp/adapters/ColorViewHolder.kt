package com.cesargurrola.liverpool_shopapp.adapters

import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cesargurrola.liverpool_shopapp.R

class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val colorView: View = itemView.findViewById(R.id.color_view)

    fun bind(color: String) {
        try {
            colorView.setBackgroundColor(Color.parseColor(color))
        } catch (e: Exception) {
            Log.e("colorListEx", e.localizedMessage)
        }
    }
}