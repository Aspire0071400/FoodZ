package com.andro.foodz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityLoginFragmentBinding



class Login : Fragment() {
    lateinit var  login : ActivityLoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        login = ActivityLoginFragmentBinding.inflate(inflater)
        return login.root
    }

}
