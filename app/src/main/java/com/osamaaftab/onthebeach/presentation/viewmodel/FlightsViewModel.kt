package com.osamaaftab.onthebeach.presentation.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.osamaaftab.onthebeach.domain.model.FlightItem
import com.osamaaftab.onthebeach.domain.model.FlightResponse
import com.osamaaftab.onthebeach.domain.model.base.ErrorModel
import com.osamaaftab.onthebeach.domain.usecase.GetFlightUsecase
import com.osamaaftab.onthebeach.domain.usecase.base.UseCaseResponse
import com.osamaaftab.onthebeach.presentation.viewmodel.base.BaseViewModel

class FlightsViewModel(private val flightUsecase: GetFlightUsecase) : BaseViewModel() {

    private val onShow = MutableLiveData<Boolean>()
    private val onError = MutableLiveData<String>()
    private val flightList = MutableLiveData<List<FlightItem>>()


    fun loadVehicleList() {
        onShow.value = true
        flightUsecase.invoke(scope, null, getFlightUseCaseResponse())
    }


    fun getFlightUseCaseResponse() = object : UseCaseResponse<FlightResponse> {
        override fun onSuccess(result: FlightResponse) {
            onShow.value = false
            Log.i(ContentValues.TAG, "result: $result")
            flightList.value = result.flights
        }

        override fun onError(errorModel: ErrorModel?) {
            Log.i(ContentValues.TAG, "error: $errorModel?.message code")
            onShow.value = false
            onError.value = errorModel?.getErrorMessage().toString()
        }
    }

    fun getOnShow(): LiveData<Boolean> {
        return onShow
    }

    fun getOnError(): LiveData<String> {
        return onError
    }

    fun getFlightList(): LiveData<List<FlightItem>> {
        return flightList
    }
}