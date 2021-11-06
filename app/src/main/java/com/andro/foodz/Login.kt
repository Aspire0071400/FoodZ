package com.andro.foodz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class Login : Fragment() {
    //Initializing Variables
    private lateinit var login: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var callback: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var credential: PhoneAuthCredential

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        login = ActivityLoginBinding.inflate(inflater)

        auth = FirebaseAuth.getInstance()

        callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(pin: PhoneAuthCredential) {
                login.loginOtpEt.setText(pin.smsCode.toString())
                credential = pin
            }
            override fun onVerificationFailed(p0: FirebaseException) {

            }
        }

        //Sending OTP
        login.getotpBtn.setOnClickListener {
            if(login.loginNoEt.text.toString().trim().isNotEmpty()){
                val mobile = login.loginNoEt.text.toString()
                val updatedMobile = "+91$mobile"
                startNumberVerification(updatedMobile)
            }
            //Snackbar.make(forgotPasswordActivity.root,"Please Enter Your Phone Number!",Snackbar.LENGTH_LONG).show()
        }

        //Verifying the authenticity
        login.submitBtn.setOnClickListener {
            if(login.loginNoEt.text.toString().trim().isNotEmpty()
                and login.loginOtpEt.text.toString().trim().isNotEmpty()){
                signIn(credential)
            }
            //Snackbar.make(forgotPasswordActivity.root,"Fields are Empty!",Snackbar.LENGTH_LONG).show()
        }

        login.loginLveTw.setOnClickListener {
            (activity as MainActivity).change(LoginViaEmail())
        }

        login.loginSignupTv.setOnClickListener{
            (activity as MainActivity).change(Registration())
        }


        return login.root
    }

    private fun signIn(pin: PhoneAuthCredential) {
        auth.signInWithCredential(pin).addOnCompleteListener {
            if(it.isSuccessful) {
                Snackbar.make(login.root,"Successful",Snackbar.LENGTH_SHORT).show()
                activity?.startActivity(Intent(context,MainPage::class.java))
                activity?.finish()
            } else {
                Snackbar.make(login.root,"Invalid OTP",Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun startNumberVerification(updatedMobile: String) {
        val option = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(updatedMobile)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(context as Activity)
            .setCallbacks(callback)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }

}