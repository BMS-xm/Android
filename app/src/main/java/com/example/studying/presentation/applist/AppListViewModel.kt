package com.example.studying.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studying.data.AppListApi
import com.example.studying.data.AppListRepositoryImpl
import com.example.studying.data.AppMapper
import com.example.studying.domain.GetAppListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppListViewModel: ViewModel(){
    private val getAppListUseCase = GetAppListUseCase(
        repository = AppListRepositoryImpl(
            api = AppListApi(),
            mapper = AppMapper()
        )
    )
    private val _state = MutableStateFlow(AppListState())
    val state = _state.asStateFlow()

    init {
        getContent()
    }

    fun getContent(){
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            val appList = getAppListUseCase()
            //delay(3.seconds)
            _state.value = _state.value.copy(
                loading = false,
                items = appList
            )
        }
    }
}