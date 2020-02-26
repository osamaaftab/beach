package com.osamaaftab.onthebeach.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericPagerAdpater
import com.osamaaftab.onthebeach.domain.model.base.PagerItem
import com.osamaaftab.onthebeach.R
import com.osamaaftab.onthebeach.presentation.ui.fragment.FlightFragment
import com.osamaaftab.onthebeach.presentation.ui.fragment.HotelFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var genericPagerAdpater: GenericPagerAdpater
    private  var list: ArrayList<PagerItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
    }

    private fun setAdapter() {

        list.add(PagerItem(HotelFragment(), "Hotel"))
        list.add(PagerItem(FlightFragment(), "Flight"))

        genericPagerAdpater = object : GenericPagerAdpater(supportFragmentManager) {
            override fun getViewsCount(): Int {
                return list.size
            }

            override fun getPagerItem(): ArrayList<PagerItem> {
                return list
            }
        }
        mainViewPager.adapter = genericPagerAdpater
        tab.setupWithViewPager(mainViewPager)
    }
}
