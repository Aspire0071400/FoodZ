package com.andro.foodz.ui.category.catfrag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andro.foodz.adapter.CatNavDataAdapter
import com.andro.foodz.databinding.ActivityFastFoodBinding
import com.andro.foodz.model.CatNavDataModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class FastFood : Fragment() {
    lateinit var fragmentFastFood : ActivityFastFoodBinding
    private var data = arrayListOf<CatNavDataModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentFastFood = ActivityFastFoodBinding.inflate(inflater)
        fetchData()
        return fragmentFastFood.root
    }

    private fun fetchData() {
        val request: RequestQueue = Volley.newRequestQueue(context)  //url

        val stringRequest = StringRequest(
            Request.Method.GET,"https://foodzproject.000webhostapp.com/fetch_data.php" , {
                val catnavdataArray = JSONArray(it)
                for (i in 0 until catnavdataArray.length()){
                    val catnavdata : JSONObject = catnavdataArray.get(i) as JSONObject
                    val catnavmodeldata = CatNavDataModel(catnavdata.getString("ProductName").toString()
                        ,(catnavdata.getString("Price").toString())
                        ,(catnavdata.getString("Description").toString())
                        ,(catnavdata.getString("Category").toString())
                        ,(catnavdata.getString("Image").toString()))
                    data.add(catnavmodeldata)
                }
                fragmentFastFood.cat3NavDataViewcycle.layoutManager = LinearLayoutManager(context)
                fragmentFastFood.cat3NavDataViewcycle.adapter = CatNavDataAdapter(data)

            },{
                //Log.d("Error",it.toString())
                if(it.networkResponse.statusCode == 404){
                    fetchData()
                }
            })
        request.add(stringRequest)
    }
}