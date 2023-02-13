package com.cesargurrola.liverpool_shopapp.repository

import com.cesargurrola.liverpool_shopapp.model.Product
import retrofit2.Call

class ProductRepository {

    val productApiService = retrofit.create(ProductApiService::class.java)


    fun searchProducts(query: String): Call<List<Product>> {
        return productApiService.searchProducts(query)
    }

}