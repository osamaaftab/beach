package com.osamaaftab.onthebeach.di.module

import com.osamaaftab.onthebeach.data.source.remote.FlightServices
import com.osamaaftab.onthebeach.data.source.remote.HotelServices
import org.koin.dsl.module
import retrofit2.Retrofit


val APIServiceModule = module {
    single { provideHotelService(get()) }
    single { provideFlightService(get()) }
}

private fun provideHotelService(retrofit: Retrofit): HotelServices {
    return retrofit.create(HotelServices::class.java)
}

private fun provideFlightService(retrofit: Retrofit): FlightServices {
    return retrofit.create(FlightServices::class.java)
}