package com.example.spotifyalbumscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class SongsAdapter(
    private val mDataSet: List<Album>
) :
    RecyclerView.Adapter<SongsAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.cardviewcanciones, parent, false)
        return MainViewHolder(v)
    }
/*
DESQUITE
    private var mequieromatar = positron
    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }
    */


    ///////////////
    var context: Context? = null
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
    /////////////////

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = mDataSet[position]
        holder.bindItems(data)


        /*
        DESQUITE
        holder.itemView.setOnClickListener {
            OnClick(data)
        }
        */

/*
        val songs = mDataSet[mequieromatar]
        holder.mytexto.text = songs.name
        holder.mydesc.text = songs.artist
        Picasso.with(holder.myImg.context)
            .load(songs.image)
            .into(holder.myImg)
            */

        var factor: Boolean = false
        holder.FavImgButton.setOnClickListener {
            if (!factor) {
                factor = true
                holder.FavImgButton.setBackgroundResource(R.drawable.ic_baseline_favorite_24)

            } else {
                factor = false
                holder.FavImgButton.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
        /*
        DESQUITE
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }
         */
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    inner class MainViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        val mytexto = v.findViewById<TextView>(R.id.mytextoS)
        val mydesc = v.findViewById<TextView>(R.id.myvaloracionS)
        val myImg = v.findViewById<ImageView>(R.id.imageViewS)
        fun bindItems(data: Album) {
            mytexto.text = data.name
            mydesc.text = data.artist
            Picasso.with(myImg.context)
                .load(data.image)
                .into(myImg)
        }

        val FavImgButton = v.findViewById<ImageButton>(R.id.favButton)
    }
}