package com.andro.foodz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var main:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        supportFragmentManager.beginTransaction().replace(R.id.host,Login()).addToBackStack(null).commit()
    }
    fun change(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.host,fragment).addToBackStack(null).commit()
    }
}
