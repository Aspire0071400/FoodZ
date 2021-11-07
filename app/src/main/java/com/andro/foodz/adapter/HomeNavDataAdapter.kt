package com.andro.foodz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.andro.foodz.model.HomeNavDataModel
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeNavDataAdapter:RecyclerView.Adapter<HomeNavDataAdapter.ViewHolder>() {

    private var productname = arrayOf("shaahi paneer","coke")
    private var price = arrayOf("240","90")
    private var category = arrayOf("main-course","drink")
    //private var images = intArrayOf()


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): HomeNavDataAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.home_nav_data_view,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return productname.size
    }

    override fun onBindViewHolder(holder: HomeNavDataAdapter.ViewHolder, position: Int) {
        holder.itemProductName.text = productname[position]
        holder.itemPrice.text = price[position]
        holder.itemCategory.text = category[position]

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemProductName: TextView
        var itemPrice: TextView
        var itemCategory: TextView
        var itemRemove: FloatingActionButton
        var itemAdd: FloatingActionButton
        var itemQuantity: TextView

        init {
            itemImage=itemView.findViewById(R.id.image)
            itemProductName=itemView.findViewById(R.id.ProductName)
            itemPrice=itemView.findViewById(R.id.Price)
            itemCategory=itemView.findViewById(R.id.Category)
            itemRemove=itemView.findViewById(R.id.remove)
            itemQuantity=itemView.findViewById(R.id.qty)
            itemAdd=itemView.findViewById(R.id.add)
        }
    }
}





