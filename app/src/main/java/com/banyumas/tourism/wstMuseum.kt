package com.banyumas.tourism

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.banyumas.tourism.adapter.AdapterHotel
import androidx.recyclerview.widget.RecyclerView
import com.banyumas.tourism.model.MyData
import com.google.firebase.firestore.*

class wstMuseum : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var arrayList = ArrayList <MyData> ()
    lateinit var myAdapter: AdapterHotel
    private var fbFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wst_museum)
        setTitle("Wisata Museum")

        recyclerView = findViewById(R.id.rv_wisata)
        myAdapter = AdapterHotel(arrayList, this)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        getData()
    }

    private fun getData() {

        fbFirestore = FirebaseFirestore.getInstance()
        fbFirestore.collection("wstmuseum").orderBy("name", Query.Direction.ASCENDING)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if (error != null){
                        Log.e("Firestore Error", error.message.toString())
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!){
                        if (dc.type == DocumentChange.Type.ADDED){
                            arrayList.add(dc.document.toObject(MyData::class.java))
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                }
            })
    }
}