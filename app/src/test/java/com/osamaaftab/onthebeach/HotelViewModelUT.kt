package com.osamaaftab.onthebeach

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.osamaaftab.onthebeach.data.source.remote.ApiErrorHandle
import com.osamaaftab.onthebeach.domain.model.HotelResponse
import com.osamaaftab.onthebeach.domain.usecase.GetHotelUsecase
import com.osamaaftab.onthebeach.presentation.viewmodel.HotelsViewModel
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

class HotelViewModelUT {


    @RelaxedMockK
    lateinit var getHotelUsecase: GetHotelUsecase

    private val dispatcher = TestCoroutineDispatcher()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var hotelViewModel: HotelsViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
        hotelViewModel = HotelsViewModel(getHotelUsecase)
    }


    @Test
    fun onSuccess() {
        val hotels = mockk<HotelResponse>()
        hotelViewModel.getHotelsUseCaseResponse().onSuccess(hotels)
        val response = hotelViewModel.getHotelResponse().value
        val state = hotelViewModel.getOnShow().value
        Assert.assertEquals(false, state)
        Assert.assertEquals(hotels, response)
    }

    @Test
    fun onFails() {
        val apiErrorHandle = ApiErrorHandle()
        val throwable = mockk<Throwable>()
        apiErrorHandle.traceErrorException(throwable)
        hotelViewModel.getHotelsUseCaseResponse()
            .onError(apiErrorHandle.traceErrorException(throwable))
        val state = hotelViewModel.getOnShow().value
        val msg = hotelViewModel.getOnError().value
        Assert.assertEquals("Bad response!", msg)
        Assert.assertEquals(false, state)
    }

    @Test
    fun onLoad() {
        hotelViewModel.loadHotels()
        val state = hotelViewModel.getOnShow().value
        Assert.assertEquals(true, state)
    }
}