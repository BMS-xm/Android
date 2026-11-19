package com.example.studying.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studying.data.AppDetailsApi
import com.example.studying.data.AppDetailsMapper
import com.example.studying.data.AppDetailsRepositoryImpl
import com.example.studying.domain.GetAppDetailsUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppDetailsViewModel: ViewModel(){
    private val getAppDetailsUseCase = GetAppDetailsUseCase(
        repository = AppDetailsRepositoryImpl(
            api = AppDetailsApi(),
            mapper = AppDetailsMapper()
        )
    )
    private val _state = MutableStateFlow(AppDetailsState())
    private var _installJob: Job = Job()
    val state = _state.asStateFlow()

    init {
        getAppDetails()
    }

    fun getAppDetails(){
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            val appDetails = getAppDetailsUseCase()
            delay(2.seconds)
            _state.value = _state.value.copy(
                loading = false,
                details = appDetails
            )
        }
    }

    fun onButtonClick() {
        if (_state.value.installing) {
            _installJob.cancel()
            _state.value = _state.value.copy(
                installing = false,
                progress = 0
            )
        } else {
            _installJob = viewModelScope.launch {
                _state.value = _state.value.copy(installing = true)
                for (i in 1..100) {
                    _state.value = _state.value.copy(progress = i)
                    delay(0.1.seconds)
                }
                _state.value = _state.value.copy(
                    installing = false,
                    installed = !_state.value.installed
                )
            }
        }
    }
}