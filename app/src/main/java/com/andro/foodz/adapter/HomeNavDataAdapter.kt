package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.databinding.FragmentHomeBinding
import com.andro.foodz.databinding.HomeNavDataViewBinding
import com.andro.foodz.model.HomeNavDataModel
import com.bumptech.glide.Glide

class HomeNavDataAdapter (private val data:ArrayList<HomeNavDataModel>): RecyclerView.Adapter<HomeNavDataAdapter.Data>() {
    class Data(v: View) : RecyclerView.ViewHolder(v) {
        var HomeNavDataAdapter = HomeNavDataViewBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNavDataAdapter.Data {
        val adapter = HomeNavDataViewBinding.inflate(LayoutInflater.from(parent.context))
        return Data(adapter.root)
    }

    override fun onBindViewHolder(holder: HomeNavDataAdapter.Data, position: Int) {
        holder.HomeNavDataAdapter.ProductName.text=data[position].ProductName
        holder.HomeNavDataAdapter.Price.text = data[position].Price
        holder.HomeNavDataAdapter.Description.text = data[position].Description
        holder.HomeNavDataAdapter.Category.text = data[position].Category
        Glide.with(holder.HomeNavDataAdapter.root).load(data[position].Image)
            .into(holder.HomeNavDataAdapter.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}