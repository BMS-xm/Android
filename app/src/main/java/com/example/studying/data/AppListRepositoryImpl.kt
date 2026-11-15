package com.example.studying.data

import com.example.studying.domain.App
import com.example.studying.domain.AppListRepository

class AppListRepositoryImpl(
    private val api: AppListApi,
    private val mapper: AppMapper
) : AppListRepository{
    override suspend fun get(): List<App>{
        val dtoList = api.get()
        val domainList = dtoList.map { mapper.map(it) }
        return domainList
    }
}