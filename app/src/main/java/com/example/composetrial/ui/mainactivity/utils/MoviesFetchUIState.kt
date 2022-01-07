package com.example.composetrial.ui.mainactivity.utils

import com.example.composetrial.data.response.Movies
import com.example.composetrial.utils.UIState

interface MoviesAppUIState<T> : UIState {
    val data: T
    val isLoading: Boolean
    val error: UIError?
}

data class UIError(val header: String, val message: String)

data class MoviesFetchUIState(
    override val data: Movies = Movies(),
    override val isLoading: Boolean = false,
    override val error: UIError? = null
) : MoviesAppUIState<Movies>