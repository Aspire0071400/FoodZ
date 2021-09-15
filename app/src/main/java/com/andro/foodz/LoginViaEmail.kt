package com.andro.foodz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityLoginViaEmailBinding

class LoginViaEmail : Fragment() {
    lateinit var loginViaEmail: ActivityLoginViaEmailBinding
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        loginViaEmail = ActivityLoginViaEmailBinding.inflate(inflater)


        return loginViaEmail.root
    }
}
