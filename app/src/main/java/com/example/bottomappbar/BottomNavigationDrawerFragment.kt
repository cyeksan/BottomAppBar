package com.example.bottomappbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment(), IFragmentMethods {


    private var navItemList = ArrayList<Int>()
    private var toastTextItemList = ArrayList<String>()

    companion object {

        fun getInstance(): BottomNavigationDrawerFragment {

            var instance: BottomNavigationDrawerFragment? = null
            return if (instance == null) {

                instance = BottomNavigationDrawerFragment()
                instance
            } else {

                instance
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        navItemList = createNavItemArray(navItemList)
        toastTextItemList = createToastTextItemArray(context!!, toastTextItemList)
        navigation_view.setNavigationItemSelectedListener {


            for (i in 0 until navItemList.size) {
                when (it.itemId) {

                    navItemList[i] -> showToastMessage(toastTextItemList[i], context!!)
                }

            }

            return@setNavigationItemSelectedListener true

        }
    }


}