package com.andro.foodz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityForgetPasswordBinding

class ForgotPassword : Fragment() {
    lateinit var forgotPassword:ActivityForgetPasswordBinding
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        forgotPassword = ActivityForgetPasswordBinding.inflate(inflater)

        return forgotPassword.root
    }
}
