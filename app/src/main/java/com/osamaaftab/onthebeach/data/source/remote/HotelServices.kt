package com.osamaaftab.onthebeach.data.source.remote

import com.osamaaftab.onthebeach.domain.model.HotelResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface HotelServices {

    @GET("/raw/f0Tm6bfy")
    fun getHotels(): Deferred<HotelResponse>
}