package com.example.studying.domain

interface AppListRepository{
    suspend fun get(): List<App>
}