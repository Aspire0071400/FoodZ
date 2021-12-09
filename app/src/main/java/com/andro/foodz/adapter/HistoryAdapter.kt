package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.andro.foodz.databinding.OrederRecViewBinding
import com.andro.foodz.model.HistoryData
import com.bumptech.glide.Glide

class HistoryAdapter(val orderrecList:ArrayList<HistoryData>):RecyclerView.Adapter<HistoryAdapter.ViewHolder4>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder4 {
        val adapter = OrederRecViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder4(adapter.root)
    }

    override fun onBindViewHolder(holder: ViewHolder4, position: Int) {
        holder.productName.text =orderrecList[position].toString()
        holder.price.text       =orderrecList[position].toString()
        Glide.with(holder.image).load(orderrecList[position].imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return orderrecList.size
    }

    class ViewHolder4(itemView: View):RecyclerView.ViewHolder(itemView) {
        var productName:TextView = itemView.findViewById(R.id.ProductName4)
        var price      :TextView = itemView.findViewById(R.id.Price4)
        var image   :ImageView= itemView.findViewById(R.id.image4)
    }
}