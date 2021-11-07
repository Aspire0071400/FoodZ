package com.andro.foodz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andro.foodz.adapter.HomeNavDataAdapter
import com.andro.foodz.databinding.FragmentHomeBinding
class HomeFragment : Fragment() {
    private lateinit var fragmenthome : FragmentHomeBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<HomeNavDataAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmenthome = FragmentHomeBinding.inflate(inflater)
        return fragmenthome.root
        layoutManager = LinearLayoutManager(context)
        fragmenthome.homeNavDataViewcycle.layoutManager =layoutManager

        adapter = HomeNavDataAdapter()
        fragmenthome.homeNavDataViewcycle.adapter = adapter

    }
}