package com.andro.foodz.ui.home

import android.app.DownloadManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andro.foodz.R
import com.andro.foodz.databinding.FragmentHomeBinding
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class HomeFragment : Fragment() {

    private lateinit var fragmenthome : FragmentHomeBinding
    private var _binding: FragmentHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        fragmenthome = FragmentHomeBinding.inflate(inflater)
        fetchData()
        return fragmenthome.root
    }

    private fun fetchData() {
        val request: RequestQueue= Volley.newRequestQueue(context)  //url
        val stringRequest:StringRequest = StringRequest(
            Request.Method.GET,"https://foodzproject.000webhostapp.com/fetch_data.php",{
                val 
            }

        )
    }
}