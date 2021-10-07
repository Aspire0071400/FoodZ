package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.databinding.CatNavDataViewBinding
import com.andro.foodz.model.CatNavDataModel
import com.bumptech.glide.Glide

class CatNavDataAdapter (private val data:ArrayList<CatNavDataModel>): RecyclerView.Adapter<CatNavDataAdapter.Data>() {
    class Data(v: View) : RecyclerView.ViewHolder(v) {
        var CatNavDataAdapter = CatNavDataViewBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatNavDataAdapter.Data {
        val adapter = CatNavDataViewBinding.inflate(LayoutInflater.from(parent.context))
        return Data(adapter.root)
    }

    override fun onBindViewHolder(holder: CatNavDataAdapter.Data, position: Int) {
        holder.CatNavDataAdapter.ProductName.text=data[position].ProductName
        holder.CatNavDataAdapter.Price.text = data[position].Price
        holder.CatNavDataAdapter.Description.text = data[position].Description
        holder.CatNavDataAdapter.Category.text = data[position].Category
        Glide.with(holder.CatNavDataAdapter.Imageview).load(data[position].Image)
            .into(holder.CatNavDataAdapter.Imageview)
    }

    override fun getItemCount(): Int {
        return data.size
    }


}