package com.example.rappelconso.view.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rappelconso.repository.ProductUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListProductVm(val productUseCase: ProductUseCase): ViewModel() {
    fun getProducts(retailer: String) {
        viewModelScope.launch {
            productUseCase.getProducts(retailer)
        }
    }
}