package com.example.spotifyalbumscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class HomeFragment : Fragment() {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val json = readJsonFromFile("Default.json")
        val bottom_navigation_view =
            view.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        //users.data
        val users = Gson().fromJson(json, AlbumSon::class.java)

        val mAdapter = HomeAdapter(users.albums) {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_homeFragment_to_songsFragment)
        }

        val mainRecyclerView = view.findViewById<RecyclerView>(R.id.mainRecyclerView)
        mainRecyclerView?.layoutManager = GridLayoutManager(context, 2)


        //LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

/*
        mAdapter.setOnAlbumClickListener(object : HomeAdapter.OnAlbumClickListener {
            override fun onAlbumClick(position: Int) {


                val parquet = SongsFragment.Polanski(position)
                Log.i("paquete-va", parquet.toString())
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSongsFragment(
                        parquet
                    )
                )


            }
        })
         */

        mainRecyclerView?.adapter = mAdapter
    }

}