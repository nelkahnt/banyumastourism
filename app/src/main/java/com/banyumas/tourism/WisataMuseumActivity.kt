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

class WisataMuseumActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var arrayList = ArrayList <MyData> ()
    lateinit var myAdapter: AdapterHotel
    private var fbFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wisata_museum)
        setTitle("Wisata Museum")

        recyclerView = findViewById(R.id.rv_wisata)
        myAdapter = AdapterHotel(arrayList, this)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        getData()
    }

    private fun getData() {
        fbFirestore = FirebaseFirestore.getInstance()
        fbFirestore.collection("wstmuseum")
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

////    override fun onCreateOptionsMenu(menu: Menu): Boolean {
////
////        val inflater =  menuInflater
////        inflater.inflate(R.menu.main,menu)
////        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
////        val searchItem = menu?.findItem(R.id.menu_search)
////        val searchView = searchItem?.actionView as SearchView
////
////        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))
////        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
////            override fun onQueryTextSubmit(query: String?): Boolean {
////                searchView.clearFocus()
////                searchView.setQuery("",false)
////                searchItem.collapseActionView()
////
////                return true
////            }
////
////            override fun onQueryTextChange(newText: String?): Boolean {
////                filter(newText.toString())
////                return true
////            }
////
////        })
////        return true
////    }
//
//    private fun filter(text: String) {
//        //new array list that will hold the filtered data
//        val filteredNames = ArrayList < MyData > ()
//        //looping through existing elements and adding the element to filtered list
//        dataList!!.filterTo(filteredNames) {
//            //if the existing elements contains the search input
//            it.name!!.toLowerCase().contains(text.toLowerCase())
////                    || it.url.toLowerCase().contains(text.toLowerCase())
//        }
//        //calling a method of the adapter class and passing the filtered list
//        if (filteredNames != null) {
//            myAdapter!!.filterList(filteredNames)
//        }
//    }

}