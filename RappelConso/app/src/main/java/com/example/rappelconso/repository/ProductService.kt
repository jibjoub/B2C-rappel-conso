package com.example.rappelconso.repository

import androidx.lifecycle.LiveData
import com.example.rappelconso.view.model.Product
import com.example.rappelconso.view.model.ProductList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ProductService {
    @GET("rappel_conso")
    fun getProduct(): Call<ProductList>

//    @GET()
//    fun getAll(): String
}