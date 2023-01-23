package com.example.spotifyalbumscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class HomeAdapter(private val ArrayAlbum: List<Album>, val OnClick: (Album) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.MainViewHolder>() {

    /*

    private var onAlbumClickListener: OnAlbumClickListener? = null

    interface OnAlbumClickListener {
        fun onAlbumClick(position: Int)
    }

    fun setOnAlbumClickListener(listener: OnAlbumClickListener) {
        onAlbumClickListener = listener
    }

     */


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardviewalbum, parent, false)
        return MainViewHolder(v)

    }

    var context: Context? = null
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = ArrayAlbum.get(position)
        holder.bindItems(ArrayAlbum[position])
        holder.bindItems(data)
        holder.itemView.setOnClickListener {
            OnClick(data)
        }
        /*
        holder.itemView.setOnClickListener{
            onAlbumClickListener?.onAlbumClick(position)
        }

         */
    }

    override fun getItemCount(): Int {
        return ArrayAlbum.size
    }

    inner class MainViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        val mytexto = v.findViewById<TextView>(R.id.mytexto)
        val mydesc = v.findViewById<TextView>(R.id.myvaloracion)
        val myImg = v.findViewById<ImageView>(R.id.imageView)
        fun bindItems(data: Album) {
            mytexto.text = data.name
            mydesc.text = data.artist + " SEGUIDORES"
            Picasso.with(myImg.context)
                .load(data.image)
                .into(myImg)

        }
    }
}