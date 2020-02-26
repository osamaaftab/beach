package com.osamaaftab.onthebeach.presentation.ui.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.osamaaftab.onthebeach.BR
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericListAdapter

class FacilityViewHolder<T>(
    private val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root),
    GenericListAdapter.Binder<T> {

    override fun bindItem(data: T) {
        viewDataBinding.setVariable(BR.url,data)

    }
}