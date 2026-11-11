package com.example.studying.presentation

data class AppListState(
    val items: List<App> = emptyList(),
    val loading: Boolean = false
)