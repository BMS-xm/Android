package com.example.studying

data class AppListState(
    val items: List<App> = emptyList(),
    val loading: Boolean = false
)