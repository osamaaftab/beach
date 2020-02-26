package com.osamaaftab.onthebeach.di.module

import com.osamaaftab.onthebeach.data.repository.FlightRepositoryImp
import com.osamaaftab.onthebeach.data.repository.HotelRepositoryImp
import com.osamaaftab.onthebeach.data.source.remote.FlightServices
import com.osamaaftab.onthebeach.data.source.remote.HotelServices
import com.osamaaftab.onthebeach.domain.repository.FlightRepository
import com.osamaaftab.onthebeach.domain.repository.HotelRepository
import org.koin.dsl.module

val RepositoryModule = module {

    single { provideHotelRepository(get()) }
    single { provideFlightRepository(get()) }
}

fun provideHotelRepository(hotelServices: HotelServices): HotelRepository {
    return HotelRepositoryImp(hotelServices)
}


fun provideFlightRepository(flightServices: FlightServices): FlightRepository {
    return FlightRepositoryImp(flightServices)
}