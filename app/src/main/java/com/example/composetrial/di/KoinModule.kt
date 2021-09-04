package com.example.composetrial.di

import com.example.composetrial.ui.mainactivity.MainActivityViewModel
import com.example.composetrial.data.api.MoviesApi
import com.example.composetrial.data.api.ktorHttpClient
import com.example.composetrial.repository.MoviesRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ktor = "KTOR_VARIABLE"
val module = module {
    single(named(ktor)) { ktorHttpClient() }
    single { MoviesApi(get(named(ktor))) }
    single { MoviesRepository(get()) }
    viewModel { MainActivityViewModel(get()) }
}