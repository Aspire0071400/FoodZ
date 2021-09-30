package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.work.Data
import com.andro.foodz.databinding.FragmentHomeBinding
import com.andro.foodz.model.HomeNavDataModel
import com.bumptech.glide.Glide

class HomeNavDataAdapter (private val data:ArrayList<HomeNavDataModel>): RecyclerView.Adapter<HomeNavDataAdapter.Data>() {

    class Data(v: View) : RecyclerView.ViewHolder(v) {
        var HomeNavDataAdapter = FragmentHomeBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNavDataAdapter.Data {
        val adapter = FragmentHomeBinding.inflate(LayoutInflater.from(parent.context))
        return Data(adapter.root)
    }

    override fun onBindViewHolder(holder: FragmentHomeBinding.Data, position: Int) {
        holder.FragmentHomeBinding.HomeNavDataProductName.text = data[position].ProductName
        holder.FragmentHomeBinding.HomeNavDataPrice.text = data[position].Price
        holder.FragmentHomeBinding.HomeNavDataDescription.text = data[position].Description
        holder.FragmentHomeBinding.HomeNavDataCategory.text = data[position].Category
        Glide.with(holder.HomeNavDataAdapter.root).load(data[position].Image)
            .into(holder.HomeNavDataAdapter.HomeNavDataImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}