package com.andro.foodz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andro.foodz.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var splashscreen: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashscreen = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashscreen.root)

        Thread {
            Thread.sleep(1000)
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }.start()
    }
}