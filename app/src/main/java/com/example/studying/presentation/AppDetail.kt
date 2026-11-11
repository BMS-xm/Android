package com.example.studying.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AppDetail(viewModel: AppListViewModel, id: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val state by viewModel.state.collectAsStateWithLifecycle()
            if (state.loading) {
                CircularProgressIndicator()
            } else {
                App(state.items[id])
                Text("See also:")
                LazyRow {
                    for (app in state.items) {
                        item {
                            App(app)
                        }
                    }
                }
        }
    }
}
