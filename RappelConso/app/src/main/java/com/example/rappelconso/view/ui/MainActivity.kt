package com.example.rappelconso.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rappelconso.R
import com.example.rappelconso.databinding.ActivityMainBinding
import com.example.rappelconso.extension.viewBinding
import com.example.rappelconso.repository.ProductUseCase
import com.example.rappelconso.view.view_model.ListProductVm
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val vm: ListProductVm by viewModel()
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = vm
        vm.getProducts()
        setContentView(R.layout.activity_main)
    }


}