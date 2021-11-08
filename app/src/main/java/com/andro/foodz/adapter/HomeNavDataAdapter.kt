package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeNavDataAdapter:RecyclerView.Adapter<HomeNavDataAdapter.ViewHolder>() {

    private val productname = arrayOf("shaahi-paneer","coke","Aloo-Tikki")
    private val price = arrayOf("240","90","120")
    private val category = arrayOf("main-course","drink","fast-food")
    private var explanation = arrayOf("per plate","2L","per plate")
    private var pic = intArrayOf(R.drawable.shahipaneer,R.drawable.coke,R.drawable.alootikki)



    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): HomeNavDataAdapter.ViewHolder {
        val v:View=LayoutInflater.from(parent.context).inflate(R.layout.home_nav_data_view,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return productname.size
    }

    override fun onBindViewHolder(holder: HomeNavDataAdapter.ViewHolder, position: Int) {
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
        var itemExplain:TextView
        var itemAdd: FloatingActionButton


        init {
            itemImage=itemView.findViewById(R.id.image)
            itemProductName=itemView.findViewById(R.id.ProductName)
            itemPrice=itemView.findViewById(R.id.Price)
            itemCategory=itemView.findViewById(R.id.Category)
            itemExplain = itemView.findViewById(R.id.explain)
            itemAdd=itemView.findViewById(R.id.add)


        }
    }
}





