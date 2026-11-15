package com.example.studying.data

import com.example.studying.R
import com.example.studying.domain.App

class AppMapper {
    fun map(dto: AppDto): App {
        return App(
            icon = R.drawable.ic_launcher_foreground,
            title = dto.name,
            description = dto.description,
            category = dto.category
        )
    }
}