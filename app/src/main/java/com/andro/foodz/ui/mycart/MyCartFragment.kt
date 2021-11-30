package com.andro.foodz.ui.mycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.adapter.HomeNavDataAdapter
import com.andro.foodz.adapter.MyCartDataAdapter
import com.andro.foodz.databinding.FragmentMycartBinding
import com.andro.foodz.model.CartData
import com.andro.foodz.model.HomeData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MyCartFragment : Fragment() {
    private  lateinit var myCartFragment: FragmentMycartBinding
    var cartArrayList = arrayListOf<CartData>()

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        myCartFragment = FragmentMycartBinding.inflate(inflater)
        fetchData2()
        return myCartFragment.root
    }

    private fun fetchData2() {
        val request: RequestQueue = Volley.newRequestQueue(context) //url
        val stringRequest : StringRequest = StringRequest(Request.Method.GET,
            "https://foodz-android.000webhostapp.com/fetch_data2/fetch_data2.php",{
            val cartArray : JSONArray = JSONArray(it)
            for(i in 0 until cartArray.length()){
                val cartdata : JSONObject = cartArray.get(i) as JSONObject
                val CartDataDetails = CartData(cartdata.getString("productName").toString(),
                    (cartdata.getString("price").toString()),
                    (cartdata.getString("category").toString()),
                    (cartdata.getString("explanation").toString()),
                    (cartdata.getString("imageUrl").toString()))
                cartArrayList.add(CartDataDetails)
            }
            //for log option
            myCartFragment.myCartDataViewcycle.layoutManager =LinearLayoutManager(context)
            myCartFragment.myCartDataViewcycle.adapter= MyCartDataAdapter(cartArrayList)
        },{
            if (it.networkResponse.statusCode == 404){
                fetchData2()
            }
        })
        request.add(stringRequest)

    }
}