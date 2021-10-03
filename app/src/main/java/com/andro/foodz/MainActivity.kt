package com.andro.foodz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivity:ActivityMainBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivity.root)



        supportFragmentManager.beginTransaction().replace(R.id.host,Login()).addToBackStack(null).commit()

    }

    public fun change(fragment:Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.host,fragment).addToBackStack(null).commit()
    }

}


