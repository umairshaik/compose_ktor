package com.example.composetrial.data.api

import com.example.composetrial.data.response.Movies
import io.ktor.client.*
import io.ktor.client.request.*

class MoviesApi(private val client: HttpClient) {
    suspend fun getMovies(): Movies =
        client.get("https://api.themoviedb.org/3/movie/550")

}