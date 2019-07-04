package com.example.bottomappbar

import android.content.Context
import android.widget.Toast

interface IFragmentMethods {

    fun showToastMessage(text: String?, context: Context) {

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun createNavItemArray(navItemList: ArrayList<Int>): ArrayList<Int> {

        navItemList.apply {

            add(R.id.nav1)
            add(R.id.nav2)
            add(R.id.nav3)
            add(R.id.nav4)
            add(R.id.nav5)
            add(R.id.nav6)
            add(R.id.nav7)
            add(R.id.nav8)
            add(R.id.nav9)
            add(R.id.nav10)
            add(R.id.nav11)
            add(R.id.nav12)
            add(R.id.nav13)
            add(R.id.nav14)
            add(R.id.nav15)

        }

        return navItemList
    }

    fun createToastTextItemArray(context: Context, toastTextItemList: ArrayList<String>): ArrayList<String> {
        toastTextItemList.apply {

            add(context.resources?.getString(R.string.holiday_click)!!)
            add(context.resources?.getString(R.string.furniture_click)!!)
            add(context.resources?.getString(R.string.work_click)!!)
            add(context.resources?.getString(R.string.moon_click)!!)
            add(context.resources?.getString(R.string.call_click)!!)
            add(context.resources?.getString(R.string.cloud_click)!!)
            add(context.resources?.getString(R.string.cut_click)!!)
            add(context.resources?.getString(R.string.detail_click)!!)
            add(context.resources?.getString(R.string.walk_click)!!)
            add(context.resources?.getString(R.string.drive_click)!!)
            add(context.resources?.getString(R.string.download_click)!!)
            add(context.resources?.getString(R.string.fingerprint_click)!!)
            add(context.resources?.getString(R.string.flight_click)!!)
            add(context.resources?.getString(R.string.ideas_click)!!)
            add(context.resources?.getString(R.string.sun_click)!!)

        }

        return toastTextItemList
    }

}