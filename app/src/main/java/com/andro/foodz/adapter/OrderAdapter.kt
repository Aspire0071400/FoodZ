package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.andro.foodz.databinding.OrderSummaryBinding
import com.andro.foodz.databinding.OrderViewBinding
import com.andro.foodz.model.OrderData
import com.bumptech.glide.Glide

class OrderAdapter(val orderList:ArrayList<OrderData>):RecyclerView.Adapter<OrderAdapter.ViewHolder3>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder3 {
        val adapter= OrderViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder3(adapter.root)
    }

    override fun onBindViewHolder(holder: ViewHolder3, position: Int) {
        holder.orderProduct.text = orderList[position].productName
        holder.orderPrice.text   = orderList[position].price
        Glide.with(holder.orderImage).load(orderList[position].imageUrl).into(holder.orderImage)
    }

    override fun getItemCount(): Int {
       return orderList.size
    }

    class ViewHolder3(itemView: View):RecyclerView.ViewHolder(itemView) {
        var orderProduct :TextView =itemView.findViewById(R.id.Order_Product)
        var orderPrice   :TextView =itemView.findViewById(R.id.Order_Price)
        var orderImage   :ImageView =itemView.findViewById(R.id.Order_image)
        init {

        }

    }
}