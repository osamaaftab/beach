package com.osamaaftab.onthebeach.data.repository

import com.osamaaftab.onthebeach.data.source.remote.HotelServices
import com.osamaaftab.onthebeach.domain.model.HotelResponse
import com.osamaaftab.onthebeach.domain.repository.HotelRepository

class HotelRepositoryImp(private val hotelServices: HotelServices) : HotelRepository {

    override suspend fun getHotels(): HotelResponse {
        return hotelServices.getHotels().await()
    }
}