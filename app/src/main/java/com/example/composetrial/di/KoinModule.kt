package com.example.composetrial.di

import com.example.composetrial.ui.mainactivity.MainActivityViewModel
import com.example.composetrial.data.api.PostApi
import com.example.composetrial.data.api.ktorHttpClient
import com.example.composetrial.repository.PostRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ktor = "KTOR_VARIABLE"
val module = module {
    single(named(ktor)) { ktorHttpClient() }
    single { PostApi(get(named(ktor))) }
    single { PostRepository(get()) }
    viewModel { MainActivityViewModel(get()) }
}