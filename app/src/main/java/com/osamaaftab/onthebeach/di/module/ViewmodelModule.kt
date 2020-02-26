package com.osamaaftab.onthebeach.di.module

import com.osamaaftab.onthebeach.presentation.viewmodel.FlightsViewModel
import com.osamaaftab.onthebeach.presentation.viewmodel.HotelsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewmodelModule = module {
    viewModel { FlightsViewModel(get()) }
    viewModel { HotelsViewModel(get()) }
}