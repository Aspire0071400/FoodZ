package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.andro.foodz.databinding.OrderViewBinding
import com.andro.foodz.model.OrderData
import com.bumptech.glide.Glide

class OrderAdapter(val orderList:ArrayList<OrderData>):RecyclerView.Adapter<OrderAdapter.ViewHolder5>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderAdapter.ViewHolder5 {
        val adapter = OrderViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder5(adapter.root)
    }

    override fun onBindViewHolder(holder: OrderAdapter.ViewHolder5, position: Int) {
        holder.ProductName.text = orderList[position].productName
        holder.Price.text       = orderList[position].price
        Glide.with(holder.ImageUrl).load(orderList[position].imageUrl).into(holder.ImageUrl)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class ViewHolder5(itemView: View):RecyclerView.ViewHolder(itemView) {
        var ProductName:TextView = itemView.findViewById(R.id.Order_Product)
        var Price      :TextView = itemView.findViewById(R.id.Order_Price)
        var ImageUrl   :ImageView= itemView.findViewById(R.id.Order_image)

        init {

        }
    }
}