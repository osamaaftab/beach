package com.osamaaftab.onthebeach.domain.usecase

import com.osamaaftab.onthebeach.data.source.remote.ApiErrorHandle
import com.osamaaftab.onthebeach.domain.model.HotelResponse
import com.osamaaftab.onthebeach.domain.repository.HotelRepository
import com.osamaaftab.onthebeach.domain.usecase.base.UseCase

class GetHotelUsecase constructor(private val hotelRepository: HotelRepository, apiErrorHandle: ApiErrorHandle?) :
    UseCase<HotelResponse, Any?>(apiErrorHandle) {

    override suspend fun run(params: Any?): HotelResponse {
      return  hotelRepository.getHotels()
    }
}