package com.example.restaurantreservationjetpackcompose.presetation.tables.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.restaurantreservationjetpackcompose.common.Constants

@Composable
fun InternetConnectionDialog() {
    AlertDialog(
        modifier = Modifier.testTag(Constants.DIALOG),
            onDismissRequest={

            },
            dismissButton = {
                // Close the dialog when the user taps the "OK" button
            },
            title = {
                Text("No Internet Connection")
            },
            text = {
                Text("Please check your internet connection and try again.")
            },
            confirmButton = {
                Button(onClick = {
                    // Close the dialog when the user taps the "OK" button
                }) {
                    Text("OK")
                }
            }
        )
}
