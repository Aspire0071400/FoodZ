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


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        fragmentprofile = FragmentProfileBinding.inflate(inflater)
        val profdata = arrayOf("","","","")


        fragmentprofile.profileSave.setOnClickListener {
            profdata[0] = fragmentprofile.profileName.text.toString()
            profdata[1] = fragmentprofile.profileEmail.text.toString()
            profdata[2] = fragmentprofile.profileNumber.text.toString()
            profdata[3] = fragmentprofile.profileAddress.text.toString()

            fragmentprofile.profileEdit.isVisible=true
            fragmentprofile.profileSave.isVisible=false
            Snackbar.make(fragmentprofile.root,"Your Profile has been saved",Snackbar.LENGTH_LONG).show()


        }

        fragmentprofile.profileEdit.setOnClickListener {
            fragmentprofile.profileSave.isVisible=true
            fragmentprofile.profileEdit.isVisible=false
            fragmentprofile.profileName.editableText
            fragmentprofile.profileEmail.editableText
            fragmentprofile.profileNumber.editableText
            fragmentprofile.profileAddress.editableText

        }

        fragmentprofile.profileName.setText(profdata[0])
        fragmentprofile.profileEmail.setText(profdata[1])
        fragmentprofile.profileNumber.setText(profdata[2])
        fragmentprofile.profileAddress.setText(profdata[3])
        return fragmentprofile.root
    }
}