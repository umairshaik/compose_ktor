package com.example.composetrial.repository

import com.example.composetrial.data.api.MoviesApi
import com.example.composetrial.data.response.Movies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface IMoviesRepository {
    fun getMovies(): Flow<MoviesResponse<Movies>>
}

class MoviesRepository(private val moviesApi: MoviesApi) : IMoviesRepository {
    override fun getMovies(): Flow<MoviesResponse<Movies>> =
        flow { emit(MoviesResponse.Success(moviesApi.getMovies())) }
}