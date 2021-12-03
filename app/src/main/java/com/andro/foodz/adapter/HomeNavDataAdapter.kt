package com.andro.foodz.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.MainPage
import com.andro.foodz.R
import com.andro.foodz.databinding.HomeNavDataViewBinding
import com.andro.foodz.model.HomeData
import com.andro.foodz.ui.home.HomeFragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import org.json.JSONArray

class HomeNavDataAdapter(val dataList:ArrayList<HomeData>):RecyclerView.Adapter<HomeNavDataAdapter.ViewHolder>() {


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
        holder.im.text = dataList[position].imageUrl

    }

    override fun getItemCount(): Int {
        return dataList.size
    }



   class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       val sentdata = "https://foodz-android.000webhostapp.com/send_data/send_data.php"

       var ProductName:TextView =itemView.findViewById(R.id.ProductName)
       var Price :TextView      =itemView.findViewById(R.id.Price)
       var Category:TextView    = itemView.findViewById(R.id.Category)
       var Explanation:TextView =itemView.findViewById(R.id.Explanation)
       var imageUrl:ImageView      =itemView.findViewById(R.id.image)
       var add :FloatingActionButton = itemView.findViewById(R.id.add)
       var im:TextView=itemView.findViewById(R.id.imurl)

        init {


            add.setOnClickListener {
                var pn=ProductName.text.toString()
                var pr=Price.text.toString()
                var ex=Explanation.text.toString()
                var ct=Category.text.toString()
                var img=im.text.toString()

                if (pn.trim().isNotEmpty()&& pr.trim().isNotEmpty() && ex.trim().isNotEmpty() && ct.trim().isNotEmpty()){
                sendData(pn,pr,ex,ct,img)
                }
                else{
                    Toast.makeText(add.context, "empty", Toast.LENGTH_SHORT).show()
                }
            }
        }

       fun sendData(productName:String,price:String,explanation:String,category:String,imageUrl:String){
           val requestQueue = Volley.newRequestQueue(add.context) //url
           val stringRequest=object : StringRequest(Request.Method.POST,sentdata, Response.Listener{
               Log.d("Response", it.toString())
               Toast.makeText(add.context, "submit successuful", Toast.LENGTH_SHORT).show() },
               Response.ErrorListener {  Log.d("Server", it.toString())
                   Toast.makeText(add.context, "internal error", Toast.LENGTH_SHORT).show()
               }){

               override fun getParams(): Map<String, String> {
               val params: MutableMap<String, String> = HashMap()
               params["productName"] = productName
               params["price"] = price
               params["explanation"] = explanation
               params["category"] = category
               params["imageUrl"] = imageUrl
               return params
           }
           }
           requestQueue.add(stringRequest)

       }
   }

}