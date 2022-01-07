package com.example.composetrial.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetrial.utils.Event
import com.example.composetrial.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch

interface IEventUIStateHolder<UIEventHolder : Event, UIStateHolder : UIState> {
    val uiState: StateFlow<UIStateHolder>
    fun postEvent(event: UIEventHolder)
}

abstract class BaseViewModel<UIEventHolder : Event, UIStateHolder : UIState>(initialState: UIStateHolder) :
    ViewModel(),
    IEventUIStateHolder<UIEventHolder, UIStateHolder> {
    private val _uiState: MutableStateFlow<UIStateHolder> = MutableStateFlow(initialState)
    private var previousState: UIStateHolder = initialState

    override val uiState:StateFlow<UIStateHolder> = _uiState.asStateFlow()

    protected fun postUiState(newUIState: UIStateHolder) {
        previousState = _uiState.getAndUpdate { newUIState }
    }

    protected fun executeTask(block: suspend () -> Unit) {
        viewModelScope.launch {
            kotlin.runCatching {
                block.invoke()
            }.onFailure {
                Log.e(this::class.simpleName, "failure\n${it.message}")
            }
        }
    }
}