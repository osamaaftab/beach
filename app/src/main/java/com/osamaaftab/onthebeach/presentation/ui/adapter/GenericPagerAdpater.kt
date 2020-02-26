package com.osamaaftab.onthebeach.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.osamaaftab.onthebeach.domain.model.base.PagerItem

abstract class GenericPagerAdpater(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    protected abstract fun getViewsCount(): Int
    protected abstract fun getPagerItem(): ArrayList<PagerItem>

    override fun getItem(position: Int): Fragment {
        return getPagerItem()[position].fragment
    }

    override fun getCount(): Int {
        return getViewsCount()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return getPagerItem()[position].title
    }

}