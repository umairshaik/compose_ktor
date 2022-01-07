package com.example.composetrial.ui.mainactivity

import android.util.Log
import com.example.composetrial.ui.base.BaseViewModel
import com.example.composetrial.ui.mainactivity.utils.MoviesFetchEvent
import com.example.composetrial.ui.mainactivity.utils.MoviesFetchUIState
import com.example.composetrial.usecases.MoviesFetchUseCase
import com.example.composetrial.utils.DomainWrapper


class MainActivityViewModel(private val moviesFetchUseCase: MoviesFetchUseCase) :
    BaseViewModel<MoviesFetchEvent, MoviesFetchUIState>(MoviesFetchUIState()) {

    private fun getMovies() {
        Log.i("Tag", "start")
        executeTask {
            when (val mapper = moviesFetchUseCase.getMovies()) {
                is DomainWrapper.Success -> {
                    postUiState(newUIState = uiState.value.copy(isLoading = false, data = mapper.data))
                }
            }
        }
    }

    override fun postEvent(event: MoviesFetchEvent) {
        if (event == MoviesFetchEvent.FetchMovies) {
            getMovies()
        }
    }
}