package com.andro.foodz.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    lateinit var fragmentprofile : FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        fragmentprofile = FragmentProfileBinding.inflate(inflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}