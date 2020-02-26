package com.osamaaftab.onthebeach.domain.repository

import com.osamaaftab.onthebeach.domain.model.FlightResponse

interface FlightRepository {
    suspend fun getFlights(): FlightResponse
}