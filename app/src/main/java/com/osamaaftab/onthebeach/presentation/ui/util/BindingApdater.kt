package com.osamaaftab.onthebeach.presentation.ui.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericListAdapter
import com.osamaaftab.onthebeach.presentation.ui.adapter.GenericPagerAdpater
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

@BindingAdapter("gallery")
fun ViewPager.setImageGallery(adapter: GenericPagerAdpater) {
    this.adapter = adapter
}

@BindingAdapter("facility")
fun RecyclerView.facilitiesAdapter(adapter: GenericListAdapter<String>) {
    this.adapter = adapter
}

@BindingAdapter("date")
fun TextView.setDate(date: String) {
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
    val outputFormatter = SimpleDateFormat("HH:mm a")
    val formattedDate: String = outputFormatter.format(inputFormatter.parse(date))
    this.text = formattedDate
}


@BindingAdapter("indicator")
fun WormDotsIndicator.setAdapter(viewPager: ViewPager) {
    this.setViewPager(viewPager)
}