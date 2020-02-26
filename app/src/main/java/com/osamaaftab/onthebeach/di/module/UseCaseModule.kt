package com.osamaaftab.onthebeach.di.module

import com.osamaaftab.onthebeach.data.source.remote.ApiErrorHandle
import com.osamaaftab.onthebeach.domain.repository.FlightRepository
import com.osamaaftab.onthebeach.domain.repository.HotelRepository
import com.osamaaftab.onthebeach.domain.usecase.GetFlightUsecase
import com.osamaaftab.onthebeach.domain.usecase.GetHotelUsecase
import org.koin.dsl.module

val UseCaseModule = module {
    single { provideGetHotelUseCase(get(), provideApiError()) }
    single { provideGetFlightUseCase(get(), provideApiError()) }
}

fun provideGetHotelUseCase(
    hotelRepository: HotelRepository,
    apiErrorHandle: ApiErrorHandle
): GetHotelUsecase {
    return GetHotelUsecase(hotelRepository, apiErrorHandle)
}


fun provideGetFlightUseCase(
    flightRepository: FlightRepository,
    apiErrorHandle: ApiErrorHandle
): GetFlightUsecase {
    return GetFlightUsecase(flightRepository, apiErrorHandle)
}