package com.osamaaftab.onthebeach.data.source.remote

import com.osamaaftab.onthebeach.domain.model.FlightResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface FlightServices {

    @GET("/raw/bFnZQEx0")
    fun getFlights(): Deferred<FlightResponse>
}