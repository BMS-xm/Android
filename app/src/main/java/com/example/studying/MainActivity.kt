package com.example.studying

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studying.ui.theme.StudyingTheme

data class App(val icon: Int, val title: String, val description: String, val category: String)

val Apps = listOf(
    App(R.drawable.ic_launcher_foreground, "Calc", "Smart calculator", "Tools"),
    App(R.drawable.ic_launcher_foreground, "Note", "Smart notepad", "Business"),
    App(R.drawable.ic_launcher_foreground, "Dict", "Smart dictophone", "Multimedia")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screen()
        }
    }
}

@Composable
fun Screen() {
    Column() {
        ToolBar()
        AppList(Apps)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    StudyingTheme {
        Screen()
    }
}