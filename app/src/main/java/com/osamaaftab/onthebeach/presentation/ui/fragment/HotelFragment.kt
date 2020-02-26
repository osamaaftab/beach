package com.osamaaftab.onthebeach.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.osamaaftab.onthebeach.R
import com.osamaaftab.onthebeach.databinding.FragmentHotelBinding
import com.osamaaftab.onthebeach.domain.model.HotelResponse
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericListAdapter
import com.osamaaftab.onthebeach.presentation.ui.viewholder.HotelViewHolder
import com.osamaaftab.onthebeach.presentation.viewmodel.HotelsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HotelFragment : Fragment() {

    lateinit var fragmentHotelBinding: FragmentHotelBinding
    private val hotelsViewModel: HotelsViewModel by viewModel()
    private var hotelAdapter: GenericListAdapter<HotelResponse>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentHotelBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_hotel, container, false)
        initObserver()
        initAdapter()
        hotelsViewModel.loadHotels()
        return fragmentHotelBinding.root
    }

    private fun initObserver() {

        hotelsViewModel.getOnShow().observe(this, Observer {
            if (it == true) {
                fragmentHotelBinding.indeterminateBar.visibility = View.VISIBLE
            } else fragmentHotelBinding.indeterminateBar.visibility = View.GONE
        })

        hotelsViewModel.getHotelResponse().observe(
            this,
            Observer {
                hotelAdapter?.itemList = listOf(it)
            })

        hotelsViewModel.getOnError().observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initAdapter() {
        hotelAdapter = object : GenericListAdapter<HotelResponse>() {

            override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
                return HotelViewHolder<HotelResponse>(viewDataBinding, hotelsViewModel,fragmentManager!!)
            }

            override fun getLayoutId(): Int {
                return R.layout.item_hotel
            }
        }
        fragmentHotelBinding.hotelRecyclerView.adapter = hotelAdapter
    }

}