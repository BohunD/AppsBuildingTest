package com.bohunapps.appsbuildingtest.presentation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bohunapps.appsbuildingtest.util.Destination

@Composable
fun BottomNav(navController: NavController) {
    NavigationBar(modifier = Modifier.height(50.dp)) {
        NavigationBarItem(
            selected = navController.currentDestination?.route == Destination.EnterName.route,
            onClick = {
                navController.navigate(Destination.EnterName.route) {
                    launchSingleTop = true
                }
            },
            icon = {},
            label = { Text(text = "Name") },
        )
        NavigationBarItem(
            selected = navController.currentDestination?.route == Destination.EnterAge.route,
            onClick = {
                navController.navigate(Destination.EnterAge.route) {
                    launchSingleTop = true
                }
            },
            label = { Text(text = "Age") },
            icon = {}
        )
        NavigationBarItem(
            selected = navController.currentDestination?.route == Destination.ShowInfo.route,
            onClick = {
                navController.navigate(Destination.ShowInfo.route) {
                    launchSingleTop = true
                }
            },
            icon = {  },
            label = { Text(text = "Show") },
        )
    }
}