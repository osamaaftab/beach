package com.osamaaftab.onthebeach.domain.repository

import com.osamaaftab.onthebeach.domain.model.HotelResponse

interface HotelRepository {
    suspend fun getHotels(): HotelResponse
}