package com.example.composetrial.di

import com.example.composetrial.data.api.MoviesApi
import com.example.composetrial.data.api.ktorHttpClient
import com.example.composetrial.mappers.MoviesDomainMapper
import com.example.composetrial.repository.IMoviesRepository
import com.example.composetrial.repository.MoviesRepository
import com.example.composetrial.ui.mainactivity.MainActivityViewModel
import com.example.composetrial.usecases.MoviesFetchUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ktor = "KTOR_VARIABLE"
const val movie_domain_mapper = "MOVIE_DOMAIN_MAPPER"
val module = module {
    single(named(ktor)) { ktorHttpClient() }
    single { MoviesApi(get(named(ktor))) }
    single<IMoviesRepository> { MoviesRepository(get()) }
    single { MoviesFetchUseCase(get(), MoviesDomainMapper()) }
    viewModel { MainActivityViewModel(get()) }
}