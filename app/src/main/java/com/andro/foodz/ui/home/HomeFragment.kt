package com.andro.foodz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.foodz.adapter.HomeNavDataAdapter
import com.andro.foodz.databinding.FragmentHomeBinding
import com.andro.foodz.model.HomeNavDataModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class HomeFragment : Fragment() {
    private lateinit var fragmenthome : FragmentHomeBinding
    private var data = arrayListOf<HomeNavDataModel>()

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        fragmenthome = FragmentHomeBinding.inflate(inflater)
        fetchData()
        return fragmenthome.root
    }

    private fun fetchData() {
        val request: RequestQueue= Volley.newRequestQueue(context)  //url

        val stringRequest = StringRequest(
            Request.Method.GET,"https://foodzproject.000webhostapp.com/fetch_data.php" , {
                val homenavdataArray =JSONArray(it)
                for (i in 0 until homenavdataArray.length()){
                    val homenavdata : JSONObject = homenavdataArray.get(i) as JSONObject
                    val homenavmodeldata = HomeNavDataModel(homenavdata.getString("ProductName").toString()
                        ,(homenavdata.getString("Price").toString())
                        ,(homenavdata.getString("Description").toString())
                        ,(homenavdata.getString("Category").toString())
                        ,(homenavdata.getString("Image").toString()))
                    data.add(homenavmodeldata)
                }
                fragmenthome.homeNavDataViewcycle.layoutManager = LinearLayoutManager(context)
                fragmenthome.homeNavDataViewcycle.adapter = HomeNavDataAdapter(data)

            },{
                //Log.d("Error",it.toString())
                if(it.networkResponse.statusCode == 404){
                   fetchData()
                }
            })
        request.add(stringRequest)
    }
}