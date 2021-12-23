package com.example.rappelconso.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rappelconso.R
import com.example.rappelconso.view.model.Product

class ListProductAdapter(
    private val mList: List<Product>,
    val context: Context,
    var listener: RecyclerViewClickListener
) : RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design com.example.rappelconso.view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_product_content_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a com.example.rappelconso.view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = mList[position]

        val url = product.imageUrl

        // sets the image to the imageview from our itemHolder class
        Glide.with(context)
            .load(url)
            .into(holder.imageView)

        // sets the text to the textview from our itemHolder class
        holder.referenceName.text = product.referenceName

        holder.referenceId.text = product.referenceId

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val referenceName: TextView = itemView.findViewById(R.id.referenceName)
        val referenceId: TextView = itemView.findViewById(R.id.referenceId)

        override fun onClick(v: View?) {
            listener.onClick(adapterPosition)
        }
    }

    public interface RecyclerViewClickListener {
        fun onClick(position: Int)
    }
}