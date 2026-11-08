package com.example.studying.data

import com.example.studying.R
import com.example.studying.domain.AppDetails

class AppDetailsMapper {
    fun map(dto: AppDetailsDto): AppDetails {
        return AppDetails(
            icon = R.drawable.ic_launcher_foreground,
            title = dto.name,
            description = dto.description,
            category = dto.category
        )
    }
}