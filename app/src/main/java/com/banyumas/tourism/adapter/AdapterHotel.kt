package com.banyumas.tourism.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.banyumas.tourism.model.MyData
import com.banyumas.tourism.R
import com.banyumas.tourism.maps.MapsHotel
import kotlinx.android.synthetic.main.item_cardview.view.*

class AdapterHotel(

    private var dataList: List <MyData>,
    private val context: Context ) : RecyclerView.Adapter < AdapterHotel.ViewHolder > () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(context)
            .inflate(R.layout.item_cardview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        holder.bind(dataList[position])
        holder.titleTextView.text = dataModel.name
        holder.titleTextView.text = dataModel.harga
        holder.titleTextView.text = dataModel.desc
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemLayoutView: View): RecyclerView.ViewHolder(itemLayoutView) {

        var titleTextView: TextView
        var imgPhoto: ImageView = itemView.findViewById(R.id.cv_photo)

        init {
            titleTextView = itemLayoutView.findViewById(R.id.cv_name)
            titleTextView = itemLayoutView.findViewById(R.id.cv_harga)
            titleTextView = itemLayoutView.findViewById(R.id.cv_descr)
        }

        fun bind(myData: MyData) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(myData.photo)
                    .into(imgPhoto)
                cv_name.text = myData.name
                cv_harga.text = myData.harga
                cv_descr.text = myData.desc

                btnLoc.setOnClickListener {
                    val moveWithObjectIntent = Intent(context,MapsHotel::class.java)
                    moveWithObjectIntent.putExtra("ininama", myData.name)
                    moveWithObjectIntent.putExtra("inilat", myData.lat)
                    moveWithObjectIntent.putExtra("inilong", myData.lang)
                    context.startActivity(moveWithObjectIntent)
                }

            }
        }
    }
}