package com.example.studying

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource

@Composable
fun App(app: App) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(app.icon), "")
        Text(text = app.title)
        Text(text = app.description)
        Text(text = app.category)
    }
}