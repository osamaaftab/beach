package com.osamaaftab.onthebeach.domain.usecase.base

import com.osamaaftab.onthebeach.domain.model.base.ErrorModel

interface UseCaseResponse<in Type> {

    fun onSuccess(result: Type)

    fun onError(errorModel: ErrorModel?)
}