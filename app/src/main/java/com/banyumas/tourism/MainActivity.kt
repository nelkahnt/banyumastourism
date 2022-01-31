package com.banyumas.tourism

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHotel.setOnClickListener {
            val intent= Intent(this, HotelActivity::class.java)
            startActivity(intent)
        }
        btnRestoran.setOnClickListener {
            val intent= Intent(this, RestoranActivity::class.java)
            startActivity(intent)
        }

        btnWstalam.setOnClickListener {
            val intent= Intent(this, WisataAlamActivity::class.java)
            startActivity(intent)
        }
        btnWstbuatan.setOnClickListener {
            val intent= Intent(this, WisataBuatanActivity::class.java)
            startActivity(intent)
        }
        btnWstmuseum.setOnClickListener {
            val intent= Intent(this, WisataMuseumActivity::class.java)
            startActivity(intent)
        }
    }
}