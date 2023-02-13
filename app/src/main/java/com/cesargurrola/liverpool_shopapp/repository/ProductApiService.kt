package com.cesargurrola.liverpool_shopapp.repository

import com.cesargurrola.liverpool_shopapp.model.Product
import com.cesargurrola.liverpool_shopapp.model.response
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApiService {

    @GET("v3/plp?")
    fun searchProducts(
        @Query("search-string") query: String,
        @Query("page-number") page: Int,
    ): Call<response>

    /*@GET("v3/plp?")
    fun searchProducts1(
        @Query("search-string") query: String,
        @Query("page-number") page: Int,
        @Query(minSo)
    ): Call<response>

    @GET("v3/plp?")
    fun searchProducts2(
        @Query("search-string") query: String,
        @Query("page-number") page: Int,
    ): Call<response>*/

}

val BASE_URL = "https://shoppapp.liverpool.com.mx/appclienteservices/services/"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
