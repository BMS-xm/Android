package com.example.studying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppListViewModel: ViewModel(){
    private val repository = AppListRepository()
    private val _state = MutableStateFlow(AppListState())
    val state = _state.asStateFlow()
    fun getContent(){
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            delay(3.seconds)
            _state.value = _state.value.copy(
                loading = false,
                items = repository.get()
            )
        }
    }
}