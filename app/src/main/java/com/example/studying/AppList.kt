package com.example.studying

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AppList(apps: List<App>, navController: NavController) {
    LazyColumn() {
        for (n in 0..apps.size - 1) {
            item {
                val app = apps[n]
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate(APP_DEST)
                    })) {
                    Image(painter = painterResource(app.icon), "")
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = app.title)
                        Text(text = app.description)
                        Text(text = app.category)
                    }
                }
            }
        }
    }
}