package com.osamaaftab.onthebeach.domain.usecase

import com.osamaaftab.onthebeach.data.source.remote.ApiErrorHandle
import com.osamaaftab.onthebeach.domain.model.FlightResponse
import com.osamaaftab.onthebeach.domain.repository.FlightRepository
import com.osamaaftab.onthebeach.domain.usecase.base.UseCase

class GetFlightUsecase constructor(private val flightRepository: FlightRepository, apiErrorHandle: ApiErrorHandle?) :
    UseCase<FlightResponse, Any?>(apiErrorHandle) {

    override suspend fun run(params: Any?): FlightResponse {
      return  flightRepository.getFlights()
    }
}