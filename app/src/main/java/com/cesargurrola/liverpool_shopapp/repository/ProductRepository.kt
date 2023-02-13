package com.cesargurrola.liverpool_shopapp.repository

import com.cesargurrola.liverpool_shopapp.model.response
import retrofit2.Call

class ProductRepository {

    val productApiService = retrofit.create(ProductApiService::class.java)


    fun searchProducts(query: String, page : Int): Call<response> {
        return productApiService.searchProducts(query,page)
    }

}