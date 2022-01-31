package com.banyumas.tourism.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banyumas.tourism.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.banyumas.tourism.model.MyData as MyData

class MapsHotel : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        var title = intent.getStringExtra("ininama")
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        var title = intent.getStringExtra("ininama")
        var latitude = intent.getDoubleExtra("inilat",0.0)
        var longitude = intent.getDoubleExtra("inilong",0.0)

        val location = LatLng (latitude, longitude)

        mMap.addMarker(MarkerOptions().position(location).title(title))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16.0f))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}