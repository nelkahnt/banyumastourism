package com.banyumas.tourism

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main.*

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        btnHotel.setOnClickListener {
            val intent= Intent(this, Hotel::class.java)
            startActivity(intent)
        }
        btnRestoran.setOnClickListener {
            val intent= Intent(this, Restoran::class.java)
            startActivity(intent)
        }

        btnWstalam.setOnClickListener {
            val intent= Intent(this, wstAlam::class.java)
            startActivity(intent)
        }
        btnWstbuatan.setOnClickListener {
            val intent= Intent(this, wstBuatan::class.java)
            startActivity(intent)
        }
        btnWstmuseum.setOnClickListener {
            val intent= Intent(this, wstMuseum::class.java)
            startActivity(intent)
        }
    }
}