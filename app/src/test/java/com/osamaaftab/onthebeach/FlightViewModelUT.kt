package com.osamaaftab.onthebeach

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.osamaaftab.onthebeach.data.source.remote.ApiErrorHandle
import com.osamaaftab.onthebeach.domain.model.FlightResponse
import com.osamaaftab.onthebeach.domain.usecase.GetFlightUsecase
import com.osamaaftab.onthebeach.presentation.viewmodel.FlightsViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import junit.framework.Assert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FlightViewModelUT {

    @RelaxedMockK
    lateinit var getFlightUsecase: GetFlightUsecase

    private val dispatcher = TestCoroutineDispatcher()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var flightsViewModel: FlightsViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
        flightsViewModel = FlightsViewModel(getFlightUsecase)
    }


    @Test
    fun onSuccess() {
        val flights = FlightResponse(mockk())
        flightsViewModel.getFlightUseCaseResponse().onSuccess(flights)
        val response = flightsViewModel.getFlightList().value
        val state = flightsViewModel.getOnShow().value
        Assert.assertEquals(false, state)
        Assert.assertEquals(flights.flights, response)
    }

    @Test
    fun onFails() {
        val apiErrorHandle = ApiErrorHandle()
        val throwable = mockk<Throwable>()
        apiErrorHandle.traceErrorException(throwable)
        flightsViewModel.getFlightUseCaseResponse()
            .onError(apiErrorHandle.traceErrorException(throwable))
        val state = flightsViewModel.getOnShow().value
        val msg = flightsViewModel.getOnError().value
        Assert.assertEquals("Bad response!", msg)
        Assert.assertEquals(false, state)
    }

    @Test
    fun onLoad() {
        flightsViewModel.loadVehicleList()
        val state = flightsViewModel.getOnShow().value
        Assert.assertEquals(true, state)
    }
}