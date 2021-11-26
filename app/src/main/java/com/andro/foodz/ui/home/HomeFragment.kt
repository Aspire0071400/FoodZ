package com.andro.foodz.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.adapter.HomeNavDataAdapter
import com.andro.foodz.databinding.FragmentHomeBinding
import com.andro.foodz.model.HomeData
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {
    private lateinit var homeFragment : FragmentHomeBinding
    private var dataArrayList = arrayListOf<HomeData>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeFragment = FragmentHomeBinding.inflate(inflater)
        fetchData()
        return homeFragment.root
    }

    private fun fetchData() {
        db.collection("homeDatas")
            .get().addOnSuccessListener {
                for (document in it){
                    val homeData = HomeData(
                        document.getString("productName").toString(),
                        document.getString("price").toString(),
                        document.getString("category").toString(),
                        document.getString("explanation").toString(),
                        document.getString("imageUrl").toString()
                    )
                        dataArrayList.add(homeData)
                        Log.d("TAG","Document: $document")
                    }

            }.addOnFailureListener {
                Toast.makeText(requireContext(), "Unable to fetch data!!", Toast.LENGTH_SHORT).show()
            }
        homeFragment.homeNavDataViewcycle.layoutManager = LinearLayoutManager(context)
        homeFragment.homeNavDataViewcycle.adapter = HomeNavDataAdapter(dataArrayList)
    }
}