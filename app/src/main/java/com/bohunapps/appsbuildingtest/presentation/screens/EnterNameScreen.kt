package com.bohunapps.appsbuildingtest.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.bohunapps.appsbuildingtest.presentation.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterNameScreen( vm: MainViewModel) {
    val ctx = LocalContext.current
    val currentName by vm.currentName.collectAsState("")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = currentName,
            onValueChange = { vm.setCurrentName(it) },
            isError = !vm.nameIsCorrect.value,
            label = { Text(text = "Enter name") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Button(onClick = {vm.validateName(currentName)
            vm.validateName(currentName)
            if(vm.nameIsCorrect.value)
                vm.saveName()
            else
                Toast.makeText(ctx, "Incorrect input", Toast.LENGTH_SHORT).show()}, modifier = Modifier.fillMaxWidth(0.6f)) {
            Text(text = "Save name")
        }
    }
}