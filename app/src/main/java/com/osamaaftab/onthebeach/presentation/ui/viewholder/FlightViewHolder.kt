package com.osamaaftab.onthebeach.presentation.ui.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.osamaaftab.onthebeach.BR
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericListAdapter
import com.osamaaftab.onthebeach.presentation.viewmodel.FlightsViewModel

class FlightViewHolder<T>(
    private val viewDataBinding: ViewDataBinding,
    private val viewModel: FlightsViewModel?) : RecyclerView.ViewHolder(viewDataBinding.root),
    GenericListAdapter.Binder<T> {

    override fun bindItem(data: T) {
        viewDataBinding.setVariable(BR.flightItem,data)
        viewDataBinding.setVariable(BR.flightViewModel,viewModel)
    }
}