package com.example.composetrial.repository

sealed class MoviesResponse<T> {
    data class Success<T>(val data: T) : MoviesResponse<T>()
}
