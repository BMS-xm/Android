package com.example.studying.presentation.appdetails

import com.example.studying.R
import com.example.studying.domain.AppDetails
import kotlinx.coroutines.Job

data class AppDetailsState(
    val details: AppDetails = AppDetails(
        R.drawable.ic_launcher_foreground,
        "Calc",
        "Smart calculator",
        "Tools"
    ),
    val loading: Boolean = false,
    val installing: Boolean = false,
    val progress: Int = 0,
    //val job: Job?
)