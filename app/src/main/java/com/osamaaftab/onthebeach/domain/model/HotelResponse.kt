package com.osamaaftab.onthebeach.domain.model

data class HotelResponse(
    val name: String,
    val hotel_location: String,
    val description: String,
    val images: List<String>,
    val rating: String,
    val facilities: List<String>
)