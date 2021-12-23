package com.example.rappelconso.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rappelconso.databinding.ActivityMainBinding
import com.example.rappelconso.view.adapter.ListProductAdapter
import com.example.rappelconso.view.model.Product
import com.example.rappelconso.view.view_model.ListProductVm
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener,
    ListProductAdapter.RecyclerViewClickListener {
    val vm: ListProductVm by viewModel()
    private lateinit var binding: ActivityMainBinding

//    private val binding by viewBinding(::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val rv = binding.recycleVewProducts
        binding.lifecycleOwner = this
        binding.vm = vm

        setContentView(binding.root)



        vm.getProducts()

        vm.productListLiveData.observe(this, Observer {
            val adapter = it.data?.let { it1 -> ListProductAdapter(
                it1.products,
                context = baseContext,
                listener = this
            ) }
            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(this)
        })

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val clickedItem = vm.productListLiveData.value?.data?.products?.get(position)
        val intent = Intent(applicationContext,ProductActivity::class.java).apply {
            if (clickedItem != null) {
                putExtra("product_name", clickedItem.referenceName)
            }
        }
    }

    override fun onClick(position: Int) {
        val clickedItem = vm.productListLiveData.value?.data?.products?.get(position)
        val intent = Intent(applicationContext,ProductActivity::class.java).apply {
            if (clickedItem != null) {
                putExtra("product_name", clickedItem.referenceName)
                putExtra("recall_reason", clickedItem.recallReason)
                putExtra("date", clickedItem.date)
                putExtra("danger", clickedItem.risks)
            }
        }
        startActivity(intent)
    }

}
