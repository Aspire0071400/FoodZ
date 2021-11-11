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

class MyCartFragment : Fragment() {
    lateinit var fragmentMycart : FragmentMycartBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MyCartDataAdapter.ViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        fragmentMycart = FragmentMycartBinding.inflate(inflater)
        layoutManager =LinearLayoutManager(context)
        fragmentMycart.myCartDataViewcycle.layoutManager = layoutManager

        adapter = MyCartDataAdapter()
        fragmentMycart.myCartDataViewcycle.adapter = adapter
        return fragmentMycart.root
    }
}