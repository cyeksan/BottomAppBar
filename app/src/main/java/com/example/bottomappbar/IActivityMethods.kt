package com.example.bottomappbar

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.animation.Animation
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

interface IActivityMethods {


    fun showToastMessage(text: String?, context: Context) {

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun createNavItemArray(navItemList: ArrayList<Int>): ArrayList<Int> {

        navItemList.apply {

            add(R.id.app_bar_fav)
            add(R.id.app_bar_search)
            add(R.id.app_bar_settings)
            add(R.id.app_bar_mail)
            add(R.id.app_bar_delete)
            add(R.id.app_bar_archive)
        }

        return navItemList
    }

    fun createToastTextItemArray(context: Context, toastTextItemList: ArrayList<String>): ArrayList<String> {
        toastTextItemList.apply {

            add(context.resources?.getString(R.string.favorites_click)!!)
            add(context.resources?.getString(R.string.search_click)!!)
            add(context.resources?.getString(R.string.settings_click)!!)
            add(context.resources?.getString(R.string.mail_click)!!)
            add(context.resources?.getString(R.string.delete_click)!!)
            add(context.resources?.getString(R.string.archive_click)!!)

        }

        return toastTextItemList
    }

    fun openNavigationDrawer(fm: FragmentManager) {

        //Create a Singleton object of BottomNavigationDrawerFragment:
        val bottomNavigationDrawerFragment = BottomNavigationDrawerFragment.getInstance()
        bottomNavigationDrawerFragment.show(fm, bottomNavigationDrawerFragment.tag)
    }

    fun View.changeBackgroundColor() {

        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        this.setBackgroundColor(color)
    }

    //region Slide animation method for Bottom App Bar
    fun slideAction(
        context: Context,
        fab: FloatingActionButton,
        bottomAppBar: BottomAppBar,
        navigationIcon: Int?,
        anim: Animation,
        alignmentMode: Int,
        menu: Int,
        fabDrawable: Int
    ) {

        fab.startAnimation(anim)

        if (navigationIcon == null) {

            // If you do not want to show navigation drawer icon (3 straight line at the left), hide it:
            bottomAppBar.navigationIcon = null
        } else {

            bottomAppBar.navigationIcon = ContextCompat.getDrawable(context, navigationIcon)
        }

        bottomAppBar.fabAlignmentMode = alignmentMode

        // Replace the action menu
        bottomAppBar.replaceMenu(menu)

        // Change FAB icon
        fab.setImageDrawable(ContextCompat.getDrawable(context, fabDrawable))

    }
    //endregion
}