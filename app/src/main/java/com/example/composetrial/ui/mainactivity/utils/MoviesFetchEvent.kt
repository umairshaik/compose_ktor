package com.example.composetrial.ui.mainactivity.utils

import com.example.composetrial.utils.Event

sealed class MoviesFetchEvent : Event {
    object FetchMovies : MoviesFetchEvent()
}