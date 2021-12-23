package com.example.rappelconso.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rappelconso.view.model.Product
import com.example.rappelconso.view.model.ProductList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Call
import retrofit2.Callback
import retrofit2.Response

class ProductUseCase(private val productService: ProductService) {
    fun getProducts(mLiveData: MutableLiveData<Data<ProductList>>) {
        val products = productService.getProduct()
        products?.enqueue(object : Callback<ProductList>{
            override fun onResponse(
                call: retrofit2.Call<ProductList>,
                response: Response<ProductList>
            ) {
                response.body()?.let {
                    mLiveData.postValue(Data.success(it, ""))
                }

            }

            override fun onFailure(call: retrofit2.Call<ProductList>, t: Throwable) {
                mLiveData.postValue(Data.error(null, "an error has occurred"))
            }
        })

    }

//    suspend fun getAll(): String {
//        return productService.getAll()
//    }


}