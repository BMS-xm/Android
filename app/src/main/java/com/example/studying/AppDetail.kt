package com.example.studying

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun AppDetail(app: App) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        App(app)
        Text("See also:")
        LazyRow() {
            for (app in Apps) {
                item {
                    App(app)
                }
            }
        }
    }
}