package com.andro.foodz.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.foodz.adapter.HistoryAdapter
import com.andro.foodz.databinding.FragmentOrderRecordBinding
import com.andro.foodz.model.HistoryData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class History : Fragment() {
    private lateinit var orderRecord : FragmentOrderRecordBinding
    var orederrecArrayList = arrayListOf<HistoryData>()

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        orderRecord = FragmentOrderRecordBinding.inflate(inflater)
        fetchData()
        return orderRecord.root
    }

    private fun fetchData() {
        val request: RequestQueue = Volley.newRequestQueue(context) //url
        val stringRequest : StringRequest = StringRequest(Request.Method.GET,
            "https://foodz-android.000webhostapp.com/fetch_history/fetch_history.php",{
                val cartArray : JSONArray = JSONArray(it)
                for(i in 0 until cartArray.length()){
                    val orderrecdata : JSONObject = cartArray.get(i) as JSONObject
                    val CartDataDetails = HistoryData(orderrecdata.getString("productName").toString(),
                        (orderrecdata.getString("price").toString()),
                        (orderrecdata.getString("category").toString()))
                    orederrecArrayList.add(CartDataDetails)
                }
                //for log option
                orderRecord.orderRecordview.layoutManager =LinearLayoutManager(context)
                orderRecord.orderRecordview.adapter= HistoryAdapter(orederrecArrayList)
            },{
                if (it.networkResponse.statusCode == 404){
                    fetchData()
                }
            })
        request.add(stringRequest)
    }
}