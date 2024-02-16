package com.bohunapps.appsbuildingtest.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import com.bohunapps.appsbuildingtest.presentation.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterAgeScreen(vm: MainViewModel) {
    val ctx = LocalContext.current
    val currentAge by vm.currentAge.collectAsState("")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = currentAge,
            onValueChange = { vm.setCurrentAge(it) },
            isError = !vm.ageIsCorrect.value,
            label = { Text(text = "Enter age") },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            vm.validateAge(currentAge)
            if(vm.ageIsCorrect.value)
                vm.saveAge()
            else
                Toast.makeText(ctx, "Incorrect input", Toast.LENGTH_SHORT).show()
                         }, modifier = Modifier.fillMaxWidth(0.6f)) {
            Text(text = "Save age")
        }
    }
}