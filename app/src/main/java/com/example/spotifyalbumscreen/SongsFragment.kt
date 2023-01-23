package com.example.spotifyalbumscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.Serializable


class SongsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun readJsonFromFile(fileName: String): String {
        var json = ""
        try {
            val bufferedReader = BufferedReader(
                InputStreamReader(context?.assets?.open(fileName))
            )
            val paramsBuilder = StringBuilder()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                paramsBuilder.append(line)
                line = bufferedReader.readLine()
            }
            json = paramsBuilder.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_songs, container, false)
        return view
    }

    data class Polanski(val porter: Int) : Serializable

    //val args: SongsFragmentArgs by navArgs()

   // val positron = args.polanski.porter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val json = readJsonFromFile("Default.json")
        val users = Gson().fromJson(json, AlbumSon::class.java)
        val mAdapter = SongsAdapter(users.albums) //positron es la posicion del onClick del recyclerView
        val mainRecyclerView = view.findViewById<RecyclerView>(R.id.mainRecyclerViewSongs)
        mainRecyclerView?.layoutManager = //GridLayoutManager(context, 2)
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mainRecyclerView?.adapter = mAdapter

    }
}