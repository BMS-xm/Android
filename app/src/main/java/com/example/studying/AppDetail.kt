package com.example.studying

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.studying.ui.theme.StudyingTheme

@Composable
fun AppDetail(id: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        App(Apps[id])
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

@Preview(showBackground = true)
@Composable
fun Show() {
    StudyingTheme() {
        AppDetail(0)
    }
}