package com.andro.foodz.ui.mycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.FragmentMycartBinding

class MyCartFragment : Fragment() {
    lateinit var fragmentMycart : FragmentMycartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMycart = FragmentMycartBinding.inflate(inflater)
        return fragmentMycart.root
    }
}