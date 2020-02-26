package com.osamaaftab.onthebeach.di.module

import com.osamaaftab.onthebeach.data.source.remote.ApiErrorHandle
import org.koin.dsl.module

val AppModule = module {
    single { provideApiError() }
}

fun provideApiError(): ApiErrorHandle {
    return ApiErrorHandle()
}