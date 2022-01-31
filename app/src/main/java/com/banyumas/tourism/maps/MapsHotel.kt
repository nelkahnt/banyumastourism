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
    private var myData: MyData = MyData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.maps_hotel)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        supportActionBar?.title = myData.name.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        var latitude = myData.lat
        var longitude = myData.lng

        val location = LatLng (latitude!!, longitude!!)

        mMap.addMarker(MarkerOptions().position(location).title(myData.name.toString()))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16.0f))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}