package com.example.studying.presentation.appdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AppDetails(viewModel: AppDetailsViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val state by viewModel.state.collectAsStateWithLifecycle()
        if (state.loading) {
            CircularProgressIndicator()
        } else {
            Image(painter = painterResource(state.details.icon), "")
            Text(text = state.details.title)
            Text(text = state.details.description)
            Text(text = state.details.category)
        }
    }
}