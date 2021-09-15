package com.andro.foodz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityRegistrationBinding

class Registration :Fragment() {
    lateinit var Registration: ActivityRegistrationBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        Registration = ActivityRegistrationBinding.inflate(inflater)

        Registration.regSignupEt.setOnClickListener{
            (activity as MainActivity).change(Login())
        }

        return Registration.root
    }
}