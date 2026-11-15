package com.example.studying.domain

class GetAppListUseCase(
    private val repository: AppListRepository
) {
    suspend operator fun invoke(): List<App> {
        return repository.get()
    }
}