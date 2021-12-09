package com.andro.foodz.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.foodz.adapter.OrderAdapter
import com.andro.foodz.databinding.OrderSummaryBinding
import com.andro.foodz.model.OrderData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Order:Fragment() {
    private lateinit var order : OrderSummaryBinding
    var orderArrayList = arrayListOf<OrderData>()

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {

        order = OrderSummaryBinding.inflate(inflater)
        order.textView4.setOnClickListener {
            order.textView6.isVisible=false
            order.orderz.isVisible=false
            order.imageview0.isVisible=true
            order.textView4.isVisible=false
            Toast.makeText(order.textView4.context, "Your Order Has Been Placed", Toast.LENGTH_SHORT).show()
            Toast.makeText(order.textView4.context, "You can pay prior,using UPI", Toast.LENGTH_LONG).show()
        }
        orderfetch()
        return order.root
    }


    private fun orderfetch() {
        val request: RequestQueue = Volley.newRequestQueue(context) //url
        val stringRequest : StringRequest = StringRequest(
            Request.Method.GET,
            "https://foodz-android.000webhostapp.com/fetch_order/fetch_order.php",{
                val orderArray : JSONArray = JSONArray(it)
                for(i in 0 until orderArray.length()){
                    val orderdata : JSONObject = orderArray.get(i) as JSONObject
                    val orderDetails = OrderData(orderdata.getString("productName").toString(),
                        (orderdata.getString("price").toString()),
                        (orderdata.getString("imageUrl").toString()))
                    orderArrayList.add(orderDetails)
                }
                 //for log option
                order.orderz.layoutManager = LinearLayoutManager(context)
                order.orderz.adapter= OrderAdapter(orderArrayList)
            },{
                if (it.networkResponse.statusCode == 404){
                    orderfetch()
                }
            })
        request.add(stringRequest)
    }
}