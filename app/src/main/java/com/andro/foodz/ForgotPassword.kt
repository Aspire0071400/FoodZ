package com.andro.foodz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.andro.foodz.databinding.ActivityForgetPasswordBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPassword : Fragment() {
    lateinit var forgotPassword:ActivityForgetPasswordBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
       //auth = FirebaseAuth.getInstance()
        forgotPassword = ActivityForgetPasswordBinding.inflate(inflater)

         //Sending Password reset mail
        forgotPassword.button.setOnClickListener {
            val email = forgotPassword.editTextTextEmailAddress.text.toString()
            if (email.trim().isNotEmpty()){
                val eMail = forgotPassword.editTextTextEmailAddress.text.toString()
                auth = Firebase.auth
                auth.sendPasswordResetEmail(eMail)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Snackbar.make(forgotPassword.root,
                                "Password Reset Link Send to your Email !!",
                                Snackbar.LENGTH_LONG).show()
                        } else {
                            if (task.exception is FirebaseAuthInvalidCredentialsException ||
                                task.exception is FirebaseAuthInvalidUserException){
                                Snackbar.make(forgotPassword.root,
                                    "Invalid Credentials !!",
                                    Snackbar.LENGTH_LONG).show()
                            } else {
                                Snackbar.make(forgotPassword.root,
                                    "Something went wrong, Please try again later !!",
                                    Snackbar.LENGTH_LONG).show()
                            }
                        }
                    }
            } else {
                Snackbar.make(forgotPassword.root,
                    "Please enter the credentials !!",
                    Snackbar.LENGTH_LONG).show()
            }
        }


        return forgotPassword.root
    }
}
