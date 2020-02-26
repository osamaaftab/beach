package com.osamaaftab.onthebeach.di.module

import androidx.test.espresso.IdlingRegistry
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    single { providesRetrofit(get(), get()) }
    single { providesOkHttpClient() }
    single { createMoshiConverterFactory() }
}


fun providesRetrofit(
    okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory
): Retrofit {
    IdlingRegistry
        .getInstance()
        .register(OkHttp3IdlingResource.create("okhttp", okHttpClient))
    return Retrofit.Builder()
        .baseUrl("https://pastebin.com")
        .client(okHttpClient)
        .addConverterFactory(moshiConverterFactory)
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()

}

fun createMoshiConverterFactory(): MoshiConverterFactory {
    return MoshiConverterFactory.create()
}

fun providesOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}