package com.example.rappelconso

import com.example.rappelconso.repository.ProductService
import com.example.rappelconso.repository.ProductUseCase
import com.example.rappelconso.view.view_model.ListProductVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class Module {
    val applicationModule = module {

        single{ Retrofit.Builder()
            .baseUrl("https://rappelconso.herokuapp.com/api/v1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        }

        single {
            get<Retrofit>().create(ProductService::class.java)
        }

        single {
            ProductUseCase(get())
        }

        single {
            ListProductVm(get())
        }
    }
}