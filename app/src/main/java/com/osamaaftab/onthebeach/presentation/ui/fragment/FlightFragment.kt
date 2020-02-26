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
import com.osamaaftab.onthebeach.databinding.FragmentFlightBinding
import com.osamaaftab.onthebeach.domain.model.FlightItem
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericListAdapter
import com.osamaaftab.onthebeach.presentation.ui.viewholder.FlightViewHolder
import com.osamaaftab.onthebeach.presentation.viewmodel.FlightsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FlightFragment : Fragment() {

    lateinit var flightBinding: FragmentFlightBinding
    private val flightViewModel: FlightsViewModel by viewModel()
    private var flightAdapter: GenericListAdapter<FlightItem>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        flightBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight, container, false)
        initObserver()
        initAdapter()
        flightViewModel.loadVehicleList()
        return flightBinding.root
    }


    private fun initObserver() {

        flightViewModel.getOnShow().observe(this, Observer {
            if (it == true) {
                flightBinding.indeterminateBar.visibility = View.VISIBLE
            } else flightBinding.indeterminateBar.visibility = View.GONE
        })

        flightViewModel.getFlightList().observe(
            this,
            Observer {
                flightAdapter?.itemList = it
            })

        flightViewModel.getOnError().observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initAdapter() {
        flightAdapter = object : GenericListAdapter<FlightItem>() {

            override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
                return FlightViewHolder<FlightItem>(viewDataBinding, flightViewModel)
            }

            override fun getLayoutId(): Int {
                return R.layout.item_flight
            }
        }
        flightBinding.flightRecyclerView.adapter = flightAdapter
    }
}