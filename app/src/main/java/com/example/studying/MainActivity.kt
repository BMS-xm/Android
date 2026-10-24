package com.example.studying

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
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.studying.ui.theme.StudyingTheme
import kotlinx.serialization.Serializable

data class App(val icon: Int, val title: String, val description: String, val category: String)

val Apps = listOf(
    App(R.drawable.ic_launcher_foreground, "Calc", "Smart calculator", "Tools"),
    App(R.drawable.ic_launcher_foreground, "Note", "Smart notepad", "Business"),
    App(R.drawable.ic_launcher_foreground, "Cam", "Smart camera", "Multimedia"),
    App(R.drawable.ic_launcher_foreground, "Dict", "Smart dictophone", "Multimedia")
)

const val HOME_DEST = "home"
const val APP_DEST = "app"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyingTheme {
                //Screen()
                RootNavHost()
            }
        }
    }
}

@Composable
fun RootNavHost() {
    val myNavController = rememberNavController()
    NavHost(navController = myNavController, startDestination = HOME_DEST) {
        composable(HOME_DEST) {Screen(myNavController)}
        //composable( route = APP_DEST) {AppDetail(Apps[0])}
        composable(
            route = "${APP_DEST}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            AppDetail(id = requireNotNull(id))
        }
    }
}

@Composable
fun Screen(navController: NavController) {
    Column() {
        ToolBar()
        AppList(Apps, navController)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    StudyingTheme {
        Column() {
            RootNavHost()
            //Screen()
            //App(Apps[1])
            //AppDetail(Apps[2])
        }
    }
}