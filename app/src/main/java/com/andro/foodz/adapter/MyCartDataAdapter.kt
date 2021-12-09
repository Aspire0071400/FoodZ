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
import com.andro.foodz.databinding.CartDataViewBinding
import com.andro.foodz.model.CartData
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyCartDataAdapter(val cartList: ArrayList<CartData>): RecyclerView.Adapter<MyCartDataAdapter.ViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder2 {
        val adapter = CartDataViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder2(adapter.root)
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.ProductName2.text = cartList[position].productName
        holder.Price2.text =cartList[position].price
        holder.Category2.text = cartList[position].category
        holder.Explanation2.text = cartList[position].explanation
        Glide.with(holder.image2).load(cartList[position].imageUrl).into(holder.image2)

    }

    override fun getItemCount(): Int {
        return cartList.size
    }


    class ViewHolder2(itemView : View):RecyclerView.ViewHolder(itemView){
        var ProductName2:TextView =itemView.findViewById(R.id.ProductName2)
        var Price2 :TextView      =itemView.findViewById(R.id.Price2)
        var Category2:TextView    = itemView.findViewById(R.id.Category2)
        var Explanation2:TextView =itemView.findViewById(R.id.Explanation2)
        var image2:ImageView      =itemView.findViewById(R.id.image2)
        var remove :FloatingActionButton = itemView.findViewById(R.id.remove)

        init {

            remove.setOnClickListener {
                var pn=ProductName2.text.toString()
                if (pn.trim().isNotEmpty()){
                deleteData(pn)
                }else{
                    Toast.makeText(remove.context, "empty", Toast.LENGTH_SHORT).show()
                }

            }
        }

        private fun deleteData(pn:String) {
            val requestQueue = Volley.newRequestQueue(remove.context) //url
            val stringRequest=object : StringRequest(
                Method.POST,"https://foodz-android.000webhostapp.com/del_data/del_data.php", Response.Listener{
                Log.d("Response", it.toString())
                Toast.makeText(remove.context, "deleted", Toast.LENGTH_SHORT).show() },
                Response.ErrorListener {  Log.d("Server", it.toString())
                    Toast.makeText(remove.context, "internal error", Toast.LENGTH_SHORT).show()
                }){

                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["pn"] = pn
                    return params
                }
            }
            requestQueue.add(stringRequest)

        }

    }

}