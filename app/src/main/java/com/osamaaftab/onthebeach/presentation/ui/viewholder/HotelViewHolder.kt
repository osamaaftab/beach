package com.osamaaftab.onthebeach.presentation.ui.viewholder

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.osamaaftab.onthebeach.BR
import com.osamaaftab.onthebeach.R
import com.osamaaftab.onthebeach.domain.model.FlightItem
import com.osamaaftab.onthebeach.domain.model.HotelResponse
import com.osamaaftab.onthebeach.domain.model.base.PagerItem
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericListAdapter
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericPagerAdpater
import com.osamaaftab.onthebeach.presentation.ui.fragment.ImageFragment
import com.osamaaftab.onthebeach.presentation.viewmodel.HotelsViewModel

class HotelViewHolder<T> (
    private val viewDataBinding: ViewDataBinding,
    private val viewModel: HotelsViewModel?,
    private val fragmentManager: FragmentManager
) :RecyclerView.ViewHolder(viewDataBinding.root),
GenericListAdapter.Binder<T> {

    override fun bindItem(data: T) {
        viewDataBinding.setVariable(BR.hotelItem, data)
        viewDataBinding.setVariable(BR.hotelViewModel, viewModel)
        viewDataBinding.setVariable(BR.galleryAdpater,initGalleryAdapter(data as HotelResponse))
        viewDataBinding.setVariable(BR.facilityAdpater,initFacilitiesAdapter(data as HotelResponse))
    }

    private fun initGalleryAdapter(data: HotelResponse): GenericPagerAdpater  {
        val list: ArrayList<PagerItem> = ArrayList()
        for (element in data.images) {
            list.add(PagerItem(ImageFragment.newInstance(element)))
        }
        return object : GenericPagerAdpater(fragmentManager) {
            override fun getViewsCount(): Int {
                return list.size
            }

            override fun getPagerItem(): ArrayList<PagerItem> {
                return list
            }
        }
    }

    private fun initFacilitiesAdapter(data: HotelResponse): GenericListAdapter<String>  {
        val adapter =  object : GenericListAdapter<String>() {

            override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
                return FacilityViewHolder<String>(viewDataBinding)
            }

            override fun getLayoutId(): Int {
                return R.layout.item_facility
            }
        }
        adapter.itemList = data.facilities
        return adapter
    }
}