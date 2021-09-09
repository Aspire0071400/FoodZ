package com.andro.foodz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    lateinit var main:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        supportFragmentManager.beginTransaction().replace(R.id.host,Login()).addToBackStack(null).commit()
    }
    public fun change(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.host,fragment).addToBackStack(null).commit()
    }
}
