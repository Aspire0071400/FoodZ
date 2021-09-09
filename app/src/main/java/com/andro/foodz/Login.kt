package com.andro.foodz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityLoginBinding


class Login : Fragment() {
    lateinit var  Login : ActivityLoginBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        Login = ActivityLoginBinding.inflate(inflater)
        return Login.root
    }

}
