package com.cesargurrola.liverpool_shopapp.adapters

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cesargurrola.liverpool_shopapp.R
import com.cesargurrola.liverpool_shopapp.model.Record
import com.cesargurrola.liverpool_shopapp.utils.formatCurrency
import com.squareup.picasso.Picasso

class ProductViewHolder(
    itemView: View,
    private val context: Context
) : RecyclerView.ViewHolder(itemView) {

    private val productImageView: ImageView = itemView.findViewById(R.id.product_image)
    private val productNameTextView: TextView = itemView.findViewById(R.id.product_name)
    private val productPriceWithoutDiscountTextView: TextView = itemView.findViewById(R.id.product_price_without_discount)
    private val productPriceWithDiscountTextView: TextView = itemView.findViewById(R.id.product_price_with_discount)
    private val productColorsRecyclerView: RecyclerView = itemView.findViewById(R.id.product_colors)

    fun bind(product: Record) {
        val colorList = product.variantsColor.map { it.colorHex }
        val colorAdapter = ColorAdapter(colorList)
        productColorsRecyclerView.also {
            it.adapter = colorAdapter
            it.layoutManager = LinearLayoutManager(context)
        }


        Picasso.with(context).load(product.lgImage).into(productImageView)
        productNameTextView.text = product.productDisplayName
        product.also {
            Log.d("PromoPrice", it.promoPrice.toString())
            productPriceWithoutDiscountTextView.text = it.listPrice.formatCurrency()
            productPriceWithDiscountTextView.text = it.promoPrice.formatCurrency()
            if (it.promoPrice != 0.00){
                productPriceWithDiscountTextView.setTextColor(context.getColor(R.color.RED))
                productPriceWithoutDiscountTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                productPriceWithDiscountTextView.visibility = View.VISIBLE
            }
        }
    }
}