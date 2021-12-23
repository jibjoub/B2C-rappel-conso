package com.example.rappelconso.view.model

import com.google.gson.annotations.SerializedName

data class ProductList (
    @SerializedName("results")
    var products: List<Product>
)