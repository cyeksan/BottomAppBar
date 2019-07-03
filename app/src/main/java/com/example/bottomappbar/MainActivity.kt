package com.example.bottomappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_app_bar.replaceMenu(R.menu.bottom_app_bar_menu)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.bottom_app_bar_menu, menu)

        //If you want to add icon in front of your menu items:
        /*if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }*/
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {

            R.id.app_bar_fav -> Toast.makeText(this, "Favoriler tıklandı", Toast.LENGTH_LONG).show()
            R.id.app_bar_search -> Toast.makeText(this, "Arama tıklandı", Toast.LENGTH_LONG).show()
            R.id.app_bar_settings -> Toast.makeText(this, "Ayarlar tıklandı", Toast.LENGTH_LONG).show()

        }

        return true
    }
}
