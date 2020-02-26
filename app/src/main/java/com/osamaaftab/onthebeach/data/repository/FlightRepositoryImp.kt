package com.osamaaftab.onthebeach.data.repository

import com.osamaaftab.onthebeach.data.source.remote.FlightServices
import com.osamaaftab.onthebeach.domain.model.FlightResponse
import com.osamaaftab.onthebeach.domain.repository.FlightRepository

class FlightRepositoryImp(private val flightServices: FlightServices) : FlightRepository {

    override suspend fun getFlights(): FlightResponse {
        return flightServices.getFlights().await()
    }
}