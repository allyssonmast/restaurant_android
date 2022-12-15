package com.example.restaurantreservationjetpackcompose.presetation.tables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TablesSreen(
    navController: NavController,
    viewModel: TablesViewModel = hiltViewModel()
){
    val state= viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize()){

    }
}