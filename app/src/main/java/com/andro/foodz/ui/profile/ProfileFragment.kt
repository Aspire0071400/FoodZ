package com.andro.foodz.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar


class ProfileFragment : Fragment() {
    lateinit var fragmentprofile : FragmentProfileBinding

    var name: String? =null
    var email: String? =null
    var number: String? =null
    var address: String? =null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        fragmentprofile = FragmentProfileBinding.inflate(inflater)



        fragmentprofile.profileSave.setOnClickListener {
            name   = fragmentprofile.profileName.text.toString()
            email  =fragmentprofile.profileEmail.text.toString()
            number =fragmentprofile.profileNumber.text.toString()
            address= fragmentprofile.profileAddress.text.toString()
            fragmentprofile.profileEdit.isVisible=true
            fragmentprofile.profileSave.isVisible=false
            Snackbar.make(fragmentprofile.root,"Your Profile has been saved",Snackbar.LENGTH_LONG).show()



        }

        fragmentprofile.profileEdit.setOnClickListener {
            fragmentprofile.profileSave.isVisible=true
            fragmentprofile.profileEdit.isVisible=false

            if (name!=null) {
                fragmentprofile.profileName.setText(name)
                fragmentprofile.profileEmail.setText(email)
                fragmentprofile.profileNumber.setText(number)
                fragmentprofile.profileAddress.setText(address)
            }else{
                fragmentprofile.profileName.setText("")
                fragmentprofile.profileEmail.setText("")
                fragmentprofile.profileNumber.setText("")
                fragmentprofile.profileAddress.setText("")

            }

        }

        return fragmentprofile.root
    }
}