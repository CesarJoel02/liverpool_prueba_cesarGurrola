package com.cesargurrola.liverpool_shopapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesargurrola.liverpool_shopapp.model.Record
import com.cesargurrola.liverpool_shopapp.model.response
import com.cesargurrola.liverpool_shopapp.repository.ProductRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {
    private val _productList = MutableLiveData<MutableList<Record>>()
    private var productRepository: ProductRepository = ProductRepository()
    val products: LiveData<MutableList<Record>>
        get() = _productList

    var page = 1

    fun searchProducts(query: String) {
        viewModelScope.launch {
            productRepository.searchProducts(query, page).enqueue(object : Callback<response>{
                override fun onResponse(call: Call<response>, response: Response<response>) {
                    _productList.value = response.body()?.plpResults?.records
                    Log.d("repoCall", response.body()?.plpResults?.records.toString())
                    page += 1
                }

                override fun onFailure(call: Call<response>, t: Throwable) {

                }
            })
        }
    }

    fun nextPage(query: String){
        viewModelScope.launch {
            productRepository.searchProducts(query, page).enqueue(object : Callback<response>{
                override fun onResponse(call: Call<response>, response: Response<response>) {
                    val products = response.body()?.plpResults?.records
                    if (!products.isNullOrEmpty()) {
                        _productList.value!!.addAll(products)
                        page += 1
                    }
                }

                override fun onFailure(call: Call<response>, t: Throwable) {

                }
            })
        }
    }
}
