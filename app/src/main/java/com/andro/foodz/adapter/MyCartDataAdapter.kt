package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyCartDataAdapter:RecyclerView.Adapter<MyCartDataAdapter.ViewHolder>() {
     public val productname1= arrayOf("")
     public val price1= arrayOf("")
     public val category1= arrayOf("")
     public val explanation1= arrayOf("")
     public val pic1 = intArrayOf()



    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyCartDataAdapter.ViewHolder {
        val v:View=LayoutInflater.from(parent.context).inflate(R.layout.cart_data_view,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return productname1.size
    }

    override fun onBindViewHolder(holder:MyCartDataAdapter.ViewHolder, position: Int) {
        holder.itemProductName.text = productname1[position]
        holder.itemPrice.text = price1[position]
        holder.itemCategory.text = category1[position]
        holder.itemExplain.text = explanation1[position]
        holder.itemImage.setImageResource(pic1[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemProductName: TextView
        var itemPrice: TextView
        var itemCategory: TextView
        var itemExplain: TextView
        var itemRemove: FloatingActionButton

        init{
            itemImage=itemView.findViewById(R.id.image2)
            itemProductName=itemView.findViewById(R.id.ProductName2)
            itemPrice=itemView.findViewById(R.id.Price2)
            itemCategory=itemView.findViewById(R.id.Category2)
            itemExplain = itemView.findViewById(R.id.explain2)
            itemRemove=itemView.findViewById(R.id.remove)

        }
    }
}