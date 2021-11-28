package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.andro.foodz.databinding.HomeNavDataViewBinding
import com.andro.foodz.model.HomeData
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeNavDataAdapter(private val dataList:ArrayList<HomeData>):RecyclerView.Adapter<HomeNavDataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
        val adapter = HomeNavDataViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(adapter.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ProductName.text = dataList[position].productName
        holder.Price.text =dataList[position].price
        holder.Category.text = dataList[position].category
        holder.Explanation.text = dataList[position].explanation
        Glide.with(holder.imageUrl).load(dataList[position].imageUrl).into(holder.imageUrl)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

   class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       var ProductName:TextView =itemView.findViewById(R.id.ProductName)
       var Price :TextView      =itemView.findViewById(R.id.Price)
       var Category:TextView    = itemView.findViewById(R.id.Category)
       var Explanation:TextView =itemView.findViewById(R.id.Explanation)
       var imageUrl:ImageView      =itemView.findViewById(R.id.image)
       var add :FloatingActionButton = itemView.findViewById(R.id.add)

        init {
            add = itemView.findViewById(R.id.add)


            add.setOnClickListener {
                Toast.makeText(itemView.context, "you clicked ${ProductName.text.toString()}", Toast.LENGTH_SHORT).show()
            }

        }
    }

}






