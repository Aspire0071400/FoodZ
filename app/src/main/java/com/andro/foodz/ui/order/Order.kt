package com.andro.foodz.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private lateinit var payment : OrderSummaryBinding
    var orderArrayList = arrayListOf<OrderData>()

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        payment = OrderSummaryBinding.inflate(inflater)
        orderfetch()
        return payment.root
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
                payment.order.layoutManager = LinearLayoutManager(context)
                payment.order.adapter= OrderAdapter(orderArrayList)
            },{
                if (it.networkResponse.statusCode == 404){
                    orderfetch()
                }
            })
        request.add(stringRequest)
    }
}