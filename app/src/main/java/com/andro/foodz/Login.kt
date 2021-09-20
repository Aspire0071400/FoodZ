package com.andro.foodz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityLoginBinding


class Login : Fragment() {
    lateinit var  login : ActivityLoginBinding


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        login = ActivityLoginBinding.inflate(inflater)
        login.loginLveTw.setOnClickListener {
            (activity as MainActivity).change(LoginViaEmail())
        }
        login.loginSignupTv.setOnClickListener{
            (activity as MainActivity).change(Registration())
        }

        login.submitBtn.setOnClickListener {
            activity?.startActivity(Intent(context,MainPage::class.java))
        }
        return login.root




    }

}






