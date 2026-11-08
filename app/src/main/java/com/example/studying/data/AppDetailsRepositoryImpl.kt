package com.example.studying.data

import com.example.studying.domain.AppDetails
import com.example.studying.domain.AppDetailsRepository

class AppDetailsRepositoryImpl(
    private val api: AppDetailsApi,
    private val mapper: AppDetailsMapper
) : AppDetailsRepository{
    override fun get(): AppDetails{
        val dto = api.get()
        val domain = mapper.map(dto)
        return domain
    }
}