package com.example.studying.domain

class GetAppDetailsUseCase(
    private val repository: AppDetailsRepository
) {
    operator fun invoke(): AppDetails {
        return repository.get()
    }
}