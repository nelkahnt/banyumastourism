package com.banyumas.tourism

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.splash.*

class Splash : AppCompatActivity() {

        lateinit var handler: Handler
        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.splash)

            handler = Handler()
            handler.postDelayed({
                val intent = Intent(this@Splash, Main::class.java)
                startActivity(intent)
                finish()
            }, 2000)
        }
}