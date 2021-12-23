package com.example.rappelconso.view.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rappelconso.repository.ProductUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListProductVm(private val productUseCase: ProductUseCase): ViewModel() {
    val mLiveData = MutableLiveData<String>()

    fun getProducts() {
        viewModelScope.launch {
            productUseCase.getProducts()
            mLiveData.value = productUseCase.mLiveData.value.toString()
        }
    }

//    fun getAll() {
//        viewModelScope.launch {
//            mLiveData.value = productUseCase.getAll()
//        }
//    }
}