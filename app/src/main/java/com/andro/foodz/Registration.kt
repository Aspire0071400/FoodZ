package com.andro.foodz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.andro.foodz.databinding.ActivityRegistrationBinding


class Registration :Fragment() {
    lateinit var Registration: ActivityRegistrationBinding
    //Variable for Firebase Authentication
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {

        auth= FirebaseAuth.getInstance()
        Registration = ActivityRegistrationBinding.inflate(inflater)

        //Registering the User
        Registration.regBtn.setOnClickListener {
            val email = Registration.regEmailEt.text.toString()
            val password = Registration.regPassEt.text.toString()
            val confirmPassword = Registration.regConfirmPassEt.text.toString()
            if(email.trim().isNotEmpty() && password.trim().isNotEmpty()
                && confirmPassword.trim().isNotEmpty()){
                if(password == confirmPassword){
                    createAccount(email, confirmPassword)
                } else {
                    Snackbar.make(Registration.root,
                        "Password Mismatch !!",
                        Snackbar.LENGTH_LONG).show()
                }
            } else {
                Snackbar.make(Registration.root,
                    "Please enter the credentials !!",
                    Snackbar.LENGTH_LONG).show()
            }



        Registration = ActivityRegistrationBinding.inflate(inflater)

        Registration.regSignupEt.setOnClickListener{
            (activity as MainActivity).change(Login())

        }



    }
        return Registration.root
}

    private fun createAccount(email: String,confirmPasswword: String) {
        auth.createUserWithEmailAndPassword(email, confirmPasswword).addOnCompleteListener {task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = auth.currentUser
                user!!.sendEmailVerification()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context,
                                "Please Check Your Email for verification to Complete Your Registration.",
                                Toast.LENGTH_LONG).show()
                            (activity as MainActivity).change(LoginViaEmail())
                        } else {
                            // If sign in fails, display a message to the user
                            if (task.exception is FirebaseAuthUserCollisionException) {
                                Toast.makeText(context, "User already registered.", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
            }



        }

    }
}




