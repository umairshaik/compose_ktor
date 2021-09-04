package com.example.composetrial.repository

import com.example.composetrial.data.api.MoviesApi
import com.example.composetrial.data.response.Movies

class MoviesRepository(private val moviesApi: MoviesApi) {
    suspend fun getMovies(): Movies = moviesApi.getMovies()
}