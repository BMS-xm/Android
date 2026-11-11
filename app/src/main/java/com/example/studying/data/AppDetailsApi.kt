package com.example.studying.data

// Backend emulation
class AppDetailsApi {
    fun get(): AppDetailsDto {
        return AppDetailsDto(
            "Calc",
            "",
            "Smart calculator",
            "Tools",
        )
    }
}