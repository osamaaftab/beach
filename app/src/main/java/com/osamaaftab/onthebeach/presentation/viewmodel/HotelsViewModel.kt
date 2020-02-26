package com.osamaaftab.onthebeach.presentation.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.osamaaftab.onthebeach.domain.model.HotelResponse
import com.osamaaftab.onthebeach.domain.model.base.ErrorModel
import com.osamaaftab.onthebeach.domain.usecase.GetHotelUsecase
import com.osamaaftab.onthebeach.domain.usecase.base.UseCaseResponse
import com.osamaaftab.onthebeach.presentation.viewmodel.base.BaseViewModel

class HotelsViewModel(private val hotelUsecase: GetHotelUsecase) : BaseViewModel() {

    private val onShow = MutableLiveData<Boolean>()
    private val onError = MutableLiveData<String>()
    private val hotelResponse = MutableLiveData<HotelResponse>()


    fun loadHotels() {
        onShow.value = true
        hotelUsecase.invoke(scope, null, getHotelsUseCaseResponse())
    }


    fun getHotelsUseCaseResponse() = object : UseCaseResponse<HotelResponse> {
        override fun onSuccess(result: HotelResponse) {
            onShow.value = false
            Log.i(ContentValues.TAG, "result: $result")
            hotelResponse.value = result
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

    fun getHotelResponse(): LiveData<HotelResponse> {
        return hotelResponse
    }
}