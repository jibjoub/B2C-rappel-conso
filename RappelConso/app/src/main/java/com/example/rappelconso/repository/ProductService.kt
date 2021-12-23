package com.example.rappelconso.repository

import androidx.lifecycle.LiveData
import com.example.rappelconso.view.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ProductService {
    @GET("rappel_conso")
    fun getProduct(): Call<List<Product>>

//    @GET()
//    fun getAll(): String
}