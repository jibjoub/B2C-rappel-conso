package com.example.rappelconso.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rappelconso.R
import com.example.rappelconso.repository.ProductUseCase
import com.example.rappelconso.view.view_model.ListProductVm

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}