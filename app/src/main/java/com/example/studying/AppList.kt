package com.example.studying

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun AppList(apps: List<App>) {
    LazyColumn() {
        for (app in apps) {
            item {
                Row() {
                    Image(painter = painterResource(app.icon), "")
                    Column() {
                        Text(text = app.title)
                        Text(text = app.description)
                        Text(text = app.category)
                    }
                }
            }
        }
    }
}