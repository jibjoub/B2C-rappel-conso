package com.example.rappelconso.view.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rappelconso.repository.Data
import com.example.rappelconso.repository.ProductUseCase
import com.example.rappelconso.view.model.ProductList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListProductVm(private val productUseCase: ProductUseCase): ViewModel() {
    val productListLiveData : MutableLiveData<Data<ProductList>> = MutableLiveData()

    fun getProducts() {
        viewModelScope.launch {
            productUseCase.getProducts(productListLiveData)
        }
    }

//    fun getAll() {
//        viewModelScope.launch {
//            mLiveData.value = productUseCase.getAll()
//        }
//    }
}