package com.example.restaurantreservationjetpackcompose.presetation.tables.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.*

@Composable
fun InternetConnectionDialog() {
    AlertDialog(
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
