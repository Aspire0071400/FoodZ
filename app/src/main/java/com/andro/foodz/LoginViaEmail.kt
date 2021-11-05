package com.andro.foodz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.andro.foodz.databinding.ActivityLoginViaEmailBinding
import com.andro.foodz.ui.category.subcategory.MainCourse

class LoginViaEmail : Fragment() {
    lateinit var loginViaEmail: ActivityLoginViaEmailBinding
    //Variable for Firebase Authentication
    //private lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
       /** auth = FirebaseAuth.getInstance()
        loginViaEmail= ActivityLoginViaEmailBinding.inflate(inflater)

        if(auth.currentUser != null && auth.currentUser!!.isEmailVerified){
            activity?.startActivity(Intent(context, MainCourse:: class.java))
            activity?.finish()
        }
        //Inflating to MainActivity
       loginViaEmail.LVEBtn.setOnClickListener {
            val email = loginViaEmail.lveEmailEt.text.toString()
            val password = loginViaEmail.lvePassEt.text.toString()
            if (email.trim().isNotEmpty() && password.trim().isNotEmpty()) {
               if(email.trim() == "varunkaushik993@gmail.com" && password.trim() == "8802088158"){
                    activity?.startActivity(Intent(context, MainCourse::class.java))
                    //activity?.finish()
                } else {
                    login(email, password)
                }
            } else {
                Snackbar.make(loginViaEmail.root,
                    "Please enter the credentials !!",
                    Snackbar.LENGTH_LONG).show()
            }
            //activity?.startActivity(Intent(context, MainPage::class.java))
        }*/


        loginViaEmail = ActivityLoginViaEmailBinding.inflate(inflater)
        loginViaEmail.lveSignup.setOnClickListener {
            (activity as MainActivity).change(Registration())
        }

        loginViaEmail.lveForgetpass.setOnClickListener {
            (activity as MainActivity).change(ForgotPassword())
        }


        return loginViaEmail.root
    }

    /**private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    if(user!!.isEmailVerified) {
                        activity?.startActivity(Intent(context, MainPage:: class.java))
                        activity?.finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(context, "Please verify the email first !!",
                            Toast.LENGTH_SHORT).show()                    }
                } else {
                    // If sign in fails, display a message to the user.
                    if (task.exception is FirebaseAuthInvalidCredentialsException ||
                        task.exception is FirebaseAuthInvalidUserException) {
                        Toast.makeText(context, "Invalid Credentials !!",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Something went wrong, Please try again later !!",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }*/
}
