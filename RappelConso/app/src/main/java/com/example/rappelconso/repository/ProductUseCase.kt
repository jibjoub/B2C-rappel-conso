package com.example.rappelconso.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rappelconso.view.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Call
import retrofit2.Callback
import retrofit2.Response

class ProductUseCase(private val productService: ProductService) {
    val mLiveData = MutableLiveData<Data<List<Product>>>()
    suspend fun getProducts() {
        val products = productService.getProduct()
        products?.enqueue(object : Callback<List<Product>>{
            override fun onResponse(
                call: retrofit2.Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                response.body()?.let {
                    mLiveData.postValue(Data.success(it, ""))
                }?.let { mLiveData.postValue(Data.error(null, "body is null")) }

            }

            override fun onFailure(call: retrofit2.Call<List<Product>>, t: Throwable) {
                mLiveData.postValue(Data.error(null, "an error has occurred"))
            }
        })

    }

//    suspend fun getAll(): String {
//        return productService.getAll()
//    }


}