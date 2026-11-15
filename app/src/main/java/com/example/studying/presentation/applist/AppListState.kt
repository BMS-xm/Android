package com.example.studying.presentation.applist

import com.example.studying.domain.App

data class AppListState(
    val items: List<App> = emptyList(),
    val loading: Boolean = true
)