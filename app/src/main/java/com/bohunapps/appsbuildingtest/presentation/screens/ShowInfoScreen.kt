package com.bohunapps.appsbuildingtest.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bohunapps.appsbuildingtest.presentation.MainViewModel
import com.bohunapps.appsbuildingtest.util.Constants

@Composable
fun ShowInfoScreen(vm: MainViewModel) {
    vm.loadFromSharedPreferences()
    val name by vm.nameFromPrefs.collectAsState(initial = "")
    val age by vm.ageFromPrefs.collectAsState(initial = "")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name)
        Text(text = age)
        AsyncImage(model = Constants.PHOTO_LINK, contentDescription = null, modifier = Modifier.size(150.dp))
    }
}