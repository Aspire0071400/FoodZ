package com.andro.foodz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.foodz.adapter.HomeNavDataAdapter
import com.andro.foodz.databinding.FragmentHomeBinding
import com.andro.foodz.model.CartData
import com.andro.foodz.model.HomeData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class HomeFragment : Fragment() {
    private lateinit var homeFragment: FragmentHomeBinding
    var dataArrayList = arrayListOf<HomeData>()
    val sentdata = "https://foodz-android.000webhostapp.com/fetch_data/send_data.php"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeFragment = FragmentHomeBinding.inflate(inflater)
        fetchData()
        return homeFragment.root
    }

    fun fetchData() {
        val request: RequestQueue = Volley.newRequestQueue(context) //url
        val stringRequest : StringRequest = StringRequest(Request.Method.GET,
            "https://foodz-android.000webhostapp.com/fetch_data/fetch_data.php",{
            val dataArray : JSONArray = JSONArray(it)
            for(i in 0 until dataArray.length()){
                val homedata : JSONObject= dataArray.get(i) as JSONObject
                val HomeDataDetails = HomeData(homedata.getString("productName").toString(),
                    (homedata.getString("price").toString()),
                    (homedata.getString("category").toString()),
                    (homedata.getString("explanation").toString()),
                    (homedata.getString("imageUrl").toString()))
                dataArrayList.add(HomeDataDetails)
            }
             //for log option
            homeFragment.homeNavDataViewcycle.layoutManager =LinearLayoutManager(context)
            homeFragment.homeNavDataViewcycle.adapter= HomeNavDataAdapter(dataArrayList)
        },{
            if (it.networkResponse.statusCode == 404){
                fetchData()
            }
        })
        request.add(stringRequest)
    }

    fun sendData(){
    }



}