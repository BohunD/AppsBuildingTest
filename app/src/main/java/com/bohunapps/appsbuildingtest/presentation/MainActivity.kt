package com.bohunapps.appsbuildingtest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bohunapps.appsbuildingtest.presentation.screens.EnterAgeScreen
import com.bohunapps.appsbuildingtest.presentation.screens.EnterNameScreen
import com.bohunapps.appsbuildingtest.presentation.screens.ShowInfoScreen
import com.bohunapps.appsbuildingtest.ui.theme.AppsBuildingTestTheme
import com.bohunapps.appsbuildingtest.util.Destination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppsBuildingTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    Scaffold(
                        bottomBar = { BottomNav(navController) }
                    ) {
                        NavHost(navController = navController, startDestination = Destination.EnterName.route) {
                            composable(Destination.EnterName.route) { EnterNameScreen( viewModel) }
                            composable(Destination.EnterAge.route) { EnterAgeScreen(viewModel) }
                            composable(Destination.ShowInfo.route) { ShowInfoScreen(viewModel) }
                        }
                    }
                }
            }
        }
    }
}

