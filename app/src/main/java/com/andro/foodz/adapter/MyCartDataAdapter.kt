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
      val productname1= HomeNavDataAdapter().productname0
      val price1= HomeNavDataAdapter().price0
      val category1= HomeNavDataAdapter().category0
      val explanation1= HomeNavDataAdapter().explanation0
      //val pic1 = HomeNavDataAdapter().pic0


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyCartDataAdapter.ViewHolder {
        val v:View=LayoutInflater.from(parent.context).inflate(R.layout.cart_data_view,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        TODO()
    }

    override fun onBindViewHolder(holder:MyCartDataAdapter.ViewHolder, position: Int) {
        holder.itemProductName.text = productname1
        holder.itemPrice.text = price1
        holder.itemCategory.text = category1
        holder.itemExplain.text = explanation1
       // holder.itemImage.setImageResource(pic1)
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