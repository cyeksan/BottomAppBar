package com.example.bottomappbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), IActivityMethods {

    private var navItemList = ArrayList<Int>()
    private var toastTextItemList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNavItemArray(navItemList)
        createToastTextItemArray(this, toastTextItemList)


        //region Set menu (primary) to Bottom App Bar at first (App theme must be NoActionBar type of theme!)
        bottom_app_bar.replaceMenu(R.menu.bottom_app_bar_menu_primary)
        //endregion

        //region When items on Bottom App Bar menu are clicked on (both primary menu and secondary menu):
        bottom_app_bar.setOnMenuItemClickListener {

            for (i in 0 until navItemList.size) {
                when (it.itemId) {

                    navItemList[i] -> showToastMessage(toastTextItemList[i], this)
                }

            }

            return@setOnMenuItemClickListener true
        }


        //endregion

        //region When 3 straight line menu item at the left is clicked on:
        bottom_app_bar.setNavigationOnClickListener {

            openNavigationDrawer(supportFragmentManager)
        }
        //endregion

        //region When fab is clicked on:
        fab.setOnClickListener {

            //Change background color:
            coordinatorLayout.changeBackgroundColor()

            //Show a snack bar:
            Snackbar.make(fab, getString(R.string.snack_bar_shown), Snackbar.LENGTH_SHORT)
                .setAction(getString(R.string.ok)) {
                    //Do what you want as snackBar action.
                }.show()

        }
        //endregion

        //region When toggle button is clicked, a slide animation on Bottom App Bar is run between primary menu and secondary menu:
        toggleButton.setOnCheckedChangeListener { _, isChecked ->


            val slideRtl = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_rtl)

            if (isChecked) {


                slideAction(
                    this,
                    fab,
                    bottom_app_bar,
                    null,
                    slideRtl,
                    BottomAppBar.FAB_ALIGNMENT_MODE_END,
                    R.menu.bottom_app_bar_menu_secondary,
                    R.drawable.ic_reply_white_24dp
                )

            } else {

                slideAction(

                    this,
                    fab,
                    bottom_app_bar,
                    R.drawable.ic_menu_white_24dp,
                    slideRtl,
                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER,
                    R.menu.bottom_app_bar_menu_primary,
                    R.drawable.ic_add_white_24dp
                )

            }
        }
        //endregion

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.bottom_app_bar_menu_primary, menu)

        /***
         ** If you want to add an icon in front of your menu items:
        }***/

        /*if (menu is MenuBuilder) {
          menu.setOptionalIconsVisible(true)
        }*/

        return true
    }


    //endregion

}
