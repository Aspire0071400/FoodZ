package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.model.HomeNavDataModel
import com.bumptech.glide.Glide

class HomeNavDataAdapter (private val data:ArrayList<HomeNavDataModel>): RecyclerView.Adapter<HomeNavDataAdapter.Data>() {

    class Data(v: View) : RecyclerView.ViewHolder(v) {
        var HomeNavDataAdapter = HomeNavDataBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNavDataAdapter.Data {
        val adapter = HomeNavDataBinding.inflate(LayoutInflater.from(parent.context))
        return Data(adapter.root)
    }

    override fun onBindViewHolder(holder: HomeNavDataBinding.Data, position: Int) {
        holder.HomeNavDataBinding.HomeNavDataProductName.text = data[position].ProductName
        holder.HomeNavDataBinding.HomeNavDataPrice.text = data[position].Price
        holder.HomeNavDataBinding.HomeNavDataDescription.text = data[position].Description
        holder.HomeNavDataBinding.HomeNavDataCategory.text = data[position].Category
        Glide.with(holder.HomeNavDataAdapter.root).load(data[position].Image)
            .into(holder.HomeNavDataAdapter.HomeNavDataImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}