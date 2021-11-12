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
    var productname = arrayOf("Shaahi-Paneer","Coke","Aloo-Tikki","Raj-Kachori")
    var price = arrayOf("140","90","120","100")
    var category = arrayOf("Main Course","Drink","Fast Food","Fast Food")
    var explanation = arrayOf("Per Plate","2L","Per Plate","Per Plate")
    var pic = intArrayOf(R.drawable.shahipaneer,R.drawable.coke,R.drawable.alootikki,R.drawable.rajkachori)


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyCartDataAdapter.ViewHolder {
        val v:View=LayoutInflater.from(parent.context).inflate(R.layout.cart_data_view,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return productname.size
    }

    override fun onBindViewHolder(holder:MyCartDataAdapter.ViewHolder, position: Int) {
        holder.itemProductName.text = productname[position]
        holder.itemPrice.text = price[position]
        holder.itemCategory.text = category[position]
        holder.itemExplain.text = explanation[position]
        holder.itemImage.setImageResource(pic[position])
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