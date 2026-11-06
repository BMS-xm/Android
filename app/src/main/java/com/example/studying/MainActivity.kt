package com.example.studying

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.studying.ui.theme.StudyingTheme

data class App(val icon: Int, val title: String, val description: String, val category: String)


const val HOME_DEST = "home"
const val APP_DEST = "app"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyingTheme {
                RootNavHost()
            }
        }
    }
}

@Composable
fun RootNavHost() {
    val viewModel = viewModel<AppListViewModel>()
    val myNavController = rememberNavController()
    LaunchedEffect(Unit) {
        viewModel.getContent()
    }
    NavHost(navController = myNavController, startDestination = HOME_DEST) {
        composable(HOME_DEST) {HomeScreen(viewModel, myNavController)}
        //composable( route = APP_DEST) {AppDetail(Apps[0])}
        composable(
            route = "${APP_DEST}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            AppDetail(viewModel, id = requireNotNull(id))
        }
    }
}

@Composable
fun HomeScreen(viewModel : AppListViewModel, navController: NavController) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Column {
        ToolBar()
        if (state.loading) {
            CircularProgressIndicator()
        } else {
            AppList(state.items, navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    StudyingTheme {
        Column {
            RootNavHost()
        }
    }
}