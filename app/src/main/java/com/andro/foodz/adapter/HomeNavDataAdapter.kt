package com.andro.foodz.adapter

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.andro.foodz.databinding.HomeNavDataViewBinding
import com.andro.foodz.model.HomeData
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.lang.reflect.Array


class HomeNavDataAdapter(private val dataList:ArrayList<HomeData>):RecyclerView.Adapter<HomeNavDataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): HomeNavDataAdapter.ViewHolder {
        val adapter = HomeNavDataViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(adapter.root)
    }

    override fun onBindViewHolder(holder: HomeNavDataAdapter.ViewHolder, position: Int) {
        holder.HomeNavDataAdapter.ProductName.text = dataList[position].productName
        holder.HomeNavDataAdapter.Price.text =dataList[position].price
        holder.HomeNavDataAdapter.Category.text = dataList[position].category
        holder.HomeNavDataAdapter.Explanation.text = dataList[position].explanation
        Glide.with(holder.HomeNavDataAdapter.root).load(dataList[position].imageUrl).into(holder.HomeNavDataAdapter.image)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var HomeNavDataAdapter = HomeNavDataViewBinding.bind(itemView)
        var add :FloatingActionButton
        init {
            val position : Int = absoluteAdapterPosition
            add = itemView.findViewById(R.id.add)
            itemView.setOnClickListener {
               // Toast.makeText(itemView.context,"You clicked ${HomeNavDataAdapter.ProductName[position]}",Toast.LENGTH_SHORT).show()

            }
            add.setOnClickListener {  }
        }
    }

}






