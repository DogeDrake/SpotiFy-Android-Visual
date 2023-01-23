package com.example.spotifyalbumscreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottom_navigation_view = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottom_navigation_view.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Buscard -> {
                    goToFragment(HomeFragment())
                    this.setTitle("Playlists populares")
                    true
                }
                R.id.Library -> {
                    goToFragment(SongsFragment())
                    true
                }
                else -> false
            }
        }
        bottom_navigation_view.selectedItemId = R.id.Buscard
    }

    fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
    }
}

