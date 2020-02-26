package com.osamaaftab.onthebeach.domain.model

data class FlightItem(
    var airline: String,
    val departure_date: String,
    val arrival_date: String,
    val price: String,
    val departure_airport: String,
    val arrival_airport: String
)