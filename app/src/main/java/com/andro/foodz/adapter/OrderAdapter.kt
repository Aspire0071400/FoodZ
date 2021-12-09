package com.andro.foodz.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.R
import com.andro.foodz.databinding.OrderViewBinding
import com.andro.foodz.model.OrderData
import com.andro.foodz.ui.order.Order
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class OrderAdapter(val orderList:ArrayList<OrderData>):RecyclerView.Adapter<OrderAdapter.ViewHolder5>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderAdapter.ViewHolder5 {
        val adapter = OrderViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder5(adapter.root)
    }

    override fun onBindViewHolder(holder: OrderAdapter.ViewHolder5, position: Int) {
        holder.ProductName.text = orderList[position].productName
        holder.Price.text       = orderList[position].price
        Glide.with(holder.ImageUrl).load(orderList[position].imageUrl).into(holder.ImageUrl)
        holder.Img.text         = orderList[position].imageUrl
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class ViewHolder5(itemView: View):RecyclerView.ViewHolder(itemView) {
        var ProductName:TextView = itemView.findViewById(R.id.Order_Product)
        var Price      :TextView = itemView.findViewById(R.id.Order_Price)
        var ImageUrl   :ImageView= itemView.findViewById(R.id.Order_image)
        var Img        :TextView = itemView.findViewById(R.id.Url2)

        init {
            itemView.setOnClickListener {
                var pn = ProductName.text.toString()
                var pr = Price.text.toString()
                var img= Img.text.toString()
                    send_history(pn,pr,img)
            }
        }

        private fun send_history(productName:String ,price:String,imageUrl:String) {
            val requestQueue = Volley.newRequestQueue(itemView.context) //url
            val stringRequest=object : StringRequest(
                Request.Method.POST,"https://foodz-android.000webhostapp.com/send_history/send_history.php", Response.Listener{
                    Log.d("Response", it.toString())
                    Toast.makeText(itemView.context, "confirmed", Toast.LENGTH_SHORT).show() },
                Response.ErrorListener {  Log.d("Server", it.toString())
                    Toast.makeText(itemView.context, "internal error", Toast.LENGTH_SHORT).show()
                }){

                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["productName"] = productName
                    params["price"] = price
                    params["imageUrl"] = imageUrl
                    return params
                }
            }
            requestQueue.add(stringRequest)
        }
    }
}