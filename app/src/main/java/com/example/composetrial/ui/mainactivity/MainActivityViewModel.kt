package com.example.composetrial.ui.mainactivity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.composetrial.data.response.Movies
import com.example.composetrial.repository.MoviesRepository

class MainActivityViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    suspend fun getMovies(): Movies {
        Log.i("Tag", "start")
        return moviesRepository.getMovies()
    }
}