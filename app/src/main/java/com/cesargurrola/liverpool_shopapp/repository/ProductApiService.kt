package com.cesargurrola.liverpool_shopapp.repository

import com.cesargurrola.liverpool_shopapp.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {

    @GET
    fun searchProducts(
        @Query("query") query: String
    ): Call<List<Product>>

}

val BASE_URL = " https://shoppapp.liverpool.com.mx/appclienteservices/services/v3/plp?search-string=%7B%7Btermino-de-busqueda%7D%7D&page-number=1"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
