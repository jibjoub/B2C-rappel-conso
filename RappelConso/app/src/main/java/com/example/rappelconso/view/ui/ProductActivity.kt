package com.example.rappelconso.view.ui

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rappelconso.databinding.ProductDetailsBinding
import com.example.rappelconso.view.adapter.ListProductAdapter

class ProductActivity: AppCompatActivity() {

    private lateinit var binding: ProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailsBinding.inflate(layoutInflater)
        val tv = binding.productName
        val recall_reason = binding.recallReason
        val date = binding.date
        val risk = binding.danger

        val message = intent.getStringExtra("product_name")
        val recall_message = intent.getStringExtra("recall_reason")
        val date_message = intent.getStringExtra("date")
        val risk_message = intent.getStringExtra("danger")

        tv.setText(message)
        recall_reason.setText("reason for the recall: " + recall_message)
        date.setText("date of recall: " + date_message)
        risk.setText("risks: " + risk_message)


        setContentView(binding.root)
    }
}